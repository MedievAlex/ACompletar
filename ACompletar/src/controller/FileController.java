/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import model.coleccionables.Coleccionable;
import model.coleccionables.Giroide;
import model.coleccionables.exposiciones.Fosil;
import model.coleccionables.exposiciones.Obra;
import model.coleccionables.exposiciones.capturapedia.Bicho;
import model.coleccionables.exposiciones.capturapedia.Pez;
import model.coleccionables.exposiciones.capturapedia.Submarino;
import model.data.Datos;
import utilidades.Utilidades;

public class FileController implements FileDAO{

	private final Datos datos;
	private final ArrayList<File> ficheros;

	public FileController(){
		datos = new Datos();
		ficheros = new ArrayList<File>();
	}

	//***Verifica la existencia de los ficheros************************************************************************************
	@Override
	public boolean verificarFicheros(int cantidad) {
		int existentes = 0;

		for (File fichero : ficheros) {
			if (fichero.exists()) {
				existentes++;
			}
		}

		if (existentes == cantidad) {
			return true;
		} else {
			return false;
		}
	}

	//***Genera los ficheros*******************************************************************************************************
	@Override
	public void iniciarFicheros() {
		String directoryPath = "data/";
		ficheros.add(new File(directoryPath + "museo.ac")); // MUSEO = 0
		ficheros.add(new File(directoryPath + "bichos.ac")); // BICHOS = 1
		ficheros.add(new File(directoryPath + "peces.ac")); // PECES = 2
		ficheros.add(new File(directoryPath + "submarinos.ac")); // SUBMARINOS = 3
		ficheros.add(new File(directoryPath + "fosiles.ac")); // FOSILES = 4
		ficheros.add(new File(directoryPath + "obras.ac")); // OBRAS = 5
		ficheros.add(new File(directoryPath + "giroides.ac")); // GIROIDES = 6
		ficheros.add(new File(directoryPath + "flores.ac")); // GIROIDES = 7
	}

	//***Carga los datos en los ficheros*******************************************************************************************
	@Override
	public void loadData() {
		datos.loadData(ficheros);
	}

