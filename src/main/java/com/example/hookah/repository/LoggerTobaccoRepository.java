package com.example.hookah.repository;

import com.example.hookah.model.Logger;
import com.example.hookah.model.LoggerTobacco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerTobaccoRepository extends JpaRepository<LoggerTobacco, Integer> {

}
