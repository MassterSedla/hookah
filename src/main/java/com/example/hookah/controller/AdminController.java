package com.example.hookah.controller;

import com.example.hookah.HookahApplication;
import com.example.hookah.frame.Frame;
import com.example.hookah.model.Admin;
import com.example.hookah.model.Logger;
import com.example.hookah.model.LoggerTobacco;
import com.example.hookah.model.Tobacco;
import com.example.hookah.service.AdminServiceImpl;
import com.example.hookah.service.HookahBaseServiceImpl;
import com.example.hookah.service.LoggerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/*
* class for managing service methods
 */
@Controller
public class AdminController {
    private final FrameHandler handler;
    private final AdminServiceImpl service;
    private  final HookahBaseServiceImpl hookahBaseService;
    private final LoggerServiceImpl loggerService;
    private final Frame frame;

    @Autowired
    public AdminController(AdminServiceImpl service, HookahBaseServiceImpl hookahBaseService,
                           HookahApplication frame, LoggerServiceImpl loggerService) {
        this.service = service;
        this.hookahBaseService = hookahBaseService;
        this.loggerService = loggerService;
        handler = new FrameHandler(frame, this);
        Thread thread = new Thread(handler);
        thread.start();
        this.frame = handler.getFrame();
    }

    public boolean enter() {
        return service.authority(new Admin(frame.getInputUsername().getText(),
                frame.getInputPassword().getText()));
    }

    public void homePage() {
        handler.setTobaccoList(hookahBaseService.showAllTobacco());
        handler.setCoalsList(hookahBaseService.showAllCoals());
        handler.setLoggerList(loggerService.showAllLogs());
    }

    public void changeCoals(String nameOfCoals, int amount) {
        hookahBaseService.editCoals(nameOfCoals, amount);
    }

    public void changeTobacco(String nameOfTobacco, int amount) {
        hookahBaseService.editTobacco(nameOfTobacco, amount);
    }

    public void changeNameTobacco(String name, String newName) {
        hookahBaseService.editNameTobacco(name, newName);
    }

    public void addNewTobacco(String nameOfTobacco, int amount) {
        hookahBaseService.addNewTobacco(new Tobacco(nameOfTobacco, amount));
    }

    public Tobacco getTobacco(String tobaccoName) {
        return hookahBaseService.showTobaccoByName(tobaccoName);
    }

    public void logging(Logger logger, List<LoggerTobacco> loggerTobaccos) {
        Logger log = loggerService.addLog(logger);
        while (loggerTobaccos.size() > 0) {
            loggerTobaccos.get(0).setLogger(log);
            loggerService.fillLog(loggerTobaccos.get(0));
            loggerTobaccos.remove(0);
        }
    }
}