	//***Muestra el fichero********************************************************************************************************
	@Override
	public void mostrar(int file) {
		File fichero = ficheros.get(file);
		ObjectInputStream ois = null; // Lectura
		boolean finArchivo = false;
		int numero = 1;

		if (fichero.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(fichero)); // Lectura
				System.out.println("---------------------------------------");
				while (!finArchivo) {
					try {
						Coleccionable coleccionable = (Coleccionable) ois.readObject();
						System.out.println(numero + "-" + coleccionable.toString());
						numero++;
						System.out.println("---------------------------------------");
					} catch (EOFException e) { // Fin del archivo alcanzado
						finArchivo = true;
					}
				}
				ois.close();  // Lectura (CERRAR)
			} catch (FileNotFoundException e) { // Excepcion no se ha encontrado el Fichero
				e.printStackTrace();
			} catch (ClassNotFoundException e) { // Excepcion no es de la misma clase o no se ha encontrado
				e.printStackTrace();
			} catch (IOException e) { // Excepcion error al acceder al fichero
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}
		} else {
			System.err.println("[ERROR] Fichero no encontrado.");
		}
	}

	//***Muestra el fichero********************************************************************************************************
	public void mostrarMuseo(File fichero) {
		ObjectInputStream ois = null; // Lectura
		boolean finArchivo = false;
		int numero = 1;

		if (fichero.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(fichero)); // Lectura
				System.out.println("---------------------------------------");
				while (!finArchivo) {
					try {
						ArrayList<Coleccionable> lista = (ArrayList<Coleccionable>) ois.readObject();
						for (Coleccionable coleccionable : lista) {
							if (coleccionable instanceof Bicho) {
								System.out.print(numero + "-" + "[BICHO]    ");
							} else if (coleccionable instanceof Pez) {
								System.out.print(numero + "-" + "[PEZ]      ");
							} else if (coleccionable instanceof Submarino) {
								System.out.print(numero + "-" + "[SUBMARINO]");
							} else if (coleccionable instanceof Fosil) {
								System.out.print(numero + "-" + "[FOSIL]    ");
							} else if (coleccionable instanceof Obra) {
								System.out.print(numero + "-" + "[OBRA]     ");
							}
							System.out.println(coleccionable.toString());
							numero++;
							System.out.println("---------------------------------------");
						}
					} catch (EOFException e) { // Fin del archivo alcanzado
						finArchivo = true;
					}
				}
				ois.close();  // Lectura (CERRAR)
			} catch (FileNotFoundException e) { // Excepcion no se ha encontrado el Fichero
				e.printStackTrace();
			} catch (ClassNotFoundException e) { // Excepcion no es de la misma clase o no se ha encontrado
				e.printStackTrace();
			} catch (IOException e) { // Excepcion error al acceder al fichero
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}
		} else {
			System.err.println("[ERROR] Fichero no encontrado.");
		}
	}

	public boolean buscarColeccionable(int file, String nombre) {
		File fichero = ficheros.get(file);
		boolean encontrado = false;
		boolean finArchivo = false;
		ObjectInputStream ois; //Lectura

		if(fichero.exists()) {
			try {	
				ois=new ObjectInputStream(new FileInputStream(fichero));		
				while (!finArchivo) {
					try {
						Coleccionable aux = (Coleccionable) ois.readObject();
						if (aux.getNombre().equalsIgnoreCase(nombre)) {
							encontrado = true;
						}
					} catch (EOFException e) {
						finArchivo = true;
					}
				}
				ois.close();	 
			}catch(Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}	
		}
		else {
			System.err.println("\n[ERROR] Fichero no encontrado.");
		}
		return encontrado;
	}

	public Coleccionable obtenerColeccionable(int file, String nombre) {
		File fichero = ficheros.get(file);
		Coleccionable coleccionable = null;
		boolean encontrado = false;
		boolean finArchivo = false;
		ObjectOutputStream oos=null; //Escritura
		ObjectInputStream ois=null; //Lectura

		if(fichero.exists()) {

			try {	
				ois=new ObjectInputStream(new FileInputStream(fichero));			
				while (!finArchivo || !encontrado) {
					try {
						Coleccionable aux = (Coleccionable) ois.readObject();
						if (aux.getNombre().equalsIgnoreCase(nombre)) {
							encontrado = true;
							coleccionable = aux;
						}
					} catch (EOFException e) {
						finArchivo = true;
					}
				}
				ois.close();	 	 
			}catch(Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}	
		}
		else {
			System.err.println("\n[ERROR] Fichero no encontrado.");
		}	
		return coleccionable;
	}

	public void modificar(int file, String nombre) {
		File fichero = ficheros.get(file);
		ObjectOutputStream oos = null; //Escritura
		ObjectInputStream ois = null; //Lectura
		String id;
		int respuesta;
		boolean existe, finArchivo = false, modificado=false;
		LocalDate fecha;
		Coleccionable coleccionable = null;
		String directoryPath = "data/";
		File ficheroAux = new File(directoryPath, "ficheroAux.ac");

		if(fichero.exists()) {
			do{
				existe = buscarColeccionable(file, nombre);
				if (existe) {	
					coleccionable = obtenerColeccionable(file, nombre);

					System.out.println(coleccionable.toString());

				}else {
					System.out.println("[ERROR] No se a encontrado ''" + nombre + "'' en el registro.");
				}
			}while(!existe);
			System.out.println("Es este el coleccionable que desea marcar como OBTENIDO? (1.SI/2.NO)");
			respuesta=Utilidades.leerInt();

			switch(respuesta) {
			case 1:
				coleccionable.setObtenido(true);
				try {
					ois = new ObjectInputStream(new FileInputStream(fichero));
					oos = new ObjectOutputStream(new FileOutputStream(ficheroAux));
					while(!finArchivo) {
						try { //FALTABA TRY
							Coleccionable coleccionables = (Coleccionable) ois.readObject();
							if(!coleccionables.getNombre().equalsIgnoreCase(nombre)){
								oos.writeObject(coleccionables);
							} else if(coleccionables.getNombre().equalsIgnoreCase(nombre)) {
								oos.writeObject(coleccionable);
								modificado = true;
							}
						} catch (EOFException e) { //FALTABA CATCH
							finArchivo = true;
						}
					}
					ois.close(); //FALTABA UN CLOSE Y SOBRABA UN WRITE OBJECT
					oos.close();
					if(modificado) {
						System.out.println("ACTUALIZADO");
						if(fichero.delete()) {
							ficheroAux.renameTo(fichero);
						}
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("[SE HA GUARDADO CORRECTAMENTE]");
				break;
			case 2: 
				System.out.println("No se haran modificaciones.");
				break;
			}
		}
	}	

	//***[BICHOS]******************************************************************************************************************
	@Override
	public ArrayList<Coleccionable> obtenerBichos() {
		File ficheroBichos = ficheros.get(1);
		ObjectInputStream ois = null; // Lectura
		boolean finArchivo = false;
		ArrayList<Coleccionable> bichos = new ArrayList<Coleccionable>();

		if (ficheroBichos.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(ficheroBichos)); // Lectura
				while (!finArchivo) {
					try {
						Coleccionable coleccionable = (Coleccionable) ois.readObject();
						if (coleccionable instanceof Bicho) {
							bichos.add((Bicho) coleccionable);
						}
					} catch (EOFException e) { // Fin del archivo alcanzado
						finArchivo = true;
					}
				}
				ois.close();  // Lectura (CERRAR)
			} catch (FileNotFoundException e) { // Excepcion no se ha encontrado el Fichero
				e.printStackTrace();
			} catch (ClassNotFoundException e) { // Excepcion no es de la misma clase o no se ha encontrado
				e.printStackTrace();
			} catch (IOException e) { // Excepcion error al acceder al fichero
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}
		} else {
			System.err.println("[ERROR] Fichero no encontrado.");
		}
		return bichos;
	}

	//***[PECES]*******************************************************************************************************************
	@Override
	public ArrayList<Coleccionable> obtenerPeces() {
		File ficheroPeces = ficheros.get(2);
		ObjectInputStream ois = null; // Lectura
		boolean finArchivo = false;
		ArrayList<Coleccionable> peces = new ArrayList<Coleccionable>();

		if (ficheroPeces.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(ficheroPeces)); // Lectura
				while (!finArchivo) {
					try {
						Coleccionable coleccionable = (Coleccionable) ois.readObject();
						if (coleccionable instanceof Pez) {
							peces.add((Pez) coleccionable);
						}
					} catch (EOFException e) { // Fin del archivo alcanzado
						finArchivo = true;
					}
				}
				ois.close();  // Lectura (CERRAR)
			} catch (FileNotFoundException e) { // Excepcion no se ha encontrado el Fichero
				e.printStackTrace();
			} catch (ClassNotFoundException e) { // Excepcion no es de la misma clase o no se ha encontrado
				e.printStackTrace();
			} catch (IOException e) { // Excepcion error al acceder al fichero
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}
		} else {
			System.err.println("[ERROR] Fichero no encontrado.");
		}
		return peces;
	}

	//***[SUBMARINOS]**************************************************************************************************************
	@Override
	public ArrayList<Coleccionable> obtenerSubmarinos() {
		File ficheroSubmarinos = ficheros.get(3);
		ObjectInputStream ois = null; // Lectura
		boolean finArchivo = false;
		ArrayList<Coleccionable> submarinos = new ArrayList<Coleccionable>();

		if (ficheroSubmarinos.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(ficheroSubmarinos)); // Lectura
				while (!finArchivo) {
					try {
						Coleccionable coleccionable = (Coleccionable) ois.readObject();
						if (coleccionable instanceof Submarino) {
							submarinos.add((Submarino) coleccionable);
						}
					} catch (EOFException e) { // Fin del archivo alcanzado
						finArchivo = true;
					}
				}
				ois.close();  // Lectura (CERRAR)
			} catch (FileNotFoundException e) { // Excepcion no se ha encontrado el Fichero
				e.printStackTrace();
			} catch (ClassNotFoundException e) { // Excepcion no es de la misma clase o no se ha encontrado
				e.printStackTrace();
			} catch (IOException e) { // Excepcion error al acceder al fichero
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}
		} else {
			System.err.println("[ERROR] Fichero no encontrado.");
		}
		return submarinos;
	}

	//***[FOSILES]*****************************************************************************************************************
	@Override
	public ArrayList<Coleccionable> obtenerFosiles() {
		File ficheroFosiles = ficheros.get(4);
		ObjectInputStream ois = null; // Lectura
		boolean finArchivo = false;
		ArrayList<Coleccionable> fosiles = new ArrayList<Coleccionable>();

		if (ficheroFosiles.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(ficheroFosiles)); // Lectura
				while (!finArchivo) {
					try {
						Coleccionable coleccionable = (Coleccionable) ois.readObject();
						if (coleccionable instanceof Fosil) {
							fosiles.add((Fosil) coleccionable);
						}
					} catch (EOFException e) { // Fin del archivo alcanzado
						finArchivo = true;
					}
				}
				ois.close();  // Lectura (CERRAR)
			} catch (FileNotFoundException e) { // Excepcion no se ha encontrado el Fichero
				e.printStackTrace();
			} catch (ClassNotFoundException e) { // Excepcion no es de la misma clase o no se ha encontrado
				e.printStackTrace();
			} catch (IOException e) { // Excepcion error al acceder al fichero
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}
		} else {
			System.err.println("[ERROR] Fichero no encontrado.");
		}
		return fosiles;
	}

	//***[OBRAS DE ARTE]***********************************************************************************************************
	@Override
	public ArrayList<Coleccionable> obtenerObras() {
		File ficheroObras = ficheros.get(5);
		ObjectInputStream ois = null; // Lectura
		boolean finArchivo = false;
		ArrayList<Coleccionable> obras = new ArrayList<Coleccionable>();

		if (ficheroObras.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(ficheroObras)); // Lectura
				while (!finArchivo) {
					try {
						Coleccionable coleccionable = (Coleccionable) ois.readObject();
						if (coleccionable instanceof Obra) {
							obras.add((Obra) coleccionable);
						}
					} catch (EOFException e) { // Fin del archivo alcanzado
						finArchivo = true;
					}
				}
				ois.close();  // Lectura (CERRAR)
			} catch (FileNotFoundException e) { // Excepcion no se ha encontrado el Fichero
				e.printStackTrace();
			} catch (ClassNotFoundException e) { // Excepcion no es de la misma clase o no se ha encontrado
				e.printStackTrace();
			} catch (IOException e) { // Excepcion error al acceder al fichero
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}
		} else {
			System.err.println("[ERROR] Fichero no encontrado.");
		}
		return obras;
	}

	//***[SUBMARINOS]**************************************************************************************************************
	@Override
	public ArrayList<Coleccionable> obtenerGiroides() {
		File ficheroGiroides = ficheros.get(6);
		ObjectInputStream ois = null; // Lectura
		boolean finArchivo = false;
		ArrayList<Coleccionable> giroides = new ArrayList<Coleccionable>();

		if (ficheroGiroides.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(ficheroGiroides)); // Lectura
				while (!finArchivo) {
					try {
						Coleccionable coleccionable = (Coleccionable) ois.readObject();
						if (coleccionable instanceof Giroide) {
							giroides.add((Giroide) coleccionable);
						}
					} catch (EOFException e) { // Fin del archivo alcanzado
						finArchivo = true;
					}
				}
				ois.close();  // Lectura (CERRAR)
			} catch (FileNotFoundException e) { // Excepcion no se ha encontrado el Fichero
				e.printStackTrace();
			} catch (ClassNotFoundException e) { // Excepcion no es de la misma clase o no se ha encontrado
				e.printStackTrace();
			} catch (IOException e) { // Excepcion error al acceder al fichero
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}
		} else {
			System.err.println("[ERROR] Fichero no encontrado.");
		}
		return giroides;
	}
}
