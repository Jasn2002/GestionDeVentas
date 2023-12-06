package Programa;

import Articulos.*;
import Vista.*;
import Usuario.*;

public class Main {

	public static void main(String[] args) {
		/* INICIO CARRITO, CARGAR STOCK, INICIO SCANNER, INICIO-CARGA USUARIOS, INICIO CONTADOR BUCLE (MENU EMPELADOS), INICIO MODULO BANCARIO (CLIENTES) */
		Carrito.getInstance();
		Stock.cargar();
		Usuarios.cargar();

		new Login();

	}
}
