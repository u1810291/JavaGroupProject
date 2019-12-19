package sample.Controller;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import sample.Model.Users;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminControl implements Initializable{
  @FXML
  public Button librarian;
  @FXML
  public Button studentButton;
  @FXML
  public Button bookButton;
  @FXML
  public Button logout;
  @FXML
  public Button back;
  @FXML
  private TableView<Users> TableView;
  @FXML
  private TableColumn<Users, String> fullName;
  @FXML
  private TableColumn<Users, String> id;
  @FXML
  private TableColumn<Users, String> status;
  @FXML
  private TableColumn<Users, String> dateOfBirth;
  @FXML
  private TableColumn<Users, String> password;
  @FXML
  private TableColumn<Users, Button> addButton;
  @FXML
  private TableColumn<Users, Button> editButton;
  @FXML
  private TableColumn<Users, Button> deleteButton;

  @Override
  public void initialize(URL location, ResourceBundle resource){
    initializeTable();
  }
  public void initializeTable(){
    initCols();
    loadData();
  }
  @FXML
  public void initCols(){

    id.setCellValueFactory(new PropertyValueFactory<>("id"));
    fullName.setCellValueFactory(new PropertyValueFactory<>(""));
    status.setCellValueFactory(new PropertyValueFactory<>(""));
    dateOfBirth.setCellValueFactory(new PropertyValueFactory<>(""));
    password.setCellValueFactory(new PropertyValueFactory<>(""));
    addButton();
    editButton();
    deleteButton();
  }
  @FXML
  public void addButton(){

  }
  @FXML
  public void editButton(){
    id.setCellFactory(TextFieldTableCell.forTableColumn());
    id.setOnEditCommit(e-> {
      e.getTableView().getItems().get(e.getTablePosition().getRow()).setId(e.getNewValue());

    });
    fullName.setCellFactory(TextFieldTableCell.forTableColumn());
    fullName.setOnEditCommit(e-> {
      e.getTableView().getItems().get(e.getTablePosition().getRow()).setFullName(e.getNewValue());

    });
    status.setCellFactory(TextFieldTableCell.forTableColumn());
    status.setOnEditCommit(e-> {
      e.getTableView().getItems().get(e.getTablePosition().getRow()).setStatus(e.getNewValue());

    });
    dateOfBirth.setCellFactory(TextFieldTableCell.forTableColumn());
    dateOfBirth.setOnEditCommit(e-> {
      e.getTableView().getItems().get(e.getTablePosition().getRow()).setDateOfBirth(e.getNewValue());

    });
    password.setCellFactory(TextFieldTableCell.forTableColumn());
    password.setOnEditCommit(e-> {
      e.getTableView().getItems().get(e.getTablePosition().getRow()).setPassword(e.getNewValue());

    });
    TableView.setEditable(true);
  }
  @FXML
  public void deleteButton(){

  }
  public void loadData(){
    ObservableList<Users> table_data = FXCollections.observableArrayList();
    for (int i = 0; i < 7; i++){
      table_data.add(new Users(String.valueOf(i),
          "Id" + i, "Full name" + i, "status" + i, "date of birth" + i, "password" + i ,
          new Button("add"), new Button("edit"), new Button("delete")));
    }
    TableView.setItems(table_data);
  }



  public void logoutHandler(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/sample/login.fxml"));
    Stage stage = (Stage) logout.getScene().getWindow();
    stage.close();
    stage.setScene(new Scene(root, 550, 400));
    stage.show();
  }

  public void bookButtonHandler(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/sample/View/theme/admin/book_management.fxml"));
    Stage stage = (Stage) bookButton.getScene().getWindow();
    stage.close();
    stage.setScene(new Scene(root, 850, 600));
    stage.show();
  }

  public void studentButtonHandler(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/sample/View/theme/admin/student_management.fxml"));
    Stage stage = (Stage) studentButton.getScene().getWindow();
    stage.close();
    stage.setScene(new Scene(root, 850, 600));
    stage.show();
  }

  public void librarianHandler(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/sample/View/theme/admin/librarian_management.fxml"));
    Stage stage = (Stage) librarian.getScene().getWindow();
    stage.close();
    stage.setScene(new Scene(root, 850, 600));
    stage.show();
  }

  public void backHandler(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/sample/View/theme/admin/main_menu.fxml"));
    Stage stage = (Stage) back.getScene().getWindow();
    stage.close();
    stage.setScene(new Scene(root, 850, 600));
    stage.show();
  }

}
