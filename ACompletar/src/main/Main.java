package main;

import controller.Controller;
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
import model.coleccionables.exposiciones.capturapedia.Bicho;
import model.coleccionables.exposiciones.capturapedia.Pez;
import model.coleccionables.exposiciones.capturapedia.Submarino;
import utilidades.Utilidades;

public class Main {

    public static void main(String[] args) {
        Controller cont = new Controller();
        
        cont.iniciarFicheros();
        
        int opcion = 0;

        if (!cont.verificarFicheros(8)) {
            System.out.println("***************************************");
            cont.loadData();
            System.out.println("[Ficheros Recargados]");
        }

        do {
            System.out.println("***************************************");
            opcion = mostrarMenu();
            System.out.println("***************************************");

            switch (opcion) {
                case 1: // 1. Mostrar BICHOS
                    cont.mostrar(1);
                    //mostrarBichos(ficheros.get(1));
                    break;
                case 2: // Mostrar PECES
                    cont.mostrar(2);
                    //mostrarPeces(ficheros.get(2));
                    break;
                case 3: // Mostrar SUBMARINOS
                    cont.mostrar(3);
                    //mostrarSubmarinos(ficheros.get(3));
                    break;
                case 4: // Mostrar FOSILES
                    cont.mostrar(4);
                    //mostrarFosiles(ficheros.get(4));
                    break;
                case 5: // Mostrar OBRAS DE ARTE
                    cont.mostrar(5);
                    //mostrarObras(ficheros.get(5));
                    break;
                case 6: // Mostrar GIROIDES
                    cont.mostrar(6);
                    //mostrarGiroides(ficheros.get(6));
                    break;
                case 7: // Mostrar FLORES
                    cont.mostrar(7);
                    break;
                case 0:
                    System.out.println(" ________________\n|                |\n|      AGUR      |\n|________________|\n");
                    break;
            }
        } while (opcion != 0);
        System.out.println("***************************************");
    }

    //***Verifica la existencia de los ficheros******************************************************************************************/
    public boolean verificarFicheros(int cantidad, ArrayList<File> ficheros) {
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

    /**
     * **[MENU]**********************************************************************************************************************
     */
    public static int mostrarMenu() {
        System.out.println(" ________________\n|                |\n|      MENU      |\n|   PRINCIPAL    |\n|________________|\n");
        System.out.println("[1. Mostrar BICHOS]");
        System.out.println("[2. Mostrar PECES]");
        System.out.println("[3. Mostrar SUBMARINOS]");
        System.out.println("[4. Mostrar FOSILES]");
        System.out.println("[5. Mostrar OBRAS DE ARTE]");
        System.out.println("[6. Mostrar GIROIDES]");
        System.out.println("[7. Mostrar FLORES]");
        System.out.println("[0. Salir]");
        System.out.print("Elige una opcion: ");
        
        return Utilidades.leerInt(0, 7);
    }

    //***Muestra el fichero**************************************************************************************************************/
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

    //***Muestra el fichero**************************************************************************************************************/
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

    /**
     * **[BICHOS]***********************************************************************************************************************
     */
    public void obtenerBichos(File ficheroBichos) {
        ObjectInputStream ois = null; // Lectura
        boolean finArchivo = false;
        int numero = 1;

        if (ficheroBichos.exists()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(ficheroBichos)); // Lectura
                System.out.println("[BICHOS]");
                System.out.println("---------------------------------------");
                while (!finArchivo) {
                    try {
                        Coleccionable coleccionable = (Coleccionable) ois.readObject();
                        if (coleccionable instanceof Bicho) {
                            System.out.println(numero + "-" + ((Bicho) coleccionable).toString());
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

    /**
     * **[PECES]************************************************************************************************************************
     */
    public void obtenerPeces(File ficheroPeces) {
        ObjectInputStream ois = null; // Lectura
        boolean finArchivo = false;
        int numero = 1;

        if (ficheroPeces.exists()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(ficheroPeces)); // Lectura
                System.out.println("[PECES]");
                System.out.println("---------------------------------------");
                while (!finArchivo) {
                    try {
                        Coleccionable coleccionable = (Coleccionable) ois.readObject();
                        if (coleccionable instanceof Pez) {
                            System.out.println(numero + "-" + ((Pez) coleccionable).toString());
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

    /**
     * **[SUBMARINOS]*******************************************************************************************************************
     */
    public void obtenerSubmarinos(File ficheroSubmarinos) {
        ObjectInputStream ois = null; // Lectura
        boolean finArchivo = false;
        int numero = 1;

        if (ficheroSubmarinos.exists()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(ficheroSubmarinos)); // Lectura
                System.out.println("[SUBMARINOS]");
                System.out.println("---------------------------------------");
                while (!finArchivo) {
                    try {
                        Coleccionable coleccionable = (Coleccionable) ois.readObject();
                        if (coleccionable instanceof Submarino) {
                            System.out.println(numero + "-" + ((Submarino) coleccionable).toString());
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

    /**
     * **[FOSILES]**********************************************************************************************************************
     */
    public void obtenerFosiles(File ficheroFosiles) {
        ObjectInputStream ois = null; // Lectura
        boolean finArchivo = false;
        int numero = 1;

        if (ficheroFosiles.exists()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(ficheroFosiles)); // Lectura
                System.out.println("[FOSILES]");
                System.out.println("---------------------------------------");
                while (!finArchivo) {
                    try {
                        Coleccionable coleccionable = (Coleccionable) ois.readObject();
                        if (coleccionable instanceof Fosil) {
                            System.out.println(numero + "-" + ((Fosil) coleccionable).toString());
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

    /**
     * **[OBRAS DE ARTE]****************************************************************************************************************
     */
    public void obtenerObras(File ficheroObras) {
        ObjectInputStream ois = null; // Lectura
        boolean finArchivo = false;
        int numero = 1;

        if (ficheroObras.exists()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(ficheroObras)); // Lectura
                System.out.println("[OBRAS DE ARTE]");
                System.out.println("---------------------------------------");
                while (!finArchivo) {
                    try {
                        Coleccionable coleccionable = (Coleccionable) ois.readObject();
                        if (coleccionable instanceof Obra) {
                            System.out.println(numero + "-" + ((Obra) coleccionable).toString());
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

    /**
     * **[SUBMARINOS]*******************************************************************************************************************
     */
    public void obtenerGiroides(File ficheroGiroides) {
        ObjectInputStream ois = null; // Lectura
        boolean finArchivo = false;
        int numero = 1;

        if (ficheroGiroides.exists()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(ficheroGiroides)); // Lectura
                System.out.println("[GIROIDES]");
                System.out.println("---------------------------------------");
                while (!finArchivo) {
                    try {
                        Coleccionable coleccionable = (Coleccionable) ois.readObject();
                        if (coleccionable instanceof Giroide) {
                            System.out.println(numero + "-" + ((Giroide) coleccionable).toString());
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
}
