package com.data_info.fitnessapi.domain.listener;

import java.time.LocalDateTime;

public interface Utility {
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();

    void setCreatedAt(LocalDateTime createdAt);
    void setUpdatedAt(LocalDateTime updatedAt);
}
