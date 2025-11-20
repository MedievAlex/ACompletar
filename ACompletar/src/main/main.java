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
    	File ficheroMuseo = new File("museo.ac");
    	File ficheroBichos = new File("bichos.ac");
    	File ficheroPeces = new File("bichos.ac");
    	File ficheroFosiles = new File("fosiles.ac");
    	File ficheroObras = new File("obras.ac");
    	
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
