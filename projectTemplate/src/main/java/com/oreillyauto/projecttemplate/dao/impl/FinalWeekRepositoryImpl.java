package com.oreillyauto.projecttemplate.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.oreillyauto.projecttemplate.dao.custom.FinalWeekRepositoryCustom;
import com.oreillyauto.projecttemplate.domain.CarParts;
import com.oreillyauto.projecttemplate.domain.QCarParts;
import com.oreillyauto.projecttemplate.util.LastFm;

@Repository
public class FinalWeekRepositoryImpl extends QuerydslRepositorySupport implements FinalWeekRepositoryCustom {

    public FinalWeekRepositoryImpl() {
        super(LastFm.class);
    }
    
       
    @SuppressWarnings("unchecked")
    @Override
    public List<CarParts> getCarParts() {
    	QCarParts carPartsTable = QCarParts.carParts;

		List<CarParts> eventList = (List<CarParts>) (Object) getQuerydsl().createQuery()
                .from(carPartsTable)
                .fetch();
        return eventList;

    }


    @Override
    @Transactional
    public CarParts save(CarParts e) {
        if (e.getPartNumber() == null) {
            getEntityManager().persist(e);
        } else {
            return getEntityManager().merge(e);
        }
        return e;
    }


    @Override
    public Optional<CarParts> findByPartNumber(String id) {
        Optional<CarParts> result = Optional.empty();
        QCarParts carPartsTable = QCarParts.carParts;
        CarParts e = (CarParts) getQuerydsl().createQuery().from(carPartsTable).where(carPartsTable.partNumber.eq(id)).fetchOne();
        if (e != null) {
            result = Optional.of(e);
        }      
        return result;
    }

}