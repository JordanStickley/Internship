package com.oreillyauto.projecttemplate.dao;

import org.springframework.data.repository.CrudRepository;

import com.oreillyauto.projecttemplate.dao.custom.LastFmRepositoryCustom;
import com.oreillyauto.projecttemplate.domain.Event;

public interface LastFmRepository extends CrudRepository<Event, String>, LastFmRepositoryCustom {

}