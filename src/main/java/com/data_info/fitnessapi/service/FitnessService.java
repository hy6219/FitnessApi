package com.data_info.fitnessapi.service;

import com.data_info.fitnessapi.domain.Fitness;
import com.data_info.fitnessapi.repository.FitnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class FitnessService {

    @Qualifier(value="fitnessRepository")
    private FitnessRepository fitnessRepository;


    public Page<Fitness> getFitnessInfo(String province, Pageable pageable){
        Page<Fitness> info=fitnessRepository.findAllByProvince(province,pageable);
        return info;
    }


}
