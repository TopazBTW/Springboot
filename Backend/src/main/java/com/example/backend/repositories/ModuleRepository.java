package com.example.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.entities.ModuleEntity;
import org.springframework.stereotype.Repository;



@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity, Long> {

}
