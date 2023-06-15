package com.bafeimao.mall.demo.entity;

import com.google.common.collect.Lists;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author YouChuande
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "ums_admin")
public class UmsAdmin implements UserDetails {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String icon;

    private String email;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Lists.newArrayList(new SimpleGrantedAuthority("TEST"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
