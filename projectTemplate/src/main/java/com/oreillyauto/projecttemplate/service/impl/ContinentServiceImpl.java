package com.oreillyauto.projecttemplate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreillyauto.projecttemplate.dao.ContinentRepository;

@Service("continentService")
public class ContinentServiceImpl {

    @Autowired
    ContinentRepository continentRepository;

    public String getAnimalClassName(String animalName) {
        return null;
    }

}
