package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Almacen.Almacen;
import Control.Archivos;
import Control.GestorDeVentas;
import Control.Interfaz;
import CuentaBancaria.CuentaBancaria;
import Usuario.Cliente;

public class InterfazClientes extends JFrame implements ActionListener {

    JButton botonOpcion1 = new JButton("Ver lista de articulos");
    JButton botonOpcion2 = new JButton("Añadir articulo al carrito");
    JButton botonOpcion3 = new JButton("Añadir Saldo");
    JButton botonOpcion4 = new JButton("Ver carrito");
    JButton botonOpcion5 = new JButton("Confirmar compra");

    public InterfazClientes(){
    //FRAME SETUP
	this.setTitle("Gestor de Ventas - Clientes");
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
    
    this.add(mainPanel);
    mainPanel.add(botonOpcion1);
    mainPanel.add(botonOpcion2);
    mainPanel.add(botonOpcion3);
    mainPanel.add(botonOpcion4);
    mainPanel.add(botonOpcion5);
    this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== botonOpcion1){
            new Almacen().listarArticulos();
            
        }
        if(e.getSource()== botonOpcion2){
            new Interfaz().ComprarArticulo();

        }
        if(e.getSource()== botonOpcion3){
            Cliente usuarioActual = GestorDeVentas.getUsuarioActual();
            CuentaBancaria cuenta = usuarioActual.getCuenta();
            cuenta.AñadirSaldo(new Double(JOptionPane.showInputDialog("Ingrese la cantidad que desee depositar: ")));
            new Archivos().guardarDatos(cuenta, false);
            
        }
        if(e.getSource()== botonOpcion4){
            GestorDeVentas.getCarrito().listarArticulos();
        }
        if(e.getSource()== botonOpcion5){
            GestorDeVentas.getCarrito().CrearCompra();
        }

    }
    
}
