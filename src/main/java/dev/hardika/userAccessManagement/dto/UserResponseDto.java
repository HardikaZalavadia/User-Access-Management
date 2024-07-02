package dev.hardika.userAccessManagement.dto;

import dev.hardika.userAccessManagement.entity.Role;
import dev.hardika.userAccessManagement.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserResponseDto {
    private UUID userId;
    private String userName;
    private String emailId;
    private List<String> roleName;

    public static UserResponseDto converUserToUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUserId(user.getId());
        userResponseDto.setUserName(user.getName());
        userResponseDto.setEmailId(user.getEmail());
        List<String> roleName = new ArrayList<>();
        for(Role role : user.getRoles()) {
            roleName.add(role.getRoleName());
        }
        userResponseDto.setRoleName(roleName);
        return userResponseDto;
    }
}
