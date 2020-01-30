/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import GUI.AgregarDiscMusic;
import GUI.AgregarMovie;
import GUI.BuyMovie;
import GUI.ChoosUsrPeli;
import GUI.Date_fin;
import GUI.Date_finMov;
import GUI.Date_ini;
import GUI.Date_iniMov;
import GUI.EliminDisc;
import GUI.EliminMovie;
import GUI.FinalOrderMovi;
import GUI.ListaCompras;
import GUI.MenuAdmin;
import GUI.MenuAdminMovie;
import javax.swing.JFrame;
import GUI.RegistrarUsuario;
import GUI.MenuAdminMusic;
import GUI.MenuCompraDisco;
import GUI.MenuUsrCompra;
import GUI.ModifMovie;
import GUI.ModificarDisco;
import GUI.OrderFinal;
import GUI.VerDiscos;
import GUI.VerPeliculas;
import GUI.Reports;
import GUI.Select_user;
import GUI.pre_Order;
/**
 *
 * @author Luis Felipe
 */
public class Instancias extends JFrame{
    
    
     public void registro() {
        RegistrarUsuario re = new RegistrarUsuario(this, true);
        re.pack();
        re.setVisible(true);

    }
        public void MenuAdm() {
        MenuAdmin menuAd = new MenuAdmin(this, true);
        menuAd.pack();
        menuAd.setVisible(true);
    }
         public void CatalogoMusic() {
        MenuAdminMusic menAdMu = new MenuAdminMusic(this, true);
        menAdMu.pack();
        menAdMu.setVisible(true);
    }
          public void modifyDisc() {
        ModificarDisco disco = new ModificarDisco(this, true);
        disco.pack();
        disco.setVisible(true);

    }
              public void eliminarDiscMusic() {
        EliminDisc disco = new EliminDisc(this, true);
        disco.pack();
        disco.setVisible(true);
    }
                public void verInfoDisc() {
        VerDiscos leer = new VerDiscos(this, true);
        leer.pack();
        leer.setVisible(true);
    }
                  public void AddDisc() {
        AgregarDiscMusic add = new AgregarDiscMusic(this, true);
        add.pack();
        add.setVisible(true);
    }
                     public void BuyMusic() {
        MenuCompraDisco add = new MenuCompraDisco(this, true);
        add.pack();
        add.setVisible(true);
    }
                       public void BuyMovie() {
        BuyMovie add = new BuyMovie(this, true);
        add.pack();
        add.setVisible(true);
    }
                      public void MenuUsr() {
        MenuUsrCompra add = new MenuUsrCompra(this, true);
        add.pack();
        add.setVisible(true);
    }
                       public void OrderFInal() {
        OrderFinal add = new OrderFinal(this, true);
        add.pack();
        add.setVisible(true);
    }
                   public void ModifMovie() {
        ModifMovie add = new ModifMovie(this, true);
        add.pack();
        add.setVisible(true);
    }
               public void CatMovie() {
        MenuAdminMovie add = new MenuAdminMovie(this, true);
        add.pack();
        add.setVisible(true);
    }    
                 public void AddMovie() {
        AgregarMovie add = new AgregarMovie(this, true);
        add.pack();
        add.setVisible(true);
    }    
           public void ReadMovie() {
        VerPeliculas add = new VerPeliculas(this, true);
        add.pack();
        add.setVisible(true);
    }    
            public void deleteMovie() {
        EliminMovie add = new EliminMovie(this, true);
        add.pack();
        add.setVisible(true);
    }    
  public void FinalMovie() {
       FinalOrderMovi fom = new FinalOrderMovi(this, true);
       fom.pack();
        fom.setVisible(true);
    }    
   public void Reports() {
       Reports fom = new Reports(this, true);
       fom.pack();
        fom.setVisible(true);
    } 
  public void SeleCtUser() {
       Select_user fom = new Select_user(this, true);
       fom.pack();
        fom.setVisible(true);
    }    
  public void fechaini() {
        Date_ini ini = new Date_ini(this, true);
        ini.pack();
        ini.setVisible(true);
    }
  public void fechafin() {
        Date_fin ini = new Date_fin(this, true);
        ini.pack();
        ini.setVisible(true);
    }
   public void chooseUsrPeli() {

        ChoosUsrPeli ele = new ChoosUsrPeli(this, true);
        ele.pack();
        ele.setVisible(true);

    }
   public void DateFechIn() {

        Date_iniMov ele = new Date_iniMov(this, true);
        ele.pack();
        ele.setVisible(true);

    }
   public void DateFechaFin() {

        Date_finMov ele = new Date_finMov(this, true);
        ele.pack();
        ele.setVisible(true);

    }
   public void List() {
        ListaCompras re = new ListaCompras(this, true);
        re.pack();
        re.setVisible(true);

    }
    public void PreOrder() {
        pre_Order re = new pre_Order(this, true);
        re.pack();
        re.setVisible(true);

    }
}