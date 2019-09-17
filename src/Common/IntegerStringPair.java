package Common;

public class IntegerStringPair {
    private int line;
    private String palavra;

    public IntegerStringPair(int line, String palavra) {
        this.line = line;
        this.palavra = palavra;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
}
