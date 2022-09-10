package com.geriatria.geriatria.model.repository;

import com.geriatria.geriatria.model.entities.Idoso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdosoRepository extends JpaRepository<Idoso, Integer> {
}
