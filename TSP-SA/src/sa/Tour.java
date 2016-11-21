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
import java.util.Collections;

public class Tour{

    // Realiza o tour pelas cidades
    private ArrayList tour = new ArrayList<City>();
    // Cache
    private int distancia = 0;
    
    //Gera um novo tour
    public Tour(){
        for (int i = 0; i < TourManager.numCities(); i++) {
            tour.add(null);
        }
    }
    
    // Gera um tour de outro tour
    public Tour(ArrayList tour){
        this.tour = (ArrayList) tour.clone();
    }
    
    // Recupera as informacoes do tour
    public ArrayList getTour(){
        return tour;
    }

    // Cria um indivíduo aleatório
    public void generateIndividual() {
       // Percorre todas as nossas cidades de destino e adicione ao nosso tour
        for (int cityIndex = 0; cityIndex < TourManager.numCities(); cityIndex++) {
          setCity(cityIndex, TourManager.getCity(cityIndex));
        }
        // Reordenar aleatoriamente o tour
        Collections.shuffle(tour);
    }

    // Recupera uma cidade do tour
    public City getCity(int posicaoTour) {
        return (City)tour.get(posicaoTour);
    }

    // Define uma cidade em uma determinada posição dentro de um tour
    public void setCity(int posicaoTour, City city) {
        tour.set(posicaoTour, city);
        // Se os tours forem alterados, precisamos redefinir a distância
        distancia = 0;
    }
    
    // Recupera a distância total do tour
    public int getDistancia(){
        if (distancia == 0) {
            int tourDistancia = 0;
            // Percorra as cidades do tour
            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
                // Recupera a cidade que esta viajando
                City fromCity = getCity(cityIndex);
                // Cidade que estamos viajando para
                City destinoCity;
                // Verifique que nao esta na ultima cidade da nossa turne, se estamos
                // cidade de destino final da excursao para nossa cidade de partida
                if(cityIndex+1 < tourSize()){
                    destinoCity = getCity(cityIndex+1);
                }
                else{
                    destinoCity = getCity(0);
                }
                // Get the distance between the two cities
                tourDistancia += fromCity.distancia(destinoCity);
            }
            distancia = tourDistancia;
        }
        return distancia;
    }

    // Recupera a distância entre as duas cidades
    public int tourSize() {
        return tour.size();
    }
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCity(i)+"|";
        }
        return geneString;
    }
}
