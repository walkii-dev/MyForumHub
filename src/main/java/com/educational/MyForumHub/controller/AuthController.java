package com.educational.MyForumHub.controller;

import com.educational.MyForumHub.domain.user.*;
import com.educational.MyForumHub.infra.security.JwtTokenData;
import com.educational.MyForumHub.infra.security.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthService authService;

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){
        var user = userRepository.getReferenceById(id);
        return ResponseEntity.ok(new UserDetailsData(user));
    }


    @PostMapping("/login")
    @Transactional
    public ResponseEntity login(@RequestBody @Valid AuthData data){
        var token = new UsernamePasswordAuthenticationToken(data.login(),data.password());
        var auth = authManager.authenticate(token);
        var JWTtoken = tokenService.generateToken((User)auth.getPrincipal());
        return ResponseEntity.ok(new JwtTokenData(JWTtoken));
    }

    @PostMapping("/signup")
    @Transactional
    public ResponseEntity signUp (@RequestBody @Valid UserSignupData data, UriComponentsBuilder uriBuilder) {
        var user = authService.signUp(data);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDetailsData(user));
    }

}
