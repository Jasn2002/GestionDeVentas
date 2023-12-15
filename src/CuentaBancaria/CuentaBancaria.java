package CuentaBancaria;

import java.io.Serializable;

import Control.Interfaz;

public class CuentaBancaria implements Serializable{

    String propietario;    
    double balance;

    public CuentaBancaria(String propietario, double balance){
        this.propietario = propietario;
        if (balance <= 0){this.balance = 0;} else this.balance = balance;
    }

    public void AñadirSaldo(double saldo){
        this.setBalance(balance + saldo);
        new Interfaz().MostrarMensaje("La operacion fue completada con exito\nNuevo balance: " + this.balance);
    }

    public void SustraerSaldo(double saldo){
        if (this.balance >= saldo){
            this.balance -= saldo;
            new Interfaz().MostrarMensaje("La operacion fue completada con exito\nNuevo balance: " + this.balance);
        } else {
            new Interfaz().MostrarMensaje("No fue posible completar la operacion");
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    

}
