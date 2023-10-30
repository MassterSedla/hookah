package com.example.hookah.repository;

import com.example.hookah.model.Coals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoalsRepository extends JpaRepository<Coals, Integer> {
    Coals findByNameOfCoals(String nameOfCoals);
}
