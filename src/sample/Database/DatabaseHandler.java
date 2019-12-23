package sample.Database;

import javax.management.relation.RelationSupport;
import javax.sql.DataSource;
import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.*;
import java.util.concurrent.BlockingDeque;

public class DatabaseHandler {
  private static DatabaseHandler handler;
  private static final String DB_URL = "jdbc:derby:database;";
  private static Connection conn = null;
  private static Statement statement = null;

  public DatabaseHandler(){
    createConnection();
    setUpBookTable();
    setUpUsers();
  }
  public void createConnection(){
    try{
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
      conn = DriverManager.getConnection(DB_URL);
      System.out.println("Connected");
    }catch (Exception ex){
      ex.printStackTrace();
    }
  }
  public void setUpUsers(){
    String USERS_TABLE_NAME = "USERS";
    String DROP_USERS_TABLE = "DROP TABLE " + USERS_TABLE_NAME;
    try {
      statement = conn.createStatement();
      DatabaseMetaData dbm = conn.getMetaData();
      ResultSet users = dbm.getTables(null,null, USERS_TABLE_NAME.toUpperCase(), null);
      String CREATE_USERS_TABLE = "CREATE TABLE " + USERS_TABLE_NAME + " (" +
          "     full_name varchar(200),\n" +
          "     id varchar(200) primary key,\n"+
          "     status varchar(200),\n" +
          "     date_of_birth varchar(200),\n"+
          "     password varchar(200)" +
          ")";
      if (users.next()){
        System.out.println("Table " + USERS_TABLE_NAME + " already exist. Ready fo go!");
//        statement.execute(DROP_USERS_TABLE);
      }
      else {
        statement.execute(CREATE_USERS_TABLE);
        System.out.println("Created Users table");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void setUpBookTable(){
    String BOOKS_TABLE_NAME = "BOOKS";
    try{
      statement = conn.createStatement();
      DatabaseMetaData dbm = conn.getMetaData();
      ResultSet tables = dbm.getTables(null,null, BOOKS_TABLE_NAME.toUpperCase(), null);
      String DROP_BOOKS_TABLE = "DROP TABLE " + BOOKS_TABLE_NAME;
      String CREATE_BOOKS_TABLE = "CREATE TABLE " + BOOKS_TABLE_NAME + " ("+
          "     isbn varchar(200) primary key,\n"+
          "     title varchar(200),\n" +
          "     subject varchar(200),\n" +
          "     status varchar(200),\n" +
          "     author varchar(200),\n" +
          "     publishDate varchar(200) " +
          ")";
      if (tables.next()){
        System.out.println("Table " + BOOKS_TABLE_NAME + " already exist. Ready to go!");
//        statement.execute(DROP_BOOKS_TABLE);
//        System.out.println("Table dropped!");
      }
      else {
//        statement.execute(CREATE_USERS_TABLE);
        statement.execute(CREATE_BOOKS_TABLE);
        System.out.println("Created Books table");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public ResultSet execQuery(String query){
    ResultSet resultSet;
    try
    {
      statement = conn.createStatement();
      resultSet = statement.executeQuery(query);
      System.out.println("Execution of query");
      System.out.println(query);
      ResultSetMetaData res = resultSet.getMetaData();
      while (resultSet.next()){
        for (int i = 1; i <= 5;i++){
          if (i != 1) System.out.println(", ");
          String col = resultSet.getString(i);
          System.out.print(res.getColumnName(i) + " : " +col);
        }
      }
    } catch (Exception e) {
      System.out.println("Exception is execQuery:databaseHandler " + e.getLocalizedMessage());
      e.printStackTrace();
      return null;
    }
    finally {
    }
    return resultSet;
  }
  public boolean execAction(String qu){
    try {
      statement = conn.createStatement();
      statement.executeUpdate(qu);
      System.out.println("Successfully inserted");
      return true;
    } catch (Exception e)
    {
      JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error Occurred", JOptionPane.ERROR_MESSAGE);
      e.printStackTrace();
      return false;
    }
    finally {

    }
  }

}
