package com.data_info.fitnessapi.service;

import com.data_info.fitnessapi.domain.Fitness;
import com.data_info.fitnessapi.repository.FitnessRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class FitnessService {

    private FitnessRepository fitnessRepository;

    public FitnessService(FitnessRepository fitnessRepository){
        this.fitnessRepository=fitnessRepository;
    }

    public Page<Fitness> getFitnessInfo(String province, Pageable pageable, String sort){
        Page<Fitness> info=fitnessRepository.findAllByProvince(province,pageable,getSort(sort));
        return info;
    }

    private Sort getSort(String column){
        return Sort.by(column);
    }

}
