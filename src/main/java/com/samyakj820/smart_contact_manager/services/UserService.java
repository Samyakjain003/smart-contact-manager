package com.samyakj820.smart_contact_manager.services;

import java.util.List;
import java.util.Optional;

import com.samyakj820.smart_contact_manager.entities.User;

public interface UserService {

    User saveUser(User user);
    Optional<User> getUserById(String id);
    Optional<User> updateUser(User user);
    void deleteUser(String id);
    Boolean isUserExist(String userId);
    Boolean isUserExistByEmail(String email);
    List<User> getAllUsers();
}
