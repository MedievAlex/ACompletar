/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.data;

import java.util.ArrayList;
import java.util.HashMap;
import model.Frecuencia;
import model.Habitad;
import model.coleccionables.Bicho;
import model.coleccionables.Fosil;
import model.coleccionables.Fragmento;
import model.coleccionables.Obra;
import model.coleccionables.Pez;

/**
 *
 * @author 2dami
 */
public class data {
    
    private static HashMap<String, Boolean> temporada;
    
    // Seccion Bichos
    private static void loadBichos() {
        temporada = reloadTemporada();

        ArrayList<Bicho> bichos = new ArrayList<>();
        Bicho bicho;
        
    }
    
    // Seccion Peces
    private static ArrayList<Pez> loadPeces() {
        ArrayList<Pez> peces = new ArrayList<>();
        
        // Amarguillo
        temporada = reloadTemporada();
        loadInTemporada("Enero");
        loadInTemporada("Febrero");
        loadInTemporada("Marzo");
        loadInTemporada("Noviembre");
        loadInTemporada("Diciembre");
        peces.add(new Pez("Amarguillo", temporada, "24h", Habitad.RIO, Frecuencia.MUCHA));
        
        // Anguila de listón azul
        temporada = reloadTemporada();
        loadInTemporada("Junio");
        loadInTemporada("Julio");
        loadInTemporada("Agosto");
        loadInTemporada("Septiembre");
        loadInTemporada("Octubre");
        peces.add(new Pez("Anguila de listón azul", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));
        
        // Arowana
        temporada = reloadTemporada();
        loadInTemporada("Junio");
        loadInTemporada("Julio");
        loadInTemporada("Agosto");
        loadInTemporada("Septiembre");
        peces.add(new Pez("Arowana", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.POCA));
        
        // Atún
        temporada = reloadTemporada();
        loadInTemporada("Enero");
        loadInTemporada("Febrero");
        loadInTemporada("Marzo");
        loadInTemporada("Abril");
        loadInTemporada("Noviembre");
        peces.add(new Pez("Atún", temporada, "24h", Habitad.MUELLE, Frecuencia.MUYPOCA));
        
        // Ayu
        temporada = reloadTemporada();
        loadInTemporada("Julio");
        loadInTemporada("Agosto");
        loadInTemporada("Septiembre");
        peces.add(new Pez("Ayu", temporada, "24h", Habitad.RIO, Frecuencia.FRECUENTE));
        
        // Betta
        temporada = reloadTemporada();
        loadInTemporada("Mayo");
        loadInTemporada("Junio");
        loadInTemporada("Julio");
        loadInTemporada("Agosto");
        loadInTemporada("Septiembre");
        loadInTemporada("Octubre");
        peces.add(new Pez("Betta", temporada, "9:00-16:00", Habitad.RIO, Frecuencia.MUYPOCA));
        
        // Bichir ensillado
        temporada = reloadTemporada();
        loadInTemporada("Junio");
        loadInTemporada("Julio");
        loadInTemporada("Agosto");
        loadInTemporada("Septiembre");
        
        pez = new Pez("Bichir ensillado", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.POCA);
        peces.add(pez);
        
        // Boquerón
        temporada = reloadTemporada();
        loadInTemporada("");
        pez = new Pez("Boquerón", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Caballito de mar
        temporada = reloadTemporada();
        pez = new Pez("Caballito de mar", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.POCA);
        peces.add(pez);
        
        // Cacho
        temporada = reloadTemporada();
        pez = new Pez("Cacho", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.MUCHA);
        peces.add(pez);
        
        // Calamar
        temporada = reloadTemporada();
        pez = new Pez("Calamar", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Cangrejo de río
        temporada = reloadTemporada();
        pez = new Pez("Cangrejo de río", temporada, "16:00h - 9:00h", Habitad.ESTANQUE, Frecuencia.MUCHA);
        peces.add(pez);
        
        // Cangrejo de Shanghái
        temporada = reloadTemporada();
        pez = new Pez("Cangrejo de Shanghái", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.POCA);
        peces.add(pez);
        
        // Carpa
        temporada = reloadTemporada();
        pez = new Pez("Carpa", temporada, "16:00h - 9:00h", Habitad.ESTANQUE, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Carpín
        temporada = reloadTemporada();
        pez = new Pez("Carpín", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.MUCHA);
        peces.add(pez);
        
        // Celacanto
        temporada = reloadTemporada();
        pez = new Pez("Celacanto", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.POCA);
        peces.add(pez);
        
        // Dorada japonesa
        temporada = reloadTemporada();
        pez = new Pez("Dorada japonesa", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Dorado
        temporada = reloadTemporada();
        pez = new Pez("Dorado", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.MUYPOCA);
        peces.add(pez);
        
        // Eperlano
        temporada = reloadTemporada();
        pez = new Pez("Eperlano", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.MUCHA);
        peces.add(pez);
        
        // Esturión
        temporada = reloadTemporada();
        pez = new Pez("Esturión", temporada, "16:00h - 9:00h", Habitad.DESEMBOCADURA, Frecuencia.POCA);
        peces.add(pez);
        
        // Gallo
        temporada = reloadTemporada();
        pez = new Pez("Gallo", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.MUCHA);
        peces.add(pez);
        
        // Gobio de río
        temporada = reloadTemporada();
        pez = new Pez("Gobio de río", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Gupi
        temporada = reloadTemporada();
        pez = new Pez("Gupi", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Jurel
        temporada = reloadTemporada();
        pez = new Pez("Jurel", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.MUCHA);
        peces.add(pez);
        
        // Jurel gigante
        temporada = reloadTemporada();
        pez = new Pez("Jurel gigante", temporada, "16:00h - 9:00h", Habitad.MUELLE, Frecuencia.MUYPOCA);
        peces.add(pez);
        
        // Killi
        temporada = reloadTemporada();
        pez = new Pez("Killi", temporada, "16:00h - 9:00h", Habitad.ESTANQUE, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Koi
        temporada = reloadTemporada();
        pez = new Pez("Koi", temporada, "16:00h - 9:00h", Habitad.ESTANQUE, Frecuencia.POCA);
        peces.add(pez);
        
        // Lampuga
        temporada = reloadTemporada();
        pez = new Pez("Lampuga", temporada, "16:00h - 9:00h", Habitad.MUELLE, Frecuencia.MUYPOCA);
        peces.add(pez);
        
        // Leucisco
        temporada = reloadTemporada();
        pez = new Pez("Leucisco", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.MUCHA);
        peces.add(pez);
        
        // Locha
        temporada = reloadTemporada();
        pez = new Pez("Locha", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.MUCHA);
        peces.add(pez);
        
        // Lubina
        temporada = reloadTemporada();
        pez = new Pez("Lubina", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.MUCHA);
        peces.add(pez);
        
        // Lucio
        temporada = reloadTemporada();
        pez = new Pez("Lucio", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.POCA);
        peces.add(pez);
        
        // Mariposa marina
        temporada = reloadTemporada();
        pez = new Pez("Mariposa marina", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Morena
        temporada = reloadTemporada();
        pez = new Pez("Morena", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Pargo rojo
        temporada = reloadTemporada();
        pez = new Pez("Pargo rojo", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Perca
        temporada = reloadTemporada();
        pez = new Pez("Perca", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.MUCHA);
        peces.add(pez);
        
        // Perca amarilla
        temporada = reloadTemporada();
        pez = new Pez("Perca amarilla", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.MUCHA);
        peces.add(pez);
                
        // Pez ángel
        temporada = reloadTemporada();
        pez = new Pez("Pez ángel", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.POCA);
        peces.add(pez);
        
        // Pez arcoíris
        temporada = reloadTemporada();
        pez = new Pez("Pez arcoíris", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.FRECUENTE);
        peces.add(pez); 
        
        // Pez balón
        temporada = reloadTemporada();
        pez = new Pez("Pez balón", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.POCA);
        peces.add(pez); 
        
        // Pez cabeza de serpiente
        temporada = reloadTemporada();
        pez = new Pez("Pez cabeza de serpiente", temporada, "16:00h - 9:00h", Habitad.ESTANQUE, Frecuencia.MUYPOCA);
        peces.add(pez); 
        
        // Pez cabeza transparente
        temporada = reloadTemporada();
        pez = new Pez("Pez cabeza transparente", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.MUYPOCA);
        peces.add(pez); 
        
        // Pez caimán
        temporada = reloadTemporada();
        pez = new Pez("Pez caimán", temporada, "16:00h - 9:00h", Habitad.ESTANQUE, Frecuencia.MUYPOCA);
        peces.add(pez); 
        
        // Pez cirujano
        temporada = reloadTemporada();
        pez = new Pez("Pez cirujano", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.POCA);
        peces.add(pez); 
        
        // Pez doctor
        temporada = reloadTemporada();
        pez = new Pez("Pez doctor", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.FRECUENTE);
        peces.add(pez); 
        
        // Pez dorado
        temporada = reloadTemporada();
        pez = new Pez("Pez dorado", temporada, "16:00h - 9:00h", Habitad.ESTANQUE, Frecuencia.FRECUENTE);
        peces.add(pez); 
        
        // Pez erizo
        temporada = reloadTemporada();
        pez = new Pez("Pez erizo", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.MUCHA);
        peces.add(pez); 
        
        // Pez espada
        temporada = reloadTemporada();
        pez = new Pez("Pez espada", temporada, "16:00h - 9:00h", Habitad.MUELLE, Frecuencia.MUYPOCA);
        peces.add(pez); 
        
        // Pez globo
        temporada = reloadTemporada();
        pez = new Pez("Pez globo", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.POCA);
        peces.add(pez); 
        
        // Pez león
        temporada = reloadTemporada();
        pez = new Pez("Pez león", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.FRECUENTE);
        peces.add(pez); 
        
        // Pez luna
        temporada = reloadTemporada();
        pez = new Pez("Pez luna", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.MUYPOCA);
        peces.add(pez); 
        
        // Pez mariposa
        temporada = reloadTemporada();
        pez = new Pez("Pez mariposa", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Pez martillo
        temporada = reloadTemporada();
        pez = new Pez("Pez martillo", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.POCA);
        peces.add(pez);
        
        // Pez napoleón
        temporada = reloadTemporada();
        pez = new Pez("Pez napoleón", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.POCA);
        peces.add(pez);
        
        // Pez payaso
        temporada = reloadTemporada();
        pez = new Pez("Pez payaso", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Pez remo
        temporada = reloadTemporada();
        pez = new Pez("Pez remo", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.POCA);
        peces.add(pez);
        
        // Pez sierra
        temporada = reloadTemporada();
        pez = new Pez("Pez sierra", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.POCA);
        peces.add(pez);
        
        // Pez sol
        temporada = reloadTemporada();
        pez = new Pez("Pez sol", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.MUCHA);
        peces.add(pez);
        
        // Pez telescopio
        temporada = reloadTemporada();
        pez = new Pez("Pez telescopio", temporada, "16:00h - 9:00h", Habitad.ESTANQUE, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Piraña
        temporada = reloadTemporada();
        pez = new Pez("Piraña", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Pirarucú
        temporada = reloadTemporada();
        pez = new Pez("Pirarucú", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.POCA);
        peces.add(pez);
        
        // Rana
        temporada = reloadTemporada();
        pez = new Pez("Rana", temporada, "16:00h - 9:00h", Habitad.ESTANQUE, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Ranchú
        temporada = reloadTemporada();
        pez = new Pez("Ranchú", temporada, "16:00h - 9:00h", Habitad.ESTANQUE, Frecuencia.POCA);
        peces.add(pez);
                
        // Raya
        temporada = reloadTemporada();
        pez = new Pez("Raya", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.POCA);
        peces.add(pez);     
        
        // Rémora
        temporada = reloadTemporada();
        pez = new Pez("Rémora", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.POCA);
        peces.add(pez);
        
        // Renacuajo
        temporada = reloadTemporada();
        pez = new Pez("Renacuajo", temporada, "16:00h - 9:00h", Habitad.ESTANQUE, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Rodaballo
        temporada = reloadTemporada();
        pez = new Pez("Rodaballo", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.MUCHA);
        peces.add(pez);
        
        // Salmón
        temporada = reloadTemporada();
        pez = new Pez("Salmón", temporada, "16:00h - 9:00h", Habitad.DESEMBOCADURA, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Salmón japonés
        temporada = reloadTemporada();
        pez = new Pez("Salmón japonés", temporada, "16:00h - 9:00h", Habitad.CASCADA, Frecuencia.POCA);
        peces.add(pez);
        
        // Salmón real
        temporada = reloadTemporada();
        pez = new Pez("Salmón real", temporada, "16:00h - 9:00h", Habitad.DESEMBOCADURA, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Siluro
        temporada = reloadTemporada();
        pez = new Pez("Siluro", temporada, "16:00h - 9:00h", Habitad.ESTANQUE, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Taimén
        temporada = reloadTemporada();
        pez = new Pez("Taimén", temporada, "16:00h - 9:00h", Habitad.CASCADA, Frecuencia.MUYPOCA);
        peces.add(pez);
        
        // Tetra neón
        temporada = reloadTemporada();
        pez = new Pez("Tetra neón", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Tiburón
        temporada = reloadTemporada();
        pez = new Pez("Tiburón", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.POCA);
        peces.add(pez);
        
        // Tiburón ballena
        temporada = reloadTemporada();
        pez = new Pez("Tiburón ballena", temporada, "16:00h - 9:00h", Habitad.MAR, Frecuencia.POCA);
        peces.add(pez);
        
        // Tilapia
        temporada = reloadTemporada();
        pez = new Pez("Tilapia", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Tortuga caparazón blando
        temporada = reloadTemporada();
        pez = new Pez("Tortuga caparazón blando", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.FRECUENTE);
        peces.add(pez);
        
        // Tortuga mordedora
        temporada = reloadTemporada();
        pez = new Pez("Tortuga mordedora", temporada, "16:00h - 9:00h", Habitad.RIO, Frecuencia.POCA);
        peces.add(pez);
        
        // Trucha
        temporada = reloadTemporada();
        pez = new Pez("Trucha", temporada, "16:00h - 9:00h", Habitad.CASCADA, Frecuencia.POCA);
        peces.add(pez);
        
        // Trucha dorada
        temporada = reloadTemporada();
        pez = new Pez("Trucha dorada", temporada, "16:00h - 9:00h", Habitad.CASCADA, Frecuencia.MUYPOCA);
        peces.add(pez);
         
        return peces;
    }
    
    // Seccion Fosiles
    private static void loadFosiles() {
        temporada = reloadTemporada();

        ArrayList<Fosil> fosiles = new ArrayList<>();
        Fosil fosil;
        Fragmento fragmento;
    }
    
    // Seccion Obras de Arte
    private static void loadObras() {
        temporada = reloadTemporada();

        ArrayList<Obra> obras = new ArrayList<>();
        Obra obra;
    }
    
    private static HashMap<String, Boolean> reloadTemporada()
    {
        HashMap<String, Boolean> temporadaVacia = new HashMap<>();
        
        temporadaVacia.put("Enero", false); // 1
        temporadaVacia.put("Febrero", false); // 2
        temporadaVacia.put("Marzo", false); // 3
        temporadaVacia.put("Abril", false); // 4
        temporadaVacia.put("Mayo", false); // 5
        temporadaVacia.put("Junio", false); // 6
        temporadaVacia.put("Julio", false); // 7
        temporadaVacia.put("Agosto", false); // 8
        temporadaVacia.put("Septiembre", false); // 9
        temporadaVacia.put("Octubre", false); // 10
        temporadaVacia.put("Noviembre", false); // 11
        temporadaVacia.put("Diciembre", false); // 12     
        
        return temporadaVacia;
    }
    
    private static void loadInTemporada(String mes)
    {
        temporada.replace(mes, true);   
    }
}
