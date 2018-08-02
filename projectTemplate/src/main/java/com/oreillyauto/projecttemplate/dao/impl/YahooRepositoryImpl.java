package com.oreillyauto.projecttemplate.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.oreillyauto.projecttemplate.dao.custom.YahooRepositoryCustom;
import com.oreillyauto.projecttemplate.domain.Event;
import com.oreillyauto.projecttemplate.domain.QEvent;
import com.oreillyauto.projecttemplate.util.Yahoo;

@Repository
public class YahooRepositoryImpl extends QuerydslRepositorySupport implements YahooRepositoryCustom {

    public YahooRepositoryImpl() {
        super(Yahoo.class);
    }
    
       
    @SuppressWarnings("unchecked")
    @Override
    public List<Event> getEvents() {
    	QEvent yahooTable = QEvent.event;

		List<Event> eventList = (List<Event>) (Object) getQuerydsl().createQuery()
                .from(yahooTable)
                .fetch();
        return eventList;

    }


    @Override
    @Transactional
    public Event save(Event e) {
        if (e.getEventId() == null) {
            getEntityManager().persist(e);
        } else {
            return getEntityManager().merge(e);
        }
        return e;
    }

}