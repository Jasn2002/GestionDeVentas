package Almacen;

import java.util.ArrayList;

import Articulos.Articulo;
import Control.Archivos;
import Control.Interfaz;

public class Almacen {

    private static ArrayList<Articulo> listaArticulos = new Archivos().leerDatosArticulo();

    public Almacen(){  }

    public static void RegistrarArticulo(String nombre, String descripcion, int id, double precio, int cantidadEnAlmacen){
        Articulo u = new Articulo(nombre, descripcion, id, precio, cantidadEnAlmacen);
        
        if (new Almacen().ArticuloExiste(id)){
            new Interfaz().MostrarMensaje("Ya existe un articulo con esta ID");
        }   else {
            new Archivos().guardarDatos(u, false);
            new Interfaz().MostrarMensaje("Articulo Registrado");
        }
        }

    public void listarArticulos(){
        listaArticulos = new Archivos().leerDatosArticulo();
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

public Articulo EncontrarArticulo(int id){

    ArrayList<Articulo> listaArticulos = new Archivos().leerDatosArticulo();
    Articulo a = null;
    for (Articulo articulo : listaArticulos) {
            if (articulo.getId() == id)  {a = articulo; }
            }
    return a;
}

public Articulo EncontrarArticulo(String nombre){

    ArrayList<Articulo> listaArticulos = new Archivos().leerDatosArticulo();
    Articulo a = null;
    for (Articulo articulo : listaArticulos) {
            if (articulo.getNombre().equals(nombre))  {a = articulo; }
            }
    return a;
}

protected boolean ArticuloExiste(int id){

    ArrayList<Articulo> listaArticulos = new Archivos().leerDatosArticulo();

    for (Articulo articulo : listaArticulos) {
        if (articulo.getId() == id)  { return true; }
}
    return false;

}
    
}
