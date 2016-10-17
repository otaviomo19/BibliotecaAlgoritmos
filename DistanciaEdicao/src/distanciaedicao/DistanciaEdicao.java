/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distanciaedicao;

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
 * @author Otavio
 */

class DistanciaEdicao {
	
    static int min(int x,int y,int z) {
		if (x < y && x <z) 
                    return x;
		if (y < x && y < z) 
                    return y;
		else 
                    return z; }

    static int editorDist(String str1, String str2, int m, int n) {
       
        // Cria uma matrix guardar os resultados da execucação
        int dp[][] = new int[m+1][n+1];
    
        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
            // Se a primeira string estiver vazia, a unica opcao por todos os caracteres da segunda string
                if (i==0)
                    dp[i][j] = j;  // Min. operations = j
      
                // Se a segunda string estiver vazia, unica opcao é remover todos os caracteres da segunda string
                else if (j==0)
                    dp[i][j] = i; 
      
                // Se os ultimos caracteres sao iguais, ignora o ultimo caracter e recua para o resto da string
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
      
                // Se os ultimos caracteres sao diferentes, considere todas as possibilidades e encontre o minimo
                else                   //Insere - Remove - Substitui
                    dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j],dp[i-1][j-1]);  
                                       
            }
        }
  
        return dp[m][n];
    }

	


    public static void main(String[] args) throws IOException {
    
        FileReader fileR = new FileReader("entradas.txt");
        BufferedReader buff = new BufferedReader(fileR);
        
        FileWriter arq = new FileWriter("resultados.txt");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf("Primeira " + " Segunda " +" troca " +"\r\n");       
        
        String str1, str2,str;
        
        while(buff.ready()){
    
            str = buff.readLine();
            
            String[] arrayPalavras = str.split(" ");

            str1 = arrayPalavras[0];
            str2 = arrayPalavras[1];


            int troca;

            troca = editorDist( str1 , str2 , str1.length(), str2.length());

            System.out.println("Primeira Palavra : "+ str1 + "| Segunda Palavra : "+str2 + "| Numero de trocas : " + editorDist( str1 , str2 , str1.length(), str2.length()));

            gravarArq.printf(str1 + " " + str2 + " " + troca +"\r\n");
        }
  
    arq.close();
        
    }
}

