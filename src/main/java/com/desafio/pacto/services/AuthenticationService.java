package com.desafio.pacto.services;

import com.desafio.pacto.entities.User;
import com.desafio.pacto.entities.dto.AuthenticationDTO;
import com.desafio.pacto.entities.dto.LoginResponseDTO;
import com.desafio.pacto.entities.dto.RegisterUserDTO;
import com.desafio.pacto.entities.dto.UserDTO;

public interface AuthenticationService {

    LoginResponseDTO loginUser (AuthenticationDTO data);

    UserDTO registerUser (RegisterUserDTO user);

}
