package dev.hardika.userAccessManagement.service;

import dev.hardika.userAccessManagement.dto.UserResponseDto;
import dev.hardika.userAccessManagement.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponseDto createUser(User user);
    boolean deleteUser(UUID id);
    List<UserResponseDto> getAllUser();
}
