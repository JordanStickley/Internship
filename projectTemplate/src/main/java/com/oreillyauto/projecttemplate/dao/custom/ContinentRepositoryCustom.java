package com.oreillyauto.projecttemplate.dao.custom;

import java.util.List;
import java.util.Map;

import com.oreillyauto.projecttemplate.domain.Continent;

public interface ContinentRepositoryCustom {

    Continent getContinentByName(String name);

    List<Continent> getContinents();

    List<Continent> getContinentsByPopulation(Long low, Long high);

    Map<String, Continent> getMatchingContinents(List<Continent> continentNames);

    Long getContinentCount();
}