# Proyecto Gestion De Ventas

## Datos Generales:
Este es el Proyecto Final de la asignatura Diseño y Programacion Orientada a Objetos del segundo semestre de la carrera Ingenieria Informatica en la Universidad de Matanzas.El objetivo de este Proyecto es dessarrollar un Software que permita la gestión de ventas con el propósito de poder modernizar, facilitar y mejorar a la empresa Meitor para la gestión en sus procesos de ventas, compras, producción, área de logística y finanzas

  ## Lenguaje, Arquitectura y Metodología: 
  Para la realización del diagrama UML se utilizaron:
  - la extension de Vscode: PlantUML v2.17.5
  - el lenguaje de desarrollo java 17.0.5 
  - el IDE de desarrollo Vscode v 1.81.1 con las extensiones:

    Project Manager for Java v0.23.1

    Debugger for Java v0.54.0

    Language Support for Java(TM) by Red Hat v1.13.0
 
 ## Uso y Guia Basica

 Al inicializar el programa se necesita comprobar su identidad con un Usuario y Contraseña previamente acordado en el negocio, luego de iniciar sesion entramos a la ventana principal, cuyas opciones varían dependiendo del tipo de usuario que está utilizando el servicio ( sea empleado o cliente). 

  
 ## Colaboradores:
 * Jorge Luis Díaz
 * Jose Javier Santana
 * Jennifer Saguñola
 * Neirel Domínguez
 * Jose Alejandro Sosa
 
 ## Descripcion individual de los modulos de los colaboradores

 ### Jorge Luis Díaz

 La clase "Carrito" permite almacenar los articulos que el usuario elija para su compra y guardarlos en una lista que debe ser confirmada por dicho usuario para su compra o descartada en caso de cerrar la aplicacion. Esta clase permite añadir, modificar o eliminar los articulos presentes en la lista.
 
 
 ### Jose Javier Santana
 
 La clase "Artículos" sirve como una representacion de los productos en venta y cuenta con un numero de serie para una mejor identificacion asi como un nombre descriptivo que ayuda al cliente a reconocerlo. se almacena en estos objetos, ademas, el precio de los mismos asi como la cantidad de productos disponibles en el almacen.
 
 ### Jennifer Saguñola

  La clase "Usuarios" es una clase global que cumple con la funcion ed gestionar los usuarios registrados en la aplicacion, ya sean clientes o empleados. Contiene un nombre y contraseña unicos asi como el tipo de usuario en cuestion. Es parte de su funcionalidad ademas el guardar dicha informacion en un archivo, asi como cargarla al iniciar la aplicacion.
 
 
### Neirel Domínguez

  La clase "Stock" es una clase global que se encarga de llevar la lista de los articulos que hay disponibles para su compra, asi como guardar y cargar esta informacion cuando sea necesario. Dentro de su funcionalidad permite agregar nuevos articulos, modificar la cantidad de los ya existentes o eliminarlos de la lista.

  ### Jose Alejandro Sosa

  La clase "Menues" se encarga de enlazar la parte visual de la aplicacion a la funcionalidad de la misma, valiendose de metodos especificos para cada opcion que tiene a disposicion el usuario, ya sea este empleado o cliente. Cuenta ademas con una clase hija (Modulo) que se encarga de gestionar el modulo bancario mediante el cual se realizan operaciones relacionadas con la cuenta bancaria de cada cliente.


 


