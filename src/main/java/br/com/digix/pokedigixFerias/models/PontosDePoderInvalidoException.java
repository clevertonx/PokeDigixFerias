package br.com.digix.pokedigixFerias.models;

public class PontosDePoderInvalidoException extends Exception {

    public PontosDePoderInvalidoException() {
        super("Os pontos de poder não devem ser menor que 0 e maior que 40.");
    }

}
