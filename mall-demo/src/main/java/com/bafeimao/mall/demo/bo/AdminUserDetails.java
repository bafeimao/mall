package com.bafeimao.mall.demo.bo;

import com.bafeimao.mall.demo.entity.UmsAdmin;
import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author YouChuande
 */
public class AdminUserDetails implements UserDetails {

    private UmsAdmin admin;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Lists.newArrayList(new SimpleGrantedAuthority("TEST"));
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
