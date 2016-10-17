/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulopascal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Otavio
 */
public class TrianguloPascal {


// Uma solução baseada programação dinâmica que usa a tabela C [] [] para
// Calcular o binomial Coeficiente
 
    // Returns value of Binomial Coefficient C(n, k)
    static int binocomb(int n, int k) {
    
    int C[][] = new int[n+1][k+1];
    int i, j;
     

// Valor Calcular de coeficiente binomial em baixo para cima maneira
    for (i = 0; i <= n; i++)
    {
        for (j = 0; j <= min(i, k); j++)
        {
            // Caso base
            if (j == 0 || j == i)
                C[i][j] = 1;
      

// Calcular o valor usando os valores armazenados anteriormente 
            else
                C[i][j] = C[i-1][j-1] + C[i-1][j];
          }
     }
      
    return C[n][k];
    }
 

// Uma função de utilitário para voltar mínimo de dois inteiros
    static int min(int a, int b)
    {
    return (a<b)? a: b; 
    }
 
 
    public static void main(String args[]) throws IOException {
        
        FileReader fileR = new FileReader("entradas.txt");
        BufferedReader buff = new BufferedReader(fileR);
        
        FileWriter arq = new FileWriter("resultados.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
             
        
        String str;
        int param1,param2,resultado;
        
        while(buff.ready()){
    
            str = buff.readLine();
            
            String[] valores = str.split(" ");

            param1 = Integer.parseInt(valores[0]);
            param2 = Integer.parseInt(valores[1]);
    
 
    
    resultado = binocomb(param1,param2);
    
    System.out.println("Valor da Combinação de ("+param1+","+param2+") é "+resultado);
    
    gravarArq.printf("Valor da Combinação de ("+param1+","+param2+")" + resultado +"\r\n");
    }
    arq.close();
  }
}


