package com.oreillyauto.projecttemplate.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;

@Immutable
@Table(name = "ANIMAL")
@Entity
public class Animal implements Serializable {

    private static final long serialVersionUID = -4108469530390894201L;

    @Id
    @Column(name = "NAME", columnDefinition = "VARCHAR(200)")
    private String name;

    @OneToOne
    @JoinColumn(name = "class_name")
    private AnimalClass animalClass;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "animal")
    private List<Continent> continentList;

    @Column(name = "continent_name", columnDefinition = "VARCHAR(50)")
    private String continentName;

    @Column(name = "leg_count", columnDefinition = "INTEGER")
    private String legCount;

    @Column(name = "SOUND", columnDefinition = "VARCHAR(50)")
    private String sound;

    @Column(name = "LIFE_EXPECTANCY", columnDefinition = "INTEGER")
    private String lifeExpectancy;

    public List<Continent> getContinentList() {
        return continentList;
    }

    public void setContinentList(List<Continent> continentList) {
        this.continentList = continentList;
    }

    public AnimalClass getAnimalClass() {
        return animalClass;
    }

    public void setAnimalClass(AnimalClass animalClass) {
        this.animalClass = animalClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegCount() {
        return legCount;
    }

    public void setLegCount(String legCount) {
        this.legCount = legCount;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(String lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(name).append(animalClass).append(continentName).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (animalClass == null) {
            if (other.animalClass != null)
                return false;
        } else if (!animalClass.equals(other.animalClass))
            return false;
        if (continentName == null) {
            if (other.continentName != null)
                return false;
        } else if (!continentName.equals(other.continentName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("name:" + Objects.toString(name, ""));
        sb.append(", animalClass:" + ((animalClass == null) ? "" : Objects.toString(animalClass.getClassName(), "")));
        sb.append(", continent:" + Objects.toString(continentName, ""));
        sb.append(", legCount:" + Objects.toString(legCount, ""));
        sb.append(", lifeExpectancy:" + Objects.toString(lifeExpectancy, ""));
        sb.append(", sound:" + Objects.toString(sound, ""));
        sb.append("}");
        return sb.toString();
    }

}
