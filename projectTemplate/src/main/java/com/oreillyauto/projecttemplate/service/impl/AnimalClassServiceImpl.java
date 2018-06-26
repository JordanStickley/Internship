package com.oreillyauto.projecttemplate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreillyauto.projecttemplate.dao.AnimalClassRepository;
import com.oreillyauto.projecttemplate.domain.AnimalClass;
import com.oreillyauto.projecttemplate.service.AnimalClassService;

@Service("animalClassService")
public class AnimalClassServiceImpl implements AnimalClassService {

    @Autowired
    AnimalClassRepository animalClassRepo;

    @Override
    public AnimalClass getAnimalClassByClassName(String className) {
        return null;
    }

}
