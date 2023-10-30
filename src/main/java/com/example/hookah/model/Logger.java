package com.example.hookah.model;

import jakarta.persistence.*;
import java.util.Set;

/*
 * model for a table with data about logs
 */
@Entity
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int amountOfCoals;
    private int price;
    @OneToMany(
            mappedBy = "logger",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<LoggerTobacco> loggerTobaccos;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getAmountOfCoals() {
        return amountOfCoals;
    }

    public void setAmountOfCoals(int amountOfCoals) {
        this.amountOfCoals = amountOfCoals;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<LoggerTobacco> getLoggerTobaccos() {
        return loggerTobaccos;
    }

    public void setLoggerTobaccos(Set<LoggerTobacco> loggerTobaccos) {
        this.loggerTobaccos = loggerTobaccos;
    }
}
