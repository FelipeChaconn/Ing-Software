/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;


import static GUI.MenuPrincipal.txtId;
import static GUI.MenuPrincipal.txtNombre;
import static GUI.MenuPrincipal.txtPrecio;
import static GUI.MenuPrincipal.txtTipo;
import static GUI.MenuPrincipal.jcomProduct;

import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Luis Felipe
 */
public class Conexion extends  JFrame{
  String driver = "org.postgresql.Driver";
String ruta = "jdbc:postgresql://localhost:5432/Examen";
String user = "postgres";
String password = "Postgres";

   
  public void GuardarUsuario(String id,String nombre,String precio,String tipo){

        // Insertar datos a la bd:
         try{
            Class.forName(driver);
            Connection conne=(Connection) DriverManager.getConnection(ruta,user,password);
            Statement consulta=(Statement) conne.createStatement();
            consulta.executeUpdate("insert into productos(id,nombre,precio,tipo) values('"+id+"','"+nombre+"','"+precio+"','"+tipo+"')");
            JOptionPane.showMessageDialog(this, "EL producto fue agregado con exito");
            txtId.setText("");
            txtNombre.setText("");
            txtPrecio.setText("");
            txtTipo.setText("");
         } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"El producto ya existe");

        } catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error inesperado");
    } 
}
    public void GuardarCompra(String nombre,String edad,String sexo,String producto,String fecha){

        // Insertar datos a la bd:
         try{
            Class.forName(driver);
            Connection conne=(Connection) DriverManager.getConnection(ruta,user,password);
            Statement consulta=(Statement) conne.createStatement();
            consulta.executeUpdate("insert into productos(id,nombre,precio,tipo) values('"+nombre+"','"+edad+"','"+sexo+"','"+producto+"','"+fecha+"')");
            JOptionPane.showMessageDialog(this, "Su orden fue agregado con exito");
            
         } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"La orden de compra  ya existe");

        } catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error inesperado");
    } 
}
        public void EdadChild(String edad){

        // Insertar datos a la bd:
         try{
            Class.forName(driver);
            Connection conne=(Connection) DriverManager.getConnection(ruta,user,password);
            Statement consulta=(Statement) conne.createStatement();
             ResultSet rs = consulta.executeQuery("select nombre from productos where tipo = 1");
              while(rs.next())
        {
          
        }
            JOptionPane.showMessageDialog(this, "Su orden fue agregado con exito");
            
         } catch(SQLException e){
             System.err.println(e);

        } catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error inesperado");
    } 
}
          
}
