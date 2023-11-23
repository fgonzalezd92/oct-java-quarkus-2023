package com.herbalife.examples.jdbc;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Path("/persons")
public class PersonResource {

    @Inject
    private DataSource dataSource;

    @GET
    public List<PersonOutputDto> getPersons() {
        List<PersonOutputDto> persons = new ArrayList<>();
        try(Connection conn = dataSource.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM persons");
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                PersonOutputDto personOutputDto = new PersonOutputDto(id, firstName, lastName, age);
                persons.add(personOutputDto);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @POST
    public String createPerson(PersonInputDto personInputDto) {
        try(Connection conn = dataSource.getConnection()) {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO persons (first_name, last_name, age) VALUES (?, ?, ?)");
            statement.setString(1, personInputDto.firstName());
            statement.setString(2, personInputDto.lastName());
            statement.setInt(3, personInputDto.age());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Created person " + personInputDto;
    }

}
