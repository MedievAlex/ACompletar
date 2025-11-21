package main;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import model.coleccionables.*;
import model.coleccionables.exposiciones.Fosil;
import model.coleccionables.exposiciones.Obra;
import model.coleccionables.exposiciones.servivo.Pez;
import model.coleccionables.exposiciones.servivo.Submarino;
import model.data.*;
import utilidades.Utilidades;

public class main {

	public static void main(String[] args) {
		ArrayList<File> ficheros = new ArrayList<File>();
		String directoryPath = "data/";
		ficheros.add(new File(directoryPath + "museo.ac")); // MUSEO = 0
		ficheros.add(new File(directoryPath + "bichos.ac")); // BICHOS = 1
		ficheros.add(new File(directoryPath + "peces.ac")); // PECES = 2
		ficheros.add(new File(directoryPath + "submarinos.ac")); // SUBMARINOS = 3
		ficheros.add(new File(directoryPath + "fosiles.ac")); // FOSILES = 4
		ficheros.add(new File(directoryPath + "obras.ac")); // OBRAS = 5
		ficheros.add(new File(directoryPath + "giroides.ac")); // GIROIDES = 6
		
		int opcion = 0;

		if(!verificarFicheros(7, ficheros)) {
			System.out.println("***************************************");
			Datos.loadData(ficheros);
			System.out.println("[Ficheros Recargados]");
		}

		do {
			System.out.println("***************************************");
			opcion = mostrarMenu();
			System.out.println("***************************************");

			switch(opcion) {
			case 1: // 1. Mostrar BICHOS
				mostrarBichos(ficheros.get(1));
				break;
			case 2: // Mostrar PECES
				mostrarPeces(ficheros.get(3));
				break;
			case 3: // Mostrar SUBMARINOS
				mostrarSubmarinos(ficheros.get(3));
				break;
			case 4: // Mostrar FOSILES
				mostrarFosiles(ficheros.get(4));
				break;
			case 5: // Mostrar OBRAS DE ARTE
				mostrarObras(ficheros.get(5));
				break;
			case 6: // Mostrar GIROIDES
				mostrarGiroides(ficheros.get(6));
				break;
			case 7: // Mostrar
				
				break;
			case 0: 
				System.out.println(" ________________\n|                |\n|      AGUR      |\n|________________|\n");
				break;
			}
		}while(opcion != 0);
		System.out.println("***************************************");
	}

