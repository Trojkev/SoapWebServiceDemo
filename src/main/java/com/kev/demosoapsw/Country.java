package com.kev.demosoapsw;

import javax.persistence.*;

@Entity
@Table
public class Country {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capital")
    private String capital;

    @Column(name = "population")
    private long population;

    @ManyToOne
//    @ForeignKey(name = "currency")
    private Currency currency;

    public Country() {
    }

    public long getId() {
        return id;
    }

    public Country(String name, String capital, long population, Currency currency) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
