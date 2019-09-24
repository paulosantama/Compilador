package Analisador.Lexico;

import Common.Config;
import java.io.*;

public class LeArquivo {
    public static String[] lePrograma() {
        String[] linhas = null;
        try (BufferedReader arquivo = new BufferedReader(new FileReader(Config.NOME_ARQUIVO_LEITURA))) {
            String arquivoFull = "";
            while (arquivo.ready()) {
                String linha = arquivo.readLine();
                arquivoFull += linha;
            }
            arquivo.close();
            linhas = arquivoFull.split(Config.QUEBRA_LINHA);
            return linhas;
        } catch (IOException ex) {
            System.out.println("ERRO: O Arquivo '" +Config.NOME_ARQUIVO_LEITURA+ "' não foi encontrado.");
        }
        return linhas;
    }
}
