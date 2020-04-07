package grp7.semproject.Persistence;

import java.sql.*;

public class DatabaseAccess {
    // We've decided to open and close the connection at all queries,
    // because our chosen server option only allows 5 concurrent connections
    static Connection connection = null;

    public void connectToDB() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://balarama.db.elephantsql.com:5432/pqgenkao",
                    "pqgenkao",
                    "byC8qoatCp0s0hmQljM1XhpOYo4KcE87");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnectDB() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Creates a person in the DB
    public void createPerson(String name, String address, String phone, String email) {
        connectToDB();

        try {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO person (name, address, phone, email) VALUES (?,?,?,?)");
            insertStatement.setString(1, name);
            insertStatement.setString(2, address);
            insertStatement.setString(3, phone);
            insertStatement.setString(4, email);
            insertStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnectDB();
        }
    }

    // Creates a production in the DB, note that the date format is YYYY-MM-DD
    public void createProduction(String name, String release_date, int program_type_fk, int producer_fk) {
        connectToDB();

        try {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO production (name, release_date, program_type_fk, producer_fk) VALUES (?,?,?,?)");
            insertStatement.setString(1, name);
            insertStatement.setString(2, release_date);
            insertStatement.setInt(3, program_type_fk);
            insertStatement.setInt(4, producer_fk);
            insertStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnectDB();
        }
    }

    public void readFromDB(String table, String column, int integer) {       // Query Database for users with CPR X (<<Example!>>)
        connectToDB();

        try {
            PreparedStatement queryStatement = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + column + " = ?");
           queryStatement.setInt(1, integer);
            ResultSet queryResultSet = queryStatement.executeQuery();

            int i = 1;
            int y = 0;
            if (table == "person"){
                y = 5;
            }

            String returnString = "";

            System.out.println("The following users matched the query:");
            while (queryResultSet.next()) {
                while (i < y) {
                    returnString = returnString + queryResultSet.getString(i) + ",";
                    i++;
                }
            }
            System.out.println(returnString);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnectDB();
        }

    }

    public void readFromDB(String table, String column, String string) {       // Query Database for users with CPR X (<<Example!>>)
        connectToDB();

        try {
            PreparedStatement queryStatement = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + column + " = ?");
            queryStatement.setString(1, string);
            ResultSet queryResultSet = queryStatement.executeQuery();

            int i = 1;
            int y = 0;
            if (table == "person"){
                y = 5;
            }

            String returnString = "";

            System.out.println("The following users matched the query:");
            while (queryResultSet.next()) {
                while (i < y) {
                    returnString = returnString + queryResultSet.getString(i) + ",";
                    i++;
                }
            }
            System.out.println(returnString);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnectDB();
        }
    }

    public void exportFromDB() {
        //Export data...
    }

}

