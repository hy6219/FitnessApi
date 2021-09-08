package com.data_info.fitnessapi.domain;

import com.data_info.fitnessapi.domain.enums.Gender;
import com.data_info.fitnessapi.domain.enums.Grade;
import com.data_info.fitnessapi.domain.listener.EntityListener;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@EntityListeners(value={EntityListener.class})
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="사용자 등록 번호")
    private Long id;

    @ApiModelProperty(value="사용자 이름")
    private String name;

    @ApiModelProperty(value="사용자 나이")
    private int age;

    @ApiModelProperty(value="사용자 아이디")
    @Column(name="registered_id")
    private String userId;

    @ApiModelProperty(value="사용자 비밀번호")
    @Column(name="password")
    private String password;

    @Enumerated(value=EnumType.STRING)
    @ApiModelProperty(value="사용자 성별")
    private Gender gender;

    @Enumerated(value=EnumType.STRING)
    @ApiModelProperty(value="사용자 등급(비고객회원, 고객회원,트레이너회원,사업자회원,관리자)")
    private Grade grade;

    @ApiModelProperty(value="사용자 연락처")
    private String phone;

    @ApiModelProperty(value="sns 등 사용자의 PR 링크")
    private String link;

    @ApiModelProperty(value="사용자 자기소개")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Fitness fitness;


}
