package Analisador.Lexico;

import Common.Config;
import Common.IntegerStringPair;

import java.util.ArrayList;
import java.util.Arrays;

import Lista.*;

public class AnalisadorLexico {
    final static String LETTER = "letter";
    final static String DIGIT = "digit";
    final static String OPERATOR = "operator";
    final static String NUMBER = "number";
    final static String ID = "id";
    final static String IDENTIFIER = "identifier";
    final static String SPACE = "space";
    final static String QUEBRA_DE_LINHA = "quebra";

    private ArrayList<String> operator;
    private ArrayList<String> digit;
    private ArrayList<String> letter;

    public AnalisadorLexico() {

        operator = new ArrayList<>();
        digit = new ArrayList<>();
        letter = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
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

    public void analisador() {
        String[] linhas = LeArquivo.lePrograma();
        ArrayList<IntegerStringPair> palavras = new ArrayList<>();
        int qualLinha = 0;
        Lista listaLexemas = new Lista();
//        1ª Etapa
        for (String linha : linhas) {
            for (int i = 0; i < linha.length(); i++) {
                if (letter.contains(Character.toString(linha.charAt(i)))) {
                    listaLexemas.push(Character.toString(linha.charAt(i)), LETTER, qualLinha);
                } else if (digit.contains(Character.toString(linha.charAt(i)))) {
                    listaLexemas.push(Character.toString(linha.charAt(i)), DIGIT, qualLinha);
                } else if (operator.contains(Character.toString(linha.charAt(i)))) {
                    listaLexemas.push(Character.toString(linha.charAt(i)), OPERATOR, qualLinha);
                } else if (linha.charAt(i) == ' ') {
                    listaLexemas.push(" ", SPACE, qualLinha);
                }else if (Character.toString(linha.charAt(i)).equals(Config.QUEBRA_LINHA)){
                    listaLexemas.push(";", QUEBRA_DE_LINHA, qualLinha);
                }else {
                    System.out.printf("\n######################################\n<invalid> = '%s'\n", linha.charAt(i));
                }
            }
            qualLinha++;
        }
        ArrayList<No> lexemasV1 = listaLexemas.listar();

//         2ª Etapa
        ArrayList<No> lexemasV2 = new ArrayList<No>();
        if (lexemasV1.size() > 0) {
            lexemasV2.add(lexemasV1.get(0));
        } else {
            return;
        }

        for (No elemento : lexemasV1) {
            if (elemento == lexemasV1.get(0)) continue;

            No ultimoLexemaV2 = lexemasV2.get(lexemasV2.size() - 1);
            switch (elemento.getTipo()) {
                case DIGIT:
                    switch (ultimoLexemaV2.getTipo()) {
                        case DIGIT:
                        case NUMBER:
                            ultimoLexemaV2.setNome(ultimoLexemaV2.getNome() + elemento.getNome());
                            ultimoLexemaV2.setTipo(NUMBER);
                            break;
                        case LETTER:
                        case ID:
                            elemento.setTipo(ID);
                            lexemasV2.add(elemento);
                            break;
                        case OPERATOR:
                        case SPACE:
                        case Config.QUEBRA_LINHA:
                            elemento.setTipo(NUMBER);
                            lexemasV2.add(elemento);
                            break;
                    }
                    break;
                case LETTER:
                    if (ultimoLexemaV2.getTipo().equals(LETTER) || ultimoLexemaV2.getTipo().equals(ID)){
                        elemento.setTipo(ID);
                        lexemasV2.add(elemento);
                    }else{
                        lexemasV2.add(elemento);
                    }
                    break;
                case OPERATOR:
                case SPACE:
                case QUEBRA_DE_LINHA:
                    lexemasV2.add(elemento);
                    break;
            }
        }


//        3ª Etapa
        ArrayList<No> lexemasV3 = new ArrayList<No>();
        if (lexemasV2.size() > 0) {
            lexemasV3.add(lexemasV2.get(0));
        } else {
            return;
        }

        for (No elemento : lexemasV2) {
            if (elemento == lexemasV3.get(0)) continue;

            No ultimoLexemaV3 = lexemasV3.get(lexemasV3.size() - 1);
            switch (elemento.getTipo()) {
                case LETTER:
                case OPERATOR:
                case NUMBER:
                    lexemasV3.add(elemento);
                    break;
                case ID:
                    if (ultimoLexemaV3.getTipo().equals(LETTER) || ultimoLexemaV3.getTipo().equals(ID) || ultimoLexemaV3.getTipo().equals(IDENTIFIER)){
                        ultimoLexemaV3.setNome(ultimoLexemaV3.getNome() + elemento.getNome());
                        ultimoLexemaV3.setTipo(IDENTIFIER);
                    }
                    break;
            }
        }
        Lista lexemasFinal = new Lista();
        lexemasFinal.converter(lexemasV3);
        showProgress(lexemasFinal);
    }

    private void showProgress(Lista arr){
        String string = "";
        ArrayList<String> tokens = new ArrayList<>();

        for (int i = 0; i < arr.getQuantidade(); i++){
            string += String.format("Nome: '%s' - Tipo: '%s' - Linha: '%d'%n", arr.index(i).getNome(), arr.index(i).getTipo(), arr.index(i).getLinha());
            if (!tokens.contains(arr.index(i).getNome()))
                tokens.add(arr.index(i).getNome());
        }

        string += "\n";

        for (String token : tokens)
            string += String.format("Token: '%s' - Ocorrencia: '%s'%n", token, arr.ocorrencia(token));

        System.out.println(string);
        SalvaArquivo.salva(string);
    }
}
