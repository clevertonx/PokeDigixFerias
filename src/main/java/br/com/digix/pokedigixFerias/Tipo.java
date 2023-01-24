package br.com.digix.pokedigixFerias;

public class Tipo {

    private String nome;
    private String cor;
    private String simbolo;

    public Tipo(String nome, String cor, String simbolo) {
        this.nome = nome;
        this.cor = cor;
        this.simbolo = simbolo;
    }

    public Object getNome() {
        return this.nome;
    }

    public Object getCor() {
        return this.cor;
    }

    public Object getSimbolo() {
        return this.simbolo;
    }


}
