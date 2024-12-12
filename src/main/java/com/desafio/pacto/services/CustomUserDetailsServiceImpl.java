package com.desafio.pacto.services;

import com.desafio.pacto.entities.User;
import com.desafio.pacto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository
				.findUserByUsername(username);

		return user.orElseThrow(
				() -> new UsernameNotFoundException("Usuário não encontrado com o identificador: " + username));


	}

}
