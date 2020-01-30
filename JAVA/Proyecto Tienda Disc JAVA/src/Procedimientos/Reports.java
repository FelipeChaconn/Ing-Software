/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;
import static GUI.Select_user.listausuario;
import static GUI.ChoosUsrPeli.listapeliuser;
import static GUI.ChoosUsrPeli.modelousupeli;
import static GUI.Date_fin.now2;
import static GUI.Date_ini.now;
import static GUI.Date_finMov.nowMov2;
import static GUI.Date_iniMov.nowMov;
import static GUI.Select_user.ModelT;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Luis Felipe
 */
public class Reports {
      public static String leerInfoA() {
        String nombredisco = "";
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
                if (lista1[3].equals("Soy Peor")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return nombredisco;
    }
       public static String leerInfoB() {
        String nombredisco = "";
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
                if (lista1[3].equals("Sobredosis")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return nombredisco;
    }

    public String leerInfoC() {
        String nombredisco = "";
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
                if (lista1[3].equals("El Farsante")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return nombredisco;
    }

    public String leerInfoD() {
        String nombredisco = "";
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
                if (lista1[3].equals("Soy Peor")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return nombredisco;
    }

   

    public int Quant1() {
        int cantidad = 0;
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
                if (lista1[0].equals(leerInfoD())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int Quant2() {
        int cantidad = 0;
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
                if (lista1[0].equals(leerInfoA())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int Quant3() {
        int cantidad = 0;
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
                if (lista1[0].equals(leerInfoB())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int Quant4() {
        int cantidad = 0;
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
                if (lista1[0].equals(leerInfoD())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

 
    public String leerpeli1() {
        String nombredisco = "";
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
                if (lista1[0].equals("Fast and Furious")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return nombredisco;
    }

    public String leerpeli2() {
        String nombredisco = "";
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
                if (lista1[0].equals("Cars")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return nombredisco;
    }

    public String leerpeli3() {
        String nombredisco = "";
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
                if (lista1[0].equals("Transporter")) {
                    nombredisco = lista1[0];
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return nombredisco;
    }

   
   

   

      

    public int cantidadpeli2() {
        int cantidad = 0;
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
                if (lista1[0].equals(leerpeli1())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int cantidadpeli3() {
        int cantidad = 0;
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
                if (lista1[0].equals(leerpeli2())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int cantidadpeli4() {
        int cantidad = 0;
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
                if (lista1[0].equals(leerpeli3())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

   
   
    public void llenar_list() {
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Usuarios.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf2.readLine()) != null) {
                temp = bfRead;
                String lista = temp;

                String[] lista1 = lista.split(";");

                ModelT.addElement(lista1[0]);

            }

            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

    }

    public void llenar_listpeli() {
        
        try {
            String temp;
            BufferedReader bf2 = new BufferedReader(new FileReader("Usuarios.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf2.readLine()) != null) {
                temp = bfRead;
                String lista = temp;

                String[] lista1 = lista.split(";");

                modelousupeli.addElement(lista1[0]);

            }

            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

    }

    public int usercanti() {
        String nombre = listausuario.getSelectedValue();
        int cantidad = 0;
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leerInfoD())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int usercanti2() {
        String nombre = listausuario.getSelectedValue();
        int cantidad = 0;
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leerInfoB())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int usercanti3() {
        String nombre = listausuario.getSelectedValue();
        int cantidad = 0;
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leerInfoC())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int usercanti4() {
        String nombre = listausuario.getSelectedValue();
        int cantidad = 0;
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leerInfoC())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
            
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int usercanti5() {

        String nombre = listausuario.getSelectedValue();
        int cantidad = 0;
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leerInfoD())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int userpeli() {

        String nombre = listapeliuser.getSelectedValue();
        int cantidad = 0;
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leerpeli3())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;

    }

    

    public int userpeli2() {

        String nombre = listapeliuser.getSelectedValue();
        int cantidad = 0;
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leerpeli1())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;

    }

    public int userpeli3() {

        String nombre = listapeliuser.getSelectedValue();
        int cantidad = 0;
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
                if (lista1[1].equals(nombre) & lista1[0].equals(leerpeli2())) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;

    }

    public CategoryDataset cargardisco() {
        //this method will charge the information on the graphic table
        DefaultCategoryDataset Datos3 = new DefaultCategoryDataset();
        Datos3.addValue(usercanti(), leerInfoD(), leerInfoD());
        Datos3.addValue(usercanti2(), leerInfoB(), leerInfoB());
        Datos3.addValue(usercanti3(), leerInfoA(), leerInfoA());
        Datos3.addValue(usercanti4(), leerInfoC(), leerInfoC());


        return Datos3;
    }

    public int fecha1() throws ParseException {
        SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM");
        String fechaini = now;
        String fechafin = now2;
        Date fechainicio = formato2.parse(now);
        Date fechafin2 = formato2.parse(now2);

        int cantidad = 0;
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
                String fechaprin = lista1[5];
                Date fechaprincipal = formato2.parse(fechaprin);
                if (lista1[0].equals(leerInfoD()) & (fechaprincipal.before(fechafin2) || fechaprincipal.equals(fechafin2)) & (fechaprincipal.after(fechainicio) || fechaprincipal.equals(fechainicio))) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int fecha2() throws ParseException {
        SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM");
        String fechaini = now;
        String fechafin = now2;
        Date fechainicio = formato2.parse(now);
        Date fechafin2 = formato2.parse(now2);

        int cantidad = 0;
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
                String fechaprin = lista1[5];
                Date fechaprincipal = formato2.parse(fechaprin);
                if (lista1[0].equals(leerInfoB()) & (fechaprincipal.before(fechafin2) || fechaprincipal.equals(fechafin2)) & (fechaprincipal.after(fechainicio) || fechaprincipal.equals(fechainicio))) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int fecha3() throws ParseException {
        SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM");
        String fechaini = now;
        String fechafin = now2;
        Date fechainicio = formato2.parse(now);
        Date fechafin2 = formato2.parse(now2);

        int cantidad = 0;
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
                String fechaprin = lista1[5];
                Date fechaprincipal = formato2.parse(fechaprin);
                if (lista1[0].equals(leerInfoA()) & (fechaprincipal.before(fechafin2) || fechaprincipal.equals(fechafin2)) & (fechaprincipal.after(fechainicio) || fechaprincipal.equals(fechainicio))) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int fecha4() throws ParseException {
        SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM");
        String fechaini = now;
        String fechafin = now2;
        Date fechainicio = formato2.parse(now);
        Date fechafin2 = formato2.parse(now2);

        int cantidad = 0;
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
                String fechaprin = lista1[5];
                Date fechaprincipal = formato2.parse(fechaprin);
                if (lista1[0].equals(leerInfoC()) & (fechaprincipal.before(fechafin2) || fechaprincipal.equals(fechafin2)) & (fechaprincipal.after(fechainicio) || fechaprincipal.equals(fechainicio))) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    
    
    
    
    
   
    public CategoryDataset cargardiscofechas() throws ParseException {
        //this method will show the information about what the admi introduced as a date of beggining and end
        DefaultCategoryDataset Datos3 = new DefaultCategoryDataset();
        Datos3.addValue(fecha1(), leerInfoD(), leerInfoD());
        Datos3.addValue(fecha2(), leerInfoB(), leerInfoB());
        Datos3.addValue(fecha3(), leerInfoA(), leerInfoA());
        Datos3.addValue(fecha4(), leerInfoC(), leerInfoC());
     

  

        return Datos3;
    }


    public CategoryDataset cargarpeli() {
      
        DefaultCategoryDataset Datos3 = new DefaultCategoryDataset();
        Datos3.addValue(userpeli(), leerpeli3(), leerpeli3());
        Datos3.addValue(userpeli2(), leerpeli1(), leerpeli1());
        Datos3.addValue(userpeli3(), leerpeli2(), leerpeli2());
     

        return Datos3;
    }

     public int fechapeli1() throws ParseException {
        SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM");
        Date fechainicio = formato2.parse(nowMov);
        Date fechafin2 = formato2.parse(nowMov2);

        int cantidad = 0;
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
                String fechaprin = lista1[5];
                Date fechaprincipal = formato2.parse(fechaprin);
                if (lista1[0].equals(leerpeli3()) & (fechaprincipal.before(fechafin2) || fechaprincipal.equals(fechafin2)) & (fechaprincipal.after(fechainicio) || fechaprincipal.equals(fechainicio))) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    

   
    public int fechapeli4() throws ParseException {
        SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM");
        Date fechainicio = formato2.parse(nowMov);
        Date fechafin2 = formato2.parse(nowMov2);

        int cantidad = 0;
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
                String fechaprin = lista1[5];
                Date fechaprincipal = formato2.parse(fechaprin);
                if (lista1[0].equals(leerpeli1()) & (fechaprincipal.before(fechafin2) || fechaprincipal.equals(fechafin2)) & (fechaprincipal.after(fechainicio) || fechaprincipal.equals(fechainicio))) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public int fechapeli5() throws ParseException {
        SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM");
        Date fechainicio = formato2.parse(nowMov);
        Date fechafin2 = formato2.parse(nowMov2);

        int cantidad = 0;
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
                String fechaprin = lista1[5];
                Date fechaprincipal = formato2.parse(fechaprin);
                if (lista1[0].equals(leerpeli2()) & (fechaprincipal.before(fechafin2) || fechaprincipal.equals(fechafin2)) & (fechaprincipal.after(fechainicio) || fechaprincipal.equals(fechainicio))) {
                    cantidad += Integer.parseInt(lista1[4]);
                }
            }
            bf2.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }

        return cantidad;
    }

    public CategoryDataset cargarpelifecha() throws ParseException {
        DefaultCategoryDataset Datos3 = new DefaultCategoryDataset();
        Datos3.addValue(fechapeli1(), leerpeli3(), leerpeli3());
        Datos3.addValue(fechapeli4(), leerpeli1(), leerpeli1());
        Datos3.addValue(fechapeli5(), leerpeli2(), leerpeli2());

        return Datos3;
    }

}
