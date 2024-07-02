package dev.hardika.userAccessManagement.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "UserApp")
@Getter
@Setter
public class User extends BaseModel{
    private String name;
    private String password;
    private String email;

    @ManyToMany
    private List<Role> roles;
}
