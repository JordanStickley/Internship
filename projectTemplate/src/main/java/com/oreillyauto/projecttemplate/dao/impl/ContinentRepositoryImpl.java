package com.oreillyauto.projecttemplate.dao.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.oreillyauto.internshiplabs.domain.QContinent;
import com.oreillyauto.projecttemplate.dao.custom.ContinentRepositoryCustom;
import com.oreillyauto.projecttemplate.domain.Continent;

@Repository
public class ContinentRepositoryImpl extends QueryDslRepositorySupport implements ContinentRepositoryCustom {

    public ContinentRepositoryImpl() {
        super(Continent.class);
    }

    @Override
    public Continent getContinentByName(String continentName) {
        QContinent continent = QContinent.continent;
        return (Continent) getQuerydsl().createQuery().from(continent).where(continent.name.eq(continentName)).fetch();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Continent> getContinentsByPopulation(Long low, Long high) {
        QContinent continent = QContinent.continent;

        List<Continent> continentList = (List<Continent>) (Object) getQuerydsl().createQuery()
                .from(continent)
                .where(continent.humanPopulation.between(low, high))
                .fetch();

        if (continentList != null & continentList.size() > 0) {
            return continentList;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Continent> getContinents() {
        return null;
    }

    @Override
    public Map<String, Continent> getMatchingContinents(List<Continent> continentNames) {
        return null;
    }

    @Override
    public Long getContinentCount() {
        return null;
    }

}
