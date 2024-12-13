package com.desafio.pacto.services;

import com.desafio.pacto.entities.dto.UserDTO;

public interface UserService {

    UserDTO findById(Long id) throws Exception;
}
