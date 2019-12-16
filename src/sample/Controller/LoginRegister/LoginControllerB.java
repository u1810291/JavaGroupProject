package sample.Controller.LoginRegister;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;

public class LoginControllerB implements Runnable{
  @FXML
  public TextField userName;
  @FXML
  public PasswordField userPassword;
  @FXML
  public Button signIn;
  @FXML
  public Button login;
  @FXML
  public void loginHandler(ActionEvent actionEvent) {
    String name = String.valueOf(userName.getText());
    String password = String.valueOf(userPassword.getText());
    if (name.equals("name") && password.equals("password")){
      JOptionPane.showMessageDialog(null, "Good job!");
    }
    else {
      JOptionPane.showMessageDialog(null, "Something wrong");
    }
  }

  @FXML
  public void signInHandler(ActionEvent actionEvent) {

  }

  @Override
  public void run() {
    try{

    }
    catch (Exception e){

    }
  }
}
