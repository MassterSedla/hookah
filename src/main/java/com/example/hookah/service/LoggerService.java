package com.example.hookah.service;

import com.example.hookah.model.Logger;
import com.example.hookah.model.LoggerTobacco;

import java.util.List;

public interface LoggerService {
    Logger addLog(Logger logger);
    List<Logger> showAllLogs();
    void fillLog(LoggerTobacco loggerTobacco);
}
