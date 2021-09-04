package com.data_info.fitnessapi.repository;

import com.data_info.fitnessapi.domain.Fitness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FitnessRepository extends JpaRepository<Fitness,Long> {

}
