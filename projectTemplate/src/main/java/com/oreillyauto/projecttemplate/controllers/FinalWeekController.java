package com.oreillyauto.projecttemplate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreillyauto.projecttemplate.domain.CarParts;
import com.oreillyauto.projecttemplate.service.CarPartsService;

@Controller
@RequestMapping("/")
public class FinalWeekController extends BaseController {

    @Autowired
    CarPartsService carPartsService;

    private CarParts lastCarPart;

    @GetMapping(value = { "carParts" })
    public String getCarParts(Model model) throws Exception {
        List<CarParts> empList = carPartsService.getCarParts();
        System.out.println(empList);
        model.addAttribute("empList", empList);      
        return "carParts";
    }
    
    @GetMapping(value = { "carParts/carPartsSales" })
    public String getCarParts2(Model model) throws Exception {
        List<CarParts> empList = carPartsService.getCarParts();
        System.out.println(empList);
        model.addAttribute("empList", empList);      
        return "carPartsSales";
    }
    
    /*throws exception if not a valid phone type*/
    @ResponseBody
    @GetMapping(value = { "carParts/validatePhone/{phone}"})
    public String validatePhone(@PathVariable String phone, Model model) throws Exception {
        if (!SmsSender.validate(phone))
            throw new Exception("Invalid phone type");
        
        return "";
    }
    
    /*manages the message sent via sms*/
   /* @ResponseBody
    @GetMapping(value = { "carParts/sendSms/{id}/{phone}"})
    public String sendSms(@PathVariable String id, @PathVariable String phone, Model model) throws Exception {
        CarParts e = carPartsService.getByPartNumber(id);
        String body = "Opticronius loved " + e.getTrackName() + " by " + e.getArtistName() + " on " + e.getLovedDate();
        SmsSender.send(body.substring(0, body.length() > 160 ? 160 : body.length()), phone);
        e.setSmsSent(true);
        carPartsService.save(e);
        return "";
    }*/

    @ResponseBody
    @RequestMapping(value = "carParts/getCarParts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CarParts> getCarPartss() {
        return carPartsService.getCarParts();
    }
    
    /*insert data from api calls into the database*/
   /* @Scheduled(initialDelay = 5 * 1000, fixedDelay = 5 * 1000)
    public void getLovedTracks() {
        String serviceUri = "http://ws.audioscrobbler.com/2.0/?method=user.getlovedtracks&user=opticronius&api_key=03ee79fff5563729bb00cb9b48bf50c0&format=json";
        RestTemplate restTemplate = new RestTemplate();
        Response response = restTemplate.getForObject(serviceUri, Response.class);
        String trackName = (String) response.getLovedtracks().getTrack().get(0).get("name");
        if (lastCarPart == null || !lastCarPart.getTrackName().equals(trackName)) {
            CarParts e = new CarParts();
            e.setDateTime(new Timestamp(GregorianCalendar.getInstance().getTimeInMillis()));
            e.setCarPartsType("Lastfm");
            e.setCarPartsPropertyList(new ArrayList<CarPartsProperty>());
            CarPartsProperty ep = new CarPartsProperty();
            ep.setCarParts(e);
            ep.setCarPartsKey("TRACK_NAME");
            ep.setCarPartsValue(trackName);
            e.getCarPartsPropertyList().add(ep);
            ep = new CarPartsProperty();
            ep.setCarParts(e);
            ep.setCarPartsKey("ARTIST_NAME");
            Map artist = (Map) response.getLovedtracks().getTrack().get(0).get("artist");
            ep.setCarPartsValue((String) artist.get("name"));
            e.getCarPartsPropertyList().add(ep);
            ep = new CarPartsProperty();
            ep.setCarParts(e);
            ep.setCarPartsKey("LOVED_DATE");
            Map date = (Map) response.getLovedtracks().getTrack().get(0).get("date");
            ep.setCarPartsValue((String) date.get("#text"));
            e.getCarPartsPropertyList().add(ep);
            try {
                carPartsService.save(e);
                lastCarPart = e;
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }*/
}