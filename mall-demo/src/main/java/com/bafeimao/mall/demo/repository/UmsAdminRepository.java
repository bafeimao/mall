package com.bafeimao.mall.demo.repository;

import com.bafeimao.mall.demo.entity.UmsAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author YouChuande
 */
@Repository
public interface UmsAdminRepository extends JpaRepository<UmsAdmin, Long> {

    Optional<UmsAdmin> findByEmail(String email);

    Optional<UmsAdmin> findByUsername(String username);
}
