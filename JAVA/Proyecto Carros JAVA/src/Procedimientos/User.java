/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import Procedimientos.Conection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static GUI.Login.txtUser;
import static GUI.Login.txtPass;
import GUI.AdminMenu;
import java.sql.ResultSet;

/**
 *
 * @author Luis Felipe
 */
public class User extends JFrame {

    Conection conn = new Conection();
    String u = txtUser.getText();
    String c = txtPass.getText();
    Instancias insta = new Instancias();

    public void log() {
        this.conn.ConnectionBD();
        if (conn != null) {
            ResultSet n = conn.datosAdmin();
            try {
                while (n.next()) {
                    if (u.equals(n.getString(2))) {
                        if (c.equals(n.getString(6))) {
                            ResultSet rd = conn.AdminOrUser();
                            try {
                               if(rd.next()) {
                                    insta.MenuAd();
                                    break;
                                }else{
                                   System.out.println("user");
                               }
                                  
                               
                            } catch (Exception e) {
                            }

                        } else {

                        }

                    } else {

                    }

                }
            } catch (Exception e) {
            }

        }
    }

}
