package com.oreillyauto.projecttemplate.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreillyauto.projecttemplate.dao.FinalWeekRepository;
import com.oreillyauto.projecttemplate.domain.CarParts;
import com.oreillyauto.projecttemplate.service.CarPartsService;

@Service("CarPartsService")
public class CarPartsServiceImpl implements CarPartsService {

    @Autowired
    FinalWeekRepository finalWeekRepository;

    @Override
    public List<CarParts> getCarParts() {
        List<CarParts> empList = (List<CarParts>) finalWeekRepository.findAll();
        return empList;
    }

    @Override
    public void save(CarParts e) {
        finalWeekRepository.save(e);   
    }

    @Override
    public CarParts getByPartNumber(String id) {
        Optional<CarParts> response = finalWeekRepository.findById(id);
        return response.isPresent() ? response.get() : null;
    }

}
