package com.data_info.fitnessapi.domain;

import com.data_info.fitnessapi.domain.listener.Utility;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@MappedSuperclass
@ApiModel(value="공통적인 부분을 관리하는 클래스")
public class BaseEntity implements Utility{
    @Column(name="created_at")
    @ApiModelProperty(value="생성일")
    private LocalDateTime createdDate;

    @Column(name="updated_at")
    @ApiModelProperty(value="수정일")
    private LocalDateTime updatedDate;

    @Override
    public LocalDateTime getCreatedAt() {
        return this.createdDate;
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return this.updatedDate;
    }

    @Override
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdDate=createdAt;
    }

    @Override
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedDate=updatedAt;
    }
}
