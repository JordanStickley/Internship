package com.oreillyauto.projecttemplate.dao;

import org.springframework.data.repository.CrudRepository;

import com.oreillyauto.projecttemplate.dao.custom.YahooRepositoryCustom;
import com.oreillyauto.projecttemplate.domain.Yahoo;

public interface YahooRepository extends CrudRepository<Yahoo, String>, YahooRepositoryCustom {

}