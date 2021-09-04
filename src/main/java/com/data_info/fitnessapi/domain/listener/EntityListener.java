package com.data_info.fitnessapi.domain.listener;

import com.data_info.fitnessapi.domain.Fitness;
import com.data_info.fitnessapi.domain.User;
import com.data_info.fitnessapi.repository.FitnessRepository;
import com.data_info.fitnessapi.repository.UserRepository;
import com.data_info.fitnessapi.utils.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class EntityListener {
    @PostPersist
    public void postPersist(Object o){
        UserRepository userRepository= BeanUtils.getBean(UserRepository.class);
        FitnessRepository fitnessRepository=BeanUtils.getBean(FitnessRepository.class);

        if(o instanceof Utility){
            Utility u=(Utility) o;

            u.setCreatedAt(LocalDateTime.now());
            u.setUpdatedAt(LocalDateTime.now());

            if(u instanceof User){
                userRepository.save((User)u);
            }else if(u instanceof Fitness){
                fitnessRepository.save((Fitness) u);
            }

        }
    }

    @PostUpdate
    public void postUpdate(Object o){
        UserRepository userRepository= BeanUtils.getBean(UserRepository.class);
        FitnessRepository fitnessRepository=BeanUtils.getBean(FitnessRepository.class);

        if(o instanceof Utility){
            Utility u=(Utility) o;

            u.setUpdatedAt(LocalDateTime.now());

            if(u instanceof User){
                userRepository.save((User)u);
            }else if(u instanceof Fitness){
                fitnessRepository.save((Fitness) u);
            }

        }
    }


}
