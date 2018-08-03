package com.oreillyauto.projecttemplate.dao.custom;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.oreillyauto.projecttemplate.domain.Event;

public interface LastFmRepositoryCustom {

    List<Event> getEvents();
    
    Event save(Event e);
    
    Optional<Event> findById(BigInteger id);

}