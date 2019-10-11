package Common;

public class Erro {
    private int linha;
    private String mensagem;
    private String alvo;

    public Erro(int linha, String mensagem, String alvo) {
        this.linha = linha;
        this.mensagem = mensagem;
        this.alvo = alvo;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getAlvo() {
        return alvo;
    }

    public void setAlvo(String alvo) {
        this.alvo = alvo;
    }
}
