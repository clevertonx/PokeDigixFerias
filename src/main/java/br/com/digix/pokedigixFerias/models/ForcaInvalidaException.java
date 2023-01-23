package br.com.digix.pokedigixFerias.models;

public class ForcaInvalidaException extends Exception{
    public ForcaInvalidaException() {
        super("A Força não deve ser menor que 0.");
    }
    
}
