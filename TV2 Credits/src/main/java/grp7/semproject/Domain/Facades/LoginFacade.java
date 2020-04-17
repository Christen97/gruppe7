package grp7.semproject.Domain.Facades;

import grp7.semproject.Domain.UserTypes.*;

public class LoginFacade {

    public static User loginAsCreditedPerson(String username, String password)
    {
        return new CreditedPerson(1, username, password, "CreditedPerson-Test");
    }

    public static User LoginAsProducer(String username, String password)
    {
        return new Producer(1, username, password, "Producer-Test");
    }

    public static User LoginAsRegDanmark(String username, String password)
    {
        return new RegDanmark(1, username, password, "RegDanmark-Test");
    }

    public static User loginAsSystemAdmin(String username, String password) {
        return new SystemAdmin(1, username, password, "SystemAdmin-Test");
    }

    public void createPersonDBrequest (){
        //Check for empty string and if true, set that string to null;
    }
}
