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
public class Father {
    String Nombre;
    String Autor;
    String Categoria;
    int Precio;
    int cantidad;

    public Father(String Nombre, String Autor, String Categoria, int Precio, int cantidad) {
        this.Nombre = Nombre;
        this.Autor = Autor;
        this.Categoria = Categoria;

        this.Precio = Precio;
        this.cantidad = cantidad;
    }

}