package com.data_info.fitnessapi.controller;

import com.data_info.fitnessapi.domain.Fitness;
import com.data_info.fitnessapi.service.FitnessService;
import io.swagger.annotations.*;
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
@Api(tags={"등록된 피트니스 센터 데이터 레스트를 지원하는 컨트롤러"})
public class FitnessRegisterController {

    @Qualifier(value="fitnessSerive")
    private FitnessService fitnessService;

    @ApiOperation(value="피트니스 센터 정보를 출력해주는 메서드",httpMethod = "GET")
    @ApiResponses(value={
            @ApiResponse(code=200,message = "올바른 접근입니다"),
            @ApiResponse(code=404,message = "uri 정보를 확인해보세요"),
            @ApiResponse(code=500,message="서버 내부 문제가 발생하였습니다. 관리자에게 문의 부탁드립니다")
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="province",value="관할 시/도",example = "서울특별시")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRegisteredFitness(@PageableDefault Pageable pageable, @RequestParam String province){
        Page<Fitness> info=fitnessService.getFitnessInfo(province,pageable);

        PagedModel.PageMetadata metadata=new PagedModel.PageMetadata(pageable.getPageSize(), info.getNumber(),info.getTotalElements());
        PagedModel<Fitness> resources=new PagedModel<>(info.getContent(),metadata);

        return ResponseEntity.ok(resources);
    }

}
