package controllers;

import play.data.validation.Constraints;

public class UserData {
    @Constraints.Required
    String name;

    String password;


    public UserData() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
