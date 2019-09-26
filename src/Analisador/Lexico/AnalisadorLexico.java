package Analisador.Lexico;

import Common.IntegerStringPair;
import Common.Config;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Lista.Lista;

public class AnalisadorLexico {
//    private char[] letter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private ArrayList<String> operator;
    private ArrayList<String> digt;
    private ArrayList<String> letter;
    public AnalisadorLexico()
    {
        operator = new ArrayList<>();
        digt = new ArrayList<>();
//
        letter = new ArrayList<>(Arrays.asList (new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}));
        digt.add("0");
        digt.add("1");
        digt.add("2");
        digt.add("3");
        digt.add("4");
        digt.add("5");
        digt.add("6");
        digt.add("7");
        digt.add("8");
        digt.add("9");
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

         for (String linha : linhas)
         {
             for (int i = 0; i < linha.length(); i++)
             {
                 if (!letter.contains(Character.toString(linha.charAt(i))))
                 {
                     System.out.println(linha.charAt(i));
                     System.out.println("Meu pinto");
                 }
                 else
                 {
                     System.out.println(linha.charAt(i));
                     System.out.println("Meu pinto kkk");
                 }

             }
         }
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
