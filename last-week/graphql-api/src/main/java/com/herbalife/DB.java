package com.herbalife;

import com.herbalife.model.Company;

import java.util.List;

public class DB {
    public static List<Company> getCompanies() {
        return List.of(
                new Company("1", "Herbalife", "John Doe", 100, true),
                new Company("2", "Amway", "Jane Doe", 200, false),
                new Company("3", "Avon", "John Smith", 300, true),
                new Company("4", "Natura", "Jane Smith", 400, false),
                new Company("5", "Nu Skin", "John Doe", 500, true)
        );
    }
}
