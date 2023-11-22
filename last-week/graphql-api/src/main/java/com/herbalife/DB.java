package com.herbalife;

import com.herbalife.model.Company;

import java.util.List;

public class DB {
    public static List<Company> getCompanies() {
        return List.of(
                new Company("1", "Herbalife", "John Doe", 100),
                new Company("2", "Amway", "Jane Doe", 200),
                new Company("3", "Avon", "John Smith", 300)
        );
    }
}
