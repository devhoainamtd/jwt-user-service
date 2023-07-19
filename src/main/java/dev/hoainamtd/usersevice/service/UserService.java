package dev.hoainamtd.usersevice.service;

import dev.hoainamtd.usersevice.domain.Role;
import dev.hoainamtd.usersevice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String email, String roleName);
    User getUser(String firsname);
    List<User> getUsers();
}
