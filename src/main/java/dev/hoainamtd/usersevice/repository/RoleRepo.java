package dev.hoainamtd.usersevice.repository;

import dev.hoainamtd.usersevice.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
