package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Util.Menues;

public class InterfazClientes extends JFrame implements ActionListener {

    JButton botonOpcion1 = new JButton("Ver lista de articulos");
    JButton botonOpcion2 = new JButton("Agregar articulo al carrito");
    JButton botonOpcion3 = new JButton("Eliminar articulo del carrito");
    JButton botonOpcion4 = new JButton("Ver carrito");
    JButton botonOpcion5 = new JButton("Confirmar compra");
    JButton botonOpcion6 = new JButton("Modulo Bancario");
    JButton botonOpcion7 = new JButton("Cerrar Sesion");

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
            Menues.empleadosOpcionUno();
            
        }
        if(e.getSource()== botonOpcion2){
            Menues.clientesOpcionDos();
        }
        if(e.getSource()== botonOpcion3){
            Menues.clientesOpcionTres();
        }
        if(e.getSource()== botonOpcion4){
            Menues.clientesOpcionCuatro();
        }
        if(e.getSource()== botonOpcion5){
            Menues.clientesOpcionCinco();
        }
        if(e.getSource()== botonOpcion6){
            Menues.moduloBancarioMenu();
        }
        if(e.getSource()== botonOpcion7){
            this.dispose();
        }

    }
    
}
