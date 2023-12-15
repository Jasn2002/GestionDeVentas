package Usuario;

import Control.Archivos;
import Control.GestorDeVentas;
import CuentaBancaria.CuentaBancaria;

public class Cliente extends Usuario{
    
    CuentaBancaria cuenta;

    public Cliente(String nombre, String contraseña){
        super(nombre, contraseña);
        
    }

    public CuentaBancaria getCuenta() {
        CuentaBancaria cuenta = GestorDeVentas.EncontrarCuenta(this.nombre);
        if (cuenta == null){cuenta = new CuentaBancaria(this.nombre, 0);}
        return cuenta;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        new Archivos().guardarDatos(cuenta, true);
    }    

}
