package dev.hardika.userAccessManagement.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends BaseModel{
    private String name;
    private String password;
    private String email;

    @OneToMany
    private Role role;
}
