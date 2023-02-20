package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion {

	SALIR("Salir"), INSERTAR_CLIENTE("Insertar cliente"), INSERTAR_TURISMO("Insertar turismo"),
	INSERTAR_ALQUILER("Insertar alquiler"), BUSCAR_CLIENTE("Buscar cliente"), BUSCAR_TURISMO("Buscar turismo"),
	BUSCAR_ALQUILER("Buscar alquiler"), MODIFICAR_CLIENTE("Modificar cliente"), DEVOLVER_ALQUILER("Devolver alquiler"),
	BORRAR_CLIENTE("Borrar cliente"), BORRAR_TURISMO("Borrar turismo"), BORRAR_ALQUILER("Borrar alquiler"),
	LISTAR_CLIENTES("Listar clientes"), LISTAR_TURISMOS("Lista Turismos"), LISTAR_ALQUILERES("Listar alquileres"),
	LISTAR_ALQUILERES_CLIENTE("Listar alquileres cliente"), LISTAR_ALQUILERES_TURISMO("Listar alquileres turismo");

	private String texto;

	private Opcion(String texto) {

		this.texto = texto;
	}

	private boolean esOrdinaValido(int ordinal) {
		boolean aux = false;
		if ((ordinal >= 0) && (ordinal <= 16)) {

			aux = true;
		}
		return aux;
	}

	public Opcion get(int ordinal) {
		if (!esOrdinaValido(ordinal)) {
			throw new IllegalArgumentException("ERROR: El ordinal no es válido");
		}

		return Opcion.values()[ordinal];
	}

	@Override
	public String toString() {
		return texto;
	}
}