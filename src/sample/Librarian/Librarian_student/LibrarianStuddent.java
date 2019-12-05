package sample.Librarian.Librarian_student;

//public class LibrarianStuddent {
//    @FXML
//    private TableView<User> table_info;
//
//    @FXML
//    private TableColumn<User, String> col_id;
//
//    @FXML
//    private TableColumn<User, String> col_name;
//
//    @FXML
//    private TableColumn<User, String> col_email;
//
//    @FXML
//    private TableColumn<User, String> col_notes;
//
//    @FXML
//    private TableColumn<User, Button> col_update;
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle)
//    {
//    iniTable();
//    }
//    private void iniTable()
//    {
//        intiCols();
//    }
//    private void intiCols()
//    {
//        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
//        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
//        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
//        col_notes.setCellValueFactory(new PropertyValueFactory<>("notes"));
//        col_update.setCellValueFactory(new PropertyValueFactory<>("update"));
//        editableCols();
//    }
//    private void editableCols(){
//    col_id.setCellFactory(TextFieldTableCell.forTableColumn());
//
//    col_id.getOnEditCommit(e->
//    {
//       e.getTableView().getItems().get(e.getTablePosition().getRow()).setId(e.getNewVlaue());
//    });
//
//    col_name.setCellFactory(TextFieldTableCell.forTableColumn());
//
//    col_name.getOnEditCommit(e->
//    {
//        e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewVlaue());
//    });
//
//
//    col_email.setCellFactory(TextFieldTableCell.forTableColumn());
//
//    col_email.getOnEditCommit(e->
//    {
//        e.getTableView().getItems().get(e.getTablePosition().getRow()).setEmail(e.getNewVlaue());
//    });
//
//    col_notes.setCellFactory(TextFieldTableCell.forTableColumn());
//
//    col_notes.getOnEditCommit(e->
//    {
//        e.getTableView().getItems().get(e.getTablePosition().getRow()).setNotes(e.getNewVlaue());
//    });
//        table_info.setEditable(true);
//    }
//    private loadData(){
//
//    }
//}
