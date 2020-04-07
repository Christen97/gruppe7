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

    public void writeToDB() {         // Insert user into database (<<Example!>>)
        connectToDB();

        try {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO users (name, adresse) VALUES (?,?)");
            insertStatement.setString(1, "Boss baby2");
            insertStatement.setString(2, "Eldorado2"); //INSERT INTO users (name, cpr) VALUES ('John Doe','1234567890')
            insertStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnectDB();
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

