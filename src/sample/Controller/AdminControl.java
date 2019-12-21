package sample.Controller;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import sample.Model.Books;
import sample.Model.Users;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminControl implements Initializable
{
  @FXML private Button librarian;
  @FXML private Button studentButton;
  @FXML private Button bookButton;
  @FXML private Button logout;
  @FXML private Button back;

  @FXML private TableView<Users> TableView;
  @FXML private TableColumn<Users, String> fullName;
  @FXML private TableColumn<Users, String> id;
  @FXML private TableColumn<Users, String> status;
  @FXML private TableColumn<Users, String> dateOfBirth;
  @FXML private TableColumn<Users, String> password;
  @FXML private TableColumn<Users, Button> addButton;
  @FXML private TableColumn<Users, Button> editButton;
  @FXML private TableColumn<Users, Button> deleteButton;
  /*
  * Books table properties
  * */
  @FXML private TableView<Books> TableBookView;
  @FXML private TableColumn<Books, String> title;
  @FXML private TableColumn<Books, String> subject;
  @FXML private TableColumn<Books, String> author;
  @FXML private TableColumn<Books, String> ISBN;
  @FXML private TableColumn<Books, String> publishDate;
  @FXML private TableColumn<Books, Button> add;
  @FXML private TableColumn<Books, Button> edit;
  @FXML private TableColumn<Books, Button> delete;
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    initTable();
    initTable2();
  }
  public void initTable2(){
    initCols2();
    loadData2();
  }
  /*
  * Books table initializer
  * */
  private void initCols2(){
    try{
      title.setCellValueFactory(new PropertyValueFactory<>("title"));
      subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
      author.setCellValueFactory(new PropertyValueFactory<>("author"));
      ISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
      publishDate.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
      add.setCellValueFactory(new PropertyValueFactory<>("add"));
      edit.setCellValueFactory(new PropertyValueFactory<>("edit"));
      delete.setCellValueFactory(new PropertyValueFactory<>("delete"));
      TableBookView.setEditable(true);
      addButton2();
      editButton2();
      deleteButton2();
    }
    catch (Exception e){
      System.out.println(e);
    }
  }
  private void addButton2(){
//    try
//    {
//
//    }catch (Exception e){
//      System.err.println(e);
//    }
  }
  private void editButton2(){
    try
    {


//    title, subject, author, ISBN, publishDate, addBook, editBook, deleteBook
      title.setCellFactory(TextFieldTableCell.forTableColumn());
      title.setOnEditCommit(e-> {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setTitle(e.getNewValue());
      });
      subject.setCellFactory(TextFieldTableCell.forTableColumn());
      subject.setOnEditCommit(e-> {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setSubject(e.getNewValue());
      });
      ISBN.setCellFactory(TextFieldTableCell.forTableColumn());
      ISBN.setOnEditCommit(e-> {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setISBN(e.getNewValue());
      });
      dateOfBirth.setCellFactory(TextFieldTableCell.forTableColumn());
      dateOfBirth.setOnEditCommit(e-> {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setDateOfBirth(e.getNewValue());
      });
      password.setCellFactory(TextFieldTableCell.forTableColumn());
      password.setOnEditCommit(e-> {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setPassword(e.getNewValue());
      });
      TableBookView.setEditable(true);
    }
    catch (Exception e){
      System.err.println(e);
    }
  }
  private void deleteButton2(){
    try {
//      deleteButton.setOnEditCommit(e -> {
//        String fullName = String.valueOf(TableView.getSelectionModel().getSelectedItem());
//        TableView.getItems().remove(fullName);
//      });
//      deleteButton.setOnEditCommit(e -> {
//        String id = String.valueOf(TableView.getSelectionModel().getSelectedItem());
//        TableView.getItems().remove(id);
//      });
//
//      deleteButton.setOnEditCommit(e -> {
//        String status = String.valueOf(TableView.getSelectionModel().getSelectedItem());
//        TableView.getItems().remove(status);
//      });
//
//      deleteButton.setOnEditCommit(e -> {
//        String dateOfBirth = String.valueOf(TableView.getSelectionModel().getSelectedItem());
//      });
//        TableView.getItems().remove(dateOfBirth);
//      TableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//      ObservableList<Users> selectedRows = TableView.getSelectionModel().getSelectedItems();
//// we don't want to iterate on same collection on with we remove items
//      ArrayList<Users> rows = new ArrayList<>(selectedRows);
//      rows.forEach(row -> TableView.getItems().remove(row));
    }
    catch (Exception e) {
      System.err.println(e);
    }
  }
  public void loadData2(){
    try{
      ObservableList<Books> table_dataa = FXCollections.observableArrayList();
      for (int i = 0; i < 20; i++){
        table_dataa.add(new Books(
            "Title " + i,
            "Subject " + i,
            "ISBN " + i,
            "date of birth " + i,
            "password " + i ,
            new Button("add"),
            new Button("edit"),
            new Button("delete")));
      }
      if(table_dataa.size()!=0) {
        table_dataa.add(new Books("", "", "", "", " ",
            new Button("add"),
            new Button("edit"),
            new Button("delete")));
      }

      TableBookView.setItems(table_dataa);
    }
    catch (Exception e){
      System.err.println(e);
    }
  }
  /*
  * Students table initializer
  * */
  public void initTable(){
    initCols();
    loadData();
  }
  private void initCols(){
    try{
      fullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
      id.setCellValueFactory(new PropertyValueFactory<>("id"));
      status.setCellValueFactory(new PropertyValueFactory<>("status"));
      dateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
      password.setCellValueFactory(new PropertyValueFactory<>("password"));
      addButton.setCellValueFactory(new PropertyValueFactory<>("add"));
      editButton.setCellValueFactory(new PropertyValueFactory<>("edit"));
      deleteButton.setCellValueFactory(new PropertyValueFactory<>("delete"));
      addButton();
      editButton();
      deleteButton();
    }
    catch (Exception e){
      System.out.println(e);
    }
  }
  private void addButton(){
    try
    {

    }catch (Exception e){
      System.err.println(e);
    }
  }
  private void editButton(){
    try
    {

      fullName.setCellFactory(TextFieldTableCell.forTableColumn());
      fullName.setOnEditCommit(e-> {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setFullName(e.getNewValue());
      });
      id.setCellFactory(TextFieldTableCell.forTableColumn());
      id.setOnEditCommit(e-> {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setId(e.getNewValue());
      });
      id.setCellFactory(TextFieldTableCell.forTableColumn());
      id.setOnEditCommit(e-> {
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
    catch (Exception e){
      System.err.println(e);
    }
  }
  private void deleteButton(){
    try {
//      deleteButton.setOnEditCommit(e -> {
//        String fullName = String.valueOf(TableView.getSelectionModel().getSelectedItem());
//        TableView.getItems().remove(fullName);
//      });
//      deleteButton.setOnEditCommit(e -> {
//        String id = String.valueOf(TableView.getSelectionModel().getSelectedItem());
//        TableView.getItems().remove(id);
//      });
//
//      deleteButton.setOnEditCommit(e -> {
//        String status = String.valueOf(TableView.getSelectionModel().getSelectedItem());
//        TableView.getItems().remove(status);
//      });
//
//      deleteButton.setOnEditCommit(e -> {
//        String dateOfBirth = String.valueOf(TableView.getSelectionModel().getSelectedItem());
//        TableView.getItems().remove(dateOfBirth);
//      });
      TableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
      ObservableList<Users> selectedRows = TableView.getSelectionModel().getSelectedItems();
// we don't want to iterate on same collection on with we remove items
      ArrayList<Users> rows = new ArrayList<>(selectedRows);
      rows.forEach(row -> TableView.getItems().remove(row));
    }
    catch (Exception e) {
      System.err.println(e);
    }

  }
  public void loadData(){
    try{
      ObservableList<Users> table_data = FXCollections.observableArrayList();
      for (int i = 0; i < 20; i++){
        table_data.add(new Users(
            "Full name " + i,
            "Id " + i,
            "status " + i,
            "date of birth " + i,
            "password " + i ,
            new Button("add"),
            new Button("edit"),
            new Button("delete")));
      }
      if(table_data.size()!=0) {
        table_data.add(new Users("", "", "", "", " ",
            new Button("add"),
            new Button("edit"),
            new Button("delete")));
      }

      TableView.setItems(table_data);
    }
    catch (Exception e){
      System.err.println(e);
    }
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
//    AdminStudents students = new AdminStudents();
//    ResourceBundle resourceBundle ;
//    students.initialize(root,resourceBundle);
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
