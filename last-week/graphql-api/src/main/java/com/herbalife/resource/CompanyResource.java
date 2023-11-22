package com.herbalife.resource;

import com.herbalife.DB;
import com.herbalife.dto.CompanyDto;
import com.herbalife.model.Company;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class CompanyResource {


    @Mutation("addCompany")
    public Company addCompany(@Name("companyInput") CompanyDto companyDto) {
        Company company = new Company(
                String.valueOf((int) (Math.random() * 1000)),
                companyDto.getName(),
                companyDto.getCeo(),
                companyDto.getHeadcount(),
                companyDto.isListed()
        );
        DB.getCompanies().add(company);
        return company;
    }

    @Mutation("removeCompany")
    public Company removeCompany(@Name("companyId") String id) {
        Company company = DB
                .getCompanies()
                .stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (company != null) {
            DB.getCompanies().remove(company);
        }
        return company;

    }


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
