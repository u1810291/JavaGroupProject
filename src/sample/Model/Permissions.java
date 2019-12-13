package sample.Model;

import sample.Model.Users;

public class Permissions extends Users {
    public boolean isValid(Users users){
        if (users.getLogin() == "login" && users.getPassword() == "password"){
            return true;
        }
        else
        {
            return false;
        }
    }
}
