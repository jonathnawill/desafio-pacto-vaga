package com.desafio.pacto.services.impl;

import com.desafio.pacto.entities.User;
import com.desafio.pacto.entities.dto.UserDTO;
import com.desafio.pacto.repositories.UserRepository;
import com.desafio.pacto.services.UserService;
import com.desafio.pacto.util.parser.UserParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDTO findById(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()) {
            throw new Exception("Usuario não existe");
        }
        return UserParser.paraDTO(user.get());
    }
}
