package com.desafio.pacto.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String username;

    private String password;
}
