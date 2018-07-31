package com.oreillyauto.projecttemplate.dao.impl;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.oreillyauto.projecttemplate.dao.custom.YahooRepositoryCustom;
import com.oreillyauto.projecttemplate.domain.QYahoo;
import com.oreillyauto.projecttemplate.domain.Yahoo;

@Repository
public class YahooRepositoryImpl extends QuerydslRepositorySupport implements YahooRepositoryCustom {

    public YahooRepositoryImpl() {
        super(Yahoo.class);
    }
    
       
    @SuppressWarnings("unchecked")
    @Override
    public List<Yahoo> getYahoo() {
    	QYahoo yahooTable = QYahoo.yahoo;

		List<Yahoo> yahooList = (List<Yahoo>) (Object) getQuerydsl().createQuery()
                .from(yahooTable)
                .fetch();
        System.out.println(yahooList);
        return null;

    }


}