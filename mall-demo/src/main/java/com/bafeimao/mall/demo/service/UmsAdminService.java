package com.bafeimao.mall.demo.service;

import com.bafeimao.mall.demo.auth.AuthenticationRequest;
import com.bafeimao.mall.demo.auth.AuthenticationResponse;
import com.bafeimao.mall.demo.auth.RegisterRequest;
import com.bafeimao.mall.demo.config.JwtService;
import com.bafeimao.mall.demo.entity.UmsAdmin;
import com.bafeimao.mall.demo.repository.UmsAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author YouChuande
 */
@Service
@RequiredArgsConstructor
public class UmsAdminService {

    private final UmsAdminRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = UmsAdmin
                .builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
