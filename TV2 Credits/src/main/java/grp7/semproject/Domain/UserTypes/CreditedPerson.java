package grp7.semproject.Domain.UserTypes;

public class CreditedPerson extends User {


    private String role;
    private String address;
    private String phoneNum;
    private String email;


    public CreditedPerson(int userID, String username, String password, String name) {
        super(userID, username, password, name, "CreditedPerson");
    }

    public String getRole() {
        return role;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

}
