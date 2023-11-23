package com.herbalife;

import io.smallrye.graphql.client.GraphQLClient;
import io.smallrye.graphql.client.core.Document;

import static io.smallrye.graphql.client.core.Document.*;
import static io.smallrye.graphql.client.core.Field.*;
import static io.smallrye.graphql.client.core.Operation.*;

import io.smallrye.graphql.client.core.OperationType;
import io.smallrye.graphql.client.dynamic.api.DynamicGraphQLClient;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Path("/registry")
public class RegistryResource {

    @Inject
    @GraphQLClient("company-api")
    DynamicGraphQLClient companyClient;

    @Inject
    CompanyApi companyApi;

    @GET
    @Path("/all-companies2")
    public JsonObject getAllCompanies2() throws ExecutionException, InterruptedException {
        Document document = Document
                .document(
                        operation(OperationType.QUERY, "getCompanies",
                                field(
                                        "allCompanies",
                                        field("id"),
                                        field("name"),
                                        field("ceo")
                                )
                        )
                );
        return companyClient.executeSync(document).getData();
    }

    @GET
    @Path("/all-companies")
    public JsonObject getAllCompanies() throws ExecutionException, InterruptedException {
        String query = """
                query {
                    companies: allCompanies {
                        companyId: id
                        companyName: name
                        companyCeo: ceo
                        companyHeadcount: headcount
                    }
                }
                """;
        return companyClient
                .executeSync(query)
                .getData();
    }

    @POST
    @Path("/companies")
    public JsonObject createCompany(CompanyDto companyDto) throws ExecutionException, InterruptedException {
        String query = """
                mutation {
                   addCompany(companyInput: {
                     name: "%s",
                     ceo: "%s",
                     headcount: %s,
                     listed: %s
                   }) {
                     id
                     name
                     ceo
                     headcount
                     listed
                   }
                  }
                """.formatted(companyDto.getName(), companyDto.getCeo(), companyDto.getHeadcount(), companyDto.isListed());
        return companyClient
                .executeSync(query)
                .getData();
    }


    @POST
    @Path("/company")
    public Company addCompany(CompanyDto companyInput) {
        return companyApi.addCompany(companyInput);
    }

    @GET
    @Path("/companies")
    public List<Company> getCompanies() {
        return companyApi.getAllCompanies();
    }

    @GET
    @Path("/companies/{id}")
    public Company getCompany(@PathParam("id") String id) {
        return companyApi.getCompany(id);
    }
}
