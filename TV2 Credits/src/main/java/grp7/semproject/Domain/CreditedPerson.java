package grp7.semproject.Domain;

public class CreditedPerson extends User{


    private String role;
    private String adress;
    private String phoneNum;
    private String email;


    public CreditedPerson(int userID, String username, String password, String name) {
        super(userID, username, password, name, "CreditedPerson");
    }

    public String getRole() {
        return role;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

}
stor fed
