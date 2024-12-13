package com.desafio.pacto.controller;

import com.desafio.pacto.entities.dto.UserDTO;
import com.desafio.pacto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long userId) throws Exception {
        UserDTO userDTO = userService.findById(userId);
        return ResponseEntity.ok(userDTO);
    }
}
