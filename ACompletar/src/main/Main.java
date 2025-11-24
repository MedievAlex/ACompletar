package main;

import controller.Controller;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.coleccionables.*;
import utilidades.Utilidades;

public class Main {

    public static void main(String[] args) {
        Controller cont = new Controller();
        int opcion = 0;
        
        cont.iniciarFicheros();

        if (!cont.verificarFicheros(8)) {
            System.out.println("***************************************");
            cont.loadData();
            System.out.println("[Ficheros Recargados]");
        }

        do {
            System.out.println("***************************************");
            opcion = mostrarMenuPrincipal();
            System.out.println("***************************************");

            switch (opcion) {
                case 1: // 1. VER listas 
                	do {
                        opcion = mostrarMenuMostrar();
                        System.out.println("***************************************");

                        switch (opcion) {
                            case 1: // 1. Mostrar BICHOS
                                cont.mostrar(1); 
                                break;
                            case 2: // Mostrar PECES
                                cont.mostrar(2);
                                break;
                            case 3: // Mostrar SUBMARINOS
                                cont.mostrar(3);
                                break;
                            case 4: // Mostrar FOSILES
                                cont.mostrar(4);
                                break;
                            case 5: // Mostrar OBRAS DE ARTE
                                cont.mostrar(5);
                                break;
                            case 6: // Mostrar GIROIDES
                                cont.mostrar(6);
                                break;
                            case 7: // Mostrar FLORES
                                cont.mostrar(7);
                                break;
                            case 8: // Mostrar MUSEO
                                mostrarMuseo(cont);
                                break;
                        }
                    } while (opcion != 0);
                	opcion = -1;
                    break;
                case 2: // 2. BUSCAR
                	do {
                		
                    } while (opcion != 0);
                	opcion = -1;
                    break;
                case 3: // 3. Marcar como OBTENIDO
                	String nombre;
                	do {
                		opcion = mostrarMenuObtenido();
                		System.out.print("Introduzca el nombre: ");
                		nombre = Utilidades.introducirCadena();
                		cont.modificar(opcion, nombre);
                    } while (opcion != 0);
                	opcion = -1;
                    break;
            }
        } while (opcion != 0);
        System.out.println("***************************************");
    }

    //***[MENUS]*******************************************************************************************************************
    public static int mostrarMenuPrincipal() {
    	System.out.println("                MENU PRINCIPAL");
    	System.out.println("[1. VER listas]");
        System.out.println("[2. BUSCAR]");
        System.out.println("[3. Marcar como OBTENIDO]");
        System.out.println("[0. Salir]");
        System.out.print("Elige una opcion: ");
        
        return Utilidades.leerInt(0, 3);
    }
    
    public static int mostrarMenuMostrar() {
    	System.out.println("                MENU VER LISTAS");
    	System.out.println("[1. Mostrar BICHOS]");
        System.out.println("[2. Mostrar PECES]");
        System.out.println("[3. Mostrar SUBMARINOS]");
        System.out.println("[4. Mostrar FOSILES]");
        System.out.println("[5. Mostrar OBRAS DE ARTE]");
        System.out.println("[6. Mostrar GIROIDES]");
        System.out.println("[7. Mostrar FLORES]");
        System.out.println("[8. Mostrar MUSEO]");
        System.out.println("[0. Volver]");
        System.out.print("Elige una opcion: ");
        
        return Utilidades.leerInt(0, 8);
    }
    
    public static int mostrarMenuObtenido() {
    	System.out.println("                MENU OBTENIDO");
    	System.out.println("[1] BICHO");
        System.out.println("[2] Mostrar PEZ");
        System.out.println("[3] SUBMARINO");
        System.out.println("[4] FOSIL");
        System.out.println("[5] OBRA DE ARTE");
        System.out.println("[6] GIROIDE");
        System.out.println("[7] FLORES");
        System.out.println("[0] Volver");
    	System.out.print("Inserte que quiere marcar como OBTENIDO:");
        return Utilidades.leerInt(0, 7);
    }

    //***Muestra el fichero********************************************************************************************************
    public void mostrar(File fichero) {
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
    public static void mostrarMuseo(Controller cont) {

        for(int i = 1; i < 8; i++) {
        	cont.mostrar(i);
        }
    }
}
