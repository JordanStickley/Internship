package com.oreillyauto.projecttemplate.service;

import java.util.List;

import com.oreillyauto.projecttemplate.domain.Event;

public interface LastFmService {

    List<Event> getEvents();

    void save(Event e);
}   