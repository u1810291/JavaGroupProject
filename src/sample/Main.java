package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application
{
//    final String SELECT_QUERY = "SELECT * FROM TITLES";
//    Statement stmt = null;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 550, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        final String SELECT_QUERY = "SELECT * FROM AUTHORS";
        try {
            Connection conn;
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String dbURL = "jdbc:derby:books;";
            String user = "deitel";
            String password = "deitel";
            conn = DriverManager.getConnection(dbURL, user, password);
            System.out.println("Connected");
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
//        launch(args);
    }
}

