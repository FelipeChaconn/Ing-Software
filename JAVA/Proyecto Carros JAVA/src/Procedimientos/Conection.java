/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;
import GUI.Login;
import java.awt.Menu;
import javax.swing.JFrame;
import java.sql.*;
/**
 *
 * @author Luis Felipe
 */
public class Conection extends  JFrame{
    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;


   
   public void ConnectionBD(){
      if (connection != null) {
            return;
        }

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rent a Car", "postgres", "Postgres");
            if (connection != null) {
                System.out.println("Conection established");
            }
        } catch (Exception e) {
            System.out.println("Problem when connecting to the database" + e);
        }

 
 }
   public ResultSet datosAdmin(){
        ResultSet rs = null;
         ResultSet rs1 = null;
        Statement s = null;
        try{
        s = connection.createStatement();
        rs = s.executeQuery("select * from admin ");
        }catch(Exception e){
            System.out.println("Error consulta");
        }
   return rs;
  
   }
    public ResultSet AdminOrUser(){
        ResultSet rs = null;
         ResultSet rs1 = null;
        Statement s = null;
        try{
        s = connection.createStatement();
        rs = s.executeQuery("select * from admin where ocupation = '1'");
        }catch(Exception e){
            System.out.println("Error consulta");
        }
   return rs;
  
   }
          
}
