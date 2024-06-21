package com.samyakj820.smart_contact_manager.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samyakj820.smart_contact_manager.entities.User;
import com.samyakj820.smart_contact_manager.helper.ResourceNotFoundException;
import com.samyakj820.smart_contact_manager.respositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User oldUser = userRepository.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPhoneNumber(user.getPhoneNumber());
        oldUser.setPassword(user.getPassword());
        oldUser.setAbout(user.getAbout());
        oldUser.setProfilePic(user.getProfilePic());
        oldUser.setEmailVerified(user.getEmailVerified());
        oldUser.setPhoneVerified(user.getPhoneVerified());
        oldUser.setProvider(user.getProvider());
        oldUser.setProviderUserId(user.getProviderUserId());

        User newUser = userRepository.save(oldUser);
        return Optional.ofNullable(newUser);
    }

    @Override
    public void deleteUser(String id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        userRepository.delete(user);
    }

    @Override
    public Boolean isUserExist(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        return user != null ? true : false;
    }

    @Override
    public Boolean isUserExistByEmail(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        return user != null ? true : false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
