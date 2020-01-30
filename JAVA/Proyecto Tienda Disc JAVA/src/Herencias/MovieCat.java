/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencias;

/**
 *
 * @author Luis Felipe
 */
public class MovieCat extends Father {

    

    public MovieCat(String Nombre, String Autor, String Categoria, int Precio, int cantidad) {
        super(Nombre, Autor, Categoria, Precio, cantidad);
        
    }

    public String devolver() {

        return Nombre + ";" + Autor + ";" + Categoria + ";" + Precio + ";" + cantidad;

    }

}