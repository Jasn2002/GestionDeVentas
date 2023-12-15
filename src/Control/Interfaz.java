package Control;

import Almacen.*;
import Articulos.Articulo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Interfaz {
    
    public void MostrarMensaje(String mensaje){
        JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
        frame.setLayout(new GridLayout(0, 1));
        frame.setMinimumSize(new Dimension(100, 100));

        String[] lines = mensaje.split("\n");

        for (String line : lines) {
            System.out.println(line);
            JLabel label = new JLabel(line);
            frame.add(label);
        }
        

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);

    }

    public void AgregarArticulo(){
        JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
        frame.setLayout(new GridLayout(6, 2));

        JTextField tfNombre = new JTextField();
        JTextField tfDescripcion = new JTextField();
        JTextField tfId = new JTextField();
        JTextField tfPrecio = new JTextField();
        JTextField tfCantidad = new JTextField();
        JLabel lb1 = new JLabel("Nombre");
        JLabel lb2 = new JLabel("Descripcion");
        JLabel lb3 = new JLabel("Id");
        JLabel lb4 = new JLabel("Precio");
        JLabel lb5 = new JLabel("Cantidad En Almacen");

        JButton boton = new JButton("Agregar");
        boton.addActionListener(e -> Almacen.RegistrarArticulo(tfNombre.getText(), tfDescripcion.getText(),
         new Integer(tfId.getText()), new Double(tfPrecio.getText()), new Integer(tfCantidad.getText())));

        frame.add(lb1);
        frame.add(tfNombre);
        frame.add(lb2);
        frame.add(tfDescripcion);
        frame.add(lb3);
        frame.add(tfId);
        frame.add(lb4);
        frame.add(tfPrecio);
        frame.add(lb5);
        frame.add(tfCantidad);
        frame.add(boton);   
        
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        
    }

    public void ComprarArticulo(){
        JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
        frame.setLayout(new GridLayout(2, 1));

        ArrayList<Articulo> listaArticulos = new Archivos().leerDatosArticulo();
        String articulos = "";
        for (Articulo articulo : listaArticulos) {
            articulos = articulos + articulo.getNombre() + "\n";
        }
        JComboBox comboBox = new JComboBox(articulos.split("\n"));

        JButton boton = new JButton("Comprar");
        boton.addActionListener(e -> GestorDeVentas.getCarrito().AñadirArticulo((String) comboBox.getSelectedItem()));
            

        frame.add(comboBox); 
        frame.add(boton);
        
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        
    }

}
