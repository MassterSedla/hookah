package com.example.hookah.model;

import jakarta.persistence.*;

/*
 * model for an auxiliary table
 * with additional data for logs
 */
@Entity
public class LoggerTobacco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "logger")
    private Logger logger;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tobacco", nullable = false)
    private Tobacco tobacco;
    private int amountOfTobacco;

    public LoggerTobacco() {

    }

    public LoggerTobacco(Tobacco tobacco, int amountOfTobacco) {
        this.amountOfTobacco = amountOfTobacco;
        this.tobacco = tobacco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmountOfTobacco() {
        return amountOfTobacco;
    }

    public void setAmountOfTobacco(int amountOfTobacco) {
        this.amountOfTobacco = amountOfTobacco;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Tobacco getTobacco() {
        return tobacco;
    }

    public void setTobacco(Tobacco tobacco) {
        this.tobacco = tobacco;
    }

    @Override
    public String toString() {
        return tobacco.getNameOfTobacco() + amountOfTobacco + "g";
    }
}
