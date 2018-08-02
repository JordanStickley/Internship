package com.oreillyauto.projecttemplate.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Immutable
@Table(name = "events")
@Entity
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_ID", columnDefinition = "BIGINT")
    private BigInteger eventId;

    @OneToMany(mappedBy = "event", fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    private
    List<EventProperty> eventPropertyList = new ArrayList<>();
    
    @Column(name = "DATE_TIME", columnDefinition = "TIMESTAMP")
    private Timestamp dateTime;

    @Column(name = "EVENT_TYPE", columnDefinition = "VARCHAR(50)")
    private String eventType;

    @Column(name = "SMS_SENT", columnDefinition = "BOOLEAN")
    private Boolean smsSent = false;

 
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public BigInteger getEventId() {
        return eventId;
    }

    public void setEventId(BigInteger eventId) {
        this.eventId = eventId;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public String getEventDate() {
        String s = new SimpleDateFormat("MM/dd/yyyy").format(dateTime);
        return s;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Boolean getSmsSent() {
        return smsSent;
    }

    public void setSmsSent(Boolean smsSent) {
        this.smsSent = smsSent;
    }
    
    public String getTrackName() {
        for (EventProperty event : getEventPropertyList()) {
            if (event.getEventKey().equals("TRACK_NAME")) {
                return event.getEventValue();
            } 
        }
        return "";
    }
    
    public String getLovedDate() {
        for (EventProperty event : getEventPropertyList()) {
            if (event.getEventKey().equals("LOVED_DATE")) {
                return event.getEventValue();
            } 
        }
        return "";
    }
    
    public String getArtistName() {
        for (EventProperty event : getEventPropertyList()) {
            if (event.getEventKey().equals("ARTIST_NAME")) {
                return event.getEventValue();
            } 
        }
        return "";
    }

    public Event(BigInteger eventId, Timestamp dateTime, String eventType, Boolean smsSent) {
        super();
        this.eventId = eventId;
        this.dateTime = dateTime;
        this.eventType = eventType;
        this.smsSent = smsSent;
    }

    public Event() {
        
    }
    
    public Event(int i, Timestamp timestamp, List<EventProperty> events) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Events [eventId=" + eventId + ", dateTime=" + dateTime + ", eventType=" + eventType + ", smsSent=" + smsSent + "]";
    }

    @JsonIgnore
    public List<EventProperty> getEventPropertyList() {
        return eventPropertyList;
    }

    public void setEventPropertyList(List<EventProperty> eventPropertyList) {
        this.eventPropertyList = eventPropertyList;
    }
}
