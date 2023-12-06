package Usuario;


import java.util.InputMismatchException;

import Util.Menues;

public class Modulo {
	
	private double cantidadDinero = 0;
	

	/**
	 * Agregar saldo a la cuenta: Ingresa la cantidad que desea agregar a la cuenta y �ste se agrega solo si el monto es mayor a cero.
	 * Una vez agregado el saldo, se actualiza el archivo Usuarios.txt 
	 * @param sc Scanner
	 * */
	public void opcionUno() {
		try { 
		System.out.println("Ingrese la cantidad que desea agregar en su cuenta: ");
		double ingreso = new Double(Menues.mostrarMensajeEntrada("Ingrese la cantidad que desea agregar en su cuenta: "));
		cantidadDinero = Usuarios.getInstance().getDiccionarioUsuarios().get(Menues.username).getCantidadDinero();
	    Menues.mostrarMensaje("Monto agregado exitosamente!");
		
		if (ingreso > 0) {
			cantidadDinero += ingreso;
			Usuarios.getInstance().getUsuario(Menues.username).setCantidadDinero(cantidadDinero);
			Usuarios.guardar();
		} else Menues.mostrarMensaje("El monto ingresado es inv�lido.");
		
	}catch(InputMismatchException e) {
	
		
		
		Menues.mostrarMensaje("\n\nDio un " + e +" Debe ingresar datos numericos, elija una opcion:  " );
	}
		
	
	}
	
	
		
	
	
	/**
	 * Transferencia de dinero: ingresa la cantidad a transferir y el nombre del destinatario. Lleva a cabo la transaccion solo si 
	 * la cantidad a transferir es mayor a cero y menor o igual al saldo del usuario. 
	 * @param sc Scanner
	 * */
	public void opcionDos () {
		
		cantidadDinero = Usuarios.getInstance().getDiccionarioUsuarios().get(Menues.username).getCantidadDinero();
		
		System.out.print("Ingrese la cantidad que desea transferir: ");
		double cantidadTransferencia = new Double(Menues.mostrarMensajeEntrada("Ingrese la cantidad que desea transferir: "));
		System.out.print("Ingrese el nombre del destinatario: ");
		String nombre = Menues.mostrarMensajeEntrada("Ingrese el nombre del destinatario: ");
		
		if(cantidadTransferencia > 0 && cantidadTransferencia <= cantidadDinero) {
			Usuarios.getInstance().transferencia(cantidadTransferencia, nombre);
			Menues.mostrarMensaje("Transferencia Exitosa!");
		} else if (cantidadTransferencia > cantidadDinero) {
			Menues.mostrarMensaje("Saldo insuficiente");
		} else Menues.mostrarMensaje("El monto ingresado es inv�lido.");
		
	}
	
	
	/**
	 * Retirar dinero de la cuenta. Se ingresa la cantidad de dinero que el usuario desea retira, y se lleva a cabo solo si el monto a retirar 
	 * es menor o igual al saldo de la cuenta, y si es mayor a 0.
	 * @param sc Scanner
	 * */
	public void opcionTres () {

		System.out.println("Ingrese la cantidad que desea retirar de su cuenta: ");
		double retiro = new Double(Menues.mostrarMensajeEntrada("Ingrese la cantidad que desea retirar de su cuenta: "));
		cantidadDinero = Usuarios.getInstance().getDiccionarioUsuarios().get(Menues.username).getCantidadDinero();
		if (retiro > 0 && retiro <= cantidadDinero ) {	
			cantidadDinero -= retiro;
			Usuarios.getInstance().getUsuario(Menues.username).setCantidadDinero(cantidadDinero);
			Usuarios.guardar();
			Menues.mostrarMensaje("Retiro exitoso!, su saldo en cuenta es: "+cantidadDinero);
		}else if (retiro > cantidadDinero) {
			Menues.mostrarMensaje("Saldo insuficiente.");
		}
		else{
			Menues.mostrarMensaje("No puede retirar una cantidad negativa. ");
		}
		
		
	}
	
	/**
	 * Devuelve el saldo del usuario logueado en el banco.
	 * */
	public void opcionCuatro() {
		Menues.mostrarMensaje("Saldo: " + Usuarios.getInstance().getDiccionarioUsuarios().get(Menues.username).getCantidadDinero());
	}
	
		
}
