package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Alquiler {

	private Cliente cliente;
	private Turismo turismo;

	static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int PRECIO_DIA = 20;

	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;

	public Alquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) {
		setCliente(cliente);
		setTurismo(turismo);
		setFechaAlquiler(fechaAlquiler);
	}

	public Alquiler(Alquiler alquiler) {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
		}
		setCliente(new Cliente(alquiler.getCliente()));
		setTurismo(new Turismo(alquiler.getTurismo()));
		setFechaAlquiler(alquiler.getFechaAlquiler());
		setFechaDevolucion(alquiler.getFechaDevolucion());

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		}
		this.cliente = cliente;
	}

	public Turismo getTurismo() {
		return turismo;
	}

	public void setTurismo(Turismo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
		}
		this.turismo = turismo;
	}

	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(LocalDate fechaAlquiler) {
		if (fechaAlquiler == null) {
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		}
		if (fechaAlquiler.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
		}
		this.fechaAlquiler = fechaAlquiler;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		if (fechaDevolucion == null) {
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		}
		if (fechaDevolucion.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
		}
		if (fechaDevolucion.isBefore(getFechaAlquiler()) || fechaDevolucion.isEqual(getFechaAlquiler())) {
			throw new IllegalArgumentException(
					"ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
		}
		this.fechaDevolucion = fechaDevolucion;
	}

	public void devolver(LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (getFechaDevolucion() != null) {
			throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada.");
		}

		setFechaDevolucion(fechaDevolucion);
	}

	public int getPrecio() {
		int coste;
		if (getFechaDevolucion() == null) {
			coste = 0;
		} else {

			int factorCilindrada = getTurismo().getCilindrada() / 10;
			int numDias = Period.between(getFechaAlquiler(), getFechaDevolucion()).getDays();
			coste = (PRECIO_DIA + factorCilindrada) * numDias;
		}
		return coste;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, turismo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(turismo, other.turismo);
	}

	@Override
	public String toString() {
		String cadena = "";
		if (getFechaDevolucion() == null) {

			cadena = String.format("%s <---> %s, %s - %s (%d€)", cliente, turismo, fechaAlquiler.format(FORMATO_FECHA),
					"Aún no devuelto", getPrecio());

		} else {
			cadena = String.format("%s <---> %s, %s - %s (%d€)", cliente, turismo, fechaAlquiler.format(FORMATO_FECHA),
					fechaDevolucion.format(FORMATO_FECHA), getPrecio());
		}
		return cadena;
	}

}