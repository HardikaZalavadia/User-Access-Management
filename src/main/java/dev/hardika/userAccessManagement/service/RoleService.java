package dev.hardika.userAccessManagement.service;

import dev.hardika.userAccessManagement.entity.Role;

import java.util.List;
import java.util.UUID;

public interface RoleService {
    UUID createRole(Role role);
    List<Role> getAllRoles();
}
