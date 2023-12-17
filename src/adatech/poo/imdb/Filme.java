package adatech.poo.imdb;

public class Filme {
    private String nomeFilme;
    private Diretor diretor;
    private Ator atorPrincipal;

    public Filme(String nomeFilme, Diretor diretor, Ator atorPrincipal) {
        this.nomeFilme = nomeFilme;
        this.diretor = diretor;
        this.atorPrincipal = atorPrincipal;
    }

    public String getNomeFilme() {
        return this.nomeFilme;
    }

    public Diretor getDiretor() {
        return this.diretor;
    }

    public Ator getAtorPrincipal() {
        return this.atorPrincipal;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public void setAtorPrincipal(Ator atorPrincipal) {
        this.atorPrincipal = atorPrincipal;
    }
}
