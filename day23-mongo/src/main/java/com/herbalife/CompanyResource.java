package com.herbalife;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/companies")
public class CompanyResource {

    @POST
    public void create(@QueryParam("name") String name,
                       @QueryParam("ceo") String ceo,
                       @QueryParam("employee_count") long employeeCount) {
        Company company = new Company();
        company.setName(name);
        company.setCeo(ceo);
        company.setEmployeeCount(employeeCount);
        company.persist();
    }
}
