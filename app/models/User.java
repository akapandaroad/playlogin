package models;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;

public class User {
    public String name;
    public String password;


    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}