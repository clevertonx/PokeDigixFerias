package br.com.digix.pokedigixFerias.models;

public class QuantidadeInvalidaDeAtaquesException extends Exception {

    public QuantidadeInvalidaDeAtaquesException() {
        super("O pokemon deve possuir pelo menos um ataque e no máximo quatro.");
    }
    
}
