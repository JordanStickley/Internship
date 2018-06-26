package com.oreillyauto.projecttemplate.dao;

import org.springframework.data.repository.CrudRepository;

import com.oreillyauto.projecttemplate.dao.custom.AnimalClassRepositoryCustom;
import com.oreillyauto.projecttemplate.domain.AnimalClass;

public interface AnimalClassRepository extends CrudRepository<AnimalClass, String>, AnimalClassRepositoryCustom {

}