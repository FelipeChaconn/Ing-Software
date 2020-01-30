/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondproject;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.T;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Felipe
 */
public class nadadores extends Thread {

    crono cr = new crono();
    int n;
    int i = 0;
    private static final AtomicInteger conta = new AtomicInteger();

    // Posición del frame actual
    // Posición anterior de x
    // Variables de Clase
    static int terminan = 0; // Cuántos han terminado la carrera
    String nombre;
    int limite;
    JLabel label;

    public nadadores(String nombre, int limite, JLabel label) {
        this.nombre = nombre;
        this.limite = limite;
        this.label = label;
    }

    @Override
    public void run() {

        Random random = new Random();
        int number;
        for (n = 0; n < limite; n++) {
            number = 0 + random.nextInt(50);

            try {
                System.out.println(nombre + "Avanza");
                label.setLocation(n, 0);
                Thread.sleep(number);

            } catch (InterruptedException ex) {
                Logger.getLogger(nadadores.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
   
        Resultados rd = new Resultados();
        PoolMenu pm = new PoolMenu();

        while (i <= pm.nad) {

            rd.nombres[conta.get()] = nombre;

            if (pm.nad == 2) {
                rd.First.setText(rd.nombres[0]);
                rd.Second.setText(rd.nombres[1]);
                rd.third.setText("No participo");
               
                
            } else if (pm.nad == 3) {
                rd.First.setText(rd.nombres[2]);
                rd.Second.setText(rd.nombres[1]);
                rd.third.setText(rd.nombres[0]);
            } else if (pm.nad == 4) {
                rd.First.setText(rd.nombres[0]);
                rd.Second.setText(rd.nombres[1]);
                rd.third.setText(rd.nombres[2]);
            } else {
                rd.First.setText(rd.nombres[4]);
                rd.Second.setText(rd.nombres[3]);
                rd.third.setText(rd.nombres[2]);
            }
            // rd.posiciones.add(i + nombre);
//                System.out.println(nombres[conta]);
            i++;
        }

        yield();

//         conta++; 
        conta.getAndIncrement();
        System.out.println(rd.nombres.length);
        for (int i = 0; i < rd.nombres.length; i++) {
            System.out.println(rd.nombres[i]);
        }
          
        rd.show();
//         cr.t.stop();
      
    }

}
