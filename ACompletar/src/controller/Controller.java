/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.coleccionables.Coleccionable;

/**
 *
 * @author 2dami
 */
public class Controller {
    
    private final FileDAO dao;
    
    public Controller(){
        dao = new FileController();
    }
    
    public void showWindow(Stage stage) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Window.fxml"));
        Parent root = loader.load();

        WindowController windowController = loader.getController();
        windowController.setController(this);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("");
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/logo.png")));
        stage.show();
    }
    
    public boolean verificarFicheros(int cantidad) {
        return dao.verificarFicheros(cantidad);
    }
    
    public void iniciarFicheros(){
        dao.iniciarFicheros();
    }
    
    public void loadData() {
       dao.loadData();
    }
    
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
