package com.data_info.fitnessapi.controller;

import com.data_info.fitnessapi.repository.FitnessRepository;
import com.data_info.fitnessapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class FitnessRegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /*
    * Error creating bean with name 'commandLineRunner'
    * defined in com.data_info.fitnessapi.FitnessApiApplication
    * */

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FitnessRepository fitnessRepository;

    @Test
    public void getFitnessRegTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8089/api/fitness")
        ).andDo(
                MockMvcResultHandlers.print()
        );
    }

}