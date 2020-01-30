/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;
import Archivos.PreOrderMov;
import static GUI.MenuCompraDisco.jlistComp;
import static GUI.EliminDisc.JDelete;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static GUI.OrderFinal.totallabel;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Felipe
 */
public class ProcDisc extends JFrame {

    public static String preorden;
    public static String nombre;
    PreOrderMov pre = new PreOrderMov();
    Instancias insta = new Instancias();

    public void leercantidad() {
       
        String canti = null;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Discos.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (jlistComp.getSelectedValue().equals(lista1[0])) {
                    canti = lista1[5];
                    nombre = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
       
        if (Integer.parseInt(canti) <= 0) {

          Object preg = "We dont have this product \n"
                    + "Do you want to do other  order?";
            Object unComponentePadre = null;
            Object unIcono = null;
            int sele = JOptionPane.showOptionDialog((Component) unComponentePadre, preg, "Question", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, (Icon) unIcono, new Object[]{"Acept", "Cancel"}, // null para YES, NO y CANCEL
                    "opcion 1");
            int suma = sele + 1;

            if (sele == 0) {
                preorden = JOptionPane.showInputDialog("How many do you want");
                this.setVisible(false);
                pre.AddPreorderMusic();
                insta.BuyMusic();
            } else {
                insta.BuyMusic();
            }

        }
    }

    public void obtenerprecio(int cantidad) {
        //this method will get the price according to the cd selected
        String can = null;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Discos.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (jlistComp.getSelectedValue().equals(lista1[0])) {
                    can = lista1[4];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        int cantint = Integer.parseInt(can);
        int total = cantidad * cantint;
        totallabel.setText("₡" + String.valueOf(total));

    }

}