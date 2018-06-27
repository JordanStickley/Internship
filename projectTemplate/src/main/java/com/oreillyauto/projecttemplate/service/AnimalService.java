package com.oreillyauto.projecttemplate.service;

import org.springframework.ui.Model;

import com.oreillyauto.projecttemplate.domain.Animal;

public interface AnimalService {

    Animal getAnimalByName(String animalName);
    
 // Add Your runTest() Method to the AnimalService Interface
    void testRepo(Model model);


}