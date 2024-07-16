package com.example.backend.repositories;

import com.example.backend.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
