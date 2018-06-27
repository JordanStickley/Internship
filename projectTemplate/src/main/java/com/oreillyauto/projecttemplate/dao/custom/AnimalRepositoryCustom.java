package com.oreillyauto.projecttemplate.dao.custom;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.oreillyauto.projecttemplate.domain.Animal;

public interface AnimalRepositoryCustom {

    Animal getAnimalByName(String name);

    List<Animal> getAnimalsByContinent(String continentName, String orderBy, String direction);

    List<Animal> getAnimalsByLegCount(Long legCount, String orderBy, String direction);

    List<Animal> getAnimals();

    Map<String, Animal> getMatchingAnimals(List<Animal> animalNames);

    Long getAnimalCount();
    
    void testRepo(Model model);
}