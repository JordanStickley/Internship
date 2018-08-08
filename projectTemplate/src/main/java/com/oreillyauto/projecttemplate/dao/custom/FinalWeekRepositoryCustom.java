package com.oreillyauto.projecttemplate.dao.custom;

import java.util.List;
import java.util.Optional;

import com.oreillyauto.projecttemplate.domain.CarParts;

public interface FinalWeekRepositoryCustom {

    List<CarParts> getCarParts();
    
    CarParts save(CarParts e);
    
    Optional<CarParts> findByPartNumber(String id);

}