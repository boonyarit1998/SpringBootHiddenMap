package com.api.hiddenMap.controller;

import com.api.hiddenMap.dto.LoginRequestDTO;
import com.api.hiddenMap.dto.LoginResponseDTO;
import com.api.hiddenMap.dto.UserRequestDTO;
import com.api.hiddenMap.entity.Role;
import com.api.hiddenMap.entity.UserEntity;
import com.api.hiddenMap.service.UserService;
import com.api.hiddenMap.utility.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRequestDTO request){
        if (userService.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        userService.registerUser(user);
        return ResponseEntity.ok("Register success");

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO>  loginUser(@RequestBody LoginRequestDTO loginRequestDTO){
        UserEntity user = userService.findByEmail(loginRequestDTO.getEmail()).orElse(null);

        if (!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
            return ResponseEntity.badRequest().build();
        }

        String token = jwtUtil.generateToken(user);
        LoginResponseDTO login = new LoginResponseDTO(token);
        return ResponseEntity.ok(login);
    }
}
