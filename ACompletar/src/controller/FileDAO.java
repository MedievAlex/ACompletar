package controller;

import java.util.ArrayList;
import model.coleccionables.Coleccionable;

public interface FileDAO
{
  
	// Verifica la existencia de los ficheros
    public boolean verificarFicheros(int cantidad);

    // Genera los ficheros
    public void iniciarFicheros();

    // Carga los datos en los ficheros
    public void loadData();
    
    // Muestra el fichero
    public void mostrar(int file);
    
    public boolean buscarColeccionable(int file, String nombre);
	
	public Coleccionable obtenerColeccionable(int file, String nombre);
	
	public void modificar(int file, String nombre);
    
    // Obtener listado de BICHOS (1)
    public ArrayList<Coleccionable> obtenerBichos();
    
    // Obtener listado de PECES (2)
    public ArrayList<Coleccionable> obtenerPeces();
    
    // Obtener listado de SUBMARINOS (3)
    public ArrayList<Coleccionable> obtenerSubmarinos();
    
    // Obtener listado de FOSILES (4)
    public ArrayList<Coleccionable> obtenerFosiles();
    
    // Obtener listado de OBRAS (5)
    public ArrayList<Coleccionable> obtenerObras();
    
    // Obtener listado de GIROIDES (6)
    public ArrayList<Coleccionable> obtenerGiroides();
    
}
