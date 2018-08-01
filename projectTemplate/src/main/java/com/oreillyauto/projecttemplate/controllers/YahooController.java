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
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreillyauto.projecttemplate.domain.Event;
import com.oreillyauto.projecttemplate.domain.Quote;
import com.oreillyauto.projecttemplate.domain.Response;
import com.oreillyauto.projecttemplate.service.YahooService;

@Controller
@RequestMapping("/")
public class YahooController extends BaseController {

    @Autowired
    YahooService yahooService;

    @GetMapping(value = { "yahoo" })
    public String getEvent(Model model) throws Exception {
        List<Event> empList = yahooService.getEvents();
        System.out.println(empList);
        model.addAttribute("empList", empList);
        return "yahoo";
    }

    @ResponseBody
    @RequestMapping(value = "yahoo/getYahoo", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Event> getEvents() {
        return yahooService.getEvents();
    }

    @GetMapping(value = { "restclient/testgroupkt/{countryCode}" })
    public String getTestGroupKt(@PathVariable String countryCode, Model model) throws JsonProcessingException {
        String service = "Group Kt";
        String serviceUri = "http://services.groupkt.com/country/get/iso2code/" + countryCode;
        RestTemplate restTemplate = new RestTemplate();
        Response response = restTemplate.getForObject(serviceUri, Response.class);
        ObjectMapper mapper = new ObjectMapper();
        String responseJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
        model.addAttribute("service", service);
        model.addAttribute("serviceUri", serviceUri);
        model.addAttribute("response", responseJson);
        return "restclient";
    }

    @GetMapping(value = { "restclient/testspringboot" })
    public String getTestSpringBoot(Model model) throws JsonProcessingException {
        // Declare the service, service uri and build the Rest Template
        String service = "Spring Boot";
        String serviceUri = "https://gturnquist-quoters.cfapps.io/api/random";
        RestTemplate restTemplate = new RestTemplate();
        // Call the service and populate the Quote object
        Quote quote = restTemplate.getForObject(serviceUri, Quote.class);
        // Format the response, add the details to the model and return the JSP
        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(quote);
        model.addAttribute("service", service);
        model.addAttribute("request", serviceUri);
        model.addAttribute("response", response);
        return "restclient";
    }

}