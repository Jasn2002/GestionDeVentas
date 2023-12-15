package Usuario;

import java.io.Serializable;

public abstract class Usuario implements Serializable{
    
    String nombre;
    String contraseña;


    public Usuario (String nombre, String contraseña){
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public String getNombre(){
        return this.nombre;
    }
    public String getContraseña(){
        return this.contraseña;
    }

}
