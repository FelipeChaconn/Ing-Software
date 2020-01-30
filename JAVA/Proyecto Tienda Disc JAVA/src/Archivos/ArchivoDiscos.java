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
import Herencias.DiscC;
import static GUI.AgregarDiscMusic.txtNameDisc;
import static GUI.AgregarDiscMusic.txtQuantityDisc;
import static GUI.AgregarDiscMusic.jComboBoxCat;
import static GUI.AgregarDiscMusic.jComboBoxSon;
import static GUI.AgregarDiscMusic.txtAuthorDisc;
import static GUI.AgregarDiscMusic.txtPriceDisc;
import static GUI.EliminDisc.JDelete;
import static GUI.VerDiscos.JtableDisc;
import static GUI.ModificarDisco.jList;
import static GUI.ModificarDisco.txtAuthor;
import static GUI.ModificarDisco.txtQuantity;
import static GUI.ModificarDisco.jCategory;
import static GUI.ModificarDisco.jSongs;
import static GUI.ModificarDisco.txtName;
import static GUI.ModificarDisco.txtPrice;
import Procedimientos.admin;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Felipe
 */
public class ArchivoDiscos {

    admin ad = new admin();
    BufferedReader bf2;
    BufferedReader bf3;
    BufferedReader bf4;
    BufferedReader bf5;
    BufferedReader bf6;
    BufferedReader bf7;

    public static boolean revisarcat() {
      
        String cate = jComboBoxCat.getSelectedItem().toString();
        boolean repite = false;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Discos.txt"));

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

public void AddDisc() {
       
        if (revisarcat() == true) {
            JOptionPane.showMessageDialog(null, "Error Category!");
        } else {
            try {
                String nombre = txtNameDisc.getText();
                String autor = txtAuthorDisc.getText();
                String categoria = jComboBoxCat.getSelectedItem().toString();
                String precio = txtPriceDisc.getText();
                String lista = jComboBoxSon.getSelectedItem().toString();
                String cantidad = txtQuantityDisc.getText();
                int precio2 = Integer.parseInt(precio);
                int cantidad2 = Integer.parseInt(cantidad);
                boolean continuar = false;
                DiscC disco = new DiscC(nombre, autor, categoria, lista, precio2, cantidad2);

                if (txtNameDisc.getText().equals("") || txtAuthorDisc.getText().equals("") || precio.equals("")) {
                    continuar = true;
                    JOptionPane.showMessageDialog(null, "Fill all inputs");
                }

                if (continuar == false) {
                    try {
                        BufferedWriter bw;

                        bw = new BufferedWriter(new FileWriter("Discos.txt", true));
                        bw.write(disco.devolver() + "\n");

                        bw.close();
                    } catch (IOException ex) {

                    }
                    JOptionPane.showMessageDialog(null, "Now you are registred!");
                }
            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Fill all inputs!");
            }
        }

    }
    public void leerdisco() {
       
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

        ArrayList<String> nombres = new <String>ArrayList();
        ArrayList<String> autor = new <String>ArrayList();
        ArrayList<String> categoria = new <String>ArrayList();
        ArrayList<String> lista2 = new <String>ArrayList();
        ArrayList<String> precio = new <String>ArrayList();
        ArrayList<String> condicion = new <String>ArrayList();
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

                nombres.add(lista1[0]);
                autor.add(lista1[1]);
                categoria.add(lista1[2]);
                lista2.add(lista1[3]);
                precio.add(lista1[4]);
                condicion.add(lista1[5]);
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        for (int i = 0; i < nombres.size(); i++) {
            JtableDisc.setValueAt(nombres.get(i), i, 0);
            JtableDisc.setValueAt(autor.get(i), i, 1);
            JtableDisc.setValueAt(categoria.get(i), i, 2);
            JtableDisc.setValueAt(lista2.get(i), i, 3);
            JtableDisc.setValueAt(precio.get(i), i, 4);
            JtableDisc.setValueAt(condicion.get(i), i, 5);
            if (lNumeroLineas >= JtableDisc.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) JtableDisc.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }

        }
        if (JtableDisc.getRowCount() > lNumeroLineas) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) JtableDisc.getModel();
                JtableDisc.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }

    public void modificar() {
       
        try {
            String temp;
            BufferedReader bf = new BufferedReader(new FileReader("Discos.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (jList.getSelectedValue().equals(lista1[0])) {
                    try {
                        String temp2;
                        boolean imp = false;
                        try (BufferedReader bf2 = new BufferedReader(new FileReader("Discos.txt"))) {
                            String bfRead2;

                            try {
                                lista1[0] = txtName.getText();
                                lista1[1] = txtAuthor.getText();
                                lista1[2] = jCategory.getSelectedItem().toString();
                                lista1[3] = jSongs.getSelectedItem().toString();
                                lista1[4] = txtPrice.getText();
                                lista1[5] = txtQuantity.getText();
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
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
        JOptionPane.showMessageDialog(null, "Disco Modificado!");

        String cantidadisco = "0";
        boolean existe = false;
        String nombre = null;

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
                if (lista1[0].equals(obtenernombrepreorden())) {
                    cantidadisco = lista1[5];
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
                int contador = 0;

                temp = "";
                String bfRead;

                while ((bfRead = bf2.readLine()) != null) {
                    contador++;
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
                ad.SendEmailOrder(obtenercorreo(), obtenernombrepreorden(), "Disco", obtenercantidad(), String.valueOf(total));
            }

        }
    }

    public String precio() {
        String precio = null;
        try {
            String temp;
            bf3 = new BufferedReader(new FileReader("Discos.txt"));
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

  public void EliminarDisc() {
    
        if (JDelete.isSelectionEmpty()) {
            JDelete.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Select Element!");
            JDelete.setEnabled(true);
        } else {
            Object preg = "Do you want to delete this disc?";
            Object unComponentePadre = null;
            Object unIcono = null;
            String nombre = JDelete.getSelectedValue();
            int sele = JOptionPane.showOptionDialog((Component) unComponentePadre, preg, "Question", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, (Icon) unIcono, new Object[]{"Acept", "Cancel"}, // null para YES, NO y CANCEL
                    "opcion 1");
            int suma = sele + 1;

            if (sele == 1) {

            } else {
                try {
                    String temp;
                    try (BufferedReader bf = new BufferedReader(new FileReader("Discos.txt"))) {
                        String bfRead;
                        while ((bfRead = bf.readLine()) != null) {
                            temp = bfRead;
                            String lista = temp;
                            String[] lista1 = lista.split(";");
                            if (lista1[0].equals(nombre)) {

                                try {
                                    File archivo = new File("Discos.txt");
                                    FileWriter escribir = new FileWriter(archivo, true);
                                    String temp1;
                                    try (BufferedReader bf1 = new BufferedReader(new FileReader("Discos.txt"))) {

                                        String bf1Read;

                                        while ((bf1Read = bf1.readLine()) != null) {
                                            temp1 = bf1Read;

                                            if (temp1.equals(lista)) {
                                                BufferedWriter br = new BufferedWriter(new FileWriter("Discos.txt"));

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
                JOptionPane.showMessageDialog(null, "Disc Delete!");
                admin ad = new admin();
                ad.CargarDatosEliminar();
            }

        }
    }

}
