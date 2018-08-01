package com.oreillyauto.projecttemplate.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Immutable
@Table(name = "eventProperties")
@Entity
public class EventProperty implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROPERTY_ID", columnDefinition = "BIGINT")
    private BigInteger propertyId;

    @Column(name = "EVENT_ID", columnDefinition = "BIGINT")
    private BigInteger eventId;

    @Column(name = "EVENT_KEY", columnDefinition = "TIMESTAMP")
    private Timestamp dateTime;

    @Column(name = "EVENT_VALUE", columnDefinition = "VARCHAR(164)")
    private String eventValue;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID", columnDefinition = "BIGINT")
    private Event event;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public BigInteger getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(BigInteger propertyId) {
        this.propertyId = propertyId;
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

    public String getEventValue() {
        return eventValue;
    }

    public void setEventValue(String eventValue) {
        this.eventValue = eventValue;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public EventProperty(BigInteger propertyId, BigInteger eventId, Timestamp dateTime, String eventValue, Event event) {
        super();
        this.propertyId = propertyId;
        this.eventId = eventId;
        this.dateTime = dateTime;
        this.eventValue = eventValue;
        this.event = event;
    }

    @Override
    public String toString() {
        return "EventProperty [propertyId=" + propertyId + ", eventId=" + eventId + ", dateTime=" + dateTime + ", eventValue=" + eventValue
                + ", event=" + event + "]";
    }

}
