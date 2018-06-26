package com.oreillyauto.projecttemplate.dao.custom;

import java.util.List;
import java.util.Map;

import com.oreillyauto.projecttemplate.domain.AnimalClass;

public interface AnimalClassRepositoryCustom {

    AnimalClass getAnimalClassByClassName(String className);

    List<AnimalClass> getAnimalClasses();

    Map<String, AnimalClass> getMatchingAnimalClasses(List<AnimalClass> animalClassNames);

    Long getAnimalClassCount();
}