package com.oreillyauto.projecttemplate.controllers;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.oreillyauto.projecttemplate.domain.Event;
import com.oreillyauto.projecttemplate.domain.EventProperty;
import com.oreillyauto.projecttemplate.domain.Response;
import com.oreillyauto.projecttemplate.service.LastFmService;

@Controller
@RequestMapping("/")
public class LastFmController extends BaseController {

    @Autowired
    LastFmService lastFmService;

    private Event lastEvent;

    @GetMapping(value = { "lastFm" })
    public String getEvent(Model model) throws Exception {
        List<Event> empList = lastFmService.getEvents();
        System.out.println(empList);
        model.addAttribute("empList", empList);      
        return "lastFm";
    }
    
    /*throws exception if not a valid phone type*/
    @ResponseBody
    @GetMapping(value = { "lastFm/validatePhone/{phone}"})
    public String validatePhone(@PathVariable String phone, Model model) throws Exception {
        if (!SmsSender.validate(phone))
            throw new Exception("Invalid phone type");
        
        return "";
    }
    
    /*manages the message sent via sms*/
    @ResponseBody
    @GetMapping(value = { "lastFm/sendSms/{id}/{phone}"})
    public String sendSms(@PathVariable BigInteger id, @PathVariable String phone, Model model) throws Exception {
        Event e = lastFmService.getById(id);
        String body = "Opticronius loved " + e.getTrackName() + " by " + e.getArtistName() + " on " + e.getLovedDate();
        SmsSender.send(body.substring(0, body.length() > 160 ? 160 : body.length()), phone);
        e.setSmsSent(true);
        lastFmService.save(e);
        return "";
    }

    @ResponseBody
    @RequestMapping(value = "lastFm/getLastFm", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Event> getEvents() {
        return lastFmService.getEvents();
    }
    
    /*insert data from api calls into the database*/
    @Scheduled(initialDelay = 5 * 1000, fixedDelay = 5 * 1000)
    public void getLovedTracks() {
        String serviceUri = "http://ws.audioscrobbler.com/2.0/?method=user.getlovedtracks&user=opticronius&api_key=03ee79fff5563729bb00cb9b48bf50c0&format=json";
        RestTemplate restTemplate = new RestTemplate();
        Response response = restTemplate.getForObject(serviceUri, Response.class);
        String trackName = (String) response.getLovedtracks().getTrack().get(0).get("name");
        if (lastEvent == null || !lastEvent.getTrackName().equals(trackName)) {
            Event e = new Event();
            e.setDateTime(new Timestamp(GregorianCalendar.getInstance().getTimeInMillis()));
            e.setEventType("Lastfm");
            e.setEventPropertyList(new ArrayList<EventProperty>());
            EventProperty ep = new EventProperty();
            ep.setEvent(e);
            ep.setEventKey("TRACK_NAME");
            ep.setEventValue(trackName);
            e.getEventPropertyList().add(ep);
            ep = new EventProperty();
            ep.setEvent(e);
            ep.setEventKey("ARTIST_NAME");
            Map artist = (Map) response.getLovedtracks().getTrack().get(0).get("artist");
            ep.setEventValue((String) artist.get("name"));
            e.getEventPropertyList().add(ep);
            ep = new EventProperty();
            ep.setEvent(e);
            ep.setEventKey("LOVED_DATE");
            Map date = (Map) response.getLovedtracks().getTrack().get(0).get("date");
            ep.setEventValue((String) date.get("#text"));
            e.getEventPropertyList().add(ep);
            try {
                lastFmService.save(e);
                lastEvent = e;
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}