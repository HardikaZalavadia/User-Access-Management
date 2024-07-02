package dev.hardika.userAccessManagement.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "User_Role")
@Getter
@Setter
public class Role extends BaseModel{
    private String roleName;
    private String description;
}
