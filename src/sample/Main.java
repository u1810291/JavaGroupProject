package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
//It has some errors make sure that I resolved it before running this code
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("/sample/View/EditsViews/Librarians.fxml"));
//        primaryStage.setTitle("Librarians List");
//        primaryStage.setScene(new Scene(root, 600, 400));
//        primaryStage.show();
//    }
//Until here





//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("View/RegisterView/Login.fxml"));
//        primaryStage.setTitle("Login");
//        primaryStage.setScene(new Scene(root, 600, 400));
//        primaryStage.show();
//    }

//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("/sample/View/EditsViews/Students.fxml"));
//        primaryStage.setTitle("Students list");
//        primaryStage.setScene(new Scene(root, 600, 400));
//        primaryStage.show();
//    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/View/EditsViews/StudentEdit.fxml"));
        primaryStage.setTitle("Student Edit");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("Librarian/Librarian_student/Students.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 600, 400));
//        primaryStage.show();
//    }
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("/sample/View/RegisterView/Register.fxml"));
//        primaryStage.setTitle("Registration");
//        primaryStage.setScene(new Scene(root, 600, 400));
//        primaryStage.show();
//    }


    public static void main(String[] args) {
        launch(args);
//book edit and book delete
    }
}

