package com.oreillyauto.projecttemplate.service;

import java.util.List;

import com.oreillyauto.projecttemplate.domain.CarParts;

public interface CarPartsService {

    List<CarParts> getCarParts();

    void save(CarParts e);   

    CarParts getByPartNumber(String id);
}   