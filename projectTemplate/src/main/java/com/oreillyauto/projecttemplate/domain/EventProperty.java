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
@Table(name = "EVENT_PROPERTIES")
@Entity
public class EventProperty implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROPERTY_ID", columnDefinition = "BIGINT")
    private BigInteger propertyId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID", columnDefinition = "BIGINT")
    private Event event;

    @Column(name = "EVENT_KEY", columnDefinition = "VARCHAR(50)")
    private String eventKey;

    @Column(name = "EVENT_VALUE", columnDefinition = "VARCHAR(164)")
    private String eventValue;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public BigInteger getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(BigInteger propertyId) {
        this.propertyId = propertyId;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
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

    public EventProperty() {
        
    }
    
    public EventProperty(BigInteger propertyId, Event event, String eventKey, String eventValue) {
        super();
        this.propertyId = propertyId;
        this.event = event;
        this.eventKey = eventKey;
        this.eventValue = eventValue;
    }

    @Override
    public String toString() {
        return "EventProperty [propertyId=" + propertyId + ", event=" + event + ", eventKey=" + eventKey + ", eventValue=" + eventValue
                + "]";
    }

}
