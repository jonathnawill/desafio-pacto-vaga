package com.desafio.pacto.services.impl;


import com.desafio.pacto.entities.User;
import com.desafio.pacto.entities.dto.AuthenticationDTO;
import com.desafio.pacto.entities.dto.LoginResponseDTO;
import com.desafio.pacto.services.AuthenticationService;
import com.desafio.pacto.services.TokenService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;


	public LoginResponseDTO loginUser(AuthenticationDTO data) {

		try {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					data.getUserName(), data.getPassword());

			Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
			User user = (User) authentication.getPrincipal();


			if(!user.getDateEntity().isActive()){
				throw new SecurityException("Usuário desativado");
			}

			String token = tokenService.generateToken(user);

			return new LoginResponseDTO(user.getId(), user.getUsername(), user.getName(), token, "Bearer", user.getUserRole().getDescricao());
		} catch (ServiceException e) {
			throw new SecurityException("Usuário ou senha incorretos. Por favor, tente novamente.");
		} catch (DisabledException e){
			throw new SecurityException("Usuário desativado");
		}
	}
}
