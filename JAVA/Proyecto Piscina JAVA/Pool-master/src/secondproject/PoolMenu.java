/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondproject;

import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Luis Felipe
 */
public class PoolMenu extends javax.swing.JFrame {

    public static int nad;
    int ANCHO = 1000;

    /**
     * Creates new form PrincipalMenu
     */
    public PoolMenu() {
        initComponents();
        this.setResizable(false);
    }

    public void Spin() {
        SpinnerNumberModel Model = new SpinnerNumberModel(2, 2, 5, 1);
        JSpinner spinner1 = new JSpinner(Model);
        int option2 = JOptionPane.showOptionDialog(null, spinner1, "Cantidad de nadadores", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        if (option2 == JOptionPane.CANCEL_OPTION) {

        } else if (option2 == JOptionPane.OK_OPTION) {
            // user entered a number
            nad = (Integer) spinner1.getValue();
            Competencia cp = new Competencia();
            crono cr = new crono();
            cp.show();
            this.dispose();

            if (nad == 2) {
                nadadores phelps = new nadadores("Pelps", ANCHO - 100, cp.label[0]);
                nadadores Felipe = new nadadores("Felipe", ANCHO - 100, cp.label[1]);
                phelps.start();
                Felipe.start();
                cr.show();
                cr.empezar();
                cr.t.start();
            }
            if (nad == 3) {
                nadadores phelps = new nadadores("Pelps", ANCHO - 200, cp.label[0]);
                nadadores Felipe = new nadadores("Felipe", ANCHO - 200, cp.label[1]);
                nadadores ClaudiaPol = new nadadores("Pol", ANCHO - 200, cp.label[2]);
                phelps.start();
                Felipe.start();
                ClaudiaPol.start();
                 cr.show();
                cr.empezar();
                cr.t.start();
            }
            if (nad == 4) {
                nadadores phelps = new nadadores("Pelps", ANCHO - 200, cp.label[0]);
                nadadores Felipe = new nadadores("Felipe", ANCHO - 200, cp.label[1]);
                nadadores ClaudiaPol = new nadadores("Pol", ANCHO - 200, cp.label[2]);
                nadadores Neymar = new nadadores("Neymar", ANCHO - 200, cp.label[3]);
                phelps.start();
                Felipe.start();
                ClaudiaPol.start();
                Neymar.start();
                 cr.show();
                cr.empezar();
                cr.t.start();
            }
            if (nad == 5) {
                nadadores phelps = new nadadores("Pelps", ANCHO - 200, cp.label[0]);
                nadadores Felipe = new nadadores("Felipe", ANCHO - 200, cp.label[1]);
                nadadores ClaudiaPol = new nadadores("Pol", ANCHO - 200, cp.label[2]);
                nadadores Neymar = new nadadores("Neymar", ANCHO - 200, cp.label[3]);
                nadadores Dybala = new nadadores("Dybala", ANCHO - 200, cp.label[4]);
                phelps.start();
                Felipe.start();
                ClaudiaPol.start();
                Neymar.start();
                Dybala.start();
                 cr.show();
                cr.empezar();
                cr.t.start();
                
            }

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnJugar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu principal");
        setSize(new java.awt.Dimension(818, 410));

        btnJugar.setText("Jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        jButton2.setText("Estadisticas");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0004.gif"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jButton2))
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnJugar)
                    .addComponent(jButton2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        Spin();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnJugarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PoolMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PoolMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PoolMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PoolMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PoolMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
