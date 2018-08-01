package com.oreillyauto.projecttemplate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreillyauto.projecttemplate.dao.YahooRepository;
import com.oreillyauto.projecttemplate.domain.Event;
import com.oreillyauto.projecttemplate.service.YahooService;

@Service("YahooService")
public class YahooServiceImpl implements YahooService {

    @Autowired
    YahooRepository yahooRepository;

    @Override
    public List<Event> getEvents() {
        List<Event> empList = (List<Event>) yahooRepository.findAll();
        return empList;
    }

}
