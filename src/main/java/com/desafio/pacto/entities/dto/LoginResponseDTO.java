package com.desafio.pacto.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String Username;
    private String name;
    private String token;
    private String tipo;
    private String userRole;



}
