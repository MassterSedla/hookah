package com.example.hookah.service;

import com.example.hookah.model.Coals;
import com.example.hookah.model.Tobacco;

import java.util.List;

public interface HookahBaseService {
    boolean addNewTobacco(Tobacco tobacco);
    void editTobacco(String nameOfTobacco, int editAmount);
    void editNameTobacco(String name, String newName);
    void editCoals(String nameOfCoals, int editAmount);
    Tobacco showTobaccoByName(String nameOfTobacco);
    List<Tobacco> showAllTobacco();
    List<Coals> showAllCoals();
//    boolean addNewCoals(Coals coals);
}
