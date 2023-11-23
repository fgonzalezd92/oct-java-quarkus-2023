package com.herbalife.examples;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;

@ApplicationScoped
public class Company {
    @ConfigProperty(name = "my.company.name")
    private String name;

    @ConfigProperty(name = "my.company.location", defaultValue = "India")
    private String country;

    @ConfigProperty(name = "my.company.locations")
    private List<String> locations;

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
