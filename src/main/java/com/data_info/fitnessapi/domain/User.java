package com.data_info.fitnessapi.domain;

import com.data_info.fitnessapi.domain.enums.Gender;
import com.data_info.fitnessapi.domain.enums.Grade;
import com.data_info.fitnessapi.domain.listener.EntityListener;
import com.data_info.fitnessapi.domain.listener.Utility;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@EntityListeners(value={EntityListener.class})
@ApiModel(value="사이트 회원 정보")
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="사용자 등록 번호")
    private Long id;

    @ApiModelProperty(value="사용자 이름")
    private String name;

    @ApiModelProperty(value="사용자 이름")
    private int age;

    @Enumerated(value=EnumType.STRING)
    @ApiModelProperty(value="사용자 성별")
    private Gender gender;

    @Enumerated(value=EnumType.STRING)
    @ApiModelProperty(value="사용자 등급(비고객회원, 고객회원,트레이너회원,사업자회원,관리자)")
    private Grade grade;

    private String phone;

    private String link;

    private String desc;

    @ManyToOne
    @ToString.Exclude
    private Fitness fitness;


}
