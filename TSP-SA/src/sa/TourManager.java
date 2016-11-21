/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
* 
* 
*/

package sa;

import java.util.ArrayList;

public class TourManager {

    // Mantém nossas cidades
    private static ArrayList cidadeDestinos = new ArrayList<City>();

    // Adiciona uma cidade de destino
    public static void addCity(City city) {
        cidadeDestinos.add(city);
    }
    
    //Recupera uma cidade
    public static City getCity(int index){
        return (City)cidadeDestinos.get(index);
    }
    
    // Recupera o numero de cidades destinos
    public static int numCities(){
        return cidadeDestinos.size();
    }
    
}