package com.data_info.fitnessapi.repository;

import com.data_info.fitnessapi.domain.Fitness;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FitnessRepositoryTest {
    @Autowired
    private FitnessRepository fitnessRepository;

    @Test
    public void findAllTest(){
        fitnessRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void findAllProvinceTest(){
        Page<Fitness> page=fitnessRepository.findAllByProvince("서울특별시",PageRequest.of(1,10));
        page.forEach(System.out::println);
    }
}