/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;
import Herencias.Order;
import static GUI.AgregarMovie.NameAdd;
import static GUI.Usuario.txtUsr;
import Procedimientos.Instancias;
import static Procedimientos.UsrCompDisco.correouser;
import static Procedimientos.UsrCompDisco.usuario;
import static Procedimientos.ProcDisc.nombre;
import static Procedimientos.ProcDisc.preorden;
import static Procedimientos.ProcMovie.nombrepeli2;
import static Procedimientos.ProcMovie.preordenpeli;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author Luis Felipe
 */
public class PreOrderMov {
     String tipodisco = "Disco";
    String tipopeli = "Pelicula";
    
    Instancias insta = new Instancias();
    public String obtenercorreo(){
       
        String correo = null;
        try {
            String temp;

            BufferedReader bf = new BufferedReader(new FileReader("Usuarios.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {

                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equals(txtUsr.getText())) {
                    correo = lista1[3];
                }

            }
            bf.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
    
    return correo;}
    public void AddPreorderMusic() {
      
        Order orden = new Order(usuario,nombre,tipodisco,preorden, obtenercorreo());
        try {
            

            try {
                BufferedWriter bw;

                bw = new BufferedWriter(new FileWriter("Pre-Ordenes.txt", true));
                bw.write(orden.devolver()+"\n");

                bw.close();
            } catch (IOException ex) {

            }
            JOptionPane.showMessageDialog(null, "The pre-order was registred!");
            
        } catch (java.lang.NumberFormatException e) {
            
        }

    }
      public void AddPreMovi() {
      
        try {
            

            try {
                BufferedWriter bw;

                bw = new BufferedWriter(new FileWriter("Pre-Ordenes.txt", true));
                bw.write(usuario + ";" + nombrepeli2 + ";" + tipopeli + ";" + preordenpeli +";" + obtenercorreo() +"\n");

                bw.close();
            } catch (IOException ex) {

            }
            JOptionPane.showMessageDialog(null, "The pre-order was registred!");
            
        } catch (java.lang.NumberFormatException e) {
            
        }

    }
}
