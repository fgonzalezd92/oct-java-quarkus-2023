package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/scopes")
public class ScopedExampleResource {

//    @Inject
//    @Named("userInfo")
//    private UserInfo userInfo;

    @Inject
    private Book book;

    @Inject
    private Training training;

    @Inject
    private Company company;

    @Inject
    private Car bmw;

    @Inject
    private Car audi;

    @Inject
    private Car mercedes;

    @Inject
    private Car toyota;

    @GET
    @Path("/book")
    public String getBook() {
        return book.toString();
    }

    @GET
    @Path("/company")
    public String getCompany() {
        return company.toString();
    }

    @GET
    @Path("/training")
    public String getTraining() {
        return training.toString();
    }

//    @GET
//    @Path("/user")
//    public String getUser() {
//        return userInfo.toString();
//    }

}

@Dependent // prototype pattern
class Car {
    public Car() {
        System.out.println("***** Car object created " + this);
    }
}

@ApplicationScoped
class Book {
    public Book() {
        System.out.println("***** Book object created " + this);
    }
}

@Singleton
class Company {
    public Company() {
        System.out.println("***** Company object created " + this);
    }
}

@RequestScoped
class Training {
    public Training() {
        System.out.println("***** Training object created " + this);
    }
}

//@SessionScoped
//@Named("userInfo")
//class UserInfo implements java.io.Serializable {
//    public UserInfo() {
//        System.out.println("***** User object created " + this);
//    }
//}