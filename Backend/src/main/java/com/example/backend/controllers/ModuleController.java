package com.example.backend.controllers;

import com.example.backend.entities.ModuleEntity;
import com.example.backend.services.ModuleServImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
@AllArgsConstructor
public class ModuleController {

    private final ModuleServImp moduleService;

    @PostMapping
    public ResponseEntity<ModuleEntity> createModule(@RequestBody ModuleEntity module) {
        return ResponseEntity.ok(moduleService.create(module));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleEntity> getModule(@PathVariable Long id) {
        ModuleEntity module = moduleService.findById(id);
        return ResponseEntity.ok(module);
    }

    @GetMapping
    public ResponseEntity<List<ModuleEntity>> getAllModules() {
        return ResponseEntity.ok(moduleService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuleEntity> updateModule(@PathVariable Long id, @RequestBody ModuleEntity module) {
        module.setId(id);
        return ResponseEntity.ok(moduleService.modify(module));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        ModuleEntity module = new ModuleEntity();
        module.setId(id);
        moduleService.delete(module);
        return ResponseEntity.noContent().build();
    }
}
