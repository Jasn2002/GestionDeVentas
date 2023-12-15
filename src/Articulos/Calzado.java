package Articulos;

public class Calzado extends Articulo{
    
    String talla;

    public Calzado(String nombre, String descripcion, int id, double precio, int cantidadEnAlmacen, String talla){
        super(nombre, descripcion, id, precio, cantidadEnAlmacen);
        this.talla = talla;
    }

}
