package br.com.digix.pokedigixFerias.models;

public class AcuraciaInvalidaException extends Exception {

    public AcuraciaInvalidaException() {
        super("A acuracia não deve ser menor que 0 ou maior que 100.");
    }

}
