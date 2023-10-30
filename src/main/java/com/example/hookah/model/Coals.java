package com.example.hookah.model;

import jakarta.persistence.*;

/*
 * model for a table with data about coals
 */
@Entity
@Table(uniqueConstraints= @UniqueConstraint(columnNames={"id", "nameOfCoals"}))
public class Coals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfCoals;
    private int amountOfCoals;

    public Coals() {

    }

    public Coals(String nameOfCoals, int amountOfCoals) {
        this.nameOfCoals = nameOfCoals;
        this.amountOfCoals = amountOfCoals;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNameOfCoals() {
        return nameOfCoals;
    }

    public void setNameOfCoals(String nameOfCoals) {
        this.nameOfCoals = nameOfCoals;
    }

    public int getAmountOfCoals() {
        return amountOfCoals;
    }

    public void setAmountOfCoals(int amountOfCoals) {
        this.amountOfCoals = amountOfCoals;
    }
}
