package Analisador.Lexico;

import Common.IntegerStringPair;
import Common.Config;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalisadorLexico {
    public void analyser() {
        try (BufferedReader arquivo = new BufferedReader(new FileReader(Config.NOME_ARQUIVO_LEITURA))) {
            String arquivoFull = "";
            while (arquivo.ready()) {
                String linha = arquivo.readLine();
                arquivoFull += linha;
            }
            arquivo.close();

            String[] linhas = arquivoFull.split(Config.QUEBRA_LINHA);
            int numLinha = 0;
            ArrayList<IntegerStringPair> palavras = new ArrayList<>();

            for (String linha : linhas) {
                numLinha++;
                String palavra = "";
                for (int i = 0; i < linha.length(); i++) {
                    char caracter = linha.charAt(i);
                    if (caracter != ' ' && caracter != ',' && caracter != '.') {
                        palavra += caracter;
                    } else {
                        if (palavra.length() > 0) {
                            palavras.add(new IntegerStringPair(numLinha, palavra));
                            palavra = "";
                        }
                    }
                }
            }
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
        } catch (IOException ex) {
            System.out.println("ERRO: O Arquivo '" +Config.NOME_ARQUIVO_LEITURA+ "' não foi encontrado.");
        }
    }
}
