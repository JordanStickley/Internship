package com.oreillyauto.projecttemplate.dao.custom;

import java.util.List;

import com.oreillyauto.projecttemplate.domain.Event;

public interface LastFmRepositoryCustom {

    List<Event> getEvents();
    
    Event save(Event e);

}