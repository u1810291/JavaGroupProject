package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

  public Button loginButton;
  public TextField login;
  public PasswordField password;

  public void loginButtonHandler(ActionEvent event) throws IOException {
    if (login.getText().equals("admin") && password.getText().equals("1")){
      Parent root = FXMLLoader.load(getClass().getResource("View/theme/admin/main_menu.fxml"));
      Stage stage = (Stage) login.getScene().getWindow();
      stage.close();
      stage.setScene(new Scene(root, 850 ,600));
      stage.show();
    }
    else if (login.getText().equals("student") && password.getText().equals("2")){
      Parent root = FXMLLoader.load(getClass().getResource("View/theme/student/student_menu.fxml"));
      Stage stage = (Stage) login.getScene().getWindow();
      stage.close();
      stage.setScene(new Scene(root, 850 ,600));
      stage.show();
    }
    else if (login.getText().equals("librarian") && password.getText().equals("3")){
      Parent root = FXMLLoader.load(getClass().getResource("View/theme/librarian/librarian_management_menu.fxml"));
      Stage stage = (Stage) login.getScene().getWindow();
      stage.close();
      stage.setScene(new Scene(root, 850 ,600));
      stage.show();
    }
  }
}