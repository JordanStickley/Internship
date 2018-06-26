package com.oreillyauto.projecttemplate.service;

import com.oreillyauto.projecttemplate.domain.AnimalClass;

public interface AnimalClassService {

    AnimalClass getAnimalClassByClassName(String className);

}