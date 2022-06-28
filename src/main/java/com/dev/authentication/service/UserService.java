package com.dev.authentication.service;

import com.dev.authentication.exception.ObjectNotFoundException;
import com.dev.authentication.model.User;
import com.dev.authentication.model.dto.UserDTO;
import com.dev.authentication.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> findAll() {
        //returns a list referring to the model
        List<User> users = userRepository.findAll();
        //loops through the list and converts each model item into a dto
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
           throw new ObjectNotFoundException("User not found");
        }
        UserDTO userDTO = modelMapper.map(user.get(), UserDTO.class);
        //create and return Optional de UserDTO
        return userDTO;
    }

    public UserDTO save(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user = userRepository.save(user);
        return userDTO;
    }

    public UserDTO update(UserDTO userDTO) {
        try {
            Optional<User> currentUser = userRepository.findById(userDTO.getId());
            if (currentUser != null) {
                User user = modelMapper.map(userDTO, User.class);
                BeanUtils.copyProperties(userDTO, currentUser.get(), "id");
                userRepository.save(user);
            }
        } catch (NoSuchElementException exception) {
            throw new ObjectNotFoundException("User not Found.");
        }

        return userDTO;
    }

    public void delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ObjectNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }
}
