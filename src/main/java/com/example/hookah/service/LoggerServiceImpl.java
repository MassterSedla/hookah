package com.example.hookah.service;

import com.example.hookah.model.Logger;
import com.example.hookah.model.LoggerTobacco;
import com.example.hookah.repository.LoggerRepository;
import com.example.hookah.repository.LoggerTobaccoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoggerServiceImpl implements LoggerService {
    private final LoggerRepository repository;
    private final LoggerTobaccoRepository loggerRepository;

    @Autowired
    public LoggerServiceImpl(LoggerRepository repository, LoggerTobaccoRepository loggerRepository) {
        this.repository = repository;
        this.loggerRepository = loggerRepository;
    }

    @Override
    public Logger addLog(Logger logger) {
        return repository.save(logger);
    }

    @Override
    public void fillLog(LoggerTobacco loggerTobacco) {
        loggerRepository.save(loggerTobacco);
    }

    @Override
    public List<Logger> showAllLogs() {
        return repository.findAll();
    }

}
