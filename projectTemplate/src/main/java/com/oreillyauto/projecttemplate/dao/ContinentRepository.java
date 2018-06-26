package com.oreillyauto.projecttemplate.dao;

import org.springframework.data.repository.CrudRepository;

import com.oreillyauto.projecttemplate.dao.custom.ContinentRepositoryCustom;
import com.oreillyauto.projecttemplate.domain.Continent;

public interface ContinentRepository extends CrudRepository<Continent, String>, ContinentRepositoryCustom {

}