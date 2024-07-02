package dev.hardika.userAccessManagement.service;

import dev.hardika.userAccessManagement.dto.UserResponseDto;
import dev.hardika.userAccessManagement.entity.User;
import dev.hardika.userAccessManagement.exception.UserNotFoundException;
import dev.hardika.userAccessManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder password;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder password) {
        this.userRepository = userRepository;
        this.password = password;
    }

    @Override
    public UserResponseDto createUser(User user) {
        user.setPassword(password.encode(user.getPassword()));

        User saveUser = userRepository.save(user);
        UserResponseDto userResponseDto = UserResponseDto.converUserToUserResponseDto(saveUser);
        return userResponseDto;
    }

    @Override
    public boolean deleteUser(UUID id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User is not present of this UserId :"+id));

        userRepository.deleteById(id);
        return true;
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserResponseDto> userResponseDto = new ArrayList<>();

        for(User user : users) {
                userResponseDto.add(UserResponseDto.converUserToUserResponseDto(user));
        }

        return userResponseDto;
    }
}
