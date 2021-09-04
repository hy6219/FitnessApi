package com.data_info.fitnessapi;

import com.data_info.fitnessapi.domain.Fitness;
import com.data_info.fitnessapi.domain.User;
import com.data_info.fitnessapi.domain.enums.Gender;
import com.data_info.fitnessapi.domain.enums.Grade;
import com.data_info.fitnessapi.repository.FitnessRepository;
import com.data_info.fitnessapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class FitnessApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitnessApiApplication.class, args);
    }

    //CommandLineRunner로 테스트 데이터 넣기
    public CommandLineRunner commandLineRunner(UserRepository userRepository,
                                               FitnessRepository fitnessRepository){
        return (args -> {
            List<User> users=new ArrayList<>();

            User user1=User.builder()
                    .name("김길동")
                    .age(30)
                    .gender(Gender.MALE)
                    .grade(Grade.ceo)
                    .build();

            User user2=User.builder()
                    .name("나길동")
                    .age(30)
                    .gender(Gender.FEMALE)
                    .grade(Grade.trainer)
                    .build();

            User user3=User.builder()
                    .name("다길동")
                    .age(35)
                    .gender(Gender.MALE)
                    .grade(Grade.member)
                    .build();

            users.addAll(Arrays.asList(user1,user2,user3));

            userRepository.saveAll(users);

            IntStream.rangeClosed(1,10).forEach(i->{
                fitnessRepository.save(
                        Fitness.builder()
                                .name("테스트 "+i)
                                .ownerName("김길동")
                                .province("서울특별시")
                                .midProvince("강남구")
                                .town("역삼동")
                                .users(users)
                                .build());
            });
        });
    }
}
