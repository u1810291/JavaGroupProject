package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LibrarianControl {
  public Button students;
  public Button book;
  public Button logout;
  public Button view;
  public Button borrowReturn;
  public Button issueBook;
  public Button monthlyReport;
  public Button bookBack;
  public Button back;
  public Button issueFine;
  public TextField issueIdOfStudent;
  public DatePicker dateFine;
  public TextField issueReason;
  public TextField reasonOfBlocking;
  public TextField idOfStudent;
  public DatePicker blockStudent;
  public Button issueBlock;
  public TextField searchTextField;
  public CheckBox borrowedBooks;
  public CheckBox overdue;
  public CheckBox title;
  public CheckBox subject;
  public CheckBox authors;
  public CheckBox ISBN;
  public CheckBox publishDate;
  public Button applySearch;
  public TextField bookISBN;
  public TextField ID;
  public DatePicker dateIssue;
  public Button issue;

  public void monthlyReportHandler(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/sample/View/theme/librarian/report.fxml"));
    Stage stage = (Stage) monthlyReport.getScene().getWindow();
    stage.close();
    stage.setScene(new Scene(root, 850 ,600));
    stage.show();
  }
  public void issueBookHandler(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/sample/View/theme/librarian/return_issue.fxml"));
    Stage stage = (Stage) issueBook.getScene().getWindow();
    stage.close();
    stage.setTitle("Issue Book");
    stage.setScene(new Scene(root, 850 ,600));
    stage.show();
  }
  public void borrowReturnHandler(ActionEvent event) throws IOException {
//    Parent root = FXMLLoader.load(getClass().getResource("/sample/View/theme/librarian/view.fxml"));
//    Stage stage = (Stage) borrowReturn.getScene().getWindow();
//    stage.close();
//    stage.setTitle("Issue Book");
//    stage.setScene(new Scene(root, 850 ,600));
//    stage.show();
  }
  public void viewHandler(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/sample/View/theme/librarian/view.fxml"));
    Stage stage = (Stage) view.getScene().getWindow();
    stage.close();
    stage.setTitle("View");
    stage.setScene(new Scene(root, 850 ,600));
    stage.show();
  }
  public void logoutHandler(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/sample/login.fxml"));
    Stage stage = (Stage) logout.getScene().getWindow();
    stage.close();
    stage.setTitle("Logout");
    stage.setScene(new Scene(root, 550 ,400));
    stage.show();
  }
  public void bookHandler(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/sample/View/theme/librarian/book_management.fxml"));
    Stage stage = (Stage) book.getScene().getWindow();
    stage.close();
    stage.setTitle("Book");
    stage.setScene(new Scene(root, 850 ,600));
    stage.show();
  }
  public void studentsHandler(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/sample/View/theme/librarian/student_management.fxml"));
    Stage stage = (Stage) students.getScene().getWindow();
    stage.close();
    stage.setTitle("Students");
    stage.setScene(new Scene(root, 850 ,600));
    stage.show();
  }
  public void backHandler(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/sample/View/theme/librarian/librarian_management_menu.fxml"));
    Stage stage = (Stage) back.getScene().getWindow();
    stage.close();
    stage.setTitle("Menu");
    stage.setScene(new Scene(root, 850 ,600));
    stage.show();
  }

  public void issueFineHandler(ActionEvent event) {
  }

  public void issueBlockHandler(ActionEvent event) {
  }

  public void backButton(ActionEvent event) {
  }

  public void bookViewApply(ActionEvent event) {
  }
}
