package com.oreillyauto.projecttemplate.dao;

import org.springframework.data.repository.CrudRepository;

import com.oreillyauto.projecttemplate.dao.custom.AnimalRepositoryCustom;
import com.oreillyauto.projecttemplate.domain.Animal;

public interface AnimalRepository extends CrudRepository<Animal, String>, AnimalRepositoryCustom {

}