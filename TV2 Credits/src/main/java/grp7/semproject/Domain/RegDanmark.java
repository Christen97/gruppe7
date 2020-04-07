package grp7.semproject.Domain;

public class RegDanmark extends User {


    public RegDanmark(int userID, String username, String password, String name, int accessRight) {
        super(userID, username, password, name, "RegDanmark");
    }

    public void exportCredits(int productionID){ //Possibly return linked list?
        // Send request to persistence
    }

}
