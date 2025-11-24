package controller;

import java.util.ArrayList;
import model.coleccionables.Coleccionable;

public interface FileDAO
{
  
    public boolean verificarFicheros(int cantidad);

    public void iniciarFicheros();

    public void loadData();
    
    public void mostrar(int file);
    
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
