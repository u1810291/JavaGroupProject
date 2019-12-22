package sample.Model;


import javafx.scene.control.Button;

public class Users {
    public Users(){
        
    }

    private String s, fullName, id, status , dateOfBirth, password;

    public Users(String f, String i, String s, String d, String p) {
        this.fullName = f;
        this.id = i;
        this.status = s;
        this.dateOfBirth = d;
        this.password = p;

    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
