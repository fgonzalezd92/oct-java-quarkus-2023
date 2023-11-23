package com.herbalife;

import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLClientApi(configKey = "company-api")
public interface CompanyApi {

    @Mutation("addCompany")
    Company addCompany(CompanyDto companyInput);

    @Query("allCompanies")
    List<Company> getAllCompanies();

    @Query("company")
    Company getCompany(String id);
}
