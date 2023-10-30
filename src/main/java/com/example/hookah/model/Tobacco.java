package com.example.hookah.model;

import jakarta.persistence.*;

import java.util.Set;

/*
 * model for a table with data about tobacco
 */
@Entity
@Table(uniqueConstraints= @UniqueConstraint(columnNames={"id", "nameOfTobacco"}))
public class Tobacco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfTobacco;
    private int amountOfTobacco;
    @OneToMany(
            mappedBy = "tobacco",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<LoggerTobacco> loggerTobaccos;


    public Tobacco() {

    }

    public Tobacco(String nameOfTobacco, int amountOfTobacco) {
        this.nameOfTobacco = nameOfTobacco;
        this.amountOfTobacco = amountOfTobacco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNameOfTobacco() {
        return nameOfTobacco;
    }

    public void setNameOfTobacco(String nameOfTobacco) {
        this.nameOfTobacco = nameOfTobacco;
    }

    public int getAmountOfTobacco() {
        return amountOfTobacco;
    }

    public void setAmountOfTobacco(int amountOfTobacco) {
        this.amountOfTobacco = amountOfTobacco;
    }

    public Set<LoggerTobacco> getLoggerTobaccos() {
        return loggerTobaccos;
    }

    public void setLoggerTobaccos(Set<LoggerTobacco> loggerTobaccos) {
        this.loggerTobaccos = loggerTobaccos;
    }
}
