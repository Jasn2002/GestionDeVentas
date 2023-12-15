package Compra;

public class Registro extends Compra{
    
    String fecha;

    public Registro(Compra compra, String fecha){
        super(compra.articulosComprados, compra.comprador);
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    

}
