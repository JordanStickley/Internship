package com.oreillyauto.projecttemplate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreillyauto.projecttemplate.dao.YahooRepository;
import com.oreillyauto.projecttemplate.domain.Yahoo;
import com.oreillyauto.projecttemplate.service.YahooService;

@Service("YahooService")
public class YahooServiceImpl implements YahooService{
    
    @Autowired
    YahooRepository yahooRepository;



	@Override
	public List<Yahoo> getYahoo() {
		List<Yahoo> empList = (List<Yahoo>)yahooRepository.findAll();
		return empList;
	}
    
   

}
