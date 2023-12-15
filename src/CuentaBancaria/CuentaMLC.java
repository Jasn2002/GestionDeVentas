package CuentaBancaria;

import Control.Interfaz;

public class CuentaMLC extends CuentaBancaria{

    public CuentaMLC(String propietario, double balance) {
        super(propietario, balance);
    }

    public double ConvertirAcup(double monto){
        return monto / 250;
    }
    public double ConvertirAmlc(double monto){
        return monto * 250;
    }

    @Override
    public void AñadirSaldo(double saldo){
        this.balance += ConvertirAmlc(saldo);
        new Interfaz().MostrarMensaje("La operacion fue completada con exito\nNuevo balance: " + this.balance);
    }

    @Override
    public void SustraerSaldo(double saldo){
        if (this.balance >= ConvertirAmlc(saldo)){
            this.balance -= ConvertirAmlc(saldo);
            new Interfaz().MostrarMensaje("La operacion fue completada con exito\nNuevo balance: " + this.balance);
        } else {
            new Interfaz().MostrarMensaje("No fue posible completar la operacion");
        }
    }

}
