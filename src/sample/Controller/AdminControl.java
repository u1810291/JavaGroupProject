package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import sample.Database.DatabaseHandler;
import sample.Model.Users;
import javafx.scene.Scene;
import sample.Model.Books;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class AdminControl implements Initializable
{
  /*
  * Librarian buttons and text fields
  * */
  public Button addLibrary;
  public Button editLibrary;
  public Button deleteLibrary;
  public TextField idLibraryText;
  public TextField statusLibraryText;
  public TextField passwordLibraryText;
  public TextField dateOfBirthLibraryText;
  public TextField fullNameLibraryText;
  /*
  * Books buttons and text fields
  * */
  public Button addBook;
  public Button editBook;
  public Button deleteBook;
  public TextField titleBook;
  public TextField subjectBook;
  public TextField authorBook;
  public TextField isbnBookText;
  /*
  * Student buttons and text fields
  * */
  public Button addStudent;
  public Button editStudent;
  public Button deleteStudent;
  public TextField passwordStudent;
  public TextField dateOfBirthStudent;
  public TextField statusStudent;
  public TextField idStudent;
  public TextField fullNameStudent;
  public TextField publishBookText1;
  /*
  * Pages buttons
  * */
  @FXML private Button back;
  @FXML private Button logout;
  @FXML private Button librarian;
  @FXML private Button bookButton;
  @FXML private Button studentButton;
  /*
  * Users table (librarians and students)
  * */
  @FXML private TableView<Users> TableView;
  @FXML private TableColumn<Users, String> fullName;
  @FXML private TableColumn<Users, String> id;
  @FXML private TableColumn<Users, String> status;
  @FXML private TableColumn<Users, String> dateOfBirth;
  @FXML private TableColumn<Users, String> password;
  /*
  * Books table properties
  * */
  @FXML private TableView<Books> TableBookView;
  @FXML private TableColumn<Books, String> title;
  @FXML private TableColumn<Books, String> subject;
  @FXML private TableColumn<Books, String> author;
  @FXML private TableColumn<Books, String> ISBN;
  @FXML private TableColumn<Books, String> publishDate;
  DatabaseHandler handler;
  /*
  * Tables initializer
  * */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    initTable();
    handler = new DatabaseHandler();
    checkData();
  }
  /*
   * Columns and data initializers
   * */
  public void initTable(){
    initCols();
    loadData();
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
      TableBookView.setEditable(true);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }

  public void editBookHandler(ActionEvent event) {
  }
  public void checkData(){
    String qu = "SELECT title FROM BOOKS";
    ResultSet rs = handler.execQuery(qu);
    try {
      while (rs.next()){
        String tit = rs.getString("title");
        System.out.println(tit);;
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  public void addBookHandler(ActionEvent event) {
    String title = titleBook.getText();
    String subject = subjectBook.getText();
    String author = authorBook.getText();
    String ISBN = isbnBookText.getText();
    String publishDate = publishBookText1.getText();
    if (title.isEmpty() || subject.isEmpty() ||  author.isEmpty() || ISBN.isEmpty() || publishDate.isEmpty()){
      Alert alert = new Alert(AlertType.ERROR);
      alert.setHeaderText(null);
      alert.setContentText("Please fill all the empty places");
      alert.showAndWait();
      return;
    }

    String qu = "INSERT INTO BOOKS VALUES ("+
        "'" + ISBN + "', " +
        "'" + title + "', " +
        "'" + subject + "', " +
        "'" + author + "', " +
        "'" + publishDate + "'" +
        ")";
    System.out.println(qu);
    if (handler.execAction(qu)){
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setHeaderText(null);
      alert.setContentText("Successfully");
      alert.showAndWait();
    }
    else {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setHeaderText(null);
      alert.setContentText("Failed");
      alert.showAndWait();
    }

  }
  public void deleteBookHandler(ActionEvent event) {
  }
  public void loadData2(){
    try{
      ObservableList<Books> table_dataa = FXCollections.observableArrayList();
      for (int i = 0; i < 20; i++){
        table_dataa.add(new Books("Title " + i, "Subject " + i, "ISBN " + i, "date of birth " + i, "password " + i));
      }
      if(table_dataa.size()!=0) {
        table_dataa.add(new Books("", "", "", "", " "));
      }

      TableBookView.setItems(table_dataa);
    }
    catch (Exception e){
      System.err.println(e);
    }
  }
  /*
  * Students columns and data initializer
  * */
  private void initCols(){
    try{
      fullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
      id.setCellValueFactory(new PropertyValueFactory<>("id"));
      status.setCellValueFactory(new PropertyValueFactory<>("status"));
      dateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
      password.setCellValueFactory(new PropertyValueFactory<>("password"));
    }
    catch (Exception e){
      System.out.println(e);
    }
  }
  public void deleteStudentHandler(ActionEvent event) {
  }
  public void editStudentHandler(ActionEvent event) {
  }
  public void addStudentHandler(ActionEvent event) {
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
            "password " + i ));
      }
      if(table_data.size()!=0) {
        table_data.add(new Users("", "", "", "", " "));
      }

      TableView.setItems(table_data);
    }
    catch (Exception e){
      System.err.println(e);
    }
  }
  /*
  * Librarian columns and data initializer
  * */
  private void initCols3(){
    try{
      fullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
      id.setCellValueFactory(new PropertyValueFactory<>("id"));
      status.setCellValueFactory(new PropertyValueFactory<>("status"));
      dateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
      password.setCellValueFactory(new PropertyValueFactory<>("password"));
    }
    catch (Exception e){
      System.out.println(e);
    }
  }
  public void addLibraryHandler(ActionEvent event) {
  }
  public void editLibraryHandler(ActionEvent event) {
  }
  public void deleteLibraryHandler(ActionEvent event) {
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
