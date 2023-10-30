package com.example.hookah.controller;

import com.example.hookah.HookahApplication;
import com.example.hookah.frame.Frame;
import com.example.hookah.model.Coals;
import com.example.hookah.model.Logger;
import com.example.hookah.model.LoggerTobacco;
import com.example.hookah.model.Tobacco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*
* class for receiving and processing data from a
* frame and transmitting it to the controller
 */
@Component
public class FrameHandler implements Runnable{
    private boolean check;
    private boolean order;
    private Logger log;
    private final List<LoggerTobacco> loggerTobaccos = new ArrayList<>();
    private int amountOfCoalsToOrder;
    private final Frame frame;
    private final AdminController controller;
    private String enterText;
    private List<Tobacco> tobaccoList;
    private List<Coals> coalsList;
    private List<Logger> loggerList;

    @Autowired
    public FrameHandler(HookahApplication frame, AdminController controller) {
        this.frame = frame;
        this.controller = controller;
        check = true;
        enterText = "<html><p style = \"text-align: center;\">Enter</p>" +
                "<p style = \"text-align: center;\">Input username and password</p></html>";
    }

    public void run() {
        while (check) {
            if (frame.getFlags().isEnter()) {
                frame.getFlags().setEnter(false);
                enter();
            } else if (frame.getFlags().isHomePage()) {
                frame.getFlags().setHomePage(false);
                homePage();
                check = false;
            } else {
                check = false;
            }
        }
    }

    public void enter() {
        frame.enter(enterText);
        while (!frame.getFlags().isEnter()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (controller.enter()) {
            frame.getFlags().setEnter(false);
            frame.getFlags().setHomePage(true);
        } else {
            enterText = "<html><p style = \"text-align: center;\">Incorrect username or password</p>" +
                    "<p style = \"text-align: center;\">Try again</p></html>";
        }
    }

    public void homePage() {
        controller.homePage();
        tobaccoList.stream().sorted();
        frame.homePage(tobaccoList, coalsList, loggerList);
        while (true) {
            if (frame.getFlags().isChangeCoals()) {
                String name = frame.getSelectionList().get(0);
                controller.changeCoals(name, frame.getSelection().get(name));
                amountOfCoalsToOrder = frame.getSelection().get(name);
                frame.getSelectionList().remove(name);
                frame.getSelection().remove(name);
                frame.getFlags().setChangeCoals(false);
                if (!frame.getFlags().isChangeTobacco()) {
                    controller.homePage();
                    frame.homePage(tobaccoList, coalsList, loggerList);
                } else {
                    order = true;
                }

            } else if (frame.getFlags().isChangeTobacco()) {
                if (order) {
                    log = new Logger();
                    log.setAmountOfCoals(amountOfCoalsToOrder);
                    log.setPrice(frame.getPrice());
                }
                while (frame.getSelectionList().size() > 0) {
                    String name = frame.getSelectionList().get(0);
                    if (order) {
                        loggerTobaccos.add(new LoggerTobacco(controller.getTobacco(name),
                                frame.getSelection().get(name)));
                    } else if (!name.equals(frame.getNewTobaccoName())) {
                        controller.changeNameTobacco(name, frame.getNewTobaccoName());
                    }
                    controller.changeTobacco(frame.getNewTobaccoName(), frame.getSelection().get(name));
                    frame.getSelectionList().remove(name);
                    frame.getSelection().remove(name);
                }
                if (order) {
                    controller.logging(log, loggerTobaccos);
                }
                frame.getFlags().setChangeTobacco(false);
                controller.homePage();
                frame.homePage(tobaccoList, coalsList, loggerList);
            } else if (frame.getFlags().isAddNewTobacco()) {
                String name = frame.getSelectionList().get(0);
                controller.addNewTobacco(name, frame.getSelection().get(name));
                frame.getSelectionList().remove(name);
                frame.getSelection().remove(name);
                frame.getFlags().setAddNewTobacco(false);
                controller.homePage();
                frame.homePage(tobaccoList, coalsList, loggerList);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Frame getFrame() {
        return frame;
    }

    public void setCoalsList(List<Coals> coalsList) {
        this.coalsList = coalsList;
    }

    public void setTobaccoList(List<Tobacco> tobaccoList) {
        this.tobaccoList = tobaccoList;
    }

    public List<Logger> getLoggerList() {
        return loggerList;
    }

    public void setLoggerList(List<Logger> loggerList) {
        this.loggerList = loggerList;
    }
}
