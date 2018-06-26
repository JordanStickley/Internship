package com.oreillyauto.projecttemplate.service;

import com.oreillyauto.projecttemplate.domain.Animal;

public interface AnimalService {

    Animal getAnimalByName(String animalName);

}