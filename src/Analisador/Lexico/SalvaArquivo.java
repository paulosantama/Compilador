package Analisador.Lexico;

import Common.Config;

import java.io.*;

public class SalvaArquivo {
    static void salva(String string) {
        try  {
            FileWriter arquivo = new FileWriter(Config.NOME_ARQUIVO_ESCRITA);
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            gravarArquivo.print(string);
            arquivo.close();
        } catch (IOException ex) {
            System.out.println("ERRO: O Arquivo '" +Config.NOME_ARQUIVO_ESCRITA+ "' não foi encontrado.");
        }
    }
}
