/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;
import Archivos.ArchivoDiscos;
import static GUI.BuyMovie.txtAuthorBM;
import static GUI.BuyMovie.txtNameBM;
import static GUI.BuyMovie.jListMov;
import static GUI.BuyMovie.jtablepelicula;
import static GUI.BuyMovie.modelopeli;
import static GUI.BuyMovie.txtMinBM;
import static GUI.BuyMovie.txtMaxBM;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Luis Felipe
 */
public class UsrCompMovie {
    public void CargName() {
        //this method will charge the names of the movies according to the parameters
        String search = txtNameBM.getText();
        String searchAu = txtAuthorBM.getText();
        String min = txtMinBM.getText();
        String max = txtMaxBM.getText();
        int precio11 = 0;
        int precio22 = 0;
        boolean vacio = false;
        if (txtNameBM.getText().equals("") & txtAuthorBM.getText().equals("") & txtMinBM.getText().equals("") & txtMaxBM.getText().equals("")) {
            vacio = true;
            JOptionPane.showMessageDialog(null, "Ingrese algún Parametro de busqueda!");

        }
        if (vacio == false) {
            modelopeli.clear();

            try {
                precio11 = Integer.parseInt(min);
                precio22 = Integer.parseInt(max);
            } catch (java.lang.NumberFormatException e) {
            }
            boolean existe = false;
            String nombre = null;
            try {
                String temp;
                BufferedReader bf2 = new BufferedReader(new FileReader("Movies.txt"));

                temp = "";
                String bfRead;
                while ((bfRead = bf2.readLine()) != null) {
                    temp = bfRead;
                    String lista = temp;

                    String[] lista1 = lista.split(";");

                    if (lista1[0].equalsIgnoreCase(search) || lista1[1].equalsIgnoreCase(searchAu) || (Integer.parseInt(lista1[3]) <= precio22 & Integer.parseInt(lista1[3]) >= precio11)) {

                        modelopeli.addElement(lista1[0]);
                        existe = true;

                    }

                }

                bf2.close();

            } catch (IOException e) {
                System.err.println("No se encontro el archivo" + e);
            }
        }

    }
     public void ShowInfo() {
  

        String nombre = jListMov.getSelectedValue();

        ArrayList<String> nombres = new <String>ArrayList();
        ArrayList<String> autor = new <String>ArrayList();
        ArrayList<String> precio = new <String>ArrayList();

        int lNumeroLineas = 0;
        try {
            FileReader fr = new FileReader("Movies.txt");
            BufferedReader bf = new BufferedReader(fr);

            String sCadena = "";
            while ((sCadena = bf.readLine()) != null) {
                lNumeroLineas++;
            }
            bf.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoDiscos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoDiscos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            boolean existe = false;
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Movies.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf2.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equalsIgnoreCase(nombre)) {
                    nombres.add(lista1[0]);
                    autor.add(lista1[1]);
                    precio.add(lista1[3]);
                    existe = true;
                }

            }
            bf2.close();

        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        try {
            for (int i = 0; i < 1; i++) {
                jtablepelicula.setValueAt(nombres.get(i), i, 0);
                jtablepelicula.setValueAt(autor.get(i), i, 1);
                jtablepelicula.setValueAt(precio.get(i), i, 2);

            }
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }
        if (jtablepelicula.getRowCount() > lNumeroLineas) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) jtablepelicula.getModel();
                jtablepelicula.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

    }
}
