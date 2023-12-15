package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Control.Interfaz;
import Almacen.*;

public class InterfazEmpleados extends JFrame implements ActionListener {

    JButton botonOpcion1 = new JButton("Ver Articulos");
    JButton botonOpcion2 = new JButton("Agregar Articulo");

    public InterfazEmpleados(){
        //FRAME SETUP
        this.setTitle("Gestor de Ventas - Empleados");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(100, 100, 600, 400);
        mainPanel.setLayout(new GridLayout(0, 1));

        botonOpcion1.addActionListener(this);
        botonOpcion2.addActionListener(this);

        this.add(mainPanel);
        mainPanel.add(botonOpcion1);
        mainPanel.add(botonOpcion2);
        this.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()== botonOpcion1){
            new Almacen().listarArticulos();
            
        }
        if(e.getSource()== botonOpcion2){
            new Interfaz().AgregarArticulo();
        }

    }
    
}
