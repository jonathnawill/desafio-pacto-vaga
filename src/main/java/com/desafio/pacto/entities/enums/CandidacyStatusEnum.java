package com.desafio.pacto.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum CandidacyStatusEnum {


    PENDING(1, "PENDENTE"),
    APPROVED(2, "APROVADO"),
    REJECTED(3, "REJEITADO");

    private final Integer idStatus;
    private final String description;

    private static final Map<Integer, CandidacyStatusEnum> idToStatus = new HashMap<>();

    CandidacyStatusEnum(Integer idStatus, String description) {
        this.idStatus = idStatus;
        this.description = description;
    }

    static {
        for (CandidacyStatusEnum status : CandidacyStatusEnum.values()) {
            idToStatus.put(status.getIdStatus(), status);
        }
    }

    @JsonCreator
    public static CandidacyStatusEnum fromValue(Integer idStatus) {
        return idToStatus.get(idStatus);
    }

    @JsonValue
    public Integer getIdStatus() {
        return idStatus;
    }

    public String getDescription() {
        return description;
    }
}