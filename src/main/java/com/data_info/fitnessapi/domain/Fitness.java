package com.data_info.fitnessapi.domain;

import com.data_info.fitnessapi.domain.listener.EntityListener;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@EntityListeners(value={EntityListener.class})
@ApiModel(value="피트니스 센터 정보")
public class Fitness extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="피트니스 센터 등록번호")
    @Column(name="id")
    private Long id;

    @ApiModelProperty(value="피트니스 센터 사업장 이름")
    @Column(name="name")
    private String name;

    @ApiModelProperty(value="피트니스 센터 대표 사업자")
    @Column(name="owner_name")
    private String ownerName;

    @ApiModelProperty(value="피트니스 센터가 소속된 도 혹은 시")
    @Column(name="province")
    private String province;

    @ApiModelProperty(value="피트니스 센터가 소속된 시/군/구")
    @Column(name="mid_province")
    private String midProvince;

    @ApiModelProperty(value="피트니스 센터가 소속된 읍/면/동")
    @Column(name="town")
    private String town;

    @ApiModelProperty(value="피트니스 센터 사업자 등록번호")
    @Column(name="register_id")
    private String registerId;

    @OneToMany(mappedBy = "fitness")
    @ToString.Exclude
    private List<User> users=new ArrayList<>();
}
