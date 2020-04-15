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
                    "jdbc:postgresql://165.22.75.234:5432/tv2_db",
                    "application",
                    "umvu3PJ6BPb%");
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

            int currentColumn = 1;
            int columnTotal = queryResultSet.getMetaData().getColumnCount();

            String returnString = "";

            System.out.println("The following users matched the query:");
            while (queryResultSet.next()) {
                while (currentColumn <= columnTotal) {
                    if (currentColumn == columnTotal) {
                        returnString = returnString + queryResultSet.getString(currentColumn);
                    } else {
                        returnString = returnString + queryResultSet.getString(currentColumn) + ",";
                    }
                    currentColumn++;

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

            int currentColumn = 1;
            int columnTotal = queryResultSet.getMetaData().getColumnCount();

            String returnString = "";

            System.out.println("The following users matched the query:");
            while (queryResultSet.next()) {
                while (currentColumn <= columnTotal) {
                    if (currentColumn == columnTotal) {
                        returnString = returnString + queryResultSet.getString(currentColumn);
                    } else {
                        returnString = returnString + queryResultSet.getString(currentColumn) + ",";
                    }
                    currentColumn++;

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

