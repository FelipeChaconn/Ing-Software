/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;
//import Archivos.ArchivoPreordenes;
import Archivos.PreOrderMov;
import static GUI.BuyMovie.jListMov;
import Procedimientos.Instancias;
import static GUI.FinalOrderMovi.totallabelMov;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Luis Felipe
 */
public class ProcMovie extends JFrame{
     Instancias insta = new Instancias();

    public static String preordenpeli;
    public static String nombrepeli2;
    PreOrderMov pre = new PreOrderMov();
    
    public void leercantidad() {
       
        String cantipeli = null;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Movies.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (jListMov.getSelectedValue().equals(lista1[0])) {
                    cantipeli = lista1[4];
                    nombrepeli2 = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        
        
        if (Integer.parseInt(cantipeli) <= 0) {

            Object preg = "We dont have this product \n"
                    + "Do you want to do other  order?";
            Object unComponentePadre = null;
            Object unIcono = null;
            int sele = JOptionPane.showOptionDialog((Component) unComponentePadre, preg, "Question", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, (Icon) unIcono, new Object[]{"Accept", "Cancel"}, // null para YES, NO y CANCEL
                    "opcion 1");
            int suma = sele + 1;

            if (sele == 0) {
                preordenpeli = JOptionPane.showInputDialog("How many do you want");
                this.setVisible(false);
        pre.AddPreMovi();
                insta.BuyMovie();

            } else {
                insta.BuyMovie();
            }

        }
    }

    public void precioO(int cantidad) {
        String can = null;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Movies.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (jListMov.getSelectedValue().equals(lista1[0])) {
                    can = lista1[3];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        int cantint = Integer.parseInt(can);
        int total = cantidad * cantint;
        totallabelMov.setText("₡" + String.valueOf(total));

    }
}
