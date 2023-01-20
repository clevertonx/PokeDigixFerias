package br.com.digix.pokedigixFerias.models;

public class NivelInvalidoException extends Exception {

    public NivelInvalidoException() {
        super("O nível deve estar entre 1 e 100");
    }
    
}
