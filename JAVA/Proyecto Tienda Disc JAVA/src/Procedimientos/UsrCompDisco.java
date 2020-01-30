/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import Archivos.ArchivoDiscos;
import Archivos.ArchivoUsuario;
import static GUI.MenuCompraDisco.txtAuth;
import static GUI.MenuCompraDisco.txtNam;
import static GUI.MenuCompraDisco.txtMin;
import static GUI.MenuCompraDisco.txtMax;
import static GUI.MenuCompraDisco.jlistComp;
import static GUI.MenuCompraDisco.jtableCom;
import static GUI.MenuCompraDisco.modelo;
import GUI.Usuario;
import static GUI.Usuario.txtUsr;
import static GUI.Usuario.pssUsr;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.applet.AudioClip;
import java.util.Arrays;

/**
 *
 * @author Luis Felipe
 */
public class UsrCompDisco extends JFrame {
    AudioClip sonido;
    AudioClip sonido2;
    AudioClip sonido3;
    AudioClip sonido4;
    AudioClip sonido5;
    public static String usuario;
    public static String correouser;
    ArchivoUsuario lo = new ArchivoUsuario();

    public void sonido() {
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Musica/El_Farsante.wav"));
    }
    public void sonido2(){
        sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Musica/Adios_Amor.wav"));
    }


    public String[] leer() {
        lo.crearlogin();
        String info = lo.obtener();

        String[] posi = info.split(";");

        return posi;
    }

    public static boolean vacio() {
        boolean vacio = false;

        try {
            FileReader fr = new FileReader("Usuarios.txt");
            BufferedReader bf = new BufferedReader(fr);

            String sCadena = "";
            while ((sCadena = bf.readLine()) != null) {
                vacio = true;

            }
            bf.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoDiscos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoDiscos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vacio;

    }

    public String obtenerusuaio() {
        String user = txtUsr.getText();
        String usuario = null;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Usuarios.txt"));

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {

                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equals(user)) {
                    usuario = lista1[0];
                }

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return usuario;
    }

    public String obtenercontra() {
        String con = pssUsr.getText();
        String user = txtUsr.getText();
        String usuario = null;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Usuarios.txt"));

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {

                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equals(user) & lista1[2].equals(con)) {
                    usuario = lista1[2];
                }

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return usuario;
    }

    public void ingreusu() {
        if (vacio() == true) {

            try {

                String usu = obtenerusuaio();
                String contra = obtenercontra();
                String u = txtUsr.getText();
                String c = pssUsr.getText();
                if (u.equals(usu) & c.equals(contra)) {
                   
                    usuario = u;
                    correouser = c;
                    Instancias insta = new Instancias();
                    insta.MenuUsr();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Password or username !");
                    txtUsr.setText("");
                    pssUsr.setText("");
                    new Usuario(this, true).setVisible(true);
                }
            } catch (java.lang.NullPointerException e) {

            }

        } else {
            JOptionPane.showMessageDialog(null, "No found in system!");
            txtUsr.setText("");
            pssUsr.setText("");
            new Usuario(this, true).setVisible(true);
        }
    }

    public void Cargarnombre() {
      
        String buscarname = txtNam.getText();
        String busautor = txtAuth.getText();
        String busprecio = txtMin.getText();
        String busprecio2 = txtMax.getText();
        int precio1 = 0;
        int precio2 = 0;
        boolean vacio = false;
        if (txtNam.getText().equals("") & txtAuth.getText().equals("") & txtMin.getText().equals("") & txtMax.getText().equals("")) {
            vacio = true;
            JOptionPane.showMessageDialog(null, "Error!");

        }
        if (vacio == false) {
            modelo.clear();

            try {
                precio1 = Integer.parseInt(busprecio);
                precio2 = Integer.parseInt(busprecio2);
            } catch (java.lang.NumberFormatException e) {
            }
            boolean existe = false;
            String nombre = null;
            try {
                String temp;
                BufferedReader bf2 = new BufferedReader(new FileReader("Discos.txt"));

                temp = "";
                String bfRead;
                while ((bfRead = bf2.readLine()) != null) {
                    temp = bfRead;
                    String lista = temp;

                    String[] lista1 = lista.split(";");

                    if (lista1[0].equalsIgnoreCase(buscarname) || lista1[1].equalsIgnoreCase(busautor) || (Integer.parseInt(lista1[4]) <= precio2 & Integer.parseInt(lista1[4]) >= precio1)) {
                        modelo.addElement(lista1[0]);
                        existe = true;

                    } else {
                        existe = false;

                    }

                }

                bf2.close();
                if (existe == false) {
                    JOptionPane.showMessageDialog(null, "Disc no exists!");
                }
            } catch (IOException e) {
                System.err.println("No se encontro el archivo" + e);
            }
        }

    }

    public void mostrarinfor() {
        String nombre = jlistComp.getSelectedValue();

        ArrayList<String> nombres = new <String>ArrayList();
        ArrayList<String> autor = new <String>ArrayList();
        ArrayList<String> lista2 = new <String>ArrayList();
        ArrayList<String> precio = new <String>ArrayList();

        int lNumeroLineas = 0;
        try {
            FileReader fr = new FileReader("Discos.txt");
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
            BufferedReader bf2 = new BufferedReader(new FileReader("Discos.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf2.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equalsIgnoreCase(nombre)) {
                    nombres.add(lista1[0]);
                    autor.add(lista1[1]);
                    lista2.add(lista1[3]);
                    precio.add(lista1[4]);
                    existe = true;
                }

            }
            bf2.close();

        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        try {
            for (int i = 0; i < 1; i++) {
                jtableCom.setValueAt(nombres.get(i), i, 0);
                jtableCom.setValueAt(autor.get(i), i, 1);
                jtableCom.setValueAt(precio.get(i), i, 2);
                jtableCom.setValueAt(lista2.get(i), i, 3);

            }
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }
        if (jtableCom.getRowCount() > lNumeroLineas) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) jtableCom.getModel();
                jtableCom.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

    }

    public void playMusic() {
        if (jlistComp.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Select disc to play!");
        } else {
            if (jtableCom.getValueAt(0, 3).equals("El Farsante")) {
                sonido();
                sonido.play();
            }
            if (jtableCom.getValueAt(0, 3).equals("Soy Peor")) {
                sonido2();
                sonido2.play();
            }
        }
    }

    public void stopMusic() {
        if (jlistComp.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Select disc to play!");
        } else {
            if (jtableCom.getValueAt(0, 3).equals("El Farsante")) {

                sonido.stop();
            }
            if (jtableCom.getValueAt(0, 3).equals("Soy Peor")) {
                
                sonido2.stop();
            }

        }
    }

}
