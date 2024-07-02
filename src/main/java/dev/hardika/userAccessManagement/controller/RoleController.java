package dev.hardika.userAccessManagement.controller;

import dev.hardika.userAccessManagement.entity.Role;
import dev.hardika.userAccessManagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

     @PostMapping
    public ResponseEntity<UUID> createRole(@RequestBody Role role) {
        UUID roleId = roleService.createRole(role);
        return ResponseEntity.ok(roleId);
     }

     @GetMapping("allRoles")
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
     }
}
