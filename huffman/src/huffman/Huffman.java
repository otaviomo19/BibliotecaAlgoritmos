/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

/**
 *
 * @author Otavio
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

abstract class HuffmanTree implements Comparable<HuffmanTree> {
    public final int frequency; // A frequência desta árvore
    
    public HuffmanTree(int freq) { 
        frequency = freq; 
    }

    
    // Compara na frequência
    public int compareTo(HuffmanTree tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanFolha extends HuffmanTree {
    public final char value; // O caracter que essa folha representa

    public HuffmanFolha(int freq, char val) {
        super(freq);
        value = val;
    }
}

class HuffmanNode extends HuffmanTree {
    public final HuffmanTree esq, dir; // subÀrvores

    public HuffmanNode(HuffmanTree l, HuffmanTree r) {
        super(l.frequency + r.frequency);
        esq = l;
        dir = r;
    }
}

public class Huffman {
    // Entrada é um conjunto de frequências, indexados pelo código de caracteres
    public static HuffmanTree buildTree(int[] charFreqs, char[] test2) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();

        // Inicialmente, temos uma floresta de folhas
        // Um ​​para cada caracter não-vazio
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanFolha(charFreqs[i], test2[i]));

        assert trees.size() > 0;
        
        // Faz um loop até que haja apenas uma árvore a esq
        while (trees.size() > 1) {

            // duas árvores com menos frequência
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();

            // Colocar em novo nó e re-inserção na fila
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }

    public static void printHuff(HuffmanTree tree, StringBuffer prefix,PrintWriter gravarArq) {
        assert tree != null;
        if (tree instanceof HuffmanFolha) {
            HuffmanFolha folha = (HuffmanFolha)tree;

            // Imprimir caráter, frequência e código para esta folha (que é apenas o prefixo)
            System.out.println(folha.value + "\t" + folha.frequency + "\t" + prefix);
            gravarArq.printf(folha.value + "\t" + folha.frequency + "\t" + prefix+"\r\n");

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;

            // andando pela esq
            prefix.append('0');
            printHuff(node.esq, prefix,gravarArq);
            prefix.deleteCharAt(prefix.length()-1);

            // andando pela dir
            prefix.append('1');
            printHuff(node.dir, prefix,gravarArq);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }

    public static void main(String[] args) throws IOException {
       
        FileReader fileR = new FileReader("entradas.txt");
        BufferedReader buff = new BufferedReader(fileR);
        
        FileWriter arq = new FileWriter("resultados.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
    
       String str,str1;
       
       gravarArq.printf("SIMBOL\tFREQ\tHUFFMAN COD\r\n");
       
       while(buff.ready()){
            
            str = buff.readLine();
            
            String[] arrayPalavras = str.split(" ");

            str1 = arrayPalavras[1];
             //Simbolos:
            char[] simbolo = arrayPalavras[1].toCharArray();
            int tamanho = Integer.parseInt(arrayPalavras[0]);
            
            //Frequencia (dos simbolos abaixo)
            int[] frequencia = new int[tamanho]; 
            
            for ( int i = 2 ; i <= tamanho ; i++){
                 
                frequencia[i-2]= Integer.parseInt(arrayPalavras[i]);
            }  

            // constroi a arvore
            HuffmanTree tree = buildTree(frequencia,simbolo);

            System.out.println("SIMBOL\tFREQ\tHUFFMAN COD");
            printHuff(tree, new StringBuffer(),gravarArq);
            System.out.println("----------------------------");
            gravarArq.printf("----------------------\r\n");
        }
    arq.close();
    }   
 }