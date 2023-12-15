package Control;

import java.util.ArrayList;

import Almacen.Carrito;
import Articulos.Articulo;
import Compra.Registro;
import CuentaBancaria.CuentaBancaria;
import CuentaBancaria.CuentaMLC;
import Usuario.*;
import Vista.InterfazAdministrador;
import Vista.InterfazClientes;
import Vista.InterfazEmpleados;

public class GestorDeVentas {

    private static String[] usuarioActual;
    private static Carrito carrito = new Carrito();

    public void RegistrarUsuario(String nombre, String contraseña, boolean esCliente){
        Usuario u;
        if (esCliente){
            u = new Cliente(nombre, contraseña);
        } else {u = new Empleado(nombre, contraseña, null);}

        if (UsuarioExiste(nombre, contraseña)){
            new Interfaz().MostrarMensaje("Este Usuario Ya Existe");
        }   else {
            new Archivos().guardarDatos(u, false);
            new Interfaz().MostrarMensaje("Usuario Registrado");
        }

        //listarUsuarios();

    }
    

    public boolean Login(String nombre, String contraseña){

            if (nombre.equals("admin") && contraseña.equals("admin")) {
                new Interfaz().MostrarMensaje("Autenticado como administrador");
                
                new InterfazAdministrador();

                return true;
            }

            if (UsuarioExiste(nombre, contraseña)) {
                new Interfaz().MostrarMensaje("Autenticado con Exito");

                Usuario u = EncontrarUsuario(nombre, contraseña);
                
                usuarioActual = new String[] {u.getNombre(), u.getContraseña()};

                if (EncontrarUsuario(nombre, contraseña) instanceof Cliente)
                {new InterfazClientes();} else {new InterfazEmpleados();}

                return true;
            }
        new Interfaz().MostrarMensaje("El usuario no está registrado");
        return false;
    }

    private boolean UsuarioExiste(String nombre, String contraseña){

        ArrayList<Usuario> listaUsuarios = new Archivos().leerDatosUsuario();

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getContraseña().equals(contraseña))  { return true; }
    }
        return false;
    
}

public void listarUsuarios(){
    ArrayList<Usuario> listaUsuarios = new Archivos().leerDatosUsuario();
    String s = "";
    for (Usuario usuario : listaUsuarios) {
        String temp = "\n";
        temp =temp +  "Nombre: " + usuario.getNombre() + "\n";
        temp =temp + "Contraseña: " + usuario.getContraseña() + "\n";
        if (usuario instanceof Cliente){
            Cliente c = (Cliente)EncontrarUsuario(usuario.getNombre(), usuario.getContraseña());
            temp = temp +"Balance: " +  c.getCuenta().getBalance() + "$\n";
        }
        s += temp;
    }

    new Interfaz().MostrarMensaje(s);
}

public void listarRegistros(){
    ArrayList<Registro> listaRegistros = new Archivos().leerDatosRegistro();
    String s = "";
    for (Registro registro : listaRegistros) {
        String temp = "\n";
        temp =temp +  "Comprador: " + registro.getComprador().getNombre() + "\n";
        temp = temp + "Articulos Comprados: \n";

        for (Articulo articulo : registro.getArticulosComprados()) {
            temp = temp + articulo.getNombre() + "\n";
        }

        temp =temp + "Costo Total: " + registro.getCostoTotal() + "\n";
        temp = temp +"Fecha: " +  registro.getFecha() + "\n";
        s += temp; 
    }

    new Interfaz().MostrarMensaje(s);
}

public void listarCuentas(){
    ArrayList<CuentaBancaria> listaCuentas = new Archivos().leerDatosCuenta();
    String s = "";
    for (CuentaBancaria cuenta : listaCuentas) {
        String temp = "\n";
        temp =temp +  "Propietario: " + cuenta.getPropietario() + "\n";
        temp = temp +"Balance: " +  cuenta.getBalance() + "\n";
        temp += "Tipo de Cuenta: ";
        if (cuenta instanceof CuentaMLC){temp += "MLC\n";}
        else {temp += "CUP\n";}
        s += temp; 
    }

    new Interfaz().MostrarMensaje(s);
}


public static Usuario EncontrarUsuario(String nombre, String contraseña){

    ArrayList<Usuario> listaUsuarios = new Archivos().leerDatosUsuario();
    Usuario u = null;
    for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getContraseña().equals(contraseña))  {u = usuario; }
            }
    return u;
}

public static CuentaBancaria EncontrarCuenta(String nombre){

    ArrayList<CuentaBancaria> listaCuentas = new Archivos().leerDatosCuenta();
    CuentaBancaria u = null;
    for (CuentaBancaria cuenta : listaCuentas) {
            if (cuenta.getPropietario().equals(nombre))  {u = cuenta; }
            }
    return u;
}


public static Cliente getUsuarioActual() {
    Cliente c = (Cliente) GestorDeVentas.EncontrarUsuario(usuarioActual[0], usuarioActual[1]);
    return c;
}

public static Carrito getCarrito() {
    return carrito;
}


}
