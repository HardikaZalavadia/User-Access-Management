package dev.hardika.userAccessManagement.controller;

import dev.hardika.userAccessManagement.dto.UserResponseDto;
import dev.hardika.userAccessManagement.entity.User;
import dev.hardika.userAccessManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> userResponseDtoList = userService.getAllUser();
        return ResponseEntity.ok(userResponseDtoList);
    }
}
