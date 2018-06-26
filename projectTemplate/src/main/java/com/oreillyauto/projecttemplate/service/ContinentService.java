package com.oreillyauto.projecttemplate.service;

import com.oreillyauto.projecttemplate.domain.Continent;

public interface ContinentService {

    Continent findContinentByName(String continentName);

}