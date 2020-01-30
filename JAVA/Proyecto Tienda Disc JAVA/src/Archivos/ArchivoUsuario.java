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
import Herencias.RegistroUsuario;
import static GUI.MenuCompraDisco.jlistComp;
import static GUI.BuyMovie.jListMov;
import static GUI.RegistrarUsuario.txtIdRegister;
import static GUI.RegistrarUsuario.passRegister;
import static GUI.RegistrarUsuario.txtEmailRegister;
import static GUI.RegistrarUsuario.txtNameUser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.swing.JOptionPane;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class ArchivoUsuario {

    public static String user = "luis.felipe16981460@gmail.com";
    public static String password = "Arcoirislf1998";

    public static String to = "";
    public static String subject = "Registro Aplicacion Tienda";

    public void crearlogin() {
        
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("Usuarios.txt", true));
            bw.close();
        } catch (IOException ex) {
            System.out.println("No se Encontro el archivo" + ex);
        }

    }

    public String obtener() {
     
        String lista = null;
        try {
            String temp;

            BufferedReader bf = new BufferedReader(new FileReader("Usuarios.txt"));

            temp = "";
            String bfRead = bf.readLine();
            while ((bfRead = bf.readLine()) != null) {
                temp = bfRead;
                lista = temp;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se encontro el archivo" + e);
        }

        return lista;
    }

    public static boolean revisaruser() {
      
        String nom = txtNameUser.getText();
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
                if (lista1[0].equalsIgnoreCase(nom)) {
                    repite = true;
                }

            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return repite;
    }

    public static void enviarcorreo() {
     
        to = txtEmailRegister.getText();

        try {

            Properties props = new Properties();

            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "luis.felipe16981460@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText("Ready, Sr. " + txtNameUser.getText()+"you can use the app");

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
            JOptionPane.showMessageDialog(null, "Finish!");
            txtNameUser.setText("");
            txtIdRegister.setText("");
            passRegister.setText("");
            txtEmailRegister.setText("");
        } catch (MessagingException e) {
            System.out.println(e);
        }

    }

    public void SendCorreo(String email) {
    
        to = email;
        String subject = "Your purchase are complete!";

        try {

            Properties props = new Properties();

            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "luis.felipe16981460@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText("Your purchase are : " + jlistComp.getSelectedValue());

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
            JOptionPane.showMessageDialog(null, "Your purchase are complete!");

        } catch (MessagingException e) {
            System.out.println(e);
        }

    }

    public void SendCorreoMovie(String email) {
       
        to = email;
        String subject = "Your purchase are complete!";
        try {

            Properties props = new Properties();

            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "luis.felipe16981460@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText("Your purchase are : " + jListMov.getSelectedValue());

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
            JOptionPane.showMessageDialog(null, "Your purchase are  complete!");

        } catch (MessagingException e) {
            System.out.println(e);
        }

    }

    public void AgregarUsuario() {
        
        if (revisaruser() == true) {
            JOptionPane.showMessageDialog(null, "Try again,this user exists!");
        } else {
            try {
                String nombre = txtNameUser.getText();
                String cedula = txtIdRegister.getText();
                String contra = passRegister.getText();
                String correo = txtEmailRegister.getText();
                boolean continuar = false;
                RegistroUsuario register = new RegistroUsuario(nombre, cedula, contra, correo);
                if (txtNameUser.getText().equals("") || txtIdRegister.getText().equals("") || passRegister.getText().equals("") || txtEmailRegister.getText().equals("")) {
                    continuar = true;
                    JOptionPane.showMessageDialog(null, "Fill all inputs!");
                }
                if (continuar == false) {
                    try {
                        BufferedWriter bw;

                        bw = new BufferedWriter(new FileWriter("Usuarios.txt", true));
                        bw.write(register.register() + "\n");

                        bw.close();
                    } catch (IOException ex) {

                    }

                    enviarcorreo();

                }
            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Fill all inputs!");
            }
        }
    }

}

