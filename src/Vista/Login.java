package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
//import javax.swing.border.Border;
import javax.swing.JTextField;

import Control.GestorDeVentas;

public class Login extends JFrame implements ActionListener{

    JButton botonRegistrarse = new JButton();
    JButton botonLogIn = new JButton();

    JRadioButton botonEmpleado = new JRadioButton("Empleado");
    JRadioButton botonCliente = new JRadioButton("Cliente");

    JTextField passwordTextField = new JTextField();
    JTextField usuarioTextField = new JTextField();

    String tipoDeUsuario = "";
    
    GestorDeVentas g = new GestorDeVentas();

    public Login(){
		//FRAME SETUP
		this.setTitle("Gestor de Ventas - Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
        this.setLayout(null);
		this.setSize(800, 600);

        ButtonGroup group = new ButtonGroup();
        botonEmpleado.addActionListener(this);
        group.add(botonEmpleado);
        botonCliente.addActionListener(this);
        group.add(botonCliente);

        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Color.WHITE);
        loginPanel.setLayout(new GridLayout(0, 1));
        loginPanel.setBorder(BorderFactory.createEtchedBorder());
        loginPanel.setBounds(100, 150, 400, 200);

        JLabel loginLabel = new JLabel("LOGIN");
        loginLabel.setForeground(Color.BLUE);
        loginLabel.setFont(new Font("Mv Boli", Font.PLAIN, 70));
        //loginLabel.setBackground(Color.LIGHT_GRAY);
        loginLabel.setOpaque(true);
        //loginLabel.setBorder(border);
        loginLabel.setVerticalAlignment(JLabel.TOP);
        loginLabel.setHorizontalAlignment(JLabel.CENTER);
        loginLabel.setBounds(100, 50, 400, 100);

        usuarioTextField.setPreferredSize(new Dimension(150, 40));
        usuarioTextField.setText("Usuario");

        passwordTextField.setPreferredSize(new Dimension(150, 40));
        passwordTextField.setText("Contraseña");

        //botonRegistrarse.setBounds(175, 100, 200, 50);
        botonRegistrarse.setText("Registrarse");
        botonRegistrarse.setVerticalAlignment(JButton.CENTER);
        botonRegistrarse.addActionListener(this);

        //botonLogIn.setBounds(175, 200, 200, 50);
        botonLogIn.setText("Login");
        botonLogIn.setVerticalAlignment(JButton.CENTER);
        botonLogIn.addActionListener(this);

        this.add(loginPanel);
        this.add(loginLabel);
        loginPanel.add(usuarioTextField);
        loginPanel.add(passwordTextField);
        loginPanel.add(botonCliente);
        loginPanel.add(botonEmpleado);
        loginPanel.add(botonRegistrarse);
        loginPanel.add(botonLogIn);
        //this.pack();
		this.setVisible(true);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);

    }  

     @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== botonCliente){
            this.tipoDeUsuario = "Cliente";
            //System.out.println(tipoDeUsuario);
        }
        if(e.getSource()== botonEmpleado){
           this.tipoDeUsuario = "Empleado";
           //System.out.println(tipoDeUsuario);
        }
        if(e.getSource()== botonRegistrarse){
            boolean esCliente = false;
            if (tipoDeUsuario == "Cliente"){esCliente = true;}
            g.RegistrarUsuario(usuarioTextField.getText(), passwordTextField.getText(), esCliente);
            //this.dispose();
        }
        
        if(e.getSource()== botonLogIn){
            //System.out.println(usuarioTextField.getText() +" "+ passwordTextField.getText());
            if(g.Login(usuarioTextField.getText(), passwordTextField.getText())) this.dispose();
        }
    }

}
