/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Herencias.MovieCat;
import static GUI.AgregarMovie.txtAuthorAdd;
import static GUI.AgregarMovie.txtQuantiAdd;
import static GUI.AgregarMovie.jCatAdd;
import static GUI.AgregarMovie.txtPriceAdd;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import static GUI.AgregarMovie.NameAdd;
import static GUI.EliminMovie.btnEliminar;
import static GUI.VerPeliculas.jTablaMovies;
import static GUI.ModifMovie.listaModiMo;
import static GUI.ModifMovie.txtAuthorMov;
import static GUI.ModifMovie.txtQuantiMov;
import static GUI.ModifMovie.jCat;
import static GUI.ModifMovie.Name;
import static GUI.ModifMovie.txPriceM;
import Procedimientos.admin;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.table.DefaultTableModel;
import static GUI.EliminMovie.jDelete2;

/**
 *
 * @author Luis Felipe
 */
public class Movie {

    admin ad = new admin();
    BufferedReader bf2;
    BufferedReader bf3;
    BufferedReader bf4;
    BufferedReader bf5;
    BufferedReader bf6;
    BufferedReader bf7;

    public static boolean revisarcat() {
        //this method will check if a category is already on the file
        String cate = jCatAdd.getSelectedItem().toString();
        boolean repite = false;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Movies.txt"));

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {

                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[2].equals(cate)) {
                    repite = true;
                }

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return repite;
    }

    public void addMovie() {
        // this method will add a new movie
        if (revisarcat() == true) {
            JOptionPane.showMessageDialog(null, "Esa Categoria ya esta en el Sistema!");
        } else {
            try {
                String nombre = NameAdd.getSelectedItem().toString();
                String autor = txtAuthorAdd.getText();
                String categoria = jCatAdd.getSelectedItem().toString();
                String precio = txtPriceAdd.getText();
                String cantidad = txtQuantiAdd.getText();
                int precio2 = Integer.parseInt(precio);
                int cantidad2 = Integer.parseInt(cantidad);
                boolean continuar = false;
                MovieCat disco = new MovieCat(nombre, autor, categoria, precio2, cantidad2);
                if (txtAuthorAdd.getText().equals("") || txtPriceAdd.getText().equals("") || txtQuantiAdd.getText().equals("")) {
                    continuar = true;
                    JOptionPane.showMessageDialog(null, "Debe Llenar todos los Campos!");
                }
                if (continuar == false) {
                    try {
                        BufferedWriter bw;

                        bw = new BufferedWriter(new FileWriter("Movies.txt", true));
                        bw.write(disco.devolver() + "\n");

                        bw.close();
                    } catch (IOException ex) {

                    }
                    JOptionPane.showMessageDialog(null, "Se ha Registrado la Película Correctamente!");
                }
            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe Llenar todos los Campos!");
            }
        }
    }

    public void ReadInfo() {
      
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

        ArrayList<String> nombres = new <String>ArrayList();
        ArrayList<String> autor = new <String>ArrayList();
        ArrayList<String> categoria = new <String>ArrayList();
        ArrayList<String> precio = new <String>ArrayList();
        ArrayList<String> condicion = new <String>ArrayList();
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

                nombres.add(lista1[0]);
                autor.add(lista1[1]);
                categoria.add(lista1[2]);
                precio.add(lista1[3]);
                condicion.add(lista1[4]);
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        for (int i = 0; i < nombres.size(); i++) {
            jTablaMovies.setValueAt(nombres.get(i), i, 0);
            jTablaMovies.setValueAt(autor.get(i), i, 1);
            jTablaMovies.setValueAt(categoria.get(i), i, 2);
            jTablaMovies.setValueAt(precio.get(i), i, 3);
            jTablaMovies.setValueAt(condicion.get(i), i, 4);
            if (lNumeroLineas >= jTablaMovies.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) jTablaMovies.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }

        }
        if (jTablaMovies.getRowCount() > lNumeroLineas) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) jTablaMovies.getModel();
                jTablaMovies.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

    }

    public void modificarpeli() {
        
        try {
            String temp;
            BufferedReader bf = new BufferedReader(new FileReader("Movies.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (listaModiMo.getSelectedValue().equals(lista1[0])) {
                    try {
                        String temp2;
                        boolean imp = false;
                        try (BufferedReader bf2 = new BufferedReader(new FileReader("Movies.txt"))) {
                            String bfRead2;

                            try {
                                lista1[0] = Name.getSelectedItem().toString();
                                lista1[1] = txtAuthorMov.getText();
                                lista1[2] = jCat.getSelectedItem().toString();
                                lista1[3] = txPriceM.getText();
                                lista1[4] = txtQuantiMov.getText();
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                            File archivo = new File("Movies.txt");
                            String inf_nueva = null;
                            try {
                                inf_nueva = lista1[0] + ";" + lista1[1] + ";" + lista1[2] + ";" + lista1[3] + ";" + lista1[4];
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                            FileWriter escribir = new FileWriter(archivo, true);

                            try {

                                try (BufferedReader bf1 = new BufferedReader(new FileReader("Movies.txt"))) {

                                    String bf1Read;

                                    while ((bf1Read = bf1.readLine()) != null) {
                                        temp2 = bf1Read;

                                        if (temp2.equals(lista)) {
                                            BufferedWriter br = new BufferedWriter(new FileWriter("Movies.txt"));

                                            continue;
                                        }
                                        escribir.write(temp2 + "\r\n");
                                    }
                                    escribir.write(inf_nueva + "\r\n");
                                    escribir.close();
                                }

                            } catch (IOException e) {

                            }

                        }

                    } catch (IOException e) {
                        System.err.println("No se encontro el archivo" + e);

                    }
                }

            }
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);

        }
        JOptionPane.showMessageDialog(null, "Pelicula Modificado!");
        String cantidadisco = "0";
        boolean existe = false;
        String nombre = null;

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
                if (lista1[0].equals(obtenernombrepreorden())) {
                    cantidadisco = lista1[4];
                    existe = true;
                    nombre = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        int cantidad = Integer.parseInt(cantidadisco);

        if (cantidad > 0 & existe == true) {
            String correo = null;
            boolean enviar = false;
            try {
                String temp;
                bf2 = new BufferedReader(new FileReader("Pre-Ordenes.txt"));

                temp = "";
                String bfRead;

                while ((bfRead = bf2.readLine()) != null) {

                    temp = bfRead;
                    String lista = temp;
                    String[] lista1 = lista.split(";");
                    if (nombre.equals(obtenernombrepreorden())) {
                        enviar = true;
                    }
                }
                bf2.close();
            } catch (IOException e) {
                System.err.println("No se encontro el archivo" + e);
            }
            if (enviar == true) {
                int precio = Integer.parseInt(precio());
                int cantidadsoli = Integer.parseInt(obtenercantidad());
                int total = cantidadsoli * precio;
                ad.SendEmailOrder(obtenercorreo(), obtenernombrepreorden(), "Pelicula", obtenercantidad(), String.valueOf(total));
            }

        }

    }

    public String precio() {
      
        String precio = null;
        try {
            String temp;
            bf3 = new BufferedReader(new FileReader("Movies.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf3.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equals(obtenernombrepreorden())) {
                    precio = lista1[4];
                }
            }
            bf3.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        return precio;
    }

    public String obtenercorreo() {
        
        String can = null;
        try {
            String temp;
            bf4 = new BufferedReader(new FileReader("Pre-Ordenes.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf4.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equals(obtenerusuario())) {
                    can = lista1[4];
                }
            }
            bf4.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        return can;

    }

    public String obtenercantidad() {
       
        String can = null;
        try {
            String temp;
            bf5 = new BufferedReader(new FileReader("Pre-Ordenes.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf5.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[1].equals(obtenernombrepreorden())) {
                    can = lista1[3];
                }
            }
            bf5.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        return can;

    }

    public String obtenerusuario() {
       
        String can = null;
        try {
            String temp;
            bf6 = new BufferedReader(new FileReader("Pre-Ordenes.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf6.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[1].equals(obtenernombrepreorden())) {
                    can = lista1[0];
                }
            }
            bf6.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        return can;

    }

    public String obtenernombrepreorden() {
      
        String can = null;
        try {
            String temp;
            bf7 = new BufferedReader(new FileReader("Pre-Ordenes.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf7.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                can = lista1[1];
            }
            bf7.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        return can;
    }

    public void eliminMovie() {
        
        if (jDelete2.isSelectionEmpty()) {
            btnEliminar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Select!");
            btnEliminar.setEnabled(true);
        } else {

            Object preg = "Delete Movie?";
            Object unComponentePadre = null;
            Object unIcono = null;
            String nombre = jDelete2.getSelectedValue();
            int sele = JOptionPane.showOptionDialog((Component) unComponentePadre, preg, "Question", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, (Icon) unIcono, new Object[]{"Acept", "Cancel"}, // null para YES, NO y CANCEL
                    "opcion 1");
            int suma = sele + 1;

            if (sele == 1) {

            } else {
                try {
                    String temp;
                    try (BufferedReader bf = new BufferedReader(new FileReader("Movies.txt"))) {
                        String bfRead;
                        while ((bfRead = bf.readLine()) != null) {
                            temp = bfRead;
                            String lista = temp;
                            String[] lista1 = lista.split(";");
                            if (lista1[0].equals(nombre)) {

                                try {
                                    File archivo = new File("Movies.txt");
                                    FileWriter escribir = new FileWriter(archivo, true);
                                    String temp1;
                                    try (BufferedReader bf1 = new BufferedReader(new FileReader("Movies.txt"))) {

                                        String bf1Read;

                                        while ((bf1Read = bf1.readLine()) != null) {
                                            temp1 = bf1Read;

                                            if (temp1.equals(lista)) {
                                                BufferedWriter br = new BufferedWriter(new FileWriter("Movies.txt"));

                                                continue;
                                            }
                                            escribir.write(temp1 + "\r\n");
                                        }
                                        escribir.close();

                                    }
                                } catch (IOException e) {

                                }

                            }
                        }

                    }

                } catch (IOException e) {
                    System.err.println("No se encontro el archivo");
                }
                JOptionPane.showMessageDialog(null, "Movie deleted!");
                admin ad = new admin();
                ad.Cargarmodifica3();
            }

        }
    }
}
