package com.learninghub.learning.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.learninghub.learning.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}