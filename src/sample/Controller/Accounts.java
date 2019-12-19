package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Accounts {
  public Button librarian;
  public Button studentButton;
  public Button bookButton;
  public Button logout;
  public Button login;

  public void librarianHandler(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/sample/View/theme/student/reserve_book.fxml"));
    Stage stage = (Stage) librarian.getScene().getWindow();
    stage.close();
    stage.setScene(new Scene(root, 900,650));
    stage.show();
  }
  public void loginHandler(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/sample/View/theme/student/reserve_book.fxml"));
    Stage stage = (Stage) login.getScene().getWindow();
    stage.close();
    stage.setScene(new Scene(root, 900,650));
    stage.show();
  }

  public void logoutHandler(ActionEvent event) {
  }

  public void bookButtonHandler(ActionEvent event) {
  }

  public void studentButtonHandler(ActionEvent event) {
  }
}
