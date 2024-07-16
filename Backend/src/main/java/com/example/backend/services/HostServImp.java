package com.example.backend.services;

import com.example.backend.entities.HostEntity;
import com.example.backend.Exceptions.ResourceNotFoundException;
import com.example.backend.repositories.HostRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class HostServImp implements CRUD<HostEntity> {

    private final HostRepository hostRepository;

    @Override
    public HostEntity create(HostEntity entity) {
        log.info("Creating host entity: {}", entity);
        return hostRepository.save(entity);
    }

    @Override
    public void delete(HostEntity entity) {
        log.info("Deleting host entity: {}", entity);
        if (hostRepository.existsById(entity.getId())) {
            hostRepository.delete(entity);
        } else {
            log.warn("Host entity not found: {}", entity);
            throw new ResourceNotFoundException("Host entity not found with id: " + entity.getId());
        }
    }

    @Override
    public HostEntity modify(HostEntity entity) {
        log.info("Modifying host entity: {}", entity);
        if (hostRepository.existsById(entity.getId())) {
            return hostRepository.save(entity);
        } else {
            log.warn("Host entity not found: {}", entity);
            throw new ResourceNotFoundException("Host entity not found with id: " + entity.getId());
        }
    }

    @Override
    public List<HostEntity> findAll() {
        log.info("Retrieving all host entities");
        return hostRepository.findAll();
    }

    @Override
    public HostEntity findById(Long id) {
        log.info("Finding host entity by id: {}", id);
        return hostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Host entity not found with id: " + id));
    }
}
