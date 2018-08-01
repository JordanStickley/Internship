package com.oreillyauto.projecttemplate.dao.impl;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.oreillyauto.projecttemplate.dao.custom.YahooRepositoryCustom;
import com.oreillyauto.projecttemplate.domain.Event;
import com.oreillyauto.projecttemplate.util.Yahoo;

@Repository
public class YahooRepositoryImpl extends QuerydslRepositorySupport implements YahooRepositoryCustom {

    public YahooRepositoryImpl() {
        super(Yahoo.class);
    }
    
       
    @SuppressWarnings("unchecked")
    @Override
    public List<Event> getEvents() {
    	/*QEvent yahooTable = QEvent.Event;

		List<Event> eventList = (List<Event>) (Object) getQuerydsl().createQuery()
                .from(yahooTable)
                .fetch();
        System.out.println(eventList);*/
        return null;

    }


}