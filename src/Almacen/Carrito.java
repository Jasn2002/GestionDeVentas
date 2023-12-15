package Almacen;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import Articulos.Articulo;
import Compra.Compra;
import Compra.Registro;
import Control.Archivos;
import Control.GestorDeVentas;
import Control.Interfaz;
import Usuario.Cliente;

public class Carrito extends Almacen implements Serializable{

    private ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();

    public void AñadirArticulo(String nombreArticulo){
        Articulo a = new Almacen().EncontrarArticulo(nombreArticulo);
        this.listaArticulos.add(a);
        new Interfaz().MostrarMensaje("El articulo ha sido agregado a su Carrito");
    }

    public void CrearCompra(){
        String fecha = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(ZonedDateTime.now());
        Cliente usuarioActual = GestorDeVentas.getUsuarioActual();
        Compra c = new Compra(listaArticulos, usuarioActual);

        Registro r = new Registro(c, fecha);
        r.ProcesarCompra();

        new Archivos().guardarDatos(r, false);
        listaArticulos = new ArrayList<Articulo>();
    }
 
    @Override
    public Articulo EncontrarArticulo(int id){

    listaArticulos = new Archivos().leerDatosArticulo();
    Articulo a = null;
    for (Articulo articulo : listaArticulos) {
            if (articulo.getId() == id)  {a = articulo; }
            }
    return a;
}

@Override
public boolean ArticuloExiste(int id){

    listaArticulos = new Archivos().leerDatosArticulo();

    for (Articulo articulo : listaArticulos) {
        if (articulo.getId() == id)  { return true; }
}
    return false;

}

@Override
public void listarArticulos(){
String s = "";
for (Articulo articulo : listaArticulos) {
        String temp = "\n";
        temp =temp +  "Nombre: " + articulo.getNombre() + "\n";
        temp =temp + "Descripcion: " + articulo.getDescripcion() + "\n";
        temp = temp +"ID: " +  articulo.getId() + "\n";
        temp = temp + "Precio: " +  articulo.getPrecio() + "\n";
        temp = temp + "Cantidad: " + articulo.getCantidadEnAlmacen() + "\n";
        s += temp;
        
}

new Interfaz().MostrarMensaje(s);
}

}
