package com.herbalife.resource;

import com.herbalife.DB;
import com.herbalife.model.Company;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class CompanyResource {


    @Query("allCompanies")
    public List<Company> getAllCompanies() {
        //IDEALLY you will connect to a REST API or a database to fetch the data
        return DB.getCompanies();
    }

    @Query("listedCompanies")
    public List<Company> getAllCompanies(@Name("listed") boolean listed) {
        return DB
                .getCompanies()
                .stream()
                .filter(company -> company.isListed() == listed)
                .toList();
    }


    @Query("companiesWithHeadcountGt")
    public List<Company> getCompaniesWithHeadcountGreaterThan(@Name("headcount") int headcount) {
        return DB
                .getCompanies()
                .stream()
                .filter(company -> company.getHeadcount() > headcount)
                .toList();
    }

    @Query("company")
    public Company getCompany(@Name("id") String id) {
        return DB
                .getCompanies()
                .stream()
                .filter(company -> company.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
