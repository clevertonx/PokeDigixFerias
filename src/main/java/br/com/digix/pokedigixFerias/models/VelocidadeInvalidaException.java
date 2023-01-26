package br.com.digix.pokedigixFerias.models;

public class VelocidadeInvalidaException extends Exception {
    public VelocidadeInvalidaException() {
        super("A velocidade não deve ser menor que 1 ou maior que 100.");
    }
    
}
