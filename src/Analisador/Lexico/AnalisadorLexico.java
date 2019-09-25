package Analisador.Lexico;

import Common.IntegerStringPair;
import Common.Config;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Lista.Lista;

public class AnalisadorLexico {
    private String[] letter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}; 
    private String[] digt = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public void analisador()
    {
        String [] linhas = LeArquivo.lePrograma();
        Lista listaLexemas = new Lista();
        int numLinha = 0;
        ArrayList<IntegerStringPair> palavras = new ArrayList<>();
        
        for (String linha : linhas) 
        {
            for(int i = 0; i < linha.length(); i++)
            {

            }       
        }
        // for (String linha : linhas) {
        //     numLinha++;
        //     String palavra = "";
        //     for (int i = 0; i < linha.length(); i++) {
        //         char caracter = linha.charAt(i);
        //         if (caracter != ' ' && caracter != ',' && caracter != '.') {
        //             palavra += caracter;
        //         } else {
        //             if (palavra.length() > 0) {
        //                 palavras.add(new IntegerStringPair(numLinha, palavra));
        //                 palavra = "";
        //             }
        //         }
        //     }
        // }
        try (BufferedWriter arquivoSaida = new BufferedWriter(new FileWriter(Config.NOME_ARQUIVO_ESCRITA))) {
            palavras.forEach((palavra) -> {
                try {
                    arquivoSaida.append(palavra.getPalavra() + " -> linha " + palavra.getLine() + "\n");
                } catch (IOException ex) {
                    Logger.getLogger(AnalisadorLexico.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            arquivoSaida.close();
        } catch (IOException ex) {
            Logger.getLogger(AnalisadorLexico.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO: Houve um problema no arquivo de escrita. '"+Config.NOME_ARQUIVO_ESCRITA+"'");
        }
        System.out.println("O arquivo '"+Config.NOME_ARQUIVO_ESCRITA+"' foi gerado com sucesso!");
    }
    public bool verificaCaractere(String caractere)
    {
        
        for (String cara : this.letter)
        {
            
        }
    }
}
