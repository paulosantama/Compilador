package Lista;

public class Lista {

    private No inicio;
    private int quantidade;

    public Lista()
    {
        quantidade = 0;
    }

    public void inserir(String nome, String tipo, Integer linha)
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

}
