package com.data_info.fitnessapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(FitnessRegisterController.class)
class FitnessRegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;


}