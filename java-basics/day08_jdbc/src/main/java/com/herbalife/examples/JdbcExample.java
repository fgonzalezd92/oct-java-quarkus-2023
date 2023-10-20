package com.herbalife.examples;

import java.sql.*;
import java.util.List;

public class JdbcExample {
    public static void main(String[] args) throws SQLException {
        //OLD STYLE OF CODING
        //Load the driver class
        //Create a connection to the DB
        //Execute sql statement
        //close the connection
        //handle exceptions

        //insertPerson("Ram", "Narain", 33);
        //insertPersonUsingPreparedStatement("Mary", "Ashley", 43);
        insertPersonsUsingPreparedStatement(List.of(
                new Person("Victor", "Figueroa", 30),
                new Person("Sayani", "Biswas", 20),
                new Person("Samuel", "Mejia", 35)
        ));
        getAllPersons();
    }

    private static void insertPersonUsingStoredProc(String firstName, String lastName, int age) throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Type.GetType
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
            String query = "call sp_insertPerson(?,?,?)";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.execute();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }
    private static void insertPersonsUsingPreparedStatement(List<Person> persons) throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
            String query = "insert into persons(first_name, last_name, age) values(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            persons.forEach(person -> {
                try {
                    statement.setString(1, person.firstName());
                    statement.setString(2, person.lastName());
                    statement.setInt(3, person.age());
                    statement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }

    private static void insertPersonUsingPreparedStatement(String firstName, String lastName, int age) throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
            String query = "insert into persons(first_name, last_name, age) values(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.execute();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }

    private static void getAllPersons() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
            String query = "select * from persons";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                System.out.println("%s, %s %s, %s".formatted(id, firstName, lastName, age));
            }
            resultSet.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }


    private static void insertPerson(String firstName, String lastName, int age) throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
            String query = """
                     insert into persons(first_name, last_name, age) values("%s", "%s", %s)
                    """.formatted(firstName, lastName, age);
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }

}
