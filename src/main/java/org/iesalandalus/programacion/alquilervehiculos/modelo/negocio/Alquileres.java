package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Alquileres {

	private List<Alquiler> coleccionAlquileres;

	public Alquileres() {

		coleccionAlquileres = new ArrayList<>();
	}

	public List<Alquiler> get() {
		return new ArrayList<>(coleccionAlquileres);
	}

	public List<Alquiler> get(Cliente cliente) {
		List<Alquiler> listaTemporal = new ArrayList<>();

		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getCliente().equals(cliente)) {
				listaTemporal.add(alquiler);
			}
		}
		return listaTemporal;

	}

	public List<Alquiler> get(Turismo turismo) {
		List<Alquiler> listaTemporal = new ArrayList<>();

		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getTurismo().equals(turismo)) {
				listaTemporal.add(alquiler);
			}
		}
		return listaTemporal;
	}

	public int getCantidad() {
		return coleccionAlquileres.size();
	}

	private void comprobarAlquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler)
			throws OperationNotSupportedException {
		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getFechaDevolucion() == null) {
				// AUN NO SE HA DEVUELTO, SI ENTRA POR EL BLOQUE DE ELSE SI SE DEVUELVE
				if (alquiler.getCliente().equals(cliente)) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
				}
				if (alquiler.getTurismo().equals(turismo)) {
					throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");

				}
			} else {
				if (alquiler.getCliente().equals(cliente) && (alquiler.getFechaDevolucion().isAfter(fechaAlquiler) || alquiler.getFechaDevolucion() == fechaAlquiler)) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
				}
				if (alquiler.getTurismo().equals(turismo) && (alquiler.getFechaDevolucion().isAfter(fechaAlquiler) || alquiler.getFechaDevolucion() == fechaAlquiler)) {
					throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
				}					
			}
		}
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}

		comprobarAlquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler());
		coleccionAlquileres.add(alquiler);
	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
		}
		int indice = coleccionAlquileres.indexOf(alquiler);
		if (indice == -1) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}
		alquiler.devolver(fechaDevolucion);
	}

	public void borrar(Alquiler alquileres) throws OperationNotSupportedException {
		if (alquileres == null) {
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}
		int indice = coleccionAlquileres.indexOf(alquileres);
		if (indice == -1) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}
		coleccionAlquileres.remove(indice);
	}

	public Alquiler buscar(Alquiler alquiler) {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}
		int indice = coleccionAlquileres.indexOf(alquiler);
		Alquiler aux = null;
		if (indice != -1) {
			aux = coleccionAlquileres.get(indice);
		}
		return aux;
	}

}
