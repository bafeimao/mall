package com.bafeimao.mall.demo.controller;

import com.bafeimao.mall.demo.auth.AuthenticationRequest;
import com.bafeimao.mall.demo.auth.AuthenticationResponse;
import com.bafeimao.mall.demo.auth.RegisterRequest;
import com.bafeimao.mall.demo.service.UmsAdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YouChuande
 */
@RestController
@RequestMapping("/admin")
@Tag(name = "后台用户管理", description = "后台用户管理")
@RequiredArgsConstructor
public class UmsAdminController {

    private final UmsAdminService service;

    @PostMapping("register")
    @Operation(summary = "用户注册")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("login")
    @Operation(summary = "登录以后返回token")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.login(request));
    }

    @PostMapping("token/refresh")
    @Operation(summary = "刷新token")
    public Object refreshToken() {
        return null;
    }

}
