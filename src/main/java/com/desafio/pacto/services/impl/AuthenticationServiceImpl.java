package com.desafio.pacto.services.impl;


import com.desafio.pacto.entities.User;
import com.desafio.pacto.entities.dto.AuthenticationDTO;
import com.desafio.pacto.entities.dto.LoginResponseDTO;
import com.desafio.pacto.entities.dto.RegisterUserDTO;
import com.desafio.pacto.entities.dto.UserDTO;
import com.desafio.pacto.repositories.UserRepository;
import com.desafio.pacto.services.AuthenticationService;
import com.desafio.pacto.services.TokenService;
import com.desafio.pacto.util.parser.UserParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Transactional
	public LoginResponseDTO loginUser(AuthenticationDTO data) {
		try {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					data.getUsername(), data.getPassword());

			Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
			User user = (User) authentication.getPrincipal();


			if (!user.getDateEntity().isActive()) {
				throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Usuário desativado. Por favor, entre em contato com o suporte.");
			}

			String token = tokenService.generateToken(user);

			return new LoginResponseDTO(user.getId(), user.getUsername(), user.getName(), token, "Bearer", user.getUserRole().getDescricao());
		} catch (BadCredentialsException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Nome de usuário ou senha inválidos.");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Erro de autenticação. Verifique suas credenciais.");
		}
	}



	@Override
	@Transactional
	public UserDTO registerUser(RegisterUserDTO user) {

	 Optional<User> existe = userRepository.findUserByUsername(user.getUsername());

		if(existe.isPresent()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome de Usuário '" + user.getUsername() + "' já existe.");
		}

		User usuario = UserParser.deDTORegister(user);

		usuario.setPassword(passwordEncoder.encode(user.getPassword()));

		User saveUser = userRepository.save(usuario);

		return UserParser.paraDTO(saveUser);
	}
}
