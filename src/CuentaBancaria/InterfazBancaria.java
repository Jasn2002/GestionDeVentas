package CuentaBancaria;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Control.Archivos;
import Control.GestorDeVentas;
import Control.Interfaz;

public class InterfazBancaria extends JFrame implements ActionListener{
    
 JButton botonOpcion1 = new JButton("Crear Cuenta");
    JButton botonOpcion2 = new JButton("Listar Cuentas");
    JButton botonOpcion3 = new JButton("Modificar Cuenta");
    JButton botonOpcion4 = new JButton("Eliminar Cuenta");

    public InterfazBancaria(){
    //FRAME SETUP
	this.setTitle("Gestor de Ventas - Cuentas");
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setResizable(false);
    this.setLayout(null);
	this.setSize(800, 600);

    JPanel mainPanel = new JPanel();
    mainPanel.setBounds(100, 100, 600, 400);
    mainPanel.setLayout(new GridLayout(2, 2));

    botonOpcion1.addActionListener(this);
    botonOpcion2.addActionListener(this);
    botonOpcion3.addActionListener(this);
    botonOpcion4.addActionListener(this);
    
    this.add(mainPanel);
    mainPanel.add(botonOpcion1);
    mainPanel.add(botonOpcion2);
    mainPanel.add(botonOpcion3);
    mainPanel.add(botonOpcion4);
    this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== botonOpcion1){
            AgregarCuenta();
        }
        if(e.getSource()== botonOpcion2){
            new GestorDeVentas().listarCuentas();
        }
        if(e.getSource()== botonOpcion3){
            String propietarioCuenta = JOptionPane.showInputDialog("Propietario de la cuenta a modificar: ");
            ModificarCuenta(propietarioCuenta);
        }
        if(e.getSource()== botonOpcion4){
            String p = JOptionPane.showInputDialog("Introduzca el propietario de la cuenta a eliminar");
            EliminarCuenta(p);
        }

    }

    public void AgregarCuenta(){
        JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
        frame.setLayout(new GridLayout(4, 2));

        JTextField tfPropietario = new JTextField();
        JTextField tfBalance = new JTextField();
        JTextField tfTipoDeCuenta = new JTextField();
        JLabel lb1 = new JLabel("Propietario");
        JLabel lb2 = new JLabel("Balance");
        JLabel lb3 = new JLabel("Tipo de Cuenta");

        JButton boton = new JButton("Agregar");
        boton.addActionListener(e -> RegistrarCuenta(tfPropietario.getText(), new Double(tfBalance.getText()), tfTipoDeCuenta.getText()));

        frame.add(lb1);
        frame.add(tfPropietario);
        frame.add(lb2);
        frame.add(tfBalance);
        frame.add(lb3);
        frame.add(tfTipoDeCuenta);
        frame.add(boton);   
        
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        
    }

    public void RegistrarCuenta(String propietario, double balance, String tipoDeCuenta){

        CuentaBancaria c;

        if (tipoDeCuenta.equals("MLC")){
            c = new CuentaMLC(propietario, balance);
        }   else {
            c = new CuentaBancaria(propietario, balance);
        }
            new Archivos().guardarDatos(c, false);
            new Interfaz().MostrarMensaje("Su cuenta ha sido creada");
    }

    public void EliminarCuenta(String propietario){
        
        ArrayList<CuentaBancaria> listaCuentas = new Archivos().leerDatosCuenta();

        for (CuentaBancaria cuentaBancaria : listaCuentas) {
            if (cuentaBancaria.getPropietario().equals(propietario)){
                listaCuentas.remove(cuentaBancaria);
                break;
            }
        }

        new Archivos().guardarLista(listaCuentas, false);

    }

    public void ModificarCuenta(String propietarioCuenta){

        
        CuentaBancaria cuenta = new CuentaBancaria("", 0);
        ArrayList<CuentaBancaria> listaCuentas = new Archivos().leerDatosCuenta();

        for (CuentaBancaria cuentaBancaria : listaCuentas) {
            if (cuentaBancaria.getPropietario().equals(propietarioCuenta)){
                cuenta = cuentaBancaria;
                listaCuentas.remove(cuentaBancaria);
                new Archivos().guardarLista(listaCuentas, false);
                break;
            }
        }

        JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
        frame.setLayout(new GridLayout(4, 2));

        JTextField tfPropietario = new JTextField(cuenta.getPropietario());
        JTextField tfBalance = new JTextField(String.valueOf(cuenta.getBalance()));
        String s = "";
        if (cuenta instanceof CuentaMLC){s = "MLC";} else {s = "CUP";}
        JTextField tfTipoDeCuenta = new JTextField(s);

        JLabel lb1 = new JLabel("Propietario");
        JLabel lb2 = new JLabel("Balance");
        JLabel lb3 = new JLabel("Tipo de Cuenta");

        JButton boton = new JButton("Modificar");
        boton.addActionListener(e -> RegistrarCuenta(tfPropietario.getText(), new Double(tfBalance.getText()), tfTipoDeCuenta.getText()));

        frame.add(lb1);
        frame.add(tfPropietario);
        frame.add(lb2);
        frame.add(tfBalance);
        frame.add(lb3);
        frame.add(tfTipoDeCuenta);
        frame.add(boton);   
        
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        
    }
    
}

