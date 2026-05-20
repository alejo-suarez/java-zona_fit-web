package js.zona_fit;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import js.zona_fit.modelo.Cliente;
import js.zona_fit.servicio.IClienteServicio;
//@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner{
			//private static final String ZonaFitApplication = null;
			@Autowired
			private IClienteServicio clienteServicio;
			private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);
			String ln = System.lineSeparator();
			public static void main(String[] args) {
						logger.info("Iniciacion de la Aplicacion");
						SpringApplication.run(ZonaFitApplication.class, args);
						logger.info("Aplicacion Finalizada...");
			}

			@Override
			public void run(String...args) throws Exception{
						zonaFitApp();
			}

			private void zonaFitApp() {
						boolean salir = false;
						var consola = new Scanner(System.in);
						while (!salir) {
							    var opcion = mostrarMenu(consola);
								salir = ejecutarOpciones(consola , opcion);
								logger.info(ln);
						}
			}

//Mostrar Menu:
			private int mostrarMenu(Scanner consola) {
						logger.info("""
								
									\n***Zona Fit (GYM)***
											1. Listar Clientes
											2. Buscar Cliente por id
											3. Agregar Cliente
											4. Modificar Cliente
											5. Eliminar Cliente
											6. Salir
												Marque una opción: \s """);
						return Integer.parseInt(consola.nextLine());
			}

//Ejecutar opciones:
			private boolean ejecutarOpciones (Scanner consola, int opcion) {
				boolean salir = false ;
						switch (opcion) {
//Listar Clientes:
								case 1 -> {
													logger.info(ln+"---Listado de Clientes:  ---"+ln);
													List<Cliente>clientes = clienteServicio.listarClientes();
													clientes.forEach(cliente -> logger.info(cliente.toString()+ln));
									}
//Buscar Cliente:
									case 2 -> {
													logger.info("Ingrese id del Cliente:   ");
													var idCliente = Integer.parseInt(consola.nextLine());
													Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
													if (cliente != null) {
														logger.info("Cliente Encontrado:  " + cliente + ln );
													} else {
														logger.info("Cliente no encontrado...." + idCliente+ln);
													}
									}				
//Agregar Cliente:
									case 3 -> {
													logger.info("Agregar Cliente"+ ln);
													logger.info("Ingrese nombre del cliente:  " );
													var nombre = consola.nextLine();
													logger.info("Ingrese Apellido del Cliente:  ");
													var apellido = consola.nextLine();
													logger.info("Ingrese numero de membresia del cliente: ");
													int membresia =Integer.parseInt(consola.nextLine());
													var cliente = new Cliente();
															cliente.setNombre(nombre);
															cliente.setApellido(apellido);
															cliente.setMembresia(membresia);
															clienteServicio.guardarCliente(cliente);
															logger.info("Cliente agregado "+ cliente);
									}
//Modificar Cliente:
									case 4 -> {
													logger.info("Modificar Cliente:  ");
													logger.info("Ingrese id del cliente a modificar:  ");
													var clienteId = Integer.parseInt(consola.nextLine());
													Cliente cliente = clienteServicio.buscarClientePorId(clienteId);
													if (cliente !=null) {
																logger.info("Ingrese nombre:  ");
																var nombre = consola.nextLine();
																logger.info("Ingrese Apellido: ");
																var apellido = consola.nextLine();
																logger.info("Ingrese numero de  membresia: " );
																var membresia = Integer.parseInt(consola.nextLine());
																cliente.setNombre(nombre);
																cliente.setApellido(apellido);
																cliente.setMembresia(membresia);
																clienteServicio.guardarCliente(cliente);
																logger.info("Cliente modificado..." );
													} else
																	logger.info("Cliente NO modificado..." + ln);
													}
//Eliminar Cliente:
									case 5 -> {
													logger.info("Eliminar Cliente:  ");
													logger.info("Ingrese id del cliente a eliminar:  ");
													var idCliente = Integer.parseInt(consola.nextLine());
													Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
													if(cliente !=null) {
																clienteServicio.eliminarCliente(cliente);
																logger.info("Cliente Eliminado..." + cliente+ln);
													}else
																logger.info("Cliente NO eliminado..." + cliente+ln);
									}
//Salir del programa:
									case 6 ->{
													logger.info("Hasta luego usuario......"+ln+ln);
													salir = true;
									}
									default -> logger.info("Opcion invalida, intente otra opción: " + opcion + ln);
						}
						return salir;
		}
}




