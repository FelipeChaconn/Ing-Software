/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;
import Archivos.ArchivoDiscos;
import static Archivos.ArchivoUsuario.password;
import static Archivos.ArchivoUsuario.user;
import Archivos.Login;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import GUI.Administrador;
import static GUI.EliminMovie.jDelete2;
import static GUI.EliminDisc.JDelete;
import static GUI.Administrador.txtUsuario;
import static GUI.Administrador.txtPassAdmin;
import static GUI.ModificarDisco.jList;
import static GUI.ModificarDisco.txtAuthor;
import static GUI.ModificarDisco.txtQuantity;
import static GUI.ModificarDisco.jCategory;
import static GUI.ModificarDisco.jSongs;
import static GUI.ModificarDisco.txtName;
import static GUI.ModificarDisco.txtPrice;
import static GUI.ModifMovie.listaModiMo;
import static GUI.ModifMovie.txtAuthorMov;
import static GUI.ModifMovie.txtQuantiMov;
import static GUI.ModifMovie.jCat;
import static GUI.ModifMovie.Name;
import static GUI.ModifMovie.txPriceM;
import static GUI.ModificarDisco.txtPrice;
import static GUI.ListaCompras.listadiscos;
import static GUI.ListaCompras.listapeliculas;
import static GUI.pre_Order.jtablepreorden;
import GUI.MenuAdmin;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import static GUI.AgregarMovie.jCatAdd;
import static GUI.AgregarMovie.NameAdd;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Luis Felipe
 */
public class admin extends JFrame{
     public static DefaultListModel modelo;

    public String[] read() {
        //this method will get the information from the class Login
        Login lo = new Login();
        lo.crearlogin();
        String info = lo.obtener();

        String[] posi = info.split(",");

        return posi;
    }

