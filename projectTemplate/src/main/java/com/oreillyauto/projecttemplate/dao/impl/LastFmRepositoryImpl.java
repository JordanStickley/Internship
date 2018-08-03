package com.oreillyauto.projecttemplate.dao.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.oreillyauto.projecttemplate.dao.custom.LastFmRepositoryCustom;
import com.oreillyauto.projecttemplate.domain.Event;
import com.oreillyauto.projecttemplate.domain.QEvent;
import com.oreillyauto.projecttemplate.util.LastFm;

@Repository
public class LastFmRepositoryImpl extends QuerydslRepositorySupport implements LastFmRepositoryCustom {

    public LastFmRepositoryImpl() {
        super(LastFm.class);
    }
    
       
    @SuppressWarnings("unchecked")
    @Override
    public List<Event> getEvents() {
    	QEvent lastFmTable = QEvent.event;

		List<Event> eventList = (List<Event>) (Object) getQuerydsl().createQuery()
                .from(lastFmTable)
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


    @Override
    public Optional<Event> findById(BigInteger id) {
        Optional<Event> result = Optional.empty();
        QEvent lastFmTable = QEvent.event;
        Event e = (Event) getQuerydsl().createQuery().from(lastFmTable).where(lastFmTable.eventId.eq(id)).fetchOne();
        if (e != null) {
            result = Optional.of(e);
        }      
        return result;
    }

}