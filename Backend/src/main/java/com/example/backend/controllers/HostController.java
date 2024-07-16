package com.example.backend.controllers;

import com.example.backend.entities.HostEntity;
import com.example.backend.services.HostServImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
@AllArgsConstructor
public class HostController {

    private final HostServImp hostService;

    @PostMapping
    public ResponseEntity<HostEntity> createHost(@RequestBody HostEntity host) {
        return ResponseEntity.ok(hostService.create(host));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HostEntity> getHost(@PathVariable Long id) {
        HostEntity host = hostService.findById(id);
        return ResponseEntity.ok(host);
    }

    @GetMapping
    public ResponseEntity<List<HostEntity>> getAllHosts() {
        return ResponseEntity.ok(hostService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HostEntity> updateHost(@PathVariable Long id, @RequestBody HostEntity host) {
        host.setId(id);
        return ResponseEntity.ok(hostService.modify(host));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHost(@PathVariable Long id) {
        HostEntity host = new HostEntity();
        host.setId(id);
        hostService.delete(host);
        return ResponseEntity.noContent().build();
    }
}
