package com.example.backend.services;

import com.example.backend.entities.UserEntity;
import com.example.backend.Exceptions.ResourceNotFoundException;
import com.example.backend.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class UserServImp implements CRUD<UserEntity> {

    private final UserRepository userRepository;

    @Override
    public UserEntity create(UserEntity entity) {
        log.info("Creating user entity: {}", entity);
        return userRepository.save(entity);
    }

    @Override
    public void delete(UserEntity entity) {
        log.info("Deleting user entity: {}", entity);
        if (userRepository.existsById(entity.getId())) {
            userRepository.delete(entity);
        } else {
            log.warn("User entity not found: {}", entity);
            throw new ResourceNotFoundException("User entity not found with id: " + entity.getId());
        }
    }

    @Override
    public UserEntity modify(UserEntity entity) {
        log.info("Modifying user entity: {}", entity);
        if (userRepository.existsById(entity.getId())) {
            return userRepository.save(entity);
        } else {
            log.warn("User entity not found: {}", entity);
            throw new ResourceNotFoundException("User entity not found with id: " + entity.getId());
        }
    }

    @Override
    public List<UserEntity> findAll() {
        log.info("Retrieving all user entities");
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        log.info("Finding user entity by id: {}", id);
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User entity not found with id: " + id));
    }
}
