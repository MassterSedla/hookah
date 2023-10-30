package com.example.hookah.service;

import com.example.hookah.model.Coals;
import com.example.hookah.model.Tobacco;
import com.example.hookah.repository.CoalsRepository;
import com.example.hookah.repository.TobaccoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HookahBaseServiceImpl implements HookahBaseService {
    private final TobaccoRepository tobaccoRepository;
    private final CoalsRepository coalsRepository;

    @Autowired
    public HookahBaseServiceImpl(TobaccoRepository tobaccoRepository, CoalsRepository coalsRepository) {
        this.tobaccoRepository = tobaccoRepository;
        this.coalsRepository = coalsRepository;
    }


    @Override
    public boolean addNewTobacco(Tobacco tobacco) {
        if (tobaccoRepository.findByNameOfTobacco(tobacco.getNameOfTobacco()) == null) {
            tobaccoRepository.save(tobacco);
            return true;
        }
        return false;
    }

    @Override
    public void editTobacco(String nameOfTobacco, int editAmount) {
        Tobacco tobacco = tobaccoRepository.findByNameOfTobacco(nameOfTobacco);
        tobacco.setAmountOfTobacco(tobacco.getAmountOfTobacco() + editAmount);
        tobaccoRepository.save(tobacco);
    }

    @Override
    public void editNameTobacco(String name, String newName) {
        Tobacco tobacco = tobaccoRepository.findByNameOfTobacco(name);
        tobacco.setNameOfTobacco(newName);
        tobaccoRepository.save(tobacco);
    }

    @Override
    public void editCoals(String nameOfCoals, int editAmount) {
        Coals coals = coalsRepository.findByNameOfCoals(nameOfCoals);
        coals.setAmountOfCoals(coals.getAmountOfCoals() + editAmount);
        coalsRepository.save(coals);
    }

    @Override
    public Tobacco showTobaccoByName(String nameOfTobacco) {
        return tobaccoRepository.findByNameOfTobacco(nameOfTobacco);
    }

    @Override
    public List<Tobacco> showAllTobacco() {
        return tobaccoRepository.findAll();
    }

    @Override
    public List<Coals> showAllCoals() {
        return coalsRepository.findAll();
    }

//    @Override
//    public boolean addNewCoals(Coals coals) {
//        if (coalsRepository.findByNameOfCoals(coals.getNameOfCoals()) == null) {
//            coalsRepository.save(coals);
//            return true;
//        }
//        return false;
//    }
}
