package com.oreillyauto.projecttemplate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.oreillyauto.projecttemplate.dao.AnimalRepository;
import com.oreillyauto.projecttemplate.domain.Animal;
import com.oreillyauto.projecttemplate.service.AnimalService;

@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    @Override
    public Animal getAnimalByName(String animalName) {
        return animalRepository.getAnimalByName(animalName);
    }
    
    @Override
    public void testRepo(Model model) {
        animalRepository.testRepo(model);
    }


}
