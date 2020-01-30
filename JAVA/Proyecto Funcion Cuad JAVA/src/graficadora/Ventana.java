/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graficadora;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import graficadora.Graficadora;
import mateproyect.QuadraticaView;
/**
 *
 * @author jorge
 */
public class Ventana extends JFrame implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
          double aa = QuadraticaView.a;
        double bb = QuadraticaView.b;
        double cc = QuadraticaView.c;
       QuadraticaView.plano.paintSQRFunc(QuadraticaView.plano.getGraphics(),aa,bb,cc,-200,200);
    }

}