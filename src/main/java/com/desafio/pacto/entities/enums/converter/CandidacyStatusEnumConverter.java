package com.desafio.pacto.entities.enums.converter;

import com.desafio.pacto.entities.enums.CandidacyStatusEnum;
import jakarta.persistence.AttributeConverter;

public class CandidacyStatusEnumConverter implements AttributeConverter<CandidacyStatusEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CandidacyStatusEnum status) {
        return (status != null) ? status.getIdStatus() : null;
    }

    @Override
    public CandidacyStatusEnum convertToEntityAttribute(Integer dbData) {
        return (dbData != null) ? CandidacyStatusEnum.fromValue(dbData) : null;
    }
}
