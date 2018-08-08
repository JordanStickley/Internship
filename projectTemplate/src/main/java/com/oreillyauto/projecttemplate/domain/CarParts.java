package com.oreillyauto.projecttemplate.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//@Immutable
@Table(name = "carParts")
@Entity
public class CarParts implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PART_NUMBER", columnDefinition = "VARCHAR(64)")
    private String partNumber;

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinTable(name = "Compatibility", joinColumns = {@JoinColumn(name = "vid")}, 
                inverseJoinColumns = {@JoinColumn(name = "partNumber")})
    private
    List<Cars> carsList = new ArrayList<>();
    
    @Column(name = "TITLE", columnDefinition = "VARCHAR(50)")
    private String title;

    @Column(name = "LINE", columnDefinition = "VARCHAR(50)")
    private String line;

    @Column(name = "PRICE", columnDefinition = "DECIMAL")
    private BigDecimal price;
    
    @Column(name = "QTY_ON_HAND", columnDefinition = "INTEGER")
    private Integer qtyOnHand;

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public List<Cars> getCarsList() {
        return carsList;
    }

    public void setCarsList(List<Cars> carsList) {
        this.carsList = carsList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(Integer qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public CarParts(String partNumber, List<Cars> carsList, String title, String line, BigDecimal price, Integer qtyOnHand) {
        super();
        this.partNumber = partNumber;
        this.carsList = carsList;
        this.title = title;
        this.line = line;
        this.price = price;
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "CarParts [partNumber=" + partNumber + ", carsList=" + carsList + ", title=" + title + ", line=" + line + ", price=" + price
                + ", qtyOnHand=" + qtyOnHand + "]";
    }

   

   
    
    
    /*public String getTrackName() {
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
*/
    /*public Event(BigInteger eventId, Timestamp dateTime, String eventType, Boolean smsSent) {
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
    }*/
}
