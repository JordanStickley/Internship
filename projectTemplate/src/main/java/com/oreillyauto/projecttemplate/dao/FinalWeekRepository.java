package com.oreillyauto.projecttemplate.dao;

import org.springframework.data.repository.CrudRepository;

import com.oreillyauto.projecttemplate.dao.custom.FinalWeekRepositoryCustom;
import com.oreillyauto.projecttemplate.domain.CarParts;

public interface FinalWeekRepository extends CrudRepository<CarParts, String>, FinalWeekRepositoryCustom {

}