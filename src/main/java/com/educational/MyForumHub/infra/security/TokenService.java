package com.educational.MyForumHub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.educational.MyForumHub.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

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

//    public void method2(){
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9.eyJpc3MiOiJhdXRoMCJ9.AbIJTDMFc7yUa5MhvcP03nJPyCPzZtQcGEp-zWfOkEE";
//        DecodedJWT decodedJWT;
//        try {
//            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
//            JWTVerifier verifier = JWT.require(algorithm)
//                    // specify any specific claim validations
//                    .withIssuer("auth0")
//                    // reusable verifier instance
//                    .build();
//
//            decodedJWT = verifier.verify(token);
//        } catch (JWTVerificationException exception){
//            // Invalid signature/claims
//        }
//    }

}
