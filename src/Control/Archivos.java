package Control;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Articulos.Articulo;
import Compra.Registro;
import CuentaBancaria.CuentaBancaria;
import Usuario.*;

public class Archivos {
    
    public void guardarDatos(Usuario usuario, boolean rescribir) {
        ArrayList<Usuario> c = leerDatosUsuario();
        //ArrayList<Usuario> c = new ArrayList<Cliente>();
        if (c == null) c = new ArrayList<Usuario>();
        c.add(usuario);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Archivo/Usuario.txt", rescribir))) {
            oos.writeObject(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarDatos(Articulo articulo, boolean rescribir) {
        ArrayList<Articulo> c = leerDatosArticulo();
        //ArrayList<Usuario> c = new ArrayList<Cliente>();
        if (c == null) c = new ArrayList<Articulo>();
        c.add(articulo);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Archivo/Articulo.txt", rescribir))) {
            oos.writeObject(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarDatos(Registro registro, boolean rescribir) {
        ArrayList<Registro> c = leerDatosRegistro();
        //ArrayList<Usuario> c = new ArrayList<Cliente>();
        if (c == null) c = new ArrayList<Registro>();
        c.add(registro);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Archivo/Registro.txt", rescribir))) {
            oos.writeObject(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarDatos(CuentaBancaria cuenta, boolean rescribir) {
        ArrayList<CuentaBancaria> c = leerDatosCuenta();
        if (c == null) c = new ArrayList<CuentaBancaria>();
        c.add(cuenta);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Archivo/Cuenta.txt", rescribir))) {
            oos.writeObject(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<CuentaBancaria> leerDatosCuenta() {
        String archivo = "src/Archivo/Cuenta.txt";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<CuentaBancaria> cuenta = null;
        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);
            cuenta = (ArrayList<CuentaBancaria>) ois.readObject();

        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
        return cuenta;
    }

    public ArrayList<Registro> leerDatosRegistro() {
        String archivo = "src/Archivo/Registro.txt";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Registro> registros = null;
        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);
            registros = (ArrayList<Registro>) ois.readObject();

        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public ArrayList<Usuario> leerDatosUsuario() {
        String archivo = "src/Archivo/Usuario.txt";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Usuario> usuarios = null;
        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);
            usuarios = (ArrayList<Usuario>) ois.readObject();

        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
        return usuarios;
    }

    public ArrayList<Articulo> leerDatosArticulo() {
        String archivo = "src/Archivo/Articulo.txt";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Articulo> articulos = null;
        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);
            articulos = (ArrayList<Articulo>) ois.readObject();

        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
        return articulos;
    }

    public void borrarDatosUsuario(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Archivo/Usuario.txt"))) {
            oos.writeObject(new ArrayList<Usuario>());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void borrarDatosArticulo(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Archivo/Articulo.txt"))) {
            oos.writeObject(new ArrayList<Articulo>());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void borrarDatosCuenta(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Archivo/Cuenta.txt"))) {
            oos.writeObject(new ArrayList<CuentaBancaria>());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void borrarDatosRegistro(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Archivo/Registro.txt"))) {
            oos.writeObject(new ArrayList<Registro>());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
