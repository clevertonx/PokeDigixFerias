package br.com.digix.pokedigixFerias.models;

public class PesoInvalidoException extends Exception {
    
    public PesoInvalidoException() {
        super("O peso deve ser maior que 0");
    }
}
