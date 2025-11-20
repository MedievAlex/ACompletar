/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import model.coleccionables.*;
import model.data.*;

/**
 *
 * @author 2dami
 */
public class main {

    public static void main(String[] args) {
    	String directoryPath = "ficheros/";
    	File ficheroMuseo = new File(directoryPath + "museo.ac");
    	File ficheroBichos = new File(directoryPath + "bichos.ac");
    	File ficheroPeces = new File(directoryPath + "bichos.ac");
    	File ficheroFosiles = new File(directoryPath + "fosiles.ac");
    	File ficheroObras = new File(directoryPath + "obras.ac");
    	
    	System.out.println("Files created successfully.");
    	
    	Datos data;
        ObjectOutputStream salida;
        ObjectInputStream entrada;
    	
    	//salida = new ObjectOutputStream();
        //entrada = new ObjectInputStream();
    	
    	if(!ficheroMuseo.exists()) {
    		Datos.loadData(ficheroMuseo, ficheroBichos, ficheroPeces, ficheroFosiles, ficheroObras);
    	}
    }
}
