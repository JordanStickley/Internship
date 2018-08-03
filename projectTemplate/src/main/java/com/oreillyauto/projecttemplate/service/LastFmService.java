package com.oreillyauto.projecttemplate.service;

import java.math.BigInteger;
import java.util.List;

import com.oreillyauto.projecttemplate.domain.Event;

public interface LastFmService {

    List<Event> getEvents();

    void save(Event e);
    
    Event getById(BigInteger id);
}   