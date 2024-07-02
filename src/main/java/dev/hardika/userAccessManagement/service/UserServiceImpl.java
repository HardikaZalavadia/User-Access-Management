package dev.hardika.userAccessManagement.service;

import dev.hardika.userAccessManagement.dto.UserResponseDto;
import dev.hardika.userAccessManagement.entity.User;
import dev.hardika.userAccessManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser(User user) {

        UserResponseDto
    }

    @Override
    public boolean deleteUser(UUID id) {
        return false;
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
