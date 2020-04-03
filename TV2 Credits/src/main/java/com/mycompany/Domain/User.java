package com.mycompany.Domain;

public abstract class User {

    private int userID;
    private String username;
    private String password;
    private String name;
    private String accessRight;


    public User(int userID, String username, String password, String name, String accessRight) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.accessRight = accessRight;
    }

    public String getName() {
        return name;
    }

    public void login(){
        //Perform login - outside of scope for now
    }

    public void createProduction(int productionID){
        //First check access rights on the caller
        //Send to persistance layer...
    }

    public void deleteProduction(int productionID){
        //First check access rights on the caller
        //Send to persistance layer...
    }

}
