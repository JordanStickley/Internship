package com.oreillyauto.projecttemplate.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oreillyauto.projecttemplate.service.AnimalService;

@Controller
@RequestMapping("/")
public class IntroController {
    private static final Logger log = Logger.getLogger(IntroController.class);

    @RequestMapping(value = { "", "/", "index" })
    public String index() {
        return "index";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }
    
    @RequestMapping(value = { "javascript" })
    public String javascript() {
    	return "javascript";
    }
    
    @RequestMapping(value = { "app" })
    public String app() {
    	return "app";
    }
    
    @RequestMapping(value = { "app/milestones" })
    public String milestones() {
    	return "milestones";
    }
    
    @RequestMapping(value = { "app/enrollIntern" })
    public String enrollIntern() {
    	return "enrollIntern";
    }
    
    @RequestMapping(value = { "app/editIntern" })
    public String editIntern() {
    	return "editIntern";
    }
    
 // CREATE YOUR CONTROLLER
    @Autowired
    AnimalService animalService;

    @RequestMapping(value = "database/queryDslExample", method = {RequestMethod.GET})
    public String queryDslExample(HttpServletRequest request, Model model) {
    	animalService.testRepo(model);    	
        return "queryDslExample";
    }



}
