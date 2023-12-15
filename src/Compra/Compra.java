package Compra;

import java.io.Serializable;
import java.util.ArrayList;

import Almacen.Almacen;
import Articulos.Articulo;
import Control.Archivos;
import Control.Interfaz;
import CuentaBancaria.CuentaBancaria;
import Usuario.Cliente;

public class Compra implements Serializable{

    ArrayList<Articulo> articulosComprados;
    Cliente comprador;
    double costoTotal;

    public Compra(ArrayList<Articulo> articulosComprados, Cliente comprador){
        System.out.println(articulosComprados);
        this.articulosComprados = articulosComprados;
        double costoTemp = 0;
        for (Articulo a : articulosComprados) {
            System.out.println(a.getPrecio());
            costoTemp += a.getPrecio();
        }
        this.costoTotal = costoTemp;
        this.comprador = comprador;
    }

    public void ProcesarCompra(){
        CuentaBancaria cuenta = comprador.getCuenta();
        if (CompraViable()){
            cuenta.SustraerSaldo(costoTotal);
            new Archivos().guardarDatos(cuenta, false);
            SustraerArticulos();
            new Interfaz().MostrarMensaje("Su compra se ha realizado con exito. Costo Total: " + costoTotal);
        }
        
    }

    private boolean CompraViable(){
        boolean ret = true;
        Almacen almacen = new Almacen();
        CuentaBancaria cuenta = comprador.getCuenta();
        
        for (Articulo articulo : articulosComprados) {
            if (almacen.EncontrarArticulo(articulo.getId()).getCantidadEnAlmacen() < 1){ret = false;}
        }

        if (cuenta.getBalance() < costoTotal){ret = false;}

        return ret;
    }

    private void SustraerArticulos(){
        Almacen almacen = new Almacen();
        for (Articulo articulo : articulosComprados) {
            Articulo a = almacen.EncontrarArticulo(articulo.getId());
            a.setCantidadEnAlmacen(a.getCantidadEnAlmacen() - 1);
           new Archivos().guardarDatos(a, true);
        }
    }

    public ArrayList<Articulo> getArticulosComprados() {
        return articulosComprados;
    }

    public void setArticulosComprados(ArrayList<Articulo> articulosComprados) {
        this.articulosComprados = articulosComprados;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    
    
}
