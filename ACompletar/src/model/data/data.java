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
        peces.add(new Pez("Arowana", temporada, "16:00 - 9:00", Habitad.RIO, Frecuencia.POCA));
        
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
        peces.add(new Pez("Betta", temporada, "9:00 - 16:00", Habitad.RIO, Frecuencia.MUYPOCA));
        
        // Bichir ensillado
        temporada = reloadTemporada();
        loadInTemporada("Junio");
        loadInTemporada("Julio");
        loadInTemporada("Agosto");
        loadInTemporada("Septiembre");
        peces.add(new Pez("Bichir ensillado", temporada, "21:00 - 4:00", Habitad.RIO, Frecuencia.POCA));
        
        // Boquerón
        temporada = reloadTemporada();
        loadInTemporada("Enero");
        loadInTemporada("Febrero");
        loadInTemporada("Marzo");
        loadInTemporada("Abril");
        loadInTemporada("Mayo");
        loadInTemporada("Junio");
        loadInTemporada("Julio");
        loadInTemporada("Agosto");
        loadInTemporada("Septiembre");
        loadInTemporada("Octubre");
        loadInTemporada("Noviembre");
        loadInTemporada("Dicienbre");
        peces.add(new Pez("Boquerón", temporada, "4:00 - 21:00", Habitad.MAR, Frecuencia.FRECUENTE));
        
        // Caballito de mar
        temporada = reloadTemporada();
        loadInTemporada("Abril");
        loadInTemporada("Mayo");
        loadInTemporada("Junio");
        loadInTemporada("Julio");
        loadInTemporada("Agosto");
        loadInTemporada("Septiembre");
        loadInTemporada("Octubre");
        loadInTemporada("Noviembre");
        peces.add(new Pez("Caballito de mar", temporada, "24h", Habitad.MAR, Frecuencia.POCA));
        
        // Cacho
        temporada = reloadTemporada();
        loadInTemporada("Enero");
        loadInTemporada("Febrero");
        loadInTemporada("Marzo");
        loadInTemporada("Abril");
        loadInTemporada("Mayo");
        loadInTemporada("Junio");
        loadInTemporada("Julio");
        loadInTemporada("Agosto");
        loadInTemporada("Septiembre");
        loadInTemporada("Octubre");
        loadInTemporada("Noviembre");
        loadInTemporada("Dicienbre");
        pez = new Pez("Cacho", temporada, "9:00 - 16:00", Habitad.RIO, Frecuencia.MUCHA);
        peces.add(pez);
        
        // Calamar
        temporada = reloadTemporada();
        loadInTemporada("Enero");
        loadInTemporada("Febrero");
        loadInTemporada("Marzo");
        loadInTemporada("Abril");
        loadInTemporada("Mayo");
        loadInTemporada("Junio");
        loadInTemporada("Julio");
        loadInTemporada("Agosto");
        loadInTemporada("Dicienbre");
        peces.add(new Pez("Calamar", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));
        
        // Cangrejo de río
        temporada = reloadTemporada();
        loadInTemporada("Abril");
        loadInTemporada("Mayo");
        loadInTemporada("Junio");
        loadInTemporada("Julio");
        loadInTemporada("Agosto");
        loadInTemporada("Septiembre");
        peces.add(new Pez("Cangrejo de río", temporada, "24h", Habitad.ESTANQUE, Frecuencia.MUCHA));
        
        // Cangrejo de Shanghái
        temporada = reloadTemporada();
        loadInTemporada("Septiembre");
        loadInTemporada("Octubre");
        loadInTemporada("Noviembre");
        peces.add(new Pez("Cangrejo de Shanghái", temporada, "16:00 - 9:00", Habitad.RIO, Frecuencia.POCA));
        
        // Carpa
        temporada = reloadTemporada();
        loadInTemporada("Enero");
        loadInTemporada("Febrero");
        loadInTemporada("Marzo");
        loadInTemporada("Abril");
        loadInTemporada("Mayo");
        loadInTemporada("Junio");
        loadInTemporada("Julio");
        loadInTemporada("Agosto");
        loadInTemporada("Septiembre");
        loadInTemporada("Octubre");
        loadInTemporada("Noviembre");
        loadInTemporada("Dicienbre");
        peces.add(new Pez("Carpa", temporada, "24h", Habitad.ESTANQUE, Frecuencia.FRECUENTE));
        
        // Carpín
        temporada = reloadTemporada();
        loadInTemporada("Enero");
        loadInTemporada("Febrero");
        loadInTemporada("Marzo");
        loadInTemporada("Abril");
        loadInTemporada("Mayo");
        loadInTemporada("Junio");
        loadInTemporada("Julio");
        loadInTemporada("Agosto");
        loadInTemporada("Septiembre");
        loadInTemporada("Octubre");
        loadInTemporada("Noviembre");
        loadInTemporada("Dicienbre"); 
        peces.add(new Pez("Carpín", temporada, "24h", Habitad.RIO, Frecuencia.MUCHA));
        
        // Celacanto CON LLUVIA
        temporada = reloadTemporada();
        loadInTemporada("Enero");
        loadInTemporada("Febrero");
        loadInTemporada("Marzo");
        loadInTemporada("Abril");
        loadInTemporada("Mayo");
        loadInTemporada("Junio");
        loadInTemporada("Julio");
        loadInTemporada("Agosto");
        loadInTemporada("Septiembre");
        loadInTemporada("Octubre");
        loadInTemporada("Noviembre");
        loadInTemporada("Dicienbre");
        peces.add(new Pez("Celacanto", temporada, "24h", Habitad.MAR, Frecuencia.POCA));
        
        // Dorada japonesa
        temporada = reloadTemporada();
        loadInTemporada("Marzo");
        loadInTemporada("Abril");
        loadInTemporada("Mayo");
        loadInTemporada("Junio");
        loadInTemporada("Julio");
        loadInTemporada("Agosto");
        loadInTemporada("Septiembre");
        loadInTemporada("Octubre");
        loadInTemporada("Noviembre");
        peces.add(new Pez("Dorada japonesa", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));
        
        // Dorado
        temporada = reloadTemporada();
        /*
        loadInTemporada("Enero");
        loadInTemporada("Febrero");
        loadInTemporada("Marzo");
        loadInTemporada("Abril");
        loadInTemporada("Mayo");
        loadInTemporada("Junio");
        loadInTemporada("Julio");
        loadInTemporada("Agosto");
        loadInTemporada("Septiembre");
        loadInTemporada("Octubre");
        loadInTemporada("Noviembre");
        loadInTemporada("Dicienbre");
         */
        peces.add(new Pez("Dorado", temporada, "4:00 - 21:00", Habitad.RIO, Frecuencia.MUYPOCA));
        
        // Eperlano
        temporada = reloadTemporada();
        peces.add(new Pez("Eperlano", temporada, "24h", Habitad.RIO, Frecuencia.MUCHA));
        
        // Esturión
        temporada = reloadTemporada();
        peces.add(new Pez("Esturión", temporada, "24h", Habitad.DESEMBOCADURA, Frecuencia.POCA));
        
        // Gallo
        temporada = reloadTemporada();
        peces.add(new Pez("Gallo", temporada, "24h", Habitad.MAR, Frecuencia.MUCHA));
        
        // Gobio de río
        temporada = reloadTemporada();
        peces.add(new Pez("Gobio de río", temporada, "16:00 - 9:00", Habitad.RIO, Frecuencia.FRECUENTE));
        
        // Gupi
        temporada = reloadTemporada();
        peces.add(new Pez("Gupi", temporada, "9:00 - 16:00", Habitad.RIO, Frecuencia.FRECUENTE));
        
        // Jurel
        temporada = reloadTemporada();
        peces.add(new Pez("Jurel", temporada, "24h", Habitad.MAR, Frecuencia.MUCHA));
        
        // Jurel gigante
        temporada = reloadTemporada();
        peces.add(new Pez("Jurel gigante", temporada, "24h", Habitad.MUELLE, Frecuencia.MUYPOCA));
        
        // Killi
        temporada = reloadTemporada();
        peces.add(new Pez("Killi", temporada, "24h", Habitad.ESTANQUE, Frecuencia.FRECUENTE));
        
        // Koi
        temporada = reloadTemporada();
        peces.add(new Pez("Koi", temporada, "16:00h - 9:00h", Habitad.ESTANQUE, Frecuencia.POCA));
        
        // Lampuga
        temporada = reloadTemporada();
        peces.add(new Pez("Lampuga", temporada, "24h", Habitad.MUELLE, Frecuencia.MUYPOCA));
        
        // Leucisco
        temporada = reloadTemporada();
        peces.add(new Pez("Leucisco", temporada, "16:00 - 9:00", Habitad.RIO, Frecuencia.MUCHA));
        
        // Locha
        temporada = reloadTemporada();
        peces.add(new Pez("Locha", temporada, "24h", Habitad.RIO, Frecuencia.MUCHA));
        
        // Lubina
        temporada = reloadTemporada();
        peces.add(new Pez("Lubina", temporada, "24h", Habitad.MAR, Frecuencia.MUCHA));
        
        // Lucio
        temporada = reloadTemporada();
        peces.add(new Pez("Lucio", temporada, "24h", Habitad.RIO, Frecuencia.POCA));
        
        // Mariposa marina
        temporada = reloadTemporada();
        peces.add(new Pez("Mariposa marina", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));
        
        // Morena
        temporada = reloadTemporada();
        peces.add(new Pez("Morena", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));
        
        // Pargo rojo
        temporada = reloadTemporada();
        peces.add(new Pez("Pargo rojo", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));
        
        // Perca
        temporada = reloadTemporada();
        peces.add(new Pez("Perca", temporada, "24h", Habitad.RIO, Frecuencia.MUCHA));
        
        // Perca amarilla
        temporada = reloadTemporada();
        peces.add(new Pez("Perca amarilla", temporada, "24h", Habitad.RIO, Frecuencia.MUCHA));
                
        // Pez ángel
        temporada = reloadTemporada();
        peces.add(new Pez("Pez ángel", temporada, "16:00 - 9:00", Habitad.RIO, Frecuencia.POCA));
        
        // Pez arcoíris
        temporada = reloadTemporada();
        peces.add(new Pez("Pez arcoíris", temporada, "9:00 - 16:00", Habitad.RIO, Frecuencia.FRECUENTE)); 
        
        // Pez balón
        temporada = reloadTemporada();
        peces.add(new Pez("Pez balón", temporada, "16:00 - 9:00", Habitad.MAR, Frecuencia.POCA)); 
        
        // Pez cabeza de serpiente
        temporada = reloadTemporada();
        peces.add(new Pez("Pez cabeza de serpiente", temporada, "9:00 - 16:00", Habitad.ESTANQUE, Frecuencia.MUYPOCA)); 
        
        // Pez cabeza transparente
        temporada = reloadTemporada();
        peces.add(new Pez("Pez cabeza transparente", temporada, "21:00 - 4:00", Habitad.MAR, Frecuencia.MUYPOCA)); 
        
        // Pez caimán
        temporada = reloadTemporada();
        peces.add(new Pez("Pez caimán", temporada, "16:00 - 9:00", Habitad.ESTANQUE, Frecuencia.MUYPOCA)); 
        
        // Pez cirujano
        temporada = reloadTemporada();
        peces.add(new Pez("Pez cirujano", temporada, "24h", Habitad.MAR, Frecuencia.POCA)); 
        
        // Pez doctor
        temporada = reloadTemporada();
        peces.add(new Pez("Pez doctor", temporada, "9:00 - 16:00", Habitad.RIO, Frecuencia.FRECUENTE)); 
        
        // Pez dorado
        temporada = reloadTemporada();
        peces.add(new Pez("Pez dorado", temporada, "24h", Habitad.ESTANQUE, Frecuencia.FRECUENTE)); 
        
        // Pez erizo
        temporada = reloadTemporada();
        peces.add(new Pez("Pez erizo", temporada, "24h", Habitad.MAR, Frecuencia.MUCHA)); 
        
        // Pez espada
        temporada = reloadTemporada();
        peces.add(new Pez("Pez espada", temporada, "24h", Habitad.MUELLE, Frecuencia.MUYPOCA)); 
        
        // Pez globo
        temporada = reloadTemporada();
        peces.add(new Pez("Pez globo", temporada, "21:00 - 4:00", Habitad.MAR, Frecuencia.POCA)); 
        
        // Pez león
        temporada = reloadTemporada();
        peces.add(new Pez("Pez león", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE)); 
        
        // Pez luna
        temporada = reloadTemporada();
        peces.add(new Pez("Pez luna", temporada, "4:00 - 21:00", Habitad.MAR, Frecuencia.MUYPOCA)); 
        
        // Pez mariposa
        temporada = reloadTemporada();
        peces.add(new Pez("Pez mariposa", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));
        
        // Pez martillo
        temporada = reloadTemporada();
        peces.add(new Pez("Pez martillo", temporada, "16:00 - 9:00", Habitad.MAR, Frecuencia.POCA));
        
        // Pez napoleón
        temporada = reloadTemporada();
        peces.add(new Pez("Pez napoleón", temporada, "4:00 - 21:00", Habitad.MAR, Frecuencia.POCA));
        
        // Pez payaso
        temporada = reloadTemporada();
        peces.add(new Pez("Pez payaso", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));
        
        // Pez remo
        temporada = reloadTemporada();
        peces.add(new Pez("Pez remo", temporada, "24h", Habitad.MAR, Frecuencia.POCA));
        
        // Pez sierra
        temporada = reloadTemporada();
        peces.add(new Pez("Pez sierra", temporada, "16:00 - 9:00", Habitad.MAR, Frecuencia.POCA));
        
        // Pez sol
        temporada = reloadTemporada();
        peces.add(new Pez("Pez sol", temporada, "9:00 - 16:00", Habitad.RIO, Frecuencia.MUCHA));
        
        // Pez telescopio
        temporada = reloadTemporada();
        peces.add(new Pez("Pez telescopio", temporada, "9:00 - 16:00", Habitad.ESTANQUE, Frecuencia.FRECUENTE));
        
        // Piraña
        temporada = reloadTemporada();
        peces.add(new Pez("Piraña", temporada, "9:00 - 16:00 y 21:00 - 4:00", Habitad.RIO, Frecuencia.FRECUENTE));
        
        // Pirarucú
        temporada = reloadTemporada();
        peces.add(new Pez("Pirarucú", temporada, "16:00 - 9:00", Habitad.RIO, Frecuencia.POCA));
        
        // Rana
        temporada = reloadTemporada();
        peces.add(new Pez("Rana", temporada, "24h", Habitad.ESTANQUE, Frecuencia.FRECUENTE));
        
        // Ranchú
        temporada = reloadTemporada();
        peces.add(new Pez("Ranchú", temporada, "9:00 - 16:00", Habitad.ESTANQUE, Frecuencia.POCA));
                
        // Raya
        temporada = reloadTemporada();
        peces.add(new Pez("Raya", temporada, "4:00 - 21:00", Habitad.MAR, Frecuencia.POCA));     
        
        // Rémora
        temporada = reloadTemporada();
        peces.add(new Pez("Rémora", temporada, "24h", Habitad.MAR, Frecuencia.POCA));
        
        // Renacuajo
        temporada = reloadTemporada();
        peces.add(new Pez("Renacuajo", temporada, "24h", Habitad.ESTANQUE, Frecuencia.FRECUENTE));
        
        // Rodaballo
        temporada = reloadTemporada();
        peces.add(new Pez("Rodaballo", temporada, "24h", Habitad.MAR, Frecuencia.MUCHA));
        
        // Salmón
        temporada = reloadTemporada();
        peces.add(new Pez("Salmón", temporada, "24h", Habitad.DESEMBOCADURA, Frecuencia.FRECUENTE));
        
        // Salmón japonés
        temporada = reloadTemporada();
        peces.add(new Pez("Salmón japonés", temporada, "16:00 - 9:00", Habitad.CASCADA, Frecuencia.POCA));
        
        // Salmón real
        temporada = reloadTemporada();
        peces.add(new Pez("Salmón real", temporada, "24h", Habitad.DESEMBOCADURA, Frecuencia.FRECUENTE));
        
        // Siluro
        temporada = reloadTemporada();
        peces.add(new Pez("Siluro", temporada, "16:00 - 9:00", Habitad.ESTANQUE, Frecuencia.FRECUENTE));
        
        // Taimén
        temporada = reloadTemporada();
        peces.add(new Pez("Taimén", temporada, "16:00 - 9:00", Habitad.CASCADA, Frecuencia.MUYPOCA));
        
        // Tetra neón
        temporada = reloadTemporada();
        peces.add(new Pez("Tetra neón", temporada, "9:00 - 16:00", Habitad.RIO, Frecuencia.FRECUENTE));
        
        // Tiburón
        temporada = reloadTemporada();
        peces.add(new Pez("Tiburón", temporada, "16:00 - 9:00", Habitad.MAR, Frecuencia.POCA));
        
        // Tiburón ballena
        temporada = reloadTemporada();
        peces.add(new Pez("Tiburón ballena", temporada, "24h", Habitad.MAR, Frecuencia.POCA));
        
        // Tilapia
        temporada = reloadTemporada();
        peces.add(new Pez("Tilapia", temporada, "24h", Habitad.RIO, Frecuencia.FRECUENTE));
        
        // Tortuga caparazón blando
        temporada = reloadTemporada();
        peces.add(new Pez("Tortuga caparazón blando", temporada, "16:00 - 9:00", Habitad.RIO, Frecuencia.FRECUENTE));
        
        // Tortuga mordedora
        temporada = reloadTemporada();
        peces.add(new Pez("Tortuga mordedora", temporada, "21:00 - 4:00", Habitad.RIO, Frecuencia.POCA));
        
        // Trucha
        temporada = reloadTemporada();
        peces.add(new Pez("Trucha", temporada, "16:00 - 9:00", Habitad.CASCADA, Frecuencia.POCA));
        
        // Trucha dorada
        temporada = reloadTemporada();
        peces.add(new Pez("Trucha dorada", temporada, "16:00 - 9:00", Habitad.CASCADA, Frecuencia.MUYPOCA));
         
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
