package com.oreillyauto.projecttemplate.domain;

import java.util.Objects;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;

@Immutable
@Table(name = "animal_class")
@Entity
public class AnimalClass {

    @Id
    @Column(name = "CLASS_NAME", columnDefinition = "VARCHAR(100)")
    private String className;

    @OneToOne(mappedBy = "animalClass")
    private Animal animal;

    @Column(name = "WARM_BLOODED", columnDefinition = "CHAR(1)")
    private String warmBlooded;

    @Column(name = "HAS_HAIR", columnDefinition = "CHAR(1)")
    private String hasHair;

    @Column(name = "HAS_VERTEBRAE", columnDefinition = "CHAR(1)")
    private String hasVertebrae;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getWarmBlooded() {
        return warmBlooded;
    }

    public void setWarmBlooded(String warmBlooded) {
        this.warmBlooded = warmBlooded;
    }

    public String getHasHair() {
        return hasHair;
    }

    public void setHasHair(String hasHair) {
        this.hasHair = hasHair;
    }

    public String getHasVertebrae() {
        return hasVertebrae;
    }

    public void setHasVertebrae(String hasVertebrae) {
        this.hasVertebrae = hasVertebrae;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(className)
                .append(animal)
                .append(hasHair)
                .append(hasVertebrae)
                .append(warmBlooded)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AnimalClass other = (AnimalClass) obj;
        if (className == null) {
            if (other.className != null)
                return false;
        } else if (!className.equals(other.className))
            return false;
        if (animal == null) {
            if (other.animal != null)
                return false;
        } else if (!animal.equals(other.animal))
            return false;

        if (hasHair == null) {
            if (other.hasHair != null)
                return false;
        } else if (!hasHair.equals(other.hasHair))
            return false;
        if (hasVertebrae == null) {
            if (other.hasVertebrae != null)
                return false;
        } else if (!hasVertebrae.equals(other.hasVertebrae))
            return false;
        if (warmBlooded == null) {
            if (other.warmBlooded != null)
                return false;
        } else if (!warmBlooded.equals(other.warmBlooded))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("className:" + Objects.toString(className, ""));
        sb.append(", animal:" + ((animal == null) ? "" : Objects.toString(animal.getName(), "")));
        sb.append(", hasHair:" + Objects.toString(hasHair, ""));
        sb.append(", hasVertebrae:" + Objects.toString(hasVertebrae, ""));
        sb.append(", warmBlooded:" + Objects.toString(warmBlooded, ""));
        sb.append("}");
        return sb.toString();
    }

}
