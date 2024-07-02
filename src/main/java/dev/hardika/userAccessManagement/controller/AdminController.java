package dev.hardika.userAccessManagement.controller;

import dev.hardika.userAccessManagement.dto.UserResponseDto;
import dev.hardika.userAccessManagement.entity.User;
import dev.hardika.userAccessManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody User user) {
        UserResponseDto userResponseDto = userService.createUser(user);
        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.deleteUser(id));

    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> userResponseDtoList = userService.getAllUser();
        return ResponseEntity.ok(userResponseDtoList);
    }

}
