/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import GUI.AdminMenu;
import javax.swing.JFrame;

/**
 *
 * @author Luis Felipe
 */
public class  Instancias extends  JFrame{
    
    
   public void MenuAd(){
    AdminMenu main_m = new AdminMenu(this, true);
            main_m.pack();
            main_m.setVisible(true);
   
   
   }
    
}
