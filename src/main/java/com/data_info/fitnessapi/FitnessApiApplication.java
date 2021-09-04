package com.data_info.fitnessapi;

import com.data_info.fitnessapi.repository.FitnessRepository;
import com.data_info.fitnessapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitnessApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitnessApiApplication.class, args);
    }

    //CommandLineRunner로 테스트 데이터 넣기
    public CommandLineRunner commandLineRunner(UserRepository userRepository,
                                               FitnessRepository fitnessRepository){
        return (args -> {

        });
    }
}
