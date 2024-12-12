package com.desafio.pacto.entities.dto;

import com.desafio.pacto.entities.DateEntity;
import com.desafio.pacto.entities.enums.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String username;
    private UserRoleEnum userRole;
    private DateEntity dateEntity;

}
