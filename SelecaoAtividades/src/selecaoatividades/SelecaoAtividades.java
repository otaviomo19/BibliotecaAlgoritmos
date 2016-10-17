/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selecaoatividades;

/**
 *
 * @author Otavio
 */
import java.util.*;
import java.lang.*;
import java.io.*;
 
class SelecaoAtividades {

    // Imprime um conjunto máximo de atividades que pode ser feito por um único
    // Pessoa, um de cada vez.
    // N -> Número total de actividades
    // S [] -> Uma matriz que contém a hora de início de todas as atividades
    // F [] -> Uma matriz que contém o tempo de chegada de todas as atividades
    
    public static void MaxAtivi(int s[], int f[], int n,PrintWriter gravarArq) {
    int i, j;
      
    System.out.print("\nAs atividades a seguir foram selecionadas : ");
    gravarArq.printf("\r\nAs atividades a seguir foram selecionadas : ");  
    
    // A primeira atividade sempre é selecionado
    i = 0;
    System.out.print(i+" ");
    gravarArq.printf(i+" ");
      
    
    // Considere resto das atividades
    for (j = 1; j < n; j++) {

          // Se esta atividade tem hora de início maior ou
         // Igual ao tempo de chegada dos previamente selecionados
         // Atividade, em seguida, selecione-o
         
         if (s[j] >= f[i]){
              System.out.print(j+" ");
              i = j;
              gravarArq.printf(i+" ");
          }
     }
    }
      

    public static void main(String[] args) throws IOException  {
   
    FileReader fileR = new FileReader("entradas.txt");
    BufferedReader buff = new BufferedReader(fileR);

    FileWriter arq = new FileWriter("resultados.txt");
    PrintWriter gravarArq = new PrintWriter(arq);
    
    String str;

        while(buff.ready()){
    
            str = buff.readLine();

            
            String[] arrayAtiv = str.split(" ");
            String part1 = arrayAtiv[0];
            String part2 = arrayAtiv[1];
           
            char[] aux1 = arrayAtiv[0].toCharArray();
            char[] aux2 = arrayAtiv[1].toCharArray();
            
            int[] s = new int[aux1.length];
            int[] f = new int[aux2.length];
            
           for ( int i = 0 ; i < aux1.length ; i++){
            s[i] = (int)aux1[i];
            f[i] = (int)aux2[i];
           
           }   
            int n = s.length;

            MaxAtivi(s, f, n,gravarArq);
       }
    arq.close();
    }
}