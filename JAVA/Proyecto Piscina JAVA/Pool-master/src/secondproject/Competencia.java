/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondproject;

/**
 *
 * @author Luis Felipe
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Luis Felipe
 */
public class Competencia extends javax.swing.JFrame {

    String[] nombres = {"Phelps", "Felipe", "Pol", "Neymar", "Dybala"};
    int ANCHO = 400;
    public static JPanel[] paneles;
    public static JLabel[] label;

    public Competencia() {
        PoolMenu pm = new PoolMenu();
        setLayout(new GridLayout(0, 1));
        paneles = new JPanel[pm.nad];
        label = new JLabel[pm.nad];


        for (int n = 0; n < pm.nad; n++) {
            paneles[n] = new JPanel();
            add(paneles[n]);
            label[n] = new JLabel(nombres[n]);
            label[n].setIcon(new ImageIcon(getClass().getResource("/images/swimmer.gif")));

            paneles[n].add(label[n]);

            //  labels.setIcon(new ImageIcon(getClass().getResource("/images/meta.jpg")));
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width / 2, height / 2);
//        try {
//            int i = 0;
////            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Luis Felipe\\Documents\\NetBeansProjects\\SecondProject\\src\\images\\pool.jpg")))));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        pack();
         
      setSize(width/2, height/2);	
        setVisible(true);
        setLocationRelativeTo(null);

        setSize(1400, 600);

    }

}
