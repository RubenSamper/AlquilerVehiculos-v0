package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private static final String PATRON_FECHA = "dd/MM/yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);

	private Consola() {

	}

	public static void mostrarCabecera(String mensaje) {
		StringBuilder cabecera = new StringBuilder();
		cabecera.append("-");
		System.out.printf("%n%s%n", mensaje);
		for (int i = 0; i < mensaje.length(); i++) {
			System.out.print(cabecera);
		}
		System.out.println("");
	}

	public static void mostrarMenu() {
		mostrarCabecera("menú");
		for (int i = 0; i < Opcion.values().length; i++) {
			System.out.printf("%d.-%s %n", i, Opcion.values()[i]);
		}
	}

	private static String leerCadena(String mensaje) {
		System.out.print(mensaje);
		return Entrada.cadena();
	}

	private static Integer leerEntero(String mensaje) {
		System.out.print(mensaje);
		return Entrada.entero();
	}

	private static LocalDate leerFecha(String mensaje) {
		LocalDate aux = null;

		try {
			System.out.print(mensaje);
			aux = LocalDate.parse(Entrada.cadena(), FORMATO_FECHA);
		} catch (DateTimeParseException e) {
			System.out.println(e.getMessage());

		}
		return aux;
	}

	public static Opcion elegirOpcion() {
		int auxElegirOpcion = 0;

		do {
			auxElegirOpcion = leerEntero("Introduce una opción: ");
		} while (auxElegirOpcion < 0 && auxElegirOpcion > Opcion.values().length);

		return Opcion.values()[auxElegirOpcion];
	}

	public static Cliente leerCliente() {
		Cliente nuevoCliente = null;
		nuevoCliente = new Cliente(leerNombre(), leerCadena("Introduce un dni: "), leerTelefono());
		return nuevoCliente;

	}

	public static Cliente leerClienteDni() {
		return Cliente.getClienteConDni(leerCadena("Introduce un dni: "));

	}

	public static String leerNombre() {

		return leerCadena("Introduce un nombre: ");

	}

	public static String leerTelefono() {
		return leerCadena("Introduce un número de teléfono: ");

	}

	public static Turismo leerTurismo() {
		Turismo nuevoTurismo = null;
		nuevoTurismo = new Turismo(leerCadena("Introduce una marca: "), leerCadena("Introduce un modelo: "),
				leerEntero("Introduce una cilindrada: "), leerCadena("Introduce una matricula: "));
		return nuevoTurismo;

	}

	public static Turismo leerTurismoMatricula() {
		return Turismo.getTurismoConMatricula(leerCadena("Introduce una matricula: "));

	}

	public static Alquiler leerAlquiler() {
		Alquiler nuevoAlquiler = null;
		nuevoAlquiler = new Alquiler(leerClienteDni(), leerTurismoMatricula(),
				leerFecha("Introduce una fecha de alquiler: "));
		return nuevoAlquiler;

	}

	public static LocalDate leerFechaDevolucion() {
		return leerFecha("Introduce una fecha de devolución: ");

	}
}
