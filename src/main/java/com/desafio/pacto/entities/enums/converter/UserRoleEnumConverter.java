package com.desafio.pacto.entities.enums.converter;

import com.desafio.pacto.entities.enums.UserRoleEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

@Convert
public class UserRoleEnumConverter implements AttributeConverter<UserRoleEnum, Integer> {


    @Override
    public Integer convertToDatabaseColumn(UserRoleEnum attribute) {
        return  attribute != null ? attribute.getValor() : null;
    }

    @Override
    public UserRoleEnum convertToEntityAttribute(Integer dbData) {
        return dbData != null ? UserRoleEnum.fromValor(Integer.valueOf(dbData)) : null;
    }
}
