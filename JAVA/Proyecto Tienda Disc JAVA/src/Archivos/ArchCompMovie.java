/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

/**
 *
 * @author Luis Felipe
 */

import static GUI.BuyMovie.jListMov;
import static GUI.FinalOrderMovi.quantiDisc;
import static GUI.Usuario.pssUsr;
import Procedimientos.Instancias;
import static Procedimientos.UsrCompDisco.usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Kevin
 */
public class ArchCompMovie {

    Instancias insta = new Instancias();
    ArchivoUsuario user = new ArchivoUsuario();
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate ahora = LocalDate.now();

    public void Anadircompra() {
       
        String nomuser = usuario;
        String contra = pssUsr.getText();
        String cedula = null;
        String email = null;
        String cantidad = quantiDisc.getText();
        String nombredisco = jListMov.getSelectedValue();
        boolean repite = false;
        boolean existe = false;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Usuarios.txt"));

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {

                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equals(nomuser) & lista1[2].equals(contra)) {
                    cedula = lista1[1];
                    email = lista1[3];
                    repite = true;
                }

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        if (repite == true) {
            try {
                String temp;
                BufferedReader bf2 = new BufferedReader(new FileReader("Pre-Ordenes.txt"));

                temp = "";
                String bfRead;

                while ((bfRead = bf2.readLine()) != null) {

                    temp = bfRead;
                    String lista = temp;
                    String[] lista1 = lista.split(";");
                    if (lista1[0].equalsIgnoreCase(nomuser) & lista1[2].equals("Pelicula")) {
                        existe = true;
                    }

                }
                bf2.close();
            } catch (IOException e) {
                System.err.println("No se encontro el archivo" + e);
            }
            if (existe) {
                eliminarpreorden();
            } 
            try {
                try {
                    BufferedWriter bw;

                    bw = new BufferedWriter(new FileWriter("ComprasPeliculas.txt", true));
                    bw.write(nombredisco + ";" + nomuser + ";" + cedula + ";" + email + ";" + cantidad + ";" + fmt.format(ahora) + "\n");

                    bw.close();
                } catch (IOException ex) {

                }

                user.SendCorreoMovie(email);
                restarcantidad();

            } catch (java.lang.NumberFormatException e) {

            }

        }
    }

    public static void eliminarpreorden() {
       
        try {
            String temp;
            try (BufferedReader bf = new BufferedReader(new FileReader("Pre-Ordenes.txt"))) {
                String bfRead;
                while ((bfRead = bf.readLine()) != null) {
                    temp = bfRead;
                    String lista = temp;
                    String[] lista1 = lista.split(";");
                    if (lista1[0].equals(usuario)) {

                        try {
                            File archivo = new File("Pre-Ordenes.txt");
                            FileWriter escribir = new FileWriter(archivo, true);
                            String temp1;
                            try (BufferedReader bf1 = new BufferedReader(new FileReader("Pre-Ordenes.txt"))) {

                                String bf1Read;

                                while ((bf1Read = bf1.readLine()) != null) {
                                    temp1 = bf1Read;

                                    if (temp1.equals(lista)) {
                                        BufferedWriter br = new BufferedWriter(new FileWriter("Pre-Ordenes.txt"));

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

    }
    public static String cantipeli;

    public static String cantidadisco() {
        
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
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantipeli;
    }

    public static void restarcantidad() {
   
        String can = quantiDisc.getText();
        String can2 = cantidadisco();
        int cantidadtotal = Integer.parseInt(can2) - Integer.parseInt(can);
        try {
            String temp;
            BufferedReader bf = new BufferedReader(new FileReader("Movies.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (jListMov.getSelectedValue().equals(lista1[0])) {
                    try {
                        String temp2;
                        boolean imp = false;
                        try (BufferedReader bf2 = new BufferedReader(new FileReader("Movies.txt"))) {
                            String bfRead2;
                            lista1[0] = lista1[0];
                            lista1[1] = lista1[1];
                            lista1[2] = lista1[2];
                            lista1[3] = lista1[3];
                            lista1[4] = String.valueOf(cantidadtotal);

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

    }
}
