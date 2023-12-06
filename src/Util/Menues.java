package Util;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import Articulos.Carrito;
import Articulos.Stock;
import Usuario.*;

public class Menues {

	public static String username;

	public static void mostrarMensaje(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje, "" , JOptionPane.PLAIN_MESSAGE);
	}

	public static String mostrarMensajeEntrada(String mensaje){
		return JOptionPane.showInputDialog(mensaje).toString();
	}
	
	public static void crearUsuario(String nombre, String contrasenia, String tipoDeUsuario) {
		while( true) {
				if(tipoDeUsuario.toLowerCase().equals("empleado") || tipoDeUsuario.toLowerCase().equals("cliente")) {
					
					if(Usuarios.getInstance().agregarUsuario(nombre, contrasenia, tipoDeUsuario.toLowerCase(), 0)) {
						Usuarios.guardar();
			            System.out.println("\nRegistro exitoso.");
			            break;
					} else {
						System.out.println("Ya existe el usuario.");
						break;
					} 
		         }
		         else 
		             System.err.println("Opcion incorrecta, debe ingresar si es empleado o cliente");
					 break;
		} 
	}

	public static boolean iniciarSesion(String nombre, String contrasenia) {

			if(! Usuarios.getInstance().usuarioExistente(nombre)){
			System.out.println("Datos incorrectos, vuelva a intentarlo.");
			return false;
			}
			
			if (contrasenia.equals(Usuarios.getInstance().getUsuario(nombre).getContrasenia())) {
						return true;
				}

			return false;
			
		}
	
	public static void empleadosOpcionUno() {
		if(Stock.getInstance().getCantidadArticulosEnStock()>=1) {
			Stock.getInstance().verArticulos();
		} 
		else mostrarMensaje("No hay articulos");
	}
	
	public static void empleadosOpcionDos() {
		String codigo = mostrarMensajeEntrada("Ingrese el codigo del articulo: ");
		String nombreDeArticulo = mostrarMensajeEntrada("Ingrese el nombre del articulo: ");
		
		while(true) try {
		double precio = new Double(mostrarMensajeEntrada("Ingrese el precio del articulo: "));
		
		if (precio > 0) {
			
			System.out.print("Ingrese la cantidad de stock: ");
			int cantidad = new Integer(mostrarMensajeEntrada("Ingrese la cantidad de stock: "));
			if(cantidad>=0) {
				Stock.getInstance().add(codigo, nombreDeArticulo, precio, cantidad);
				Stock.guardar();
				mostrarMensaje("Articulo agregado."); break;
			}
			else if(cantidad<0) {
				mostrarMensaje("Cantidad incorrecta.");
				}
			} else mostrarMensaje("Valor incorrecto.");
		
	}catch(InputMismatchException e) {
			mostrarMensaje("\n\nDio un " + e +"El precio del articulo debe ser un valor numerico, elija una opcion:  ");break;
	}	
}

	public static void empleadosOpcionTres() {
		System.out.print("Ingrese el codigo del articulo a eliminar: ");
		String codigo = mostrarMensajeEntrada("Ingrese el codigo del articulo a eliminar: ");
		if (Stock.getInstance().getListaDeArticulos().containsKey(codigo)) {
			Stock.getInstance().empleadosOpcionTres(codigo);
			Stock.guardar();
			mostrarMensaje("Articulo eliminado exitosamente!");
		} else System.err.println("C�digo err�neo.");
	}
	
	/**
	 * Stock: ver cantidad, editar cantidad y volver al menu.
	 * */
	public static void empleadosOpcionCuatro() {
		while(true) {
			String opcionDos = mostrarMensajeEntrada("(1) Ver cantidad. " + " (2) Editar cantidad. " + " (3) Volver al men�.");
			
			if(opcionDos.equals("1")) {
				System.out.print("Ingrese codigo de articulo: ");
				String codigo = mostrarMensajeEntrada("Ingrese codigo de articulo: ");
				if (Stock.getInstance().getListaDeArticulos().containsKey(codigo)) {
				mostrarMensaje("\nNombre: " + Stock.getInstance().getListaDeArticulos().get(codigo).getNombreDescriptivo()
						+ ", cantidad: " + Stock.getInstance().verCantidad(codigo));
				}
				else mostrarMensaje("C�digo no valido");
			} 
			else if (opcionDos.equals("2")) {
                // opcion b editar la cantidad
                System.out.print("Ingrese codigo de articulo: ");
                String codigo = mostrarMensajeEntrada("Ingrese codigo de articulo: ");
                if (Stock.getInstance().getListaDeArticulos().containsKey(codigo)) {
                		
                	
                	
                	try {
                		System.out.print("Ingrese la cantidad: ");
                        int cantidadNueva = new Integer(mostrarMensajeEntrada("Ingrese la cantidad: "));
                		
                		 if(cantidadNueva>=0) {
                            Stock.getInstance().getListaDeArticulos().get(codigo).setCantidadDeArticulos(cantidadNueva);
                            Stock.guardar();
                            mostrarMensaje("Articulo modificado exitosamente\n");
                        }
                        else if(cantidadNueva<0) {
                            mostrarMensaje("Cantidad incorrecta");
                        }
               
                else {mostrarMensaje("C�digo no v�lido.");
                
                }
                
                	}catch (InputMismatchException ime){
                		mostrarMensaje("Error. Debe ingresar un valor numerico. \n");
                	}	
                	
                
                
                }
                	
                       
            
}
			else if(opcionDos.equals("3")) {
				
				break;
			}
			
			
		}
	}
	
	public static void empleadosOpcionCinco() {
		
		System.out.print("Ingrese codigo del articulo a editar: ");
		String codigo = mostrarMensajeEntrada("Ingrese codigo del articulo a editar: ");
		if(Stock.getInstance().getListaDeArticulos().containsKey(codigo)) {
			mostrarMensaje("Ingrese los nuevos datos: ");
			System.out.print("Nombre: ");
			String nombreNuevo = mostrarMensajeEntrada("Nombre: ");
			System.out.print("Precio: ");
			double precioNuevo = new Double(mostrarMensajeEntrada("Precio: "));
			
			if(precioNuevo > 0) {
				Stock.getInstance().getListaDeArticulos().get(codigo).setNombreDescriptivo(nombreNuevo);
				Stock.getInstance().getListaDeArticulos().get(codigo).setPrecio(precioNuevo);
				
				Stock.guardar();
			} else mostrarMensaje("Valor incorrecto.");
			
		} else mostrarMensaje("Codigo incorrecto.");
		
		
	}
	
	/**Agregar un articulo al carrito de compras*/
	public static void clientesOpcionDos() {
		
		while(true) {
			System.out.print("Ingrese codigo de articulo: ");
			String codigo = mostrarMensajeEntrada("Ingrese codigo de articulo: ");
			
			if(Stock.getInstance().getListaDeArticulos().containsKey(codigo)) {
				System.out.print("Ingrese la cantidad de articulos: ");
				int cantidad = new Integer(mostrarMensajeEntrada("Ingrese la cantidad de articulos: "));
				
				if(cantidad<0) {
					mostrarMensaje("La cantidad no puede ser negativa.");
					break;
				}
				
				if(Stock.getInstance().getListaDeArticulos().get(codigo).getCantidadDeArticulos() >= cantidad) {
					Carrito.getInstance().agregarArticulo(codigo, cantidad);
					mostrarMensaje("Articulos agregados exitosamente!\n");
					break;
				} else if (Stock.getInstance().getListaDeArticulos().get(codigo).getCantidadDeArticulos() == 0) {
					mostrarMensaje("Sin stock.");break;
				} else if (Stock.getInstance().getListaDeArticulos().get(codigo).getCantidadDeArticulos() < cantidad) {
					mostrarMensaje("Error. Cantidad disponible: " + Stock.getInstance().getListaDeArticulos().get(codigo).getCantidadDeArticulos());
					break;
					
				} 
			
			} else {
				mostrarMensaje("C�digo erroneo.");
				break;
				} 
		}
	}
	
	public static void clientesOpcionTres() {
		System.out.print("Ingrese el codigo del articulo a eliminar: ");
		String codigo = mostrarMensajeEntrada("Ingrese el codigo del articulo a eliminar: ");
		
		mostrarMensaje("\nArticulo eliminado del carrito!");
		
		if (Carrito.getInstance().getCarritoDeCompra().containsKey(codigo)) {
			Carrito.getInstance().removerArticulo(codigo);
		} else mostrarMensaje("Codigo err�neo.");
		
	}
	
	/**Ver los articulos del carrito.*/
	public static void clientesOpcionCuatro() {
		if(Carrito.getInstance().getCantidadArticulosEnCarrito() > 0) {
			
			Carrito.getInstance().verArticulosCarrito();
			
			mostrarMensaje("Total: " + String.format("%.2f", Carrito.getInstance().totalCarrito()));
		} 
		else Carrito.getInstance().verArticulosCarrito();
	}
	/**Confirma la compra y actualiza el stock. Puede abonarse con el saldo del modulo bancario.*/
	public static void clientesOpcionCinco() {
		
		String opcionDebito = mostrarMensajeEntrada("�Debitar de la cuenta? " + " (1) Si " + " (2) No");
				
		if(Carrito.getInstance().totalCarrito() <= 0) {	
			mostrarMensaje("No posee nada en el carrito");
		}
		else {
			if(opcionDebito.equals("1")) {
				double dineroUsuario = Usuarios.getInstance().getDiccionarioUsuarios().get(Menues.username).getCantidadDinero();
				if (Carrito.getInstance().totalCarrito() < dineroUsuario) {
					dineroUsuario -= Carrito.getInstance().totalCarrito();
					Usuarios.getInstance().getDiccionarioUsuarios().get(Menues.username).setCantidadDinero(dineroUsuario);
					Usuarios.guardar();
					Carrito.getInstance().confirmarCompra();
					mostrarMensaje("Compra realizada con �xito.");
				} 
				else  {
					mostrarMensaje("Saldo insuficiente.");
				}
			}
			else {
				Carrito.getInstance().confirmarCompra();
				mostrarMensaje("Compra realizada con �xito.");
			}
		}	
	}
	
	public static int clientesOpcionSiete() {
		int j=0;
		if (Carrito.getInstance().getCantidadArticulosEnCarrito() >= 1) {
			
			if (Menues.cerrarSesion()) {
				j=1;
			} 
		} else {j=1;}
		return j;
	}
	
	/**
	 * metodo para advertir al usuario de que no confirm� su compra.
	 * @return true si se desea cerrar y eliminar el carrito, false si desea continuar y confirmar compra.
	 * */
	public static boolean cerrarSesion() {
		boolean cerrar = true;
		
		if (Carrito.getInstance().getCantidadArticulosEnCarrito() >=1) {
			mostrarMensaje("Advertencia: si cierra sesi�n sin confirmar su compra el carrito se eliminar�.");
			//mostrarMensaje("1:Si \n2:No");
			
			int opcion = new Integer(mostrarMensajeEntrada("�Cerrar sesi�n de todos modos? " + " 1:Si \n2:No"));
			if (opcion==1) {
				Carrito.getInstance().getCarritoDeCompra().clear();
				mostrarMensaje("Gracias por utilizar nuestros servicios");
				cerrar = true;
			} else if (opcion==2) {
				cerrar = false;
			}else mostrarMensaje("Opcion incorrecta.");
		}
		
		return cerrar;
	}
	
	/**Todas las operaciones del modulo bancario.*/
	public static void moduloBancarioMenu() {
		String i = mostrarMensajeEntrada("Elija una opci�n " + " 1 - Agregar monto " + " 2 - Transferir dinero "
		 + " 3 - Retirar dinero " + " 4 - Ver saldo " + " 5 - Salir");

		 Modulo mod = new Modulo();
	     
			switch (i) {
				case "1": 
					mod.opcionUno();
					break;
				case "2":
					mod.opcionDos();
					break;
				case "3":
					mod.opcionTres();
					break;
				case "4":
					mod.opcionCuatro();
					break;
				case "5":
					break;
				default: mostrarMensaje("La opcion ingresada es incorrecta. Ingrese un numero del 1 al 5. ");	
			}
		
 	
	}
	
}