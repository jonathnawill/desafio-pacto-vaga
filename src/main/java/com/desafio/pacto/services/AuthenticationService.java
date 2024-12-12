package com.desafio.pacto.services;

import com.desafio.pacto.entities.dto.AuthenticationDTO;
import com.desafio.pacto.entities.dto.LoginResponseDTO;

public interface AuthenticationService {

    LoginResponseDTO loginUser (AuthenticationDTO data);

}
