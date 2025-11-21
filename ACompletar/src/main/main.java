/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.coleccionables.*;
import model.data.*;
import utilidades.Utilidades;

/**
 *
 * @author 2dami
 */
public class main {

	public static void main(String[] args) {
		String directoryPath = "ficheros/";
		File ficheroMuseo = new File(directoryPath + "museo.ac");
		File ficheroBichos = new File(directoryPath + "bichos.ac");
		File ficheroPeces = new File(directoryPath + "peces.ac");
		File ficheroFosiles = new File(directoryPath + "fosiles.ac");
		File ficheroObras = new File(directoryPath + "obras.ac");

		int opcion = 0;

		Datos data;

		if(!ficheroMuseo.exists()) {
			Datos.loadData(ficheroMuseo, ficheroBichos, ficheroPeces, ficheroFosiles, ficheroObras);
		}

		do {
			System.out.println("***************************************");
			opcion = mostrarMenu();
			System.out.println("***************************************");

			switch(opcion) {
			case 1: 

				break;
			case 2: 
				mostrarPeces(ficheroPeces);
				break;
			case 3: 

				break;
			case 4: 

				break;
			case 5: 

				break;
			case 6: 
				System.out.println(" ________________\n|                |\n|      AGUR      |\n|________________|\n");
				break;
			}
		}while(opcion != 6);
		System.out.println("***************************************");
	}


	public static int mostrarMenu() { 
		System.out.println(" ________________\n|                |\n|      MENU      |\n|   PRINCIPAL    |\n|________________|\n");		
		System.out.println("[1. Mostrar BICHOS]");
		System.out.println("[2. Mostrar PECES]");
		System.out.println("[3. Mostrar FOSILES]");
		System.out.println("[4. Mostrar OBRAS DE ARTE]");
		System.out.println("[5. Mostrar MUSEO]");
		System.out.println("[6. Salir]");
		System.out.print("Elige una opcion: ");
		return Utilidades.leerInt(1, 6);
	}

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
						if(coleccionable instanceof SerVivo) {
							if(coleccionable instanceof Pez) {
								System.out.println(numero+ "-" + ((Pez)coleccionable).toString());
								numero++;
								System.out.println("---------------------------------------");
							}
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