    public void log() {
    //this method will verify if the customer introduced the password and the user name correctly
        String[] info = read();
        String usu = info[0];
        String contra = info[1];
        String u = txtUsuario.getText();
        String c = txtPassAdmin.getText();
        if (u.equals(usu) & c.equals(contra)) {
            JOptionPane.showMessageDialog(null, "Welcome!");
             MenuAdmin catalogos = new MenuAdmin(this, true);
            catalogos.pack();
            catalogos.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Password or Username incorrect!");
            txtUsuario.setText("");
            txtPassAdmin.setText("");
            new Administrador(this, true).setVisible(true);
        }

    }
    public void Cargar() {
        //this method will charge the name of the songs to the jlist
        modelo = new DefaultListModel();
        modelo.clear();
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
                modelo.addElement(lista1[0]);

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
              jList.setModel(modelo);

    }
    public void cargaTodosDatos() {
        //this method will get the information to modify the cds
        String nombre = jList.getSelectedValue();
        boolean esta = false;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Discos.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf2.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equals(nombre)) {
                    txtName.setText(lista1[0]);
                    txtAuthor.setText(lista1[1]);
                    jCategory.setSelectedItem(lista1[2]);
                    jSongs.setSelectedItem(lista1[3]);
                    txtPrice.setText(lista1[4]);
                    txtQuantity.setText(lista1[5]);

                } else {
                    esta = true;
                }

            }

            bf2.close();
            if (esta == false) {
                JOptionPane.showMessageDialog(null, "No esta en el Registro o Seleccione un Nombre!");
            }

        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
    }

    public void SendEmailOrder(String correo,String disco,String tipodisco,String cantidad, String total) {
        //this method will sends emails in different classes that they need it
        String to = correo;
        String subject = "Arrive your product";
        try {

            Properties props = new Properties();

            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "luis.felipe16981460@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText("Name: "+disco+ " Type: "+ tipodisco + " Quantity : "+ cantidad+ " Total: "+ total);

            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);

            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(user));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mensaje.setSubject(subject);
            mensaje.setContent(m);

            Transport t = session.getTransport("smtp");
            t.connect(user, password);
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            JOptionPane.showMessageDialog(null, "You have a notification in your email!");
        } catch (MessagingException e) {
            System.out.println(e);
        }

    }
    public void CargarDatosEliminar() {
      
        modelo = new DefaultListModel();
        modelo.clear();
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
                modelo.addElement(lista1[0]);

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        JDelete.setModel(modelo);

    }
      public void CargaModifDatos() {
       
        String nombre = listaModiMo.getSelectedValue();
        boolean esta = false;
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Movies.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf2.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equals(nombre)) {
                    jCat.setSelectedItem(lista1[2]);
                    Name.setSelectedItem(lista1[0]);
                    txtAuthorMov.setText(lista1[1]);
                    txPriceM.setText(lista1[3]);
                    txtQuantiMov.setText(lista1[4]);

                } else {
                    esta = true;
                }

            }

            bf2.close();
            if (esta == false) {
                JOptionPane.showMessageDialog(null, "Select name!");
            }

        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

    }

    public void CargaModifDatosg() {
       
        modelo = new DefaultListModel();
        modelo.clear();
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
                modelo.addElement(lista1[0]);

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        listaModiMo.setModel(modelo);

    }
      public void CatMovieChos() {
        

        if (jCatAdd.getSelectedItem().equals("Science Fiction")) {
            NameAdd.addItem("Fast and Furious");
            NameAdd.setSelectedItem("Fast and Furious");
        }
        if (jCatAdd.getSelectedItem().equals("Cartoon")) {
            NameAdd.addItem("Cars");
            NameAdd.setSelectedItem("Cars");
        }
        if (jCatAdd.getSelectedItem().equals("Drama")) {
            NameAdd.addItem("Transporter");
            NameAdd.setSelectedItem("Transporter");
        }
      
        jCatAdd.setEnabled(false);
    }
        public void Cargarmodifica3() {
       
        modelo = new DefaultListModel();
        modelo.clear();
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
                modelo.addElement(lista1[0]);

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        jDelete2.setModel(modelo);

    }
         public void listacomprasdisco() {
        //this method will the cds that have been bought.
        int lNumeroLineas = 0;
        try {
            FileReader fr = new FileReader("ComprasDiscos.txt");
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
        ArrayList<String> cedula = new <String>ArrayList();
        ArrayList<String> email = new <String>ArrayList();
        ArrayList<String> disco = new <String>ArrayList();
        ArrayList<String> cantidad = new <String>ArrayList();

        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("ComprasDiscos.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");

                disco.add(lista1[0]);
                nombres.add(lista1[1]);
                cedula.add(lista1[2]);
                email.add(lista1[3]);
                cantidad.add(lista1[4]);

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        for (int i = 0; i < nombres.size(); i++) {
            listadiscos.setValueAt(nombres.get(i), i, 0);
            listadiscos.setValueAt(cedula.get(i), i, 1);
            listadiscos.setValueAt(email.get(i), i, 2);
            listadiscos.setValueAt(disco.get(i), i, 3);
            listadiscos.setValueAt(cantidad.get(i), i, 4);
            if (lNumeroLineas >= listadiscos.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) listadiscos.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }

        }
        if (listadiscos.getRowCount() > lNumeroLineas) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) listadiscos.getModel();
                listadiscos.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

    }
           public void listacompraspeli() {
        //this method will get the information of the movies that have been bought
        int lNumeroLineas = 0;
        try {
            FileReader fr = new FileReader("ComprasPeliculas.txt");
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
        ArrayList<String> cedula = new <String>ArrayList();
        ArrayList<String> email = new <String>ArrayList();
        ArrayList<String> disco = new <String>ArrayList();
        ArrayList<String> cantidad = new <String>ArrayList();

        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("ComprasPeliculas.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");

                disco.add(lista1[0]);
                nombres.add(lista1[1]);
                cedula.add(lista1[2]);
                email.add(lista1[3]);
                cantidad.add(lista1[4]);

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        for (int i = 0; i < nombres.size(); i++) {
            listapeliculas.setValueAt(nombres.get(i), i, 0);
            listapeliculas.setValueAt(cedula.get(i), i, 1);
            listapeliculas.setValueAt(email.get(i), i, 2);
            listapeliculas.setValueAt(disco.get(i), i, 3);
            listapeliculas.setValueAt(cantidad.get(i), i, 4);
            if (lNumeroLineas >= listapeliculas.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) listapeliculas.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }

        }
        if (listapeliculas.getRowCount() > lNumeroLineas) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) listapeliculas.getModel();
                listapeliculas.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

    }
             public void listapreordenes() {
       //this method will get the information of the pre-orders that have been bought 
        int lNumeroLineas = 0;
        try {
            FileReader fr = new FileReader("Pre-Ordenes.txt");
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
        ArrayList<String> disco = new <String>ArrayList();
        ArrayList<String> cantidad = new <String>ArrayList();

        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Pre-Ordenes.txt"));
            int contador = 0;

            temp = "";
            String bfRead;

            while ((bfRead = bf2.readLine()) != null) {
                contador++;
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");

                disco.add(lista1[1]);
                nombres.add(lista1[0]);
                cantidad.add(lista1[3]);

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        for (int i = 0; i < nombres.size(); i++) {
            jtablepreorden.setValueAt(nombres.get(i), i, 0);
            jtablepreorden.setValueAt(disco.get(i), i, 1);
            jtablepreorden.setValueAt(cantidad.get(i), i, 2);
            if (lNumeroLineas >= jtablepreorden.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) jtablepreorden.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }

        }
        if (jtablepreorden.getRowCount() > lNumeroLineas) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) jtablepreorden.getModel();
                jtablepreorden.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

             }
}
