package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Util.Menues;

public class InterfazEmpleados extends JFrame implements ActionListener {

    JButton botonOpcion1 = new JButton("Ver Articulos");
    JButton botonOpcion2 = new JButton("Agregar Articulo");
    JButton botonOpcion3 = new JButton("Remover Articulo");
    JButton botonOpcion4 = new JButton("Modificar stock");
    JButton botonOpcion5 = new JButton("Editar Articulo");
    JButton botonOpcion6 = new JButton("Cerrar Sesion");

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
        botonOpcion3.addActionListener(this);
        botonOpcion4.addActionListener(this);
        botonOpcion5.addActionListener(this);
        botonOpcion6.addActionListener(this);

        this.add(mainPanel);
        mainPanel.add(botonOpcion1);
        mainPanel.add(botonOpcion2);
        mainPanel.add(botonOpcion3);
        mainPanel.add(botonOpcion4);
        mainPanel.add(botonOpcion5);
        mainPanel.add(botonOpcion6);
        this.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== botonOpcion1){
            Menues.empleadosOpcionUno();
            
        }
        if(e.getSource()== botonOpcion2){
            Menues.empleadosOpcionDos();
        }
        if(e.getSource()== botonOpcion3){
            Menues.empleadosOpcionTres();
        }
        if(e.getSource()== botonOpcion4){
            Menues.empleadosOpcionCuatro();
        }
        if(e.getSource()== botonOpcion5){
            Menues.empleadosOpcionCinco();
        }
        if(e.getSource()== botonOpcion6){
            this.dispose();
        }

    }
    
}
