/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package somasubconjunto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author USUARIO
 */
class SomaSubConj {
    //Retorna true se há um subconjunto de conjunto [] com o sol igual a soma dada
    
    static boolean isSubsetSum(int conj[], int n, int soma) {

                // O valor do subconjunto [i] [j] Sera Verdade se Houver
            // E Um subconjunto do Conjunto [0..j-1] com Uma soma igual a i
        boolean subconj[][] = new boolean[soma+1][n+1];
      
        
        // Se soma é 0, então resposta é verdadeira
        for (int i = 0; i <= n; i++)
          subconj[0][i] = true;
      
        
        // Se soma não é 0 e conjunto é vazio, então resposta é falsa
        for (int i = 1; i <= soma; i++)
          subconj[i][0] = false;
      
         
        // Preenche a tabela de subconjunto no botton up forma
         for (int i = 1; i <= soma; i++) {
            for (int j = 1; j <= n; j++){
                subconj[i][j] = subconj[i][j-1];
                if (i >= conj[j-1])
                    subconj[i][j] = subconj[i][j] || subconj[i - conj[j-1]][j-1];
            }
         }
         return subconj[soma][n];
    }
    
    public static void main (String args[]) throws IOException {

        FileReader fileR = new FileReader("entradas.txt");
        BufferedReader buff = new BufferedReader(fileR);
        
        FileWriter arq = new FileWriter("resultados.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        
        String param1, param2,str;
        
        int o = 1;
        
        while(buff.ready()){
    
            str = buff.readLine();
            
            String[] valores = str.split(" ");
            
            int p = Integer.parseInt(valores[0]);
            int soma = Integer.parseInt(valores[1]);
            int[] conjunto = new int[p] ;
           
            for ( int i = 2 ; i <= p ; i++){
                 
                conjunto[i-1]= Integer.parseInt(valores[i]);
            }
                    
          int tam = conjunto.length;
          if (isSubsetSum(conjunto, tam, soma) == true){
             System.out.println("Exemplo - " + o +" Soma esperada = " + soma + " - Encontrou um subconjunto com uma soma dada");
             gravarArq.printf("Exemplo - " + o +" Soma esperada = " + soma + " - Encontrou um subconjunto com uma soma dada\r\n");  
            }
          else{
             System.out.println("Exemplo - " + o +" Soma esperada = " + soma + " - Nao encontrou um subconjunto com a soma dada");
            gravarArq.printf("Exemplo - " + o +" Soma esperada = " + soma + " - Nao encontrou um subconjunto com a soma dada\r\n");     
            }
        o++;        
        }
    arq.close();
    }
 }