package com.herbalife.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "Person", description = "Person model")
public class Person {
    @Schema(required = true, description = "First name", example = "John")
    private String firstName;
    @Schema(required = true, description = "Last name", example = "Doe")
    private String lastName;
    @Schema(required = true, description = "Email", example = "johndoe@gmail.com")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
