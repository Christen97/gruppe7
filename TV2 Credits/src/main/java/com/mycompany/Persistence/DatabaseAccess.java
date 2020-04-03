package com.mycompany.Persistence;

import java.sql.*;

public class DatabaseAccess {

    static Connection connection = null;

    public void initializeConnection() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/dbtest",
                    "postgres",
                    "Pass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void WriteToDB() {         // Insert user into database (<<Example!>>)
        try {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO users (name, cpr) VALUES (?,?)");
            insertStatement.setString(1, "John Doe");
            insertStatement.setString(2, "1234567890"); //INSERT INTO users (name, cpr) VALUES ('John Doe','1234567890')
            insertStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readFromDB() {       // Query Database for users with CPR X (<<Example!>>)
        try {
            PreparedStatement queryStatement = connection.prepareStatement("SELECT * FROM users WHERE cpr = ?");
            queryStatement.setString(1, "1234567890");
            ResultSet queryResultSet = queryStatement.executeQuery();

            System.out.println("The following users matched the query:");
            while (queryResultSet.next()) {
                System.out.println("The users name was "
                        + queryResultSet.getString("name")
                        + " and his CPR number was "
                        + queryResultSet.getString("cpr"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void exportFromDB() {
        //Export data...
    }

    }

