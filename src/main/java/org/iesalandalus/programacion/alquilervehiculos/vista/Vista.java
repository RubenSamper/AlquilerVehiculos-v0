package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;

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
		do {
			Consola.mostrarMenu();
			Ejecutar(Consola.elegirOpcion());

		} while (Consola.elegirOpcion() == null);
	}

	public void terminar() {
		System.out.println("¡Hasta luego!");
	}

	private void Ejecutar(Opcion opcion) {
		switch (opcion.ordinal()) {
		case 0:
			System.out.println("Ha sido elegida la opción 0.");

		case 1:
			System.out.println("Ha sido elegida la opción 1.");
			insertarCliente();
			break;
		case 2:
			System.out.println("Ha sido elegida la opción 2.");
			insertarTurismo();
			break;
		case 3:
			System.out.println("Ha sido elegida la opción 3.");
			insertaAlquiler();
			break;
		case 4:
			System.out.println("Ha sido elegida la opción 4.");
			buscarCliente();
			break;
		case 5:
			System.out.println("Ha sido elegida la opción 5.");
			buscarTurismo();
			break;
		case 6:
			System.out.println("Ha sido elegida la opción 6.");
			buscarAlquiler();
			break;
		case 7:
			System.out.println("Ha sido elegida la opción 7.");
			modificarCliente();
			break;
		case 8:
			System.out.println("Ha sido elegida la opción 8.");
			devolverAlquiler();
			break;
		case 9:
			System.out.println("Ha sido elegida la opción 9.");
			borrarCliente();
			break;
		case 10:
			System.out.println("Ha sido elegida la opción 10.");
			borrarTurismo();
			break;
		case 11:
			System.out.println("Ha sido elegida la opción 11.");
			borrarAlquiler();
			break;
		case 12:
			System.out.println("Ha sido elegida la opción 12.");
			listarClientes();
			break;
		case 13:
			System.out.println("Ha sido elegida la opción 13.");
			listarTurismos();
			break;
		case 14:
			System.out.println("Ha sido elegida la opción 14.");
			listarAlquileres();
			break;
		case 15:
			System.out.println("Ha sido elegida la opción 15.");
			listarAlquileresCliente();
			break;
		case 16:
			System.out.println("Ha sido elegida la opción 16.");
			listarAlquileresTurismo();
			break;
		}

	}

	public void insertarCliente() {
		Consola.mostrarCabecera("Insertar clientes");
	}

	public void insertarTurismo() {
		Consola.mostrarCabecera("Insertar turismo");

	}

	public void insertaAlquiler() {
		Consola.mostrarCabecera("Insertar alquiler");

	}

	public void buscarCliente() {
		Consola.mostrarCabecera("Buscar cliente");
	}

	public void buscarTurismo() {
		Consola.mostrarCabecera("Buscar turismo");

	}

	public void buscarAlquiler() {
		Consola.mostrarCabecera("Buscar alquiler");
	}

	public void modificarCliente() {
		Consola.mostrarCabecera("Modificar cliente");

	}

	public void devolverAlquiler() {
		Consola.mostrarCabecera("Devolver alquiler");

	}

	public void borrarCliente() {
		Consola.mostrarCabecera("Borrar cliente");

	}

	public void borrarTurismo() {
		Consola.mostrarCabecera("Borrar turismo");

	}

	public void borrarAlquiler() {
		Consola.mostrarCabecera("Borrar alquiler");

	}

	private void listarClientes() {
		Consola.mostrarCabecera("Listar clientes");

	}

	private void listarTurismos() {
		Consola.mostrarCabecera("Listar turismos");

	}

	private void listarAlquileres() {
		Consola.mostrarCabecera("Listar alquileres");

	}

	private void listarAlquileresCliente() {
		Consola.mostrarCabecera("Listar alquileres clientes");

	}

	private void listarAlquileresTurismo() {
		Consola.mostrarCabecera("Listar alquileres turismo");

	}
}