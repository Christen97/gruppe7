package grp7.semproject.Persistence;


public class DBFacade {
    private DatabaseAccess dbAcc = new DatabaseAccess();

    public void createPerson(String name, String address, String phone, String email) {
        dbAcc.createPerson(name, address, phone, email);
    }

    public void readFromDB(String table, String column, String string) {
        dbAcc.readFromDB(table, column, string);
    }

    public void readFromDB(String table, String column, int integer) {
        dbAcc.readFromDB(table, column, integer);
    }
}

