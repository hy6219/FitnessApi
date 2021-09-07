package com.data_info.fitnessapi.controller;

import com.data_info.fitnessapi.domain.Fitness;
import com.data_info.fitnessapi.service.FitnessService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestController
@RequestMapping(value="/fitness")
@Api(value="등록된 피트니스 센터 데이터 레스트를 지원하는 컨트롤러")
public class FitnessRegisterController {

    @Qualifier(value="fitnessSerive")
    private FitnessService fitnessService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRegisteredFitness(@PageableDefault Pageable pageable, @RequestParam String province){
        Page<Fitness> info=fitnessService.getFitnessInfo(province,pageable);

        PagedModel.PageMetadata metadata=new PagedModel.PageMetadata(pageable.getPageSize(), info.getNumber(),info.getTotalElements());
        PagedModel<Fitness> resources=new PagedModel<>(info.getContent(),metadata);

        return ResponseEntity.ok(resources);
    }

}
