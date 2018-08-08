package com.oreillyauto.projecttemplate.domain;

import java.io.Serializable;
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
@Table(name = "cars")
@Entity
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VID", columnDefinition = "VARCHAR(64)")
    private String vid;

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinTable(name = "Compatibility", joinColumns = {@JoinColumn(name = "partNumber")}, 
                inverseJoinColumns = {@JoinColumn(name = "vid")})
    private
    List<CarParts> carPartsList = new ArrayList<>();
    
    @Column(name = "C_YEAR", columnDefinition = "INTEGER")
    private Integer cYear;

    @Column(name = "MAKE", columnDefinition = "VARCHAR(50)")
    private String make;

    @Column(name = "MODEL", columnDefinition = "VARCHAR(50)")
    private String model;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public List<CarParts> getCarPartsList() {
        return carPartsList;
    }

    public void setCarPartsList(List<CarParts> carPartsList) {
        this.carPartsList = carPartsList;
    }

    public Integer getcYear() {
        return cYear;
    }

    public void setcYear(Integer cYear) {
        this.cYear = cYear;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Cars(String vid, List<CarParts> carPartsList, Integer cYear, String make, String model) {
        super();
        this.vid = vid;
        this.carPartsList = carPartsList;
        this.cYear = cYear;
        this.make = make;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Cars [vid=" + vid + ", carPartsList=" + carPartsList + ", cYear=" + cYear + ", make=" + make + ", model=" + model + "]";
    }


    

    
}
