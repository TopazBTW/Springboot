package com.example.backend.repositories;

import com.example.backend.entities.EnvironnementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvironnementRepository extends JpaRepository<EnvironnementEntity, Long> {
    boolean existsById(Long id);

}
