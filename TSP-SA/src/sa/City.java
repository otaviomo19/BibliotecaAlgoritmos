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

public class City {
    int x;
    int y;
    
    
    public City(){
       // this.x = (int)(Math.random()*200);
       // this.y = (int)(Math.random()*200);
    }
    
    // Construtor com as coordenadas X,Y
    public City(int x, int y){
        this.x = x;
        this.y = y;
        //.out.println("X = "+x);
       // System.out.println("Y = "+y);
    }
    
    // retorna coordenada x da cidade
    public int getX(){
        return this.x;
    }
    
    // retorna coordenada y da cidade
    public int getY(){
        return this.y;
    }
    
    //retorna a distância para determinada cidade
    public double distancia(City city){
        int xDistancia = Math.abs(getX() - city.getX());
        int yDistancia = Math.abs(getY() - city.getY());
       // System.out.println("X = "+xDistance);
       // System.out.println("y = "+yDistance);
        double distancia = Math.sqrt( (xDistancia*xDistancia) + (yDistancia*yDistancia) );
        
        return distancia;
    }
    
    @Override
    public String toString(){
        return getX()+", "+getY();
    }
}