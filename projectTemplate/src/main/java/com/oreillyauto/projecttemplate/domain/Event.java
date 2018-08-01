package com.oreillyauto.projecttemplate.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Immutable
@Table(name = "events")
@Entity
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_ID", columnDefinition = "BIGINT")
    private BigInteger eventId;

    @OneToMany(mappedBy = "event")
    List<EventProperty> eventPropertyList = new ArrayList<>();
    
    @Column(name = "DATE_TIME", columnDefinition = "TIMESTAMP")
    private Timestamp dateTime;

    @Column(name = "EVENT_TYPE", columnDefinition = "VARCHAR(50)")
    private String eventType;

    @Column(name = "SMS_SENT", columnDefinition = "BOOLEAN")
    private Boolean smsSent;

 
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

    public Event(BigInteger eventId, Timestamp dateTime, String eventType, Boolean smsSent) {
        super();
        this.eventId = eventId;
        this.dateTime = dateTime;
        this.eventType = eventType;
        this.smsSent = smsSent;
    }

    @Override
    public String toString() {
        return "Events [eventId=" + eventId + ", dateTime=" + dateTime + ", eventType=" + eventType + ", smsSent=" + smsSent + "]";
    }

   


}
