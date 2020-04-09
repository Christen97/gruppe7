package grp7.semproject.Domain;

public class SystemAdmin extends User{


    public SystemAdmin(int userID, String username, String password, String name) {
        super(userID, username, password, name, "SystemAdmin");
    }
}
