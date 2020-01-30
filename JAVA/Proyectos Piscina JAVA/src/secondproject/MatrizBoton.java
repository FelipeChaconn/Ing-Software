/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondproject;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MatrizBoton extends JFrame implements ActionListener {

    public static int contGana;
    public static int contPierde;

    public MatrizBoton() {

        JToolBar barraHerramientas = new JToolBar();
        JLabel lblFilas = new JLabel();
        JLabel lblColumnas = new JLabel();
        txtColumnas = new JTextField();
        txtFilas = new JTextField();
        btnInfo = new JButton();
        btnCrear = new JButton();
        btnResult = new JButton();
        panel = new JPanel(null);
        btnComodin = new JButton();
        btnFinal = new JButton();
        //Para que el JFrame cierre la aplicacion
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        lblFilas.setText("Filas");
//        barraHerramientas.add(lblFilas);
//        txtFilas.setPreferredSize(new Dimension(50, 25));
//        barraHerramientas.add(txtFilas);
//        lblColumnas.setText("Columnas");
//        barraHerramientas.add(lblColumnas);
        btnCrear.setText("Crear");
        btnCrear.addActionListener(this);
        barraHerramientas.add(btnCrear);

        btnInfo.setText("Informacion");
        btnInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Color Amarillo:" + " Inicio." + "\n" + "Color Rojo:" + " blques." + "\n" + "Color Cyan:" + " comodin." + "\n" + "Color Verde:" + " meta.");
            }
        });
        barraHerramientas.add(btnInfo);
        btnResult.setText("Resultados Parciales");
        btnResult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Puntos ganados: " + String.valueOf(contGana) + "\n" + "Puntos perdidos: " + String.valueOf(contPierde));
            }
        });
        barraHerramientas.add(btnResult);
        //Colocamos el JToolBar en la parte de arriba del JFrame
        this.add(barraHerramientas, BorderLayout.PAGE_START);

        //Se agrega el panel a boton
        this.add(panel, BorderLayout.CENTER);

        this.setSize(620, 240);
        //Permite que la ventana se coloque al centro de la pantalla
        this.setLocationRelativeTo(null);

    }

    public void actionPerformed(ActionEvent evt) {
        String[] pre = {"Una variable puede ser nula?", "Una variable String puede ser convertida a int?", "Una variable Int puede ser convertidad a String?", "Una variable String puede ser convertidad a double?",
            "Una variable puede ser utilizada en otra clase si es privated?", "Una variable public se puede utilizar en otros metodos?", "Una variable protected puede ser modificada en otra clase?", "Una variable declarada public static es global?", "Una instancia es una variable?",
            "Una instancia es una clase aparte?", "new clase(); es una instancia?", "Una variable int puede tener decimales?", "Se pueden sumar variables String?", "Una variable double puede tener numeros enteros?",
            "Una variable long puede contener numeros de gran rango?", "Una interfaz grafica puede realizarse a codigo manual?", "Se puede caer un programa cuando un ciclo de iteracion se encicla ?", "Un caracter es lo mismo que una cadena de texto?",
            "Los archivos almacenan informacion permanente?", "Las matrices almacenan todo tipo de dato?", "Las ArrayList tienen limites definidos?", "Las Listas tienen limited definidos?", "El println imprime de la misma forma que el print?",
            "El /n hace lo mismo que el System.LineSeparetor()?", "El /n hace lo mismo que el  /r/n ?", "El % significa 'porciento'?", "En java se concatena con +?", "Se pueden sumar metodos de diferentes tipo?",
            "Se puede retornar una variable en un metodo void?", "Format sirve para ordenar el codigo?", "Java es orientado a objetos?", "Una clase sin MAIN puede correr programas?", "Una forma de establecer el MAIN m?s rapido es escribiendo psvm?",
            "Para establecer el System.out.println mas rapido es escribiendo sout?", "Para elevar una potencia en programacion se utiliza ^ ?", "Para cerrar una declaracion de cualquier tipo en java se utiliza {}?", "Se puede declarar una variable de cualquier tipo NULL?",
            "Se puede declarar un metodo int con parametros String?", "Para ingresar informacion desde el teclado se utiliza la Clase Scanner?", "El BufferedReader se utiliza para la lectura de archivos?",};
        boolean[] impresas = new boolean[pre.length];
        String[] res = {"v", "v", "v", "f", "f", "v", "f", "v", "f", "f", "v", "f", "f", "f", "v", "v", "v", "f", "v", "f", "f", "v", "f", "v", "v", "f", "v", "f", "f", "v", "v", "f", "v", "v", "v", "v", "v", "v", "v", "v"};
        ArrayList<JButton> listaObs = new ArrayList();
        ArrayList<JButton> listaPre = new ArrayList();
        int cont = 0;

        //Se obtiene la cantidad de filas a crear como una cadena de caracter
        //Se obtiene la cantidad de columnas a crear como una cadena de caracter
        //Se cambia de cadena de caracteres a numeros
//        int filas = Integer.parseInt(f);
//        int columnas = Integer.parseInt(c);
        //Eliminamos los anteriores botones
        panel.removeAll();

        //Se crea una matriz de botones segun las filas y columnas entrantes
        Boton[][] botones = new Boton[5][8];

        //Se recorren las filas
        for (int fila = 0; fila < 5; fila++) {
            //Estando en la fila se recorrer las columnas
            for (int columna = 0; columna < 8; columna++) {
                //Se crea el boton y se agrega a las celda de la matriz
                botones[fila][columna] = new Boton(75 * columna, 30 * fila, 75, 30);

                //Se da el nombre en forma de coordenada enviando la fila y columna
                botones[fila][columna].setNombre(fila, columna);
                if (fila == 0 && columna == 0) {
                    botones[fila][columna].setBackground(Color.yellow);
                    botones[fila][columna].setName("Inicio");

                }
                if (fila == 4 && columna == 0) {
                    botones[fila][columna].setBackground(Color.CYAN);
                }
                if (fila == 4 && columna == 7) {
                    botones[fila][columna].setBackground(Color.green);

                }

                for (int x = 0; x < 5; x++) {
                    int rand = (int) (Math.random() * 7);
                    if (rand == columna) {
                        if (columna != 0) {

                            botones[fila][columna].setBackground(Color.red);
                            botones[fila][columna].setText("XXXX");

                            botones[fila][columna].enableInputMethods(true);
                        }
                    }
                }
                if (botones[fila][columna].getText().equals("XXXX")) {
                    cont++;
                    listaObs.add(botones[fila][columna]);
                    System.out.println(listaObs.size());
                } else {
                    listaPre.add(botones[fila][columna]);
                }
                btnComodin = botones[4][0];
                btnFinal = botones[4][7];//Se agrega el boton al panel
                panel.add(botones[fila][columna]);
                if (!"XXXX".equals(botones[fila][columna].getText()) && !botones[fila][columna].equals(botones[4][0]) && !botones[fila][columna].equals(botones[4][7])) {

                    int fil = fila;
                    int colum = columna;
                    botones[fila][columna].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            int perdi = 0;
                            for (int i = 0; i < pre.length;) {
                                int posicion = (int) (Math.random() * pre.length);
                                int listaObst = (int) (Math.random() * listaObs.size());
                                int listaPreg = (int) (Math.random() * listaPre.size());
                                JButton re = (JButton) listaPre.get(listaPreg);
                                JButton buen = (JButton) listaObs.get(listaPreg);
                                if (!impresas[posicion]) {
                                    i++;
                                    impresas[posicion] = true;
                                    String respuesta = JOptionPane.showInputDialog(pre[posicion] + "Coloque v= Verdadero f= Falso");
                                    if (respuesta.equals(res[posicion])) {
                                        JOptionPane.showMessageDialog(null, "CORRECTO!!!");
                                        botones[fil][colum].setEnabled(false);
                                        listaPre.set(2, re);
                                        buen.setBackground(Color.white);
                                        buen.setText("Libre");
                                        contGana++;

                                        System.out.println(contGana);
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "FALLASTE");
                                       listaPre.set(2, re);
                                        re.setBackground(Color.RED);
                                        re.setText("XXXX");
                                        re.disable();
                                        contPierde++;

                                        break;
                                    }

                                }
                               
                            }
                            
                        }
                    });

                }
            }

        }

        //Se actualiza el panel para que se vean los botones
        panel.updateUI();

        comodin();
             
        Final();
      
    }

    //COMODIN
    public static void comodin() {
        btnComodin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Comodin cm = new Comodin();
                cm.show();
                MatrizBoton mt = new MatrizBoton();
                mt.dispose();

            }
        });
    }

    public static void Final() {
        btnFinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FinalFrmMat ftr = new FinalFrmMat();
                ftr.show();

            }
        });

    }

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        new MatrizBoton().setVisible(true);
    }

    JButton btnCrear;
    JTextField txtColumnas;
    JTextField txtFilas;
    JPanel panel;
    JButton btnInfo;
    JButton btnResult;
    static JButton btnComodin;
    static JButton btnFinal;
}
