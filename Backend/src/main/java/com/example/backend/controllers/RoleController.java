package com.example.backend.controllers;

import com.example.backend.entities.RoleEntity;
import com.example.backend.services.RoleServImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class RoleController {

    private final RoleServImp roleService;

    @PostMapping
    public ResponseEntity<RoleEntity> createRole(@RequestBody RoleEntity role) {
        return ResponseEntity.ok(roleService.create(role));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleEntity> getRole(@PathVariable Long id) {
        RoleEntity role = roleService.findById(id);
        return ResponseEntity.ok(role);
    }

    @GetMapping
    public ResponseEntity<List<RoleEntity>> getAllRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleEntity> updateRole(@PathVariable Long id, @RequestBody RoleEntity role) {
        role.setId(id);
        return ResponseEntity.ok(roleService.modify(role));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        RoleEntity role = new RoleEntity();
        role.setId(id);
        roleService.delete(role);
        return ResponseEntity.noContent().build();
    }
}
