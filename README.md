# Proyecto Gestion De Ventas

## Datos Generales:
Este es el Proyecto Final de la asignatura Diseño y Programacion Orientada a Objetos del segundo semestre de la carrera Ingenieria Informatica en la Universidad de Matanzas.El objetivo de este Proyecto es dessarrollar un Software que permita la gestión de ventas con el propósito de poder modernizar, facilitar y mejorar la gestión de los procesos de ventas, compras, producción, área de logística y finanzas.

  ## Lenguaje, Arquitectura y Metodología: 
  Para la realización del diagrama UML se utilizaron:
  - la extension de Vscode: PlantUML v2.17.5
  - el lenguaje de desarrollo java 17.0.5 
  - el IDE de desarrollo Vscode v 1.81.1 con las extensiones:

    Project Manager for Java v0.23.1

    Debugger for Java v0.54.0

    Language Support for Java(TM) by Red Hat v1.13.0
 
 ## Uso y Guia Basica

 Al inicializar el programa se necesita comprobar su identidad con un Usuario y Contraseña previamente acordado en el negocio, luego de iniciar sesion entramos a la ventana principal, cuyas opciones varían dependiendo del tipo de usuario que está utilizando el servicio ( sea empleado o cliente). Existe ademas la posibilidad de ingresar a la aplicacion como administrador, dando acceso al personal calificado a más opciones para la administracion del programa.

  
 ## Colaboradores:
 * Jorge Luis Díaz
 * Jose Javier Santana
 * Jennifer Saguñola
 * Neirel Domínguez
 * Jose Alejandro Sosa
 
 ## Descripcion individual de los modulos de los colaboradores

 ### Jorge Luis Díaz

 La clase "Almacen" se encarga de llevar una lista de los productos disponibles para la venta. Por otro lado la clase "Carrito" lleva una lista que se vacia luego de cada compra, a la que los clientes pueden agregar los productos que deseen comprar antes de confirmar la operación.
 
 
 ### Jose Javier Santana
 
 La clase "Artículos" sirve como una representacion de los productos en venta y cuenta con un numero de serie para una mejor identificacion asi como un nombre descriptivo que ayuda al cliente a reconocerlo. se almacena en estos objetos, ademas, el precio de los mismos asi como la cantidad de productos disponibles en el almacen.
 Esta clase puede ser ampliada mediante la herencia, como podemos ver en el ejemplo de "Calzado" al que se agrega un nuevo atributo.
 
 ### Jennifer Saguñola

  La clase "Usuarios" es una clase que cumple con la funcion de almacenar la informacion del personal registrado en la aplicacion, ya sean clientes o empleados. Se asegura en la misma que el nombre sea único para cada cuenta.
 
 
### Neirel Domínguez

  La clase "Compra" procesa y almacena la información relacionada a la operacion de comprar los articulos. Ademas es parte de su funcionalidad la de crear registros que se almacenan en la aplicacion para su posterior consulta.

  ### Jose Alejandro Sosa

  La clase "CuentaBancaria" se encarga de gestionar el presupuesto con el que cuenta cada cliente. Se asegura que cada usuario tenga una unica cuenta. Esta permite realizar operaciones de ingreso de capital asi como su sustraccion para realizar las compras. Es posible ampliar su utilidad para diferentes tipos de moneda, como se puede observar en el ejemplo "CuentaMLC". El programa permite al administrador del mismo crear, modificar y eliminar las cuentas de cada usuario, asi como llevar un listado de todas las existentes.


 


