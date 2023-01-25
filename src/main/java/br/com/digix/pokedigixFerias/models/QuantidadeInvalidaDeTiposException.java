package br.com.digix.pokedigixFerias.models;

public class QuantidadeInvalidaDeTiposException extends Exception {

    public QuantidadeInvalidaDeTiposException() {
        super("O pokemon deve possuir pelo menos um tipo e no máximo dois.");
    }

}
