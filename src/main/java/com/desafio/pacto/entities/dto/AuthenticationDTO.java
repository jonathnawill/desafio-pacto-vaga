package com.desafio.pacto.entities.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthenticationDTO implements Serializable {

    private String userName;
    private String password;
}
