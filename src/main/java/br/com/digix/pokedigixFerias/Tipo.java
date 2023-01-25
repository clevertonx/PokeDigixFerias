package br.com.digix.pokedigixFerias;

import lombok.Getter;

@Getter

public class Tipo {

    private String nome;
    private String cor;
    private byte[] simbolo;

    public Tipo(String nome, String cor, byte[] simbolo) {
        this.nome = nome;
        this.cor = cor;
        this.simbolo = simbolo;
    }
}