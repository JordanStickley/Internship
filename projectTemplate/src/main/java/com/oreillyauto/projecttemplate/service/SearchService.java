package com.oreillyauto.projecttemplate.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.oreillyauto.projecttemplate.domain.Animal;
import com.oreillyauto.projecttemplate.domain.AnimalClass;
import com.oreillyauto.projecttemplate.domain.Continent;
import com.oreillyauto.projecttemplate.dto.Search;

public interface SearchService {
    // Create a find by name for animal and class
    Animal getAnimalByName(String animalName);

    AnimalClass getAnimalClassByClassName(String animalClassName);

    // create a find animal by continent
    List<Animal> getAnimalsByContinent(String continentName);

    // create a find continent with population between two given population parameters
    List<Continent> getContinentsByPopulation(Integer low, Integer high);

    // create a find animal by leg_count
    List<Animal> getAnimalsByLegCount(Integer count);

    // create an orderBy name for animal
    List<Animal> getAnimalByNameAsc(String animalName, String direction);

    // create an orderBy name for class
    List<Animal> getAnimalClassByClassName(String animalClassName, String direction);

    // create an orderBy name for continent
    List<Continent> getContientsByNameOrderByName(String continentName, String direction);

    // create an orderBy population for continent
    List<Continent> getContientsByNameOrderByPopulation(String continentName, String direction);

    // create an orderBy area for continent
    List<Continent> getContientsByNameOrderByArea(String continentName, String direction);

    void search(HttpSession session, Model model, Search search);

}