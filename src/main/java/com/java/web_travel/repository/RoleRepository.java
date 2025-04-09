package com.java.web_travel.repository;

import com.java.web_travel.entity.Role;
import com.java.web_travel.enums.RoleCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleCode(RoleCode roleCode);
}
