package dev.hoainamtd.usersevice.service.impl;


import dev.hoainamtd.usersevice.domain.Role;
import dev.hoainamtd.usersevice.domain.User;
import dev.hoainamtd.usersevice.repository.RoleRepo;
import dev.hoainamtd.usersevice.repository.UserRepo;
import dev.hoainamtd.usersevice.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getFirstname());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        log.info("Adding new role {} to user {}", roleName, email);
        User user = userRepo.findByEmail(email).get();
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepo.findByEmail(username).get();
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all user {}");
        return userRepo.findAll();
    }
}
