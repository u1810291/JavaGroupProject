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
  public void setUpBookTable(){
    String TABLE_NAME = "BOOKS";
    try{
      statement = conn.createStatement();
      DatabaseMetaData dbm = conn.getMetaData();
      ResultSet tables = dbm.getTables(null,null, TABLE_NAME.toUpperCase(), null);
      String DROP_TABLE = "DROP TABLE " + TABLE_NAME;
      String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("+
          "     isbn varchar(200) primary key,\n"+
          "     title varchar(200),\n" +
          "     subject varchar(200),\n" +
          "     status varchar(200),\n" +
          "     author varchar(200),\n" +
          "     publishDate varchar(200) " +
          ")";
      if (tables.next()){
        System.out.println("Table " + TABLE_NAME + " already exist. Ready to go!");
//        statement.execute(DROP_TABLE);
//        System.out.println("Table dropped!");
      }
      else {
        statement.execute(CREATE_TABLE);
        System.out.println("Created");
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

    } catch (Exception e) {
      System.out.println("Exception ar execQuery:databaseHandler" + e.getLocalizedMessage());
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
