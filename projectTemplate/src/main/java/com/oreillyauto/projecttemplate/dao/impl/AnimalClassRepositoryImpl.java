package com.oreillyauto.projecttemplate.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.oreillyauto.projecttemplate.dao.custom.AnimalClassRepositoryCustom;
import com.oreillyauto.projecttemplate.domain.AnimalClass;
import com.oreillyauto.projecttemplate.domain.QAnimalClass;

@Repository
public class AnimalClassRepositoryImpl extends QuerydslRepositorySupport implements AnimalClassRepositoryCustom {

    public AnimalClassRepositoryImpl() {
        super(AnimalClass.class);
    }

    @Override
    public AnimalClass getAnimalClassByClassName(String animalClassName) {
        QAnimalClass animalClass = QAnimalClass.animalClass;
        return (AnimalClass) getQuerydsl().createQuery().from(animalClass).where(animalClass.className.eq(animalClassName)).fetch();
    }

    @Override
    public List<AnimalClass> getAnimalClasses() {
        return null;
    }

    @Override
    public Map<String, AnimalClass> getMatchingAnimalClasses(List<AnimalClass> animalClassNames) {
        return null;
    }

    @Override
    public Long getAnimalClassCount() {
        return null;
    }

}
