package com.example.backend.services;

import com.example.backend.entities.ModuleEntity;
import com.example.backend.Exceptions.ResourceNotFoundException;
import com.example.backend.repositories.ModuleRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ModuleServImp implements CRUD<ModuleEntity> {

    private final ModuleRepository moduleRepository;

    @Override
    public ModuleEntity create(ModuleEntity entity) {
        log.info("Creating module entity: {}", entity);
        return moduleRepository.save(entity);
    }

    @Override
    public void delete(ModuleEntity entity) {
        log.info("Deleting module entity: {}", entity);
        if (moduleRepository.existsById(entity.getId())) {
            moduleRepository.delete(entity);
        } else {
            log.warn("Module entity not found: {}", entity);
            throw new ResourceNotFoundException("Module entity not found with id: " + entity.getId());
        }
    }

    @Override
    public ModuleEntity modify(ModuleEntity entity) {
        log.info("Modifying module entity: {}", entity);
        if (moduleRepository.existsById(entity.getId())) {
            return moduleRepository.save(entity);
        } else {
            log.warn("Module entity not found: {}", entity);
            throw new ResourceNotFoundException("Module entity not found with id: " + entity.getId());
        }
    }

    @Override
    public List<ModuleEntity> findAll() {
        log.info("Retrieving all module entities");
        return moduleRepository.findAll();
    }

    @Override
    public ModuleEntity findById(Long id) {
        log.info("Finding module entity by id: {}", id);
        return moduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Module entity not found with id: " + id));
    }
}
