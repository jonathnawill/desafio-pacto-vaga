package com.desafio.pacto.config;

import com.desafio.pacto.services.CustomUserDetailsServiceImpl;
import com.desafio.pacto.services.TokenService;

import javax.naming.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, PATCH");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
			return;
		}

		try {
			var token = this.recoverToken(request);

			if (token != null) {
				var login = tokenService.validateToken(token);
				if (login == null) {
					throw new AuthenticationException("Token inválido ou expirado") {};
				}

				UserDetails pessoa = customUserDetailsServiceImpl.loadUserByUsername(login);
				if (pessoa == null) {
					throw new AuthenticationException("Usuário não encontrado para o token fornecido") {};
				}

				var authentication = new UsernamePasswordAuthenticationToken(pessoa, null, pessoa.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (AuthenticationException e) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
			return;
		}

		filterChain.doFilter(request, response);
	}

	private String recoverToken(HttpServletRequest request) {
		var authHeader = request.getHeader("Authorization");
		if (authHeader == null) {
			return null;
		}
		return authHeader.replace("Bearer ", "");
	}
}