	public static boolean verificarFicheros(int cantidad, ArrayList<File> ficheros) { 
		int existentes = 0;
		
		for(File fichero : ficheros) {
			if(fichero.exists()) {
				existentes++;
			}
		}
		
		if(existentes == cantidad) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/****[MENU]***********************************************************************************************************************/
	public static int mostrarMenu() { 
		System.out.println(" ________________\n|                |\n|      MENU      |\n|   PRINCIPAL    |\n|________________|\n");		
		System.out.println("[1. Mostrar BICHOS]");
		System.out.println("[2. Mostrar PECES]");
		System.out.println("[3. Mostrar SUBMARINOS]");
		System.out.println("[4. Mostrar FOSILES]");
		System.out.println("[5. Mostrar OBRAS DE ARTE]");
		System.out.println("[6. Mostrar GIROIDES]");
		System.out.println("[7. Mostrar TODO]");
		System.out.println("[0. Salir]");
		System.out.print("Elige una opcion: ");
		return Utilidades.leerInt(0, 7);
	}

	public static void mostrar(File fichero){
		ObjectInputStream ois = null; // Lectura
		boolean finArchivo = false;

		if(fichero.exists()){
			try {
				ois = new ObjectInputStream(new FileInputStream(fichero)); // Lectura
				System.out.println("---------------------------------------");
				while (!finArchivo) {
					try{
						Coleccionable coleccionable = (Coleccionable) ois.readObject();					
						System.out.println(coleccionable.toString());
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
			} catch(Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}
		}else {
			System.err.println("[ERROR] Fichero no encontrado.");
		}
	}

	/****[BICHOS]************************************************************************************************************************/
	public static void mostrarBichos(File ficheroBichos){
		ObjectInputStream ois = null; // Lectura
		boolean finArchivo = false;
		int numero = 1;

		if(ficheroBichos.exists()){
			try {
				ois = new ObjectInputStream(new FileInputStream(ficheroBichos)); // Lectura
				System.out.println("[PECES]");
				System.out.println("---------------------------------------");
				while (!finArchivo) {
					try{
						Coleccionable coleccionable = (Coleccionable) ois.readObject();
						if(coleccionable instanceof Pez) {							
							System.out.println(numero+ "-" + ((Pez)coleccionable).toString());
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
			} catch(Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}
		}else {
			System.err.println("[ERROR] Fichero no encontrado.");
		}
	}

	/****[PECES]*************************************************************************************************************************/
	public static void mostrarPeces(File ficheroPeces){
		ObjectInputStream ois = null; // Lectura
		boolean finArchivo = false;
		int numero = 1;

		if(ficheroPeces.exists()){
			try {
				ois = new ObjectInputStream(new FileInputStream(ficheroPeces)); // Lectura
				System.out.println("[PECES]");
				System.out.println("---------------------------------------");
				while (!finArchivo) {
					try{
						Coleccionable coleccionable = (Coleccionable) ois.readObject();
						if(coleccionable instanceof Pez) {							
							System.out.println(numero+ "-" + ((Pez)coleccionable).toString());
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
			} catch(Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}
		}else {
			System.err.println("[ERROR] Fichero no encontrado.");
		}
	}

	/****[SUBMARINOS]********************************************************************************************************************/
	public static void mostrarSubmarinos(File ficheroSubmarinos){
		ObjectInputStream ois = null; // Lectura
		boolean finArchivo = false;
		int numero = 1;

		if(ficheroSubmarinos.exists()){
			try {
				ois = new ObjectInputStream(new FileInputStream(ficheroSubmarinos)); // Lectura
				System.out.println("[SUBMARINOS]");
				System.out.println("---------------------------------------");
				while (!finArchivo) {
					try{
						Coleccionable coleccionable = (Coleccionable) ois.readObject();
						if(coleccionable instanceof Submarino) {							
							System.out.println(numero+ "-" + ((Submarino)coleccionable).toString());
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
			} catch(Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}
		}else {
			System.err.println("[ERROR] Fichero no encontrado.");
		}
	}	

	/****[FOSILES]***********************************************************************************************************************/
	public static void mostrarFosiles(File ficheroFosiles){
		ObjectInputStream ois = null; // Lectura
		boolean finArchivo = false;
		int numero = 1;

		if(ficheroFosiles.exists()){
			try {
				ois = new ObjectInputStream(new FileInputStream(ficheroFosiles)); // Lectura
				System.out.println("[FOSILES]");
				System.out.println("---------------------------------------");
				while (!finArchivo) {
					try{
						Coleccionable coleccionable = (Coleccionable) ois.readObject();
						if(coleccionable instanceof Fosil) {
							System.out.println(numero+ "-" + ((Fosil)coleccionable).toString());
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
			} catch(Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}
		}else {
			System.err.println("[ERROR] Fichero no encontrado.");
		}
	}	

	/****[OBRAS DE ARTE]*****************************************************************************************************************/
	public static void mostrarObras(File ficheroObras){
		ObjectInputStream ois = null; // Lectura
		boolean finArchivo = false;
		int numero = 1;

		if(ficheroObras.exists()){
			try {
				ois = new ObjectInputStream(new FileInputStream(ficheroObras)); // Lectura
				System.out.println("[OBRAS DE ARTE]");
				System.out.println("---------------------------------------");
				while (!finArchivo) {
					try{
						Coleccionable coleccionable = (Coleccionable) ois.readObject();
						if(coleccionable instanceof Obra) {		
							System.out.println(numero+ "-" + ((Obra)coleccionable).toString());
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
			} catch(Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}
		}else {
			System.err.println("[ERROR] Fichero no encontrado.");
		}
	}

	/****[SUBMARINOS]********************************************************************************************************************/
	public static void mostrarGiroides(File ficheroGiroides){
		ObjectInputStream ois = null; // Lectura
		boolean finArchivo = false;
		int numero = 1;

		if(ficheroGiroides.exists()){
			try {
				ois = new ObjectInputStream(new FileInputStream(ficheroGiroides)); // Lectura
				System.out.println("[GIROIDES]");
				System.out.println("---------------------------------------");
				while (!finArchivo) {
					try{
						Coleccionable coleccionable = (Coleccionable) ois.readObject();
						if(coleccionable instanceof Giroide) {							
							System.out.println(numero+ "-" + ((Giroide)coleccionable).toString());
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
			} catch(Exception e) {
				System.err.println("\n[FATAL ERROR]");
			}
		}else {
			System.err.println("[ERROR] Fichero no encontrado.");
		}
	}	
}
