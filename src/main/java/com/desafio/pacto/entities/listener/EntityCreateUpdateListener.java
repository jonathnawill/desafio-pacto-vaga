package com.desafio.pacto.entities.listener;

import com.desafio.pacto.entities.DateEntity;
import com.desafio.pacto.entities.DateInterface;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.io.Serializable;
import java.time.LocalDateTime;

public class EntityCreateUpdateListener implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrePersist
    protected void onCreate(DateInterface dateInterface) {
        LocalDateTime time = LocalDateTime.now();
        dateInterface.setDateEntity(new DateEntity(time, time, true));
    }

    @PreUpdate
    protected void onUpdate(DateInterface dateInterface) {
        dateInterface.getDateEntity().setRefresh(LocalDateTime.now());
    }
}
