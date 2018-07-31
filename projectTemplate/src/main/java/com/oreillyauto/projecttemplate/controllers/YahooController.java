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
import com.oreillyauto.projecttemplate.domain.Response;
import com.oreillyauto.projecttemplate.domain.Yahoo;
import com.oreillyauto.projecttemplate.service.YahooService;

@Controller
@RequestMapping("/")
public class YahooController extends BaseController {

	@Autowired
	YahooService yahooService;

	@GetMapping(value = { "yahoo" })
	public String getYahoo(Model model) throws Exception {
		List<Yahoo> empList = yahooService.getYahoo();
		System.out.println(empList);
		model.addAttribute("empList", empList);
		return "yahoo";
	}

	@ResponseBody
	@RequestMapping(value = "yahoo/getYahoo", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Yahoo> getYahoo() {
		return yahooService.getYahoo();
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

}