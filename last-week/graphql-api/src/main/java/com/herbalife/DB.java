package com.herbalife;

import com.herbalife.model.Company;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private static List<Company> companies;
    public static List<Company> getCompanies() {
        if (companies == null) {
            companies = new ArrayList<>();
            companies.add(new Company("1", "Herbalife", "John Doe", 100, true));
            companies.add(new Company("2", "Amway", "Jane Doe", 200, false));
            companies.add(new Company("3", "Avon", "John Smith", 300, true));
            companies.add(new Company("4", "Natura", "Jane Smith", 400, false));
            companies.add(new Company("5", "Nu Skin", "John Doe", 500, true));
        }
        return companies;
    }
}
