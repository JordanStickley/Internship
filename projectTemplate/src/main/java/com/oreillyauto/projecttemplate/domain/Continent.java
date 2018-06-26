package com.oreillyauto.projecttemplate.domain;

import java.util.Objects;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;

@Immutable
@Table(name = "CONTINENT")
@Entity
public class Continent {

    public Continent() {}

    public Continent(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "NAME", columnDefinition = "VARCHAR(50)")
    private String name;

    @ManyToOne
    @JoinColumn(name = "name", referencedColumnName = "continent_name", columnDefinition = "String")
    private Animal animal;

    @Column(name = "AREA", columnDefinition = "LONG")
    private Long area;

    @Column(name = "HUMAN_POPULATION", columnDefinition = "LONG")
    private Long humanPopulation;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getHumanPopulation() {
        return humanPopulation;
    }

    public void setHumanPopulation(Long humanPopulation) {
        this.humanPopulation = humanPopulation;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(name).append(animal).append(area).append(humanPopulation).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Continent other = (Continent) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (area == null) {
            if (other.area != null)
                return false;
        } else if (!area.equals(other.area))
            return false;
        if (animal == null) {
            if (other.animal != null)
                return false;
        } else if (!animal.equals(other.animal))
            return false;
        if (humanPopulation == null) {
            if (other.humanPopulation != null)
                return false;
        } else if (!humanPopulation.equals(other.humanPopulation))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("name:" + Objects.toString(name, ""));
        sb.append(", area:" + ((area == null) ? "" : Objects.toString(area, "")));
        sb.append(", humanPopulation:" + Objects.toString(humanPopulation, ""));
        sb.append("}");
        return sb.toString();
    }

}
