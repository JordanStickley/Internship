package com.oreillyauto.projecttemplate.dao.custom;

import java.util.List;

import com.oreillyauto.projecttemplate.domain.Event;

public interface YahooRepositoryCustom {

    List<Event> getEvents();

}