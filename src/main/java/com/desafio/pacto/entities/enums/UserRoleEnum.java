package com.desafio.pacto.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum UserRoleEnum {

    DEFAULT_USER(1, "DEFAULT_USER"),
    ADMIN_USER(2, "ADMIN_USER");

    private Integer idUserRole;

    private String descricao;

    private static final Map<Integer, UserRoleEnum> idToUserRole = new HashMap<>();

    private UserRoleEnum(Integer idUserRole, String descricao) {
        this.idUserRole = idUserRole;
        setDescricao(descricao);
    }

    static {
        for (UserRoleEnum userRole : UserRoleEnum.values()) {
            idToUserRole.put(userRole.getValor(), userRole);
        }
    }

    @JsonCreator
    public static UserRoleEnum fromValor(Integer idUserRole) {
        return idToUserRole.get(idUserRole);
    }

    @JsonValue
    public Integer getValor() {
        return idUserRole;
    }

    public Integer getIdUserRole() {
        return this.idUserRole;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}