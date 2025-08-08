package com.educational.MyForumHub.controller;

import com.educational.MyForumHub.domain.user.AuthData;
import com.educational.MyForumHub.domain.user.User;
import com.educational.MyForumHub.infra.security.JwtTokenData;
import com.educational.MyForumHub.infra.security.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    @Transactional
    public ResponseEntity login(@RequestBody @Valid AuthData data){
        var token = new UsernamePasswordAuthenticationToken(data.login(),data.password());
        var auth = authManager.authenticate(token);
        var JWTtoken = tokenService.generateToken((User)auth.getPrincipal());
        return ResponseEntity.ok(new JwtTokenData(JWTtoken));
    }

//    @PostMapping("/signup")
//    @Transactional
//    public ResponseEntity signUp(){
//
//
//
//        return ResponseEntity.created(uri).body(login);
//    }


}
