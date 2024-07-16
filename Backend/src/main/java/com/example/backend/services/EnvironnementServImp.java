package com.example.backend.services;

import com.example.backend.entities.EnvironnementEntity;
import com.example.backend.Exceptions.ResourceNotFoundException;
import com.example.backend.repositories.EnvironnementRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class EnvironnementServImp implements CRUD<EnvironnementEntity> {

    private final EnvironnementRepository environnementRepository;

    @Override
    public EnvironnementEntity create(EnvironnementEntity entity) {
        log.info("Creating environnement entity: {}", entity);
        return environnementRepository.save(entity);
    }

    @Override
    public void delete(EnvironnementEntity entity) {
        log.info("Deleting environnement entity: {}", entity);
        if (environnementRepository.existsById(entity.getId())) {
            environnementRepository.delete(entity);
        } else {
            log.warn("Environnement entity not found: {}", entity);
            throw new ResourceNotFoundException("Environnement entity not found with id: " + entity.getId());
        }
    }

    @Override
    public EnvironnementEntity modify(EnvironnementEntity entity) {
        log.info("Modifying environnement entity: {}", entity);
        if (environnementRepository.existsById(entity.getId())) {
            return environnementRepository.save(entity);
        } else {
            log.warn("Environnement entity not found: {}", entity);
            throw new ResourceNotFoundException("Environnement entity not found with id: " + entity.getId());
        }
    }

    @Override
    public List<EnvironnementEntity> findAll() {
        log.info("Retrieving all environnement entities");
        return environnementRepository.findAll();
    }

    @Override
    public EnvironnementEntity findById(Long id) {
        log.info("Finding environnement entity by id: {}", id);
        return environnementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Environnement entity not found with id: " + id));
    }
}
