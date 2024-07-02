package dev.hardika.userAccessManagement.service;

import dev.hardika.userAccessManagement.entity.Role;
import dev.hardika.userAccessManagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public UUID createRole(Role role) {
        Role newRole = roleRepository.save(role);
        return newRole.getId();
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }


}
