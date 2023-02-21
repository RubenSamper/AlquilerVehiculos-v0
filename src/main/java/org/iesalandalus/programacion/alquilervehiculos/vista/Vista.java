package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Vista {

	private Controlador controlador;

	public void setControlador(Controlador controlador) {
		if (controlador == null) {
			throw new NullPointerException("ERROR: El controlador no puede ser nulo.");
		}
		this.controlador = controlador;
	}

	public void comenzar() {
		Opcion aux;
		do {
			Consola.mostrarMenu();
			aux = Consola.elegirOpcion();

			Ejecutar(aux);

		} while (aux != Opcion.SALIR);
	}

	public void terminar() {
		System.out.println("¡Hasta luego!");
	}

	private void Ejecutar(Opcion opcion) {
		switch (opcion.ordinal()) {
		case 0:
			System.out.printf("%nHa sido elegida la opción 0.");
			controlador.terminar();
		case 1:
			System.out.printf("%nHa sido elegida la opción 1:");
			insertarCliente();
			break;
		case 2:
			System.out.printf("%nHa sido elegida la opción 2: ");
			insertarTurismo();
			break;
		case 3:
			System.out.printf("%nHa sido elegida la opción 3: ");
			insertaAlquiler();
			break;
		case 4:
			System.out.printf("%nHa sido elegida la opción 4: ");
			buscarCliente();
			break;
		case 5:
			System.out.printf("%nHa sido elegida la opción 5: ");
			buscarTurismo();
			break;
		case 6:
			System.out.printf("%nHa sido elegida la opción 6: ");
			buscarAlquiler();
			break;
		case 7:
			System.out.printf("%nHa sido elegida la opción 7: ");
			modificarCliente();
			break;
		case 8:
			System.out.printf("%nHa sido elegida la opción 8: ");
			devolverAlquiler();
			break;
		case 9:
			System.out.printf("%nHa sido elegida la opción 9: ");
			borrarCliente();
			break;
		case 10:
			System.out.printf("%nHa sido elegida la opción 10: ");
			borrarTurismo();
			break;
		case 11:
			System.out.printf("%nHa sido elegida la opción 11: ");
			borrarAlquiler();
			break;
		case 12:
			System.out.printf("%nHa sido elegida la opción 12: ");
			listarClientes();
			break;
		case 13:
			System.out.printf("%nHa sido elegida la opción 13: ");
			listarTurismos();
			break;
		case 14:
			System.out.printf("%nHa sido elegida la opción 14: ");
			listarAlquileres();
			break;
		case 15:
			System.out.printf("%nHa sido elegida la opción 15: ");
			listarAlquileresCliente();
			break;
		case 16:
			System.out.printf("%nHa sido elegida la opción 16: ");
			listarAlquileresTurismo();
			break;
		}

	}

	public void insertarCliente() {
		Consola.mostrarCabecera("Insertar clientes");
		try {
			controlador.insertar(Consola.leerCliente());
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
		System.out.println("Se ha insertado el cliente");

	}

	public void insertarTurismo() {
		Consola.mostrarCabecera("Insertar turismo");
		try {
			controlador.insertar(Consola.leerTurismo());
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}

		System.out.println("Se ha insertado un turismo.");
	}

	public void insertaAlquiler() {
		Consola.mostrarCabecera("Insertar alquiler.");
		try {
			controlador.insertar(Consola.leerAlquiler());
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("Se ha insertado un alquiler.");
	}

	public void buscarCliente() {
		Consola.mostrarCabecera("Buscar cliente");
		try {
			controlador.buscar(Consola.leerCliente());
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
	}

	public void buscarTurismo() {
		Consola.mostrarCabecera("Buscar turismo");
		try {
			controlador.buscar(Consola.leerTurismo());
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
	}

	public void buscarAlquiler() {
		Consola.mostrarCabecera("Buscar alquiler");
		try {
			controlador.buscar(Consola.leerAlquiler());
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}

		System.out.println("Se ha buscado el cliente.");
	}

	public void modificarCliente() {
		Consola.mostrarCabecera("Modificar cliente");

		try {
			controlador.modificar(Consola.leerCliente(), Consola.leerNombre(), Consola.leerTelefono());
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
		System.out.println("Se ha modificado el cliente.");
	}

	public void devolverAlquiler() {
		Consola.mostrarCabecera("Devolver alquiler");

		try {
			controlador.devolver(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
		System.out.println("Se ha devuelto el alquiler.");
	}

	public void borrarCliente() {
		Consola.mostrarCabecera("Borrar cliente");
		try {
			controlador.borrar(Consola.leerCliente());
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
		System.out.println("Se ha borrado el cliente.");
	}

	public void borrarTurismo() {
		Consola.mostrarCabecera("Borrar turismo");
		try {
			controlador.borrar(Consola.leerTurismo());
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
		System.out.println("Se ha borrado el turismo.");
	}

	public void borrarAlquiler() {
		Consola.mostrarCabecera("Borrar alquiler");
		try {
			controlador.buscar(Consola.leerAlquiler());
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
		System.out.println("Se ha borrado el alquiler.");
	}

	private void listarClientes() {
		Consola.mostrarCabecera("Listar clientes");
		try {
			for (Cliente aux : controlador.getClientes()) {
				System.out.println(aux);
			}
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
		System.out.println("se ha listado los clientes.");
	}

	private void listarTurismos() {
		Consola.mostrarCabecera("Listar turismos");
		try {
			for (Turismo aux : controlador.getTurismos()) {
				System.out.println(aux);
			}
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
		System.out.println("Se han listado los turismos.");

	}

	private void listarAlquileres() {
		Consola.mostrarCabecera("Listar alquileres");
		try {
			for (Alquiler aux : controlador.getAlquileres()) {
				System.out.println(aux);
			}
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
		System.out.println("Se han listado los alquileres");

	}

	private void listarAlquileresCliente() {
		Consola.mostrarCabecera("Listar alquileres clientes");
		try {
			for (Alquiler aux : controlador.getAlquileres(Consola.leerCliente())) {
				System.out.println(aux);
			}
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
		System.out.println("Se ha listado los alquileres de clientes.");

	}

	private void listarAlquileresTurismo() {
		Consola.mostrarCabecera("Listar alquileres turismo");
		try {
			for (Alquiler aux : controlador.getAlquileres(Consola.leerTurismo())) {
				System.out.println(aux);
			}
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Se ha listado los alquileres de turismos.");
	}
}