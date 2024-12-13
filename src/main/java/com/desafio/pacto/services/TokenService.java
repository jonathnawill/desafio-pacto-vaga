package com.desafio.pacto.services;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.desafio.pacto.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

	@Value("${api.security.token.secret}")
	private String secret;

	private Date genExpirationDate() {
		return Date.from(LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00")));
	}

	public String generateToken(User user) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create().withIssuer("auth-api").withSubject(user.getUsername())
					.withExpiresAt(genExpirationDate())
					.sign(algorithm);
			return token;
		} catch (JWTCreationException e) {
			throw new RuntimeException("Error while generating token", e);
		}
	}

	public String validateToken(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);
			String username = jwt.getSubject();


			Algorithm algorithm = Algorithm.HMAC256(secret);
			JWTVerifier verifier = JWT.require(algorithm).withIssuer("auth-api").withSubject(username).build();

			verifier.verify(token);
			return username;
		} catch (JWTVerificationException e) {
			throw new SecurityException("Token inválido ou expirado.");
		}
	}

}