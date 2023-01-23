package br.com.digix.pokedigixFerias.models;

public class NaoPossuiAtaqueException extends Exception {

    public NaoPossuiAtaqueException() {
        super("O pokemon deve possuir pelo menos um ataque.");
    }
    
}
