package Lista;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Lista {

    private No inicio;

    public int getQuantidade() {
        return quantidade;
    }

    private int quantidade;

    public Lista()
    {
        quantidade = 0;
    }

    public void push(String nome, String tipo, Integer linha)
    {
        try
        {
            No no = new No(tipo, nome, linha);
            if (quantidade == 0)
            {
                inicio = no;
                quantidade++;
                return;
            }
            no.setProximo(inicio);
            inicio = no;
            quantidade++;
        }
        catch (Exception e)
        {
            System.out.println("Não foi possivel inserir elemento");
        }
    }
    public No pop(Integer posicao)
    {
        No anterior = null;
        No aux = inicio;
        for(int i = 0; i < posicao; i++)
        {
            anterior = aux;
            aux = aux.getProximo();
        }
        anterior.setProximo(aux.getProximo());
        quantidade--;
        return aux;
    }
    public No index(Integer ind)
    {
        No aux = inicio;
        for (int i = 0; i < ind; i++)
            aux = aux.getProximo();
        return aux;
    }
    public ArrayList<No> tipos(String tipo)
    {
        ArrayList<No> arrayList = new ArrayList<>();
        No aux = inicio;
        for (int i = 0; i < quantidade; i++) {
            if (aux.getTipo() == tipo)
                arrayList.add(aux);
            aux = aux.getProximo();
        }
        return arrayList;
    }
    public Integer ocorrencia(String nome)
    {
        No aux = inicio;
        int ocorrencias = 0;
        for (int i = 0; i < quantidade; i++) {
            if (aux.getNome() == nome)
                ocorrencias++;
            aux = aux.getProximo();
        }
        return ocorrencias;
    }
    public ArrayList<No> listar()
    {
        ArrayList<No> arrayList = new ArrayList<>();
        No aux = inicio;
        for (int i = 0; i < quantidade; i++) {
            arrayList.add(aux);
            aux = aux.getProximo();
        }
        return arrayList;
    }
}
