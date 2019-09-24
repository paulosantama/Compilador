package Lista;

public class No {
    private String tipo;
    private String nome;
    private Integer linha;
    private No proximo;

    public No(String tipo, String nome, Integer linha)
    {
        proximo = null;
        this.tipo = tipo;
        this.nome = nome;
        this.linha = linha;
    }

    public String getTipo() {
        return tipo;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getLinha() {
        return linha;
    }

    public void setLinha(Integer linha) {
        this.linha = linha;
    }
}
