package Analisador.Lexico;

import Common.IntegerStringPair;
import Common.Config;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Lista.*;

public class AnalisadorLexico {
//    private char[] letter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private ArrayList<String> operator;
    private ArrayList<String> digit;
    private ArrayList<String> letter;
    public AnalisadorLexico()
    {
        operator = new ArrayList<>();
        digit = new ArrayList<>();
        letter = new ArrayList<>(Arrays.asList (new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}));
        digit.add("0");
        digit.add("1");
        digit.add("2");
        digit.add("3");
        digit.add("4");
        digit.add("5");
        digit.add("6");
        digit.add("7");
        digit.add("8");
        digit.add("9");
        operator.add("+");
        operator.add("-");
        operator.add("/");
        operator.add("=");
        operator.add("!=");
        operator.add("<");
        operator.add(">");
        operator.add("<=");
        operator.add(">=");

    }

    public void analisador()
    {
        String [] linhas = LeArquivo.lePrograma();
        Lista listaLexemas = new Lista();
        ArrayList<IntegerStringPair> palavras = new ArrayList<>();
        int qualLinha = 0;
        // nome, tipo, linha
         for (String linha : linhas)
         {
             for (int i = 0; i < linha.length(); i++)
             {
                 if (letter.contains(Character.toString(linha.charAt(i))))
                 {
                     listaLexemas.push(Character.toString(linha.charAt(i)), "letter", qualLinha);
//                     System.out.printf("\n######################################\n<letter> = '%s'\n", linha.charAt(i));
                 }
                 else if (digit.contains(Character.toString(linha.charAt(i))))
                 {
                     listaLexemas.push(Character.toString(linha.charAt(i)), "digit", qualLinha);
//                     System.out.printf("\n######################################\n<digit> = '%s'\n", linha.charAt(i));
                 }
                 else if (operator.contains(Character.toString(linha.charAt(i))))
                 {
                     listaLexemas.push(Character.toString(linha.charAt(i)), "operator", qualLinha);
//                     System.out.printf("\n######################################\n<operator> = '%s'\n", linha.charAt(i));
                 }
                 else if (linha.charAt(i) == ' ')
                     continue;
//                     System.out.printf("\n######################################\n<space> = '%s'\n", linha.charAt(i));
                 else
                 {
                     System.out.printf("\n######################################\n<invalid> = '%s'\n", linha.charAt(i));
                 }
             }
             qualLinha++;
         }

         ArrayList<No> arrayList = listaLexemas.listar();
         for (No elemento : arrayList)
             System.out.printf("\nNome: %s\nLinha: %d\nTipo: %s\n", elemento.getNome(), elemento.getLinha(), elemento.getTipo());

//        try (BufferedWriter arquivoSaida = new BufferedWriter(new FileWriter(Config.NOME_ARQUIVO_ESCRITA))) {
//            palavras.forEach((palavra) -> {
//                try {
//                    arquivoSaida.append(palavra.getPalavra() + " -> linha " + palavra.getLine() + "\n");
//                } catch (IOException ex) {
//                    Logger.getLogger(AnalisadorLexico.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            });
//            arquivoSaida.close();
//        } catch (IOException ex) {
//            Logger.getLogger(AnalisadorLexico.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("ERRO: Houve um problema no arquivo de escrita. '"+Config.NOME_ARQUIVO_ESCRITA+"'");
//        }
//        System.out.println("O arquivo '"+Config.NOME_ARQUIVO_ESCRITA+"' foi gerado com sucesso!");
    }
}
