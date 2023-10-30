package com.example.hookah.flags;

import java.io.Serializable;

/*
* class for setting and processing
* buttons pressed on a frame
 */
public class Flags implements Serializable {
    private boolean enter;
    private boolean homePage;
    private boolean changeCoals;
    private boolean changeTobacco;
    private boolean addNewTobacco;

    public Flags() {
        enter = true;
    }

    public boolean isEnter() {
        return enter;
    }

    public void setEnter(boolean enter) {
        this.enter = enter;
    }

    public boolean isHomePage() {
        return homePage;
    }

    public void setHomePage(boolean homePage) {
        this.homePage = homePage;
    }

    public boolean isChangeCoals() {
        return changeCoals;
    }

    public void setChangeCoals(boolean changeCoals) {
        this.changeCoals = changeCoals;
    }

    public boolean isChangeTobacco() {
        return changeTobacco;
    }

    public void setChangeTobacco(boolean changeTobacco) {
        this.changeTobacco = changeTobacco;
    }

    public boolean isAddNewTobacco() {
        return addNewTobacco;
    }

    public void setAddNewTobacco(boolean addNewTobacco) {
        this.addNewTobacco = addNewTobacco;
    }
}
