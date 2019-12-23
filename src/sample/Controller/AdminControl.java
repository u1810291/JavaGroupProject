package sample.Controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import org.apache.derby.catalog.types.UserDefinedTypeIdImpl;
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
  @FXML private Button addLibrary;
  @FXML private Button editLibrary;
  @FXML private Button deleteLibrary;
  @FXML private TextField idLibraryText;
  @FXML private TextField statusLibraryText;
  @FXML private TextField passwordLibraryText;
  @FXML private TextField dateOfBirthLibraryText;
  @FXML private TextField fullNameLibraryText;
  /*
  * Books buttons and text fields
  * */
  @FXML private Button addBook;
  @FXML private Button editBook;
  @FXML private Button deleteBook;
  @FXML private TextField titleBook;
  @FXML private TextField subjectBook;
  @FXML private TextField authorBook;
  @FXML private TextField isbnBookText;
  /*
  * Student buttons and text fields
  * */
  @FXML private Button addStudent;
  @FXML private Button editStudent;
  @FXML private Button deleteStudent;
  @FXML private TextField passwordStudent;
  @FXML private TextField dateOfBirthStudent;
  @FXML private TextField statusStudent;
  @FXML private TextField idStudent;
  @FXML private TextField fullNameStudent;
  @FXML private TextField publishBookText1;
  @FXML private TextField statusB;
  @FXML private TableView<User> TableViewLibrarian;
  @FXML private TableColumn<User, String> idLibrary;
  @FXML private TableColumn<User, String> fullNameLibrary;
  @FXML private TableColumn<User, String> statusLibrary;
  @FXML private TableColumn<User, String> passwordLibrary;
  @FXML private TableColumn<User, String> dateOfBirthLibrary;
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
  @FXML private TableView<User> TableView;
  @FXML private TableColumn<User, String> fullName;
  @FXML private TableColumn<User, String> id;
  @FXML private TableColumn<User, String> status;
  @FXML private TableColumn<User, String> dateOfBirth;
  @FXML private TableColumn<User, String> password;
  /*
  * Books table properties
  * */
  @FXML private TableView<Book> TableBookView;
  @FXML private TableColumn<Book, String> title;
  @FXML private TableColumn<Book, String> subject;
  @FXML private TableColumn<Book, String> author;
  @FXML private TableColumn<Book, String> statusBook;
  @FXML private TableColumn<Book, String> ISBN;
  @FXML private TableColumn<Book, String> publishDate;
  DatabaseHandler handler;

  ObservableList<Book> list = FXCollections.observableArrayList();
  ObservableList<User> list2 = FXCollections.observableArrayList();
  /*
  * Tables initializer
  * */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    initTable();
    handler = new DatabaseHandler();
  }
  /*
   * Columns and data initializers
   * */
  public void initTable(){
    initCols();
    loadData();
    initCols2();
    loadData2();
    initCols3();
    loadData3();
  }
  /*
  * Books table initializer
  * */
  public static class Book{
    private final SimpleStringProperty  title, subject, author, status, ISBN, publishDate;
    Book(String t, String s, String a, String stat, String i, String p){
      this.title = new SimpleStringProperty(t);
      this.subject = new SimpleStringProperty(s);
      this.author = new SimpleStringProperty(a);
      this.status = new SimpleStringProperty(stat);
      this.ISBN = new SimpleStringProperty(i);
      this.publishDate = new SimpleStringProperty(p);
    }
    public String getTitle() {
      return title.get();
    }
    public String getSubject() {
      return subject.get();
    }
    public String getAuthor() {
      return author.get();
    }
    public String getISBN() {
      return ISBN.get();
    }
    public String getPublishDate() {
      return publishDate.get();
    }
    public String getStatus() {
      return status.get();
    }
  }
  private void initCols2(){
    try{
      title.setCellValueFactory(new PropertyValueFactory<>("title"));
      subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
      author.setCellValueFactory(new PropertyValueFactory<>("author"));
      statusBook.setCellValueFactory(new PropertyValueFactory<>("status"));
      ISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
      publishDate.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
//      TableBookView.setEditable(true);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }
  public void editBookHandler(ActionEvent event) {
  }
  public void addBookHandler(ActionEvent event) {
    String title = titleBook.getText();
    String subject = subjectBook.getText();
    String status = statusB.getText();
    String author = authorBook.getText();
    String ISBN = isbnBookText.getText();
    String publishDate = publishBookText1.getText();
    if (title.isEmpty() || subject.isEmpty() ||  author.isEmpty() || ISBN.isEmpty() || publishDate.isEmpty() || status.isEmpty()){
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
        "'" + status + "'," +
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
    handler = new DatabaseHandler();
    String qu = "SELECT * FROM BOOKS";
    ResultSet rs = handler.execQuery(qu);
    try{
      while (rs.next()){
        String tit = rs.getString("title");
        String sub = rs.getString("subject");
        String auth = rs.getString("author");
        String sta = rs.getString("status");
        String isbn = rs.getString("ISBN");
        String pub = rs.getString("publishDate");
        list.add(new Book(tit, sub, auth, sta, isbn, pub));
      }
    }
    catch (Exception e){
      System.err.println(e);
    }
//    TableBookView.getItems().setAll(list);
  }
  /*
  * Students columns and data initializer
  * */
  public static class User{
    private final SimpleStringProperty fullName, id, status , dateOfBirth, password;
//    fname, ids,stat,date,pass
    User(String f, String i, String s, String d, String p){
      this.id = new SimpleStringProperty(i);
      this.fullName = new SimpleStringProperty(f);
      this.status = new SimpleStringProperty(s);
      this.password = new SimpleStringProperty(p);
      this.dateOfBirth = new SimpleStringProperty(d);
    }
    public String getFullName() {
      return fullName.get();
    }
    public String getId() {
      return id.get();
    }
    public String getStatus() {
      return status.get();
    }
    public String getDateOfBirth() {
      return dateOfBirth.get();
    }
    public String getPassword() {
      return password.get();
    }
  }
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
//    fullName, id, status , dateOfBirth, password
    String fname = fullNameStudent.getText();
    String ids = idStudent.getText();
    String status = statusStudent.getText();
    String date = dateOfBirthStudent.getText();
    String pass = passwordStudent.getText();
    if (fname.isEmpty() || ids.isEmpty() ||  status.isEmpty() || date.isEmpty() || pass.isEmpty()){
      Alert alert = new Alert(AlertType.ERROR);
      alert.setHeaderText(null);
      alert.setContentText("Please fill all the empty places");
      alert.showAndWait();
      return;
    }
    String qu = "INSERT INTO USERS VALUES ("+
        "'" + fname + "', " +
        "'" + ids + "', " +
        "'" + status + "', " +
        "'" + date + "', " +
        "'" + pass + "'" +
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
  public void loadData(){
    handler = new DatabaseHandler();
    String qu = "SELECT * FROM USERS";
    ResultSet rs = handler.execQuery(qu);
    try{
      while (rs.next()){
        String ids = rs.getString("id");
        String fname = rs.getString("fullName");
        String stat = rs.getString("status");
        String pass = rs.getString("password");
        String date = rs.getString("dateOfBirth");
        list2.add(new User( fname, ids,stat,date,pass));
      }
    }
    catch (Exception e){
      System.err.println(e);
      e.printStackTrace();
    }
    TableView.getItems().setAll(list2);
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
  private void loadData3() {
  }
  public void addLibraryHandler(ActionEvent event) {
    String fname = fullNameLibraryText.getText();
    String ids = idLibraryText.getText();
    String status = statusLibraryText.getText();
    String date = dateOfBirthLibraryText.getText();
    String pass = passwordLibraryText.getText();
    if (fname.isEmpty() || ids.isEmpty() ||  status.isEmpty() || date.isEmpty() || pass.isEmpty()){
      Alert alert = new Alert(AlertType.ERROR);
      alert.setHeaderText(null);
      alert.setContentText("Please fill all the empty places");
      alert.showAndWait();
      return;
    }

    String qu = "INSERT INTO USERS VALUES ("+
        "'" + fname + "', " +
        "'" + ids + "', " +
        "'" + status + "', " +
        "'" + date + "'," +
        "'" + pass + "'" +
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
