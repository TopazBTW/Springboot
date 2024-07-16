package com.example.backend.controllers;

import com.example.backend.entities.EnvironnementEntity;
import com.example.backend.services.EnvironnementServImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/environments")
@AllArgsConstructor
public class EnvironnementController {

    private final EnvironnementServImp environnementService;

    @PostMapping
    public ResponseEntity<EnvironnementEntity> createEnvironment(@RequestBody EnvironnementEntity environment) {
        return ResponseEntity.ok(environnementService.create(environment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvironnementEntity> getEnvironment(@PathVariable Long id) {
        EnvironnementEntity environment = environnementService.findById(id);
        return ResponseEntity.ok(environment);
    }

    @GetMapping
    public ResponseEntity<List<EnvironnementEntity>> getAllEnvironments() {
        return ResponseEntity.ok(environnementService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvironnementEntity> updateEnvironment(@PathVariable Long id, @RequestBody EnvironnementEntity environment) {
        environment.setId(id);
        return ResponseEntity.ok(environnementService.modify(environment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvironment(@PathVariable Long id) {
        EnvironnementEntity environment = new EnvironnementEntity();
        environment.setId(id);
        environnementService.delete(environment);
        return ResponseEntity.noContent().build();
    }
}
