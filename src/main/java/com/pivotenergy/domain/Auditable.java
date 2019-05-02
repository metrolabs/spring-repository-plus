package com.pivotenergy.domain;

import java.time.LocalDateTime;

public interface Auditable<T> {
    LocalDateTime getCreatedAt();
    String getCreatedBy();
    LocalDateTime getUpdatedAt();
    String getUpdatedBy();
}
