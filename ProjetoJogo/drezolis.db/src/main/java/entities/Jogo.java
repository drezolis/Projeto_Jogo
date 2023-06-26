package entities;

public class Jogo {

    private int id;
    private String nome;
    private String tema;
    private int pontMax;

    public Jogo(String nome, String tema, int pontMax) {
        this.nome = nome;
        this.tema = tema;
        this.pontMax = pontMax;
    }

    public Jogo() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getPontMax() {
        return pontMax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", nome = '" + nome + '\'' +
                ", tema= '" + tema + '\'' +
                ", pontMax = " + pontMax;
    }
}
