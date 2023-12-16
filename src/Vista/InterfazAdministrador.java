package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Control.Archivos;
import Control.GestorDeVentas;
import Control.Interfaz;
import CuentaBancaria.InterfazBancaria;

public class InterfazAdministrador extends JFrame implements ActionListener {

    JButton botonOpcion1 = new JButton("Eliminar usuarios");
    JButton botonOpcion2 = new JButton("Eliminar articulos");
    JButton botonOpcion3 = new JButton("Ver Registros");
    JButton botonOpcion4 = new JButton("Listar Usuarios");
    JButton botonOpcion5 = new JButton("Eliminar Registros");
    JButton botonOpcion6 = new JButton("Administrar Cuentas");
    JButton botonOpcion7 = new JButton("Eliminar Cuentas");

    public InterfazAdministrador(){
    //FRAME SETUP
	this.setTitle("Gestor de Ventas - Administrador");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(false);
    this.setLayout(null);
	this.setSize(800, 600);

    JPanel mainPanel = new JPanel();
    mainPanel.setBounds(100, 100, 600, 400);
    mainPanel.setLayout(new GridLayout(0, 1));

    botonOpcion1.addActionListener(this);
    botonOpcion2.addActionListener(this);
    botonOpcion3.addActionListener(this);
    botonOpcion4.addActionListener(this);
    botonOpcion5.addActionListener(this);
    botonOpcion6.addActionListener(this);
    botonOpcion7.addActionListener(this);
    
    this.add(mainPanel);
    mainPanel.add(botonOpcion1);
    mainPanel.add(botonOpcion2);
    mainPanel.add(botonOpcion3);
    mainPanel.add(botonOpcion4);
    mainPanel.add(botonOpcion5);
    mainPanel.add(botonOpcion6);
    mainPanel.add(botonOpcion7);
    this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== botonOpcion1){
            new Archivos().borrarDatosUsuario();
            new Interfaz().MostrarMensaje("La lista de usuarios ha sido eliminada");
            
        }
        if(e.getSource()== botonOpcion2){
            new Archivos().borrarDatosArticulo();
            new Interfaz().MostrarMensaje("La lista de articulos ha sido eliminada");
        }
        if(e.getSource()== botonOpcion3){
            new GestorDeVentas().listarRegistros();
        }
        if(e.getSource()== botonOpcion4){
            new GestorDeVentas().listarUsuarios();
        }
        if(e.getSource()== botonOpcion5){
            new Archivos().borrarDatosRegistro();
        }
        if(e.getSource()== botonOpcion6){
            new InterfazBancaria();
        }
        if(e.getSource()== botonOpcion7){
            new Archivos().borrarDatosCuenta();
            new Interfaz().MostrarMensaje("La lista de cuentas bancarias ha sido eliminada");
        }

    }
    
}
