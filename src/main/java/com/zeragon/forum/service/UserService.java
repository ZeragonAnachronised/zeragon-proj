package com.zeragon.forum.service;

import com.zeragon.forum.model.User;
import com.zeragon.forum.model.UserDTO;
import com.zeragon.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return convertUsersToDTO(userRepository.findAll());
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<UserDTO> convertUsersToDTO(List<User> users) {
        List<UserDTO> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(convertUserToDTO(user));
        }
        return dtos;
    }

    public UserDTO convertUserToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }
}