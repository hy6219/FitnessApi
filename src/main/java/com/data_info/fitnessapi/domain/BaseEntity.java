package com.data_info.fitnessapi.domain;

import com.data_info.fitnessapi.domain.listener.Utility;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity implements Utility{
    @Column(name="created_at")
    private LocalDateTime createdDate;
    @Column(name="updated_at")
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
