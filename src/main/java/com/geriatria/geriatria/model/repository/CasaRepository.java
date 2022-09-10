package com.geriatria.geriatria.model.repository;

import com.geriatria.geriatria.model.entities.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaRepository extends JpaRepository<Casa, Integer> {
}
