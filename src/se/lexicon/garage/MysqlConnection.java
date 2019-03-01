package se.lexicon.garage;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MysqlConnection {

  public static ArrayList<Vehicle> getVehiclesDB() throws SQLException {

    Connection conn = null;
    Statement stat = null;
    ResultSet rs = null;

    ArrayList<Vehicle>  vehicles = new ArrayList<>();

    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "Deadthief?55");
      System.out.println("Connected to Sakila database!");

      stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

      rs = stat.executeQuery("Select * From vehicle");

      while(rs.next()){
        if(rs.getString("type").equals("car")){
          Car temp = new Car(rs.getString("maker"));
          vehicles.add(temp);
        }
      }
    }catch(SQLException e){
      e.printStackTrace();
    }finally{
      if(rs != null){
        rs.close();
      }
      if(stat != null){
        stat.close();
      }
      if(conn != null){
        conn.close();
      }
    }

    return vehicles;
  }

  public static void addVehicle(Vehicle v) throws SQLException {
    Connection conn = null;
    Statement stat = null;
    ResultSet rs = null;

   // boolean setEmpty = false;


    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "Deadthief?55");
      System.out.println("Connected to Sakila database!");

      stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

      rs = stat.executeQuery("Select * From vehicle");

      if(v instanceof Car){
        Car tempCar = (Car) v;
        rs.afterLast();
        stat.executeUpdate("Insert Into vehicle(maker, top_speed, type) values(\'" + tempCar.getBrand() + "\', \'"
                + tempCar.getTopSpeed() + "\', \'car\')");
//        while(rs.next() && !setEmpty){
//          if(rs.getString("type").equals("empty")){
//            rs = stat.executeQuery("Insert Into vehicle(maker, topspeed) Values(" + tempCar.getBrand() + ", "
//                    + tempCar.getTopSpeed() + ")");
//            rs.updateRow();
//            setEmpty = true;
//          }
//        }
        //if(!setEmpty){
        //}

      }

    }catch(SQLException e){
      e.printStackTrace();
    }finally{
      if(rs != null){
        rs.close();
      }
      if(stat != null){
        stat.close();
      }
      if(conn != null){
        conn.close();
      }
    }
  }

  public static void main(String[] args) {

    Connection conn = null;
    Statement stat = null;
    ResultSet rs = null;

    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "Deadthief?55");
      System.out.println("Connected to Sakila database!");

      stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
      rs = stat.executeQuery("Select * From sakila.city Limit 10");

      while(rs.next()){
        System.out.println(rs.getString("city"));
      }

      rs.beforeFirst();

      while(rs.next()){
        if(rs.getString("city").equals("Acua")){
          rs.updateString("city", "Aqua");
          rs.updateRow();
          System.out.println(rs.getString("city"));
        }
      }





    } catch (SQLException e) {
      e.printStackTrace();
    }
    finally{
      if(rs != null){
        try {
          rs.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if(stat != null){
        try {
          stat.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if(conn != null){
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
