package sample.Model;


import javafx.scene.control.Button;

public class Users {
    public Users(){
        
    }

    private String s, fullName, id, status , dateOfBirth, password;
    private Button add, edit, delete;
    public Users(String f, String i, String s, String d, String p, Button a, Button e, Button de) {
        this.fullName = f;
        this.id = i;
        this.status = s;
        this.dateOfBirth = d;
        this.password = p;
        this.add = a;
        this.edit = e;
        this.delete = de;

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
    public Button getAdd() {
        return add;
    }
    public void setAdd(Button add) {
        this.add = add;
    }
    public Button getEdit() {
        return edit;
    }
    public void setEdit(Button edit) {
        this.edit = edit;
    }
    public Button getDelete() {
        return delete;
    }
    public void setDelete(Button delete) {
        this.delete = delete;
    }
}
