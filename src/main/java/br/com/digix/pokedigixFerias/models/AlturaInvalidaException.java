package br.com.digix.pokedigixFerias.models;

public class AlturaInvalidaException extends Exception {

    public AlturaInvalidaException() {
        super("A altura não deve ser menor que 0");
    }

}
