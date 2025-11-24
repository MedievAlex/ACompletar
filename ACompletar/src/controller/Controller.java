package controller;

import java.util.ArrayList;
import model.coleccionables.Coleccionable;

public class Controller {

	private final FileDAO dao;

	public Controller(){
		dao = new FileController();
	}

	// Verifica la existencia de los ficheros
	public boolean verificarFicheros(int cantidad) {
		return dao.verificarFicheros(cantidad);
	}

	// Genera los ficheros
	public void iniciarFicheros(){
		dao.iniciarFicheros();
	}

	// Carga los datos en los ficheros
	public void loadData() {
		dao.loadData();
	}

	// Muestra el fichero
	public void mostrar(int file){
		dao.mostrar(file);
	}

	// Obtener listado de BICHOS (1)
	public ArrayList<Coleccionable> obtenerBichos(){
		return dao.obtenerBichos();
	}

	// Obtener listado de PECES (2)
	public ArrayList<Coleccionable> obtenerPeces(){
		return dao.obtenerPeces();
	}

	// Obtener listado de SUBMARINOS (3)
	public ArrayList<Coleccionable> obtenerSubmarinos(){
		return dao.obtenerSubmarinos();
	}

	// Obtener listado de FOSILES (4)
	public ArrayList<Coleccionable> obtenerFosiles(){
		return dao.obtenerFosiles();
	}

	// Obtener listado de OBRAS (5)
	public ArrayList<Coleccionable> obtenerObras(){
		return dao.obtenerObras();
	}

	// Obtener listado de GIROIDES (6)
	public ArrayList<Coleccionable> obtenerGiroides(){
		return dao.obtenerGiroides();
	}
}
