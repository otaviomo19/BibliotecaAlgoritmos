/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SimulatedAnnealing {

    // Calcular a probabilidade de aceitação
    public static double probAceitacao(int energy, int newEnergy, double temperatura) {
        // Se a nova solução for melhor, aceite
        if (newEnergy < energy) {
            return 1.0;
        }
        // Se a nova solução é pior, calcule uma probabilidade de aceitação
        return Math.exp((energy - newEnergy) / temperatura);
    }

    public static void main(String[] args) throws IOException {
        
       
        
        FileReader fileR = new FileReader("entradas.txt");
        BufferedReader buff = new BufferedReader(fileR);
        
        FileWriter arq = new FileWriter("resultados.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        
        String str;

        while(buff.ready()){
    
            str = buff.readLine();
            // Criar e adicionar nossas cidades
            String[] listParam = str.split(" ");
            int tam = listParam.length;

            for (int i =0; i < tam ; i++){
                String part1 = listParam[i];
                String part2 = listParam[i+1];  

                int param1 = Integer.parseInt(part1);
                int param2 = Integer.parseInt(part2);

               // System.out.println(param1+","+param2);
                i++;

                City city = new City(param1,param2);
                TourManager.addCity(city);
             }        

        // temperatura inicial
        double temp = 10000;

        // taxa de resfriamento
        double resfriamentoTaxa = 0.003;

        // Inicializar solução inicial
        Tour solucaoAtual = new Tour();
        solucaoAtual.generateIndividual();
        
        System.out.println("Distância inicial da solução : " + solucaoAtual.getDistancia());

        // Definir como melhor atual
        Tour best = new Tour(solucaoAtual.getTour());
        
        // Loop até que o sistema tenha resfriado
        while (temp > 1) {
           // Criar novo passeio pelos vizinhos
            Tour newSolution = new Tour(solucaoAtual.getTour());

            //Gerar posições aleatorias na cidade
            int tourPos1 = (int) (newSolution.tourSize() * Math.random());
            int tourPos2 = (int) (newSolution.tourSize() * Math.random());

            // recupera as cidades em posições selecionadas no tour
            City citySwap1 = newSolution.getCity(tourPos1);
            City citySwap2 = newSolution.getCity(tourPos2);

            // Troque-as
            newSolution.setCity(tourPos2, citySwap1);
            newSolution.setCity(tourPos1, citySwap2);
            
            // Obter energia de soluções
            int atualEnergy = solucaoAtual.getDistancia();
            int vizinhoEnergy = newSolution.getDistancia();

            // Decidir se devemos aceitar o vizinho
            if (probAceitacao(atualEnergy, vizinhoEnergy, temp) > Math.random()) {
                solucaoAtual = new Tour(newSolution.getTour());
            }

            // Acompanhe a melhor solução encontrada
            if (solucaoAtual.getDistancia() < best.getDistancia()) {
                best = new Tour(solucaoAtual.getTour());
            }
            
            //Sistema de refriamento
            temp *= 1-resfriamentoTaxa;
        }

            System.out.println("Distância final da solução : " + best.getDistancia());
            System.out.println("Tour: " + best);
            gravarArq.printf("Distancia inicial da solucao : " + solucaoAtual.getDistancia()+"\r\n");
            gravarArq.printf("Distancia final da solucao :"+best.getDistancia()+"\r\n");
            gravarArq.printf("Tour :" +best+"\r\n");
            gravarArq.printf("\r\n------------------------------\r\n");
      } 
    arq.close();
   }
}