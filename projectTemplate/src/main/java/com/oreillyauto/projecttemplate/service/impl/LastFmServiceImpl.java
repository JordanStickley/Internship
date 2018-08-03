package com.oreillyauto.projecttemplate.service.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreillyauto.projecttemplate.dao.LastFmRepository;
import com.oreillyauto.projecttemplate.domain.Event;
import com.oreillyauto.projecttemplate.service.LastFmService;

@Service("LastFmService")
public class LastFmServiceImpl implements LastFmService {

    @Autowired
    LastFmRepository lastFmRepository;

    @Override
    public List<Event> getEvents() {
        List<Event> empList = (List<Event>) lastFmRepository.findAll();
        return empList;
    }

    @Override
    public void save(Event e) {
        lastFmRepository.save(e);   
    }

    @Override
    public Event getById(BigInteger id) {
        Optional<Event> response = lastFmRepository.findById(id);
        return response.isPresent() ? response.get() : null;
    }

}
