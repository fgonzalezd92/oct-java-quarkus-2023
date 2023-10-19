package com.herbalife.examples;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class City {
    @JsonProperty("city")
    private String name;
    private String country;
    private long population;
    @JsonIgnore
    private boolean highlyPopulated;

    public City() {
    }

    public City(String name, String country, long population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public boolean isHighlyPopulated() {
        return highlyPopulated;
    }

    public void setHighlyPopulated(boolean highlyPopulated) {
        this.highlyPopulated = highlyPopulated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", population=" + population +
                '}';
    }
}
