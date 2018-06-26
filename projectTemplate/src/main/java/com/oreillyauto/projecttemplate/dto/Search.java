package com.oreillyauto.projecttemplate.dto;

import java.io.Serializable;

import com.oreillyauto.projecttemplate.domain.Animal;
import com.oreillyauto.projecttemplate.domain.AnimalClass;
import com.oreillyauto.projecttemplate.domain.Continent;

public class Search implements Serializable {

    private static final long serialVersionUID = -3764026198689708128L;
    private Animal animal;
    private AnimalClass animalClass;
    private Continent continent;
    private String searchType;
    private Long low;
    private Long high;
    private String lastSearch;

    public Search() {}

    public Search(Animal animal, AnimalClass animalClass, Continent continent, String searchType, Long low, Long high, String lastSearch) {
        super();
        this.animal = animal;
        this.animalClass = animalClass;
        this.continent = continent;
        this.searchType = searchType;
        this.low = low;
        this.high = high;
        this.lastSearch = lastSearch;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public AnimalClass getAnimalClass() {
        return animalClass;
    }

    public void setAnimalClass(AnimalClass animalClass) {
        this.animalClass = animalClass;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public Long getLow() {
        return low;
    }

    public void setLow(Long low) {
        this.low = low;
    }

    public Long getHigh() {
        return high;
    }

    public void setHigh(Long high) {
        this.high = high;
    }

    public String getLastSearch() {
        return lastSearch;
    }

    public void setLastSearch(String lastSearch) {
        this.lastSearch = lastSearch;
    }

}
