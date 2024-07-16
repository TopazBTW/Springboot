package com.example.backend.repositories;

import com.example.backend.entities.HostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HostRepository extends JpaRepository<HostEntity, Long> {

}
