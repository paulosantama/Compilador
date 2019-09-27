package Analisador.Lexico;

import Common.Config;
import java.io.*;

class LeArquivo {
    static String[] lePrograma() {
        String[] linhas = null;
        try (BufferedReader arquivo = new BufferedReader(new FileReader(Config.NOME_ARQUIVO_LEITURA))) {
            StringBuilder arquivoFull = new StringBuilder();
            while (arquivo.ready()) {
                String linha = arquivo.readLine();
                arquivoFull.append(linha);
            }
            arquivo.close();
            linhas = arquivoFull.toString().split(Config.QUEBRA_LINHA);

            for (int i = 0; i < linhas.length; i++){
                if (linhas[i].length()>0) linhas[i] += ";";
            }
            return linhas;
        } catch (IOException ex) {
            System.out.println("ERRO: O Arquivo '" +Config.NOME_ARQUIVO_LEITURA+ "' não foi encontrado.");
        }
        return linhas;
    }
}
