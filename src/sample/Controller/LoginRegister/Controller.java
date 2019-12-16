package sample.Controller.LoginRegister;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Model.Users;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
  public TextField nameField;
  public TextField surnameField;
  public TextField phoneNumberField;
  public TextField emailField;
  public TextField loginTextField;
  public PasswordField passwordField;
  public Button login;
  public Button register;
  @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
  public void registerHandler(ActionEvent actionEvent) {
    String name = nameField.getText();
    String surname = surnameField.getText();
    long phoneNumber = Integer.parseInt(phoneNumberField.getText());
    String email = emailField.getText();
    String login = loginTextField.getText();
    String password = passwordField.getText();
    Users users = new Users();
    try {
      if (!name.equals("") && !surname.equals("") && phoneNumber != 0 && !email.equals("") && !login.equals("") && !password.equals("")) {
        users.setName(name);
        users.setSurname(surname);
        users.setEmail(email);
        users.setPhone(phoneNumber);
        users.setLogin(login);
        users.setPassword(password);
        JOptionPane.showMessageDialog(null, users.getName() + "\n" + users.getSurname() + "\n" + users.getPhone() + "\n" + users.getEmail() + "\n" + users.getLogin() + users.getPassword());
      } else {
        JOptionPane.showMessageDialog(null, "Try again");
      }
    }
    catch (Exception e){
      System.err.println(e);

    }
  }
  public void loginHandler(ActionEvent actionEvent) {

  }
}