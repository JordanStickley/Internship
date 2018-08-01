package com.oreillyauto.projecttemplate.dao;

import org.springframework.data.repository.CrudRepository;

import com.oreillyauto.projecttemplate.dao.custom.YahooRepositoryCustom;
import com.oreillyauto.projecttemplate.domain.Event;

public interface YahooRepository extends CrudRepository<Event, String>, YahooRepositoryCustom {

}