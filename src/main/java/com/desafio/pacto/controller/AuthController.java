package com.desafio.pacto.controller;


import com.desafio.pacto.entities.dto.AuthenticationDTO;
import com.desafio.pacto.entities.dto.LoginResponseDTO;
import com.desafio.pacto.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private AuthenticationService AuthenticationService;

	@PostMapping("/user/login")
	public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationDTO authentication) {
		try {
			LoginResponseDTO loginResponse = AuthenticationService.loginUser(authentication);
			return ResponseEntity.ok(loginResponse);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body( e.getMessage());
		}
	}
}
