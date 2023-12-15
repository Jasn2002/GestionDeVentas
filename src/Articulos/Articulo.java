package Articulos;

import java.io.Serializable;

public class Articulo implements Serializable{

    String nombre;
    String descripcion;
    int id;
    double precio;
    int cantidadEnAlmacen;

    public Articulo(String nombre, String descripcion, int id, double precio, int cantidadEnAlmacen){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id = id;
        this.precio = precio;
        this.cantidadEnAlmacen = cantidadEnAlmacen;
    }

    

    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getDescripcion() {
        return descripcion;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public void setPrecio(double precio) {
        this.precio = precio;
    }



    public double getPrecio(){
        return this.precio;
    }



    public int getCantidadEnAlmacen() {
        return cantidadEnAlmacen;
    }



    public void setCantidadEnAlmacen(int cantidadEnAlmacen) {
        this.cantidadEnAlmacen = cantidadEnAlmacen;
    }

    
    
}
