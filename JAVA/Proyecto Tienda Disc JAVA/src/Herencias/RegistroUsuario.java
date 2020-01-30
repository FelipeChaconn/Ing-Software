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
public class RegistroUsuario extends Persona {


    public RegistroUsuario(String Nombre, String Cedula, String Contraseña, String Correo) {
        super(Nombre, Cedula, Contraseña, Correo);
    }

    public String register() {

        return Nombre + ";" + Cedula + ";" + Contraseña + ";" + Correo;
    }

}
