package Analisador.Lexico;

import Common.IntegerStringPair;
import Common.Config;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Lista.Lista;

public class AnalisadorLexico {
    private char[] letter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private char[] digt = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private ArrayList<String> operator;
    public AnalisadorLexico()
    {
        operator = new ArrayList<>();
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
             for (int i = 0; i < linha.length(); i++) {
                 operator.contains(linha[i]);
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
