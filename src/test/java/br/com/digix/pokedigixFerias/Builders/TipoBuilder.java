package br.com.digix.pokedigixFerias.Builders;

import br.com.digix.pokedigixFerias.Tipo;

public class TipoBuilder {

    private String nome = "Psíquico";
    private String cor = "Pink";
    private String simbolo = "Psi";

    public Tipo construir() {
        return new Tipo(nome, cor, simbolo);
    }

    public TipoBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public TipoBuilder comCor(String cor) {
        this.cor = cor;
        return this;
    }

    public TipoBuilder comSimbolo(String simbolo) {
        this.simbolo = simbolo;
        return this;
    }

}
