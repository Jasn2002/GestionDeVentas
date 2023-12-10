package Util;


import java.util.InputMismatchException;

import Usuario.Usuarios;

public class Modulo extends Menues {
	
	private double cantidadDinero = 0;
	
	public void opcionUno() {
		try { 
		System.out.println("Ingrese la cantidad que desea agregar en su cuenta: ");
		double ingreso = new Double(Menues.mostrarMensajeEntrada("Ingrese la cantidad que desea agregar en su cuenta: "));
		cantidadDinero = Usuarios.getInstance().getDiccionarioUsuarios().get(Menues.username).getCantidadDinero();
	    mostrarMensaje("Monto agregado exitosamente!");
		
		if (ingreso > 0) {
			cantidadDinero += ingreso;
			Usuarios.getInstance().getUsuario(username).setCantidadDinero(cantidadDinero);
			Usuarios.guardar();
		} else mostrarMensaje("El monto ingresado es inv�lido.");
		
	}catch(InputMismatchException e) {
	
		
		
		mostrarMensaje("\n\nDio un " + e +" Debe ingresar datos numericos, elija una opcion:  " );
	}
		
	
	}
	
	public void opcionDos () {
		
		cantidadDinero = Usuarios.getInstance().getDiccionarioUsuarios().get(username).getCantidadDinero();
		
		System.out.print("Ingrese la cantidad que desea transferir: ");
		double cantidadTransferencia = new Double(mostrarMensajeEntrada("Ingrese la cantidad que desea transferir: "));
		System.out.print("Ingrese el nombre del destinatario: ");
		String nombre = mostrarMensajeEntrada("Ingrese el nombre del destinatario: ");
		
		if(cantidadTransferencia > 0 && cantidadTransferencia <= cantidadDinero) {
			Usuarios.getInstance().transferencia(cantidadTransferencia, nombre);
			mostrarMensaje("Transferencia Exitosa!");
		} else if (cantidadTransferencia > cantidadDinero) {
			mostrarMensaje("Saldo insuficiente");
		} else mostrarMensaje("El monto ingresado es inv�lido.");
		
	}
	
	public void opcionTres () {

		System.out.println("Ingrese la cantidad que desea retirar de su cuenta: ");
		double retiro = new Double(mostrarMensajeEntrada("Ingrese la cantidad que desea retirar de su cuenta: "));
		cantidadDinero = Usuarios.getInstance().getDiccionarioUsuarios().get(username).getCantidadDinero();
		if (retiro > 0 && retiro <= cantidadDinero ) {	
			cantidadDinero -= retiro;
			Usuarios.getInstance().getUsuario(username).setCantidadDinero(cantidadDinero);
			Usuarios.guardar();
			mostrarMensaje("Retiro exitoso!, su saldo en cuenta es: "+cantidadDinero);
		}else if (retiro > cantidadDinero) {
			mostrarMensaje("Saldo insuficiente.");
		}
		else{
			mostrarMensaje("No puede retirar una cantidad negativa. ");
		}
		
		
	}
	
	public void opcionCuatro() {
		mostrarMensaje("Saldo: " + Usuarios.getInstance().getDiccionarioUsuarios().get(username).getCantidadDinero());
	}
	
		
}
