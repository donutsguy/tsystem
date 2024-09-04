package com.tsys.exauth.controllers;

import com.tsys.exauth.domain.user.User;
import com.tsys.exauth.domain.user.UserDTO;
import com.tsys.exauth.domain.user.UserRegisterDTO;
import com.tsys.exauth.infra.security.TokenModel;
import com.tsys.exauth.infra.security.TokenService;
import com.tsys.exauth.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth =  this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        var tokenResponse = new TokenModel(token);

        return ResponseEntity.status(HttpStatus.OK).body(tokenResponse);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserRegisterDTO data) {
        if(userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String passwordHash = new BCryptPasswordEncoder().encode(data.password());
        User user = new User(data.login(), passwordHash, data.role());

        userRepository.save(user);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/logout")
    public ResponseEntity logout() {
        SecurityContextHolder.clearContext();
        return new ResponseEntity<String>("Logout Successfully!", HttpStatus.OK);
    }
}
