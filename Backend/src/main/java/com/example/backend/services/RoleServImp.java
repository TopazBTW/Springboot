package com.example.backend.services;

import com.example.backend.entities.RoleEntity;
import com.example.backend.Exceptions.ResourceNotFoundException;
import com.example.backend.repositories.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class RoleServImp implements CRUD<RoleEntity> {

    private final RoleRepository roleRepository;

    @Override
    public RoleEntity create(RoleEntity entity) {
        log.info("Creating role entity: {}", entity);
        return roleRepository.save(entity);
    }

    @Override
    public void delete(RoleEntity entity) {
        log.info("Deleting role entity: {}", entity);
        if (roleRepository.existsById(entity.getId())) {
            roleRepository.delete(entity);
        } else {
            log.warn("Role entity not found: {}", entity);
            throw new ResourceNotFoundException("Role entity not found with id: " + entity.getId());
        }
    }

    @Override
    public RoleEntity modify(RoleEntity entity) {
        log.info("Modifying role entity: {}", entity);
        if (roleRepository.existsById(entity.getId())) {
            return roleRepository.save(entity);
        } else {
            log.warn("Role entity not found: {}", entity);
            throw new ResourceNotFoundException("Role entity not found with id: " + entity.getId());
        }
    }

    @Override
    public List<RoleEntity> findAll() {
        log.info("Retrieving all role entities");
        return roleRepository.findAll();
    }

    @Override
    public RoleEntity findById(Long id) {
        log.info("Finding role entity by id: {}", id);
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role entity not found with id: " + id));
    }
}
