package com.educational.MyForumHub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.educational.MyForumHub.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${myforumhub.security.token.secret}")
    private String secret;

    public String generateToken(User user){
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("auth0")
                    .withSubject(user.getLogin())
                    .withExpiresAt(tokenExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("error on generate token",exception);
        }
    }

    private Instant tokenExpirationDate() {
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
    }

    public String getSubject(String JwtToken){
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build()
                    .verify(JwtToken)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("invalid or expired token included on header.");
        }
    }

}
