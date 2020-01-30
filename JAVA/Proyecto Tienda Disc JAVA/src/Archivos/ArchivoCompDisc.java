/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import static Archivos.ArchivoUsuario.enviarcorreo;
import static GUI.MenuCompraDisco.jlistComp;
import static GUI.OrderFinal.quantiDisc;
import static GUI.Usuario.txtUsr;
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
import javax.swing.JOptionPane;
/**
 *
 * @author Luis Felipe
 */
public class ArchivoCompDisc {
    ArchivoUsuario user = new ArchivoUsuario();
    Instancias insta = new Instancias();
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate ahora = LocalDate.now();
    
    
    public void Anadircompra() {
   
        String nomuser = usuario;
        String contra = pssUsr.getText();
        String cedula = null;
        String email = null;
        String cantidad = quantiDisc.getText();
        String nombredisco = jlistComp.getSelectedValue();
        boolean existe = false;
        boolean repite = false;
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
                    if (lista1[0].equalsIgnoreCase(nomuser) & lista1[2].equals("Disco")) {
                        existe = true;
                    }

                }
                bf2.close();
            } catch (IOException e) {
                System.err.println("No se encontro el archivo" + e);
            }
            if (existe) {
                eliminarpreorden();
            } else {
            }

            try {
                try {
                    BufferedWriter bw;

                    bw = new BufferedWriter(new FileWriter("ComprasDiscos.txt", true));
                    bw.write(nombredisco + ";" + nomuser + ";" + cedula + ";" + email + ";" + cantidad + ";" + fmt.format(ahora) + "\n");

                    bw.close();
                } catch (IOException ex) {

                }

                user.SendCorreo(email);
                restarcantidad();
                
            } catch (java.lang.NumberFormatException e) {

            }

        }
    }

    public static String canti;

    public static String cantidadisco() {
        //this method will let you know the quantity of a disc
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
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return canti;
    }

    public static void restarcantidad() {
        //this method will get few discs
        String can = quantiDisc.getText();
        String can2 = cantidadisco();
        int cantidadtotal = Integer.parseInt(can2) - Integer.parseInt(can);
        try {
            String temp;
            BufferedReader bf = new BufferedReader(new FileReader("Discos.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (jlistComp.getSelectedValue().equals(lista1[0])) {
                    try {
                        String temp2;
                        boolean imp = false;
                        try (BufferedReader bf2 = new BufferedReader(new FileReader("Discos.txt"))) {
                            String bfRead2;
                            lista1[0] = lista1[0];
                            lista1[1] = lista1[1];
                            lista1[2] = lista1[2];
                            lista1[3] = lista1[3];
                            lista1[4] = lista1[4];
                            lista1[5] = String.valueOf(cantidadtotal);

                            File archivo = new File("Discos.txt");
                            String inf_nueva = null;
                            try {
                                inf_nueva = lista1[0] + ";" + lista1[1] + ";" + lista1[2] + ";" + lista1[3] + ";" + lista1[4] + ";" + lista1[5];
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                            FileWriter escribir = new FileWriter(archivo, true);

                            try {

                                try (BufferedReader bf1 = new BufferedReader(new FileReader("Discos.txt"))) {

                                    String bf1Read;

                                    while ((bf1Read = bf1.readLine()) != null) {
                                        temp2 = bf1Read;

                                        if (temp2.equals(lista)) {
                                            BufferedWriter br = new BufferedWriter(new FileWriter("Discos.txt"));

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

    public static void eliminarpreorden() {
        //this method will delete a pre-order when you buy a disc already writen on the file pre-ordenes.txt
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
}
