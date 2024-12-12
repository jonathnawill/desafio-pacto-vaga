package com.desafio.pacto.util.parser;

import com.desafio.pacto.entities.User;
import com.desafio.pacto.entities.dto.RegisterUserDTO;
import com.desafio.pacto.entities.dto.UserDTO;
import com.desafio.pacto.entities.enums.UserRoleEnum;

public class UserParser {


    public static User deDTO(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setUserRole(userDTO.getUserRole());

        return user;
    }

    public static User deDTORegister(RegisterUserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setUserRole(UserRoleEnum.DEFAULT_USER);

        return user;
    }

    public static UserDTO paraDTO (User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setDateEntity(user.getDateEntity());
        return userDTO;
    }
}
