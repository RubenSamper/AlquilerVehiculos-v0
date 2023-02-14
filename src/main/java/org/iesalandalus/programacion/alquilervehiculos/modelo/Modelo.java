package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Modelo {

	private Clientes clientes;
	private Alquileres alquileres;
	private Turismos turismos;

	public Modelo() {

	}

	public void comenzar() {
		clientes = new Clientes();
		alquileres = new Alquileres();
		turismos = new Turismos();

	}

	public void terminar() {
		System.out.println("Fin del modelo");

	}

	public void insertar(Cliente cliente) {
		try {
			clientes.insertar(new Cliente(cliente));
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {		
		if(alquiler == null) {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}
		
		Cliente auxCliente = clientes.buscar(alquiler.getCliente());
		if(auxCliente == null) {
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}
		
		Turismo auxTurismo = turismos.buscar(alquiler.getTurismo());
		if(auxTurismo == null) {
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		}
		
		Alquiler auxAlquiler = new Alquiler(auxCliente, auxTurismo, alquiler.getFechaAlquiler());

		try {
			alquileres.insertar(auxAlquiler);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertar(Turismo turismo) {
		try {
			turismos.insertar(new Turismo(turismo));
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Cliente buscar(Cliente cliente) {
		return clientes.buscar(cliente);
	}

	public Turismo buscar(Turismo turimos) {
		return turismos.buscar(turimos);
	}

	public Alquiler buscar(Alquiler alquiler) {
		return alquileres.buscar(alquiler);
	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		clientes.modificar(cliente, nombre, telefono);
	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		Alquiler aux = alquileres.buscar(alquiler);
		if(aux == null) {
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		}
		
		aux.devolver(fechaDevolucion);
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		List<Alquiler> alquileresCliente = alquileres.get(cliente);
		for(Alquiler aux : alquileresCliente) {
			borrar(aux);
		}
		
		clientes.borrar(cliente);
	}

	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		List<Alquiler> alquileresTurismo = alquileres.get(turismo);
		for(Alquiler aux : alquileresTurismo) {
			borrar(aux);
		}
		
		turismos.borrar(turismo);
	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		alquileres.borrar(alquiler);
	}

	public List<Cliente> getClientes() {
		List<Cliente> listaTemporal = new ArrayList<>();
		for (Cliente cliente : clientes.get()) {
			listaTemporal.add(new Cliente(cliente));
		}

		return listaTemporal;

	}

	public List<Turismo> getTurismos() {
		List<Turismo> listaTemporal = new ArrayList<>();
		for (Turismo turismo : turismos.get()) {
			listaTemporal.add(new Turismo(turismo));
		}

		return listaTemporal;

	}

	public List<Alquiler> getAlquileres() {
		List<Alquiler> listaTemporal = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get()) {
			listaTemporal.add(new Alquiler(alquiler));
		}

		return listaTemporal;

	}

	public List<Alquiler> getAlquileres(Cliente cliente) {
		List<Alquiler> listaTemporal = new ArrayList<>();
		for (Alquiler alquilerCliente : alquileres.get(cliente)) {
			listaTemporal.add(new Alquiler(alquilerCliente));
		}
		return listaTemporal;

	}

	public List<Alquiler> getAlquileres(Turismo turismo) {
		List<Alquiler> listaTemporal = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get(turismo)) {
			listaTemporal.add(new Alquiler(alquiler));
		}
		return listaTemporal;
	}
	
	public List<Cliente> getcoleccionClientes(){
		List<Cliente> listaTemporal = new ArrayList<>();
		for (Cliente cliente : clientes.get()) {
			listaTemporal.add(new Cliente(cliente));
		}

		return listaTemporal;
	}
}