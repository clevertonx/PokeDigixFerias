package br.com.digix.pokedigixFerias.Builders;

import br.com.digix.pokedigixFerias.models.AcuraciaInvalidaException;
import br.com.digix.pokedigixFerias.models.Ataque;
import br.com.digix.pokedigixFerias.models.Categoria;
import br.com.digix.pokedigixFerias.models.ForcaInvalidaException;
import br.com.digix.pokedigixFerias.models.PontosDePoderInvalidoException;

public class AtaqueBuilder {

    int forca = 40;
    Categoria categoria = Categoria.FISICO;
    int acuracia = 100;
    String nome = "Blizzard";
    String descricao = "O usuário invoca uma grande nevasca ao redor dele. Pode deixar os inimigos congelados.";
    int pontosDePoder = 10;

    public Ataque construir()
            throws AcuraciaInvalidaException, PontosDePoderInvalidoException, ForcaInvalidaException {
        return new Ataque(forca, categoria, acuracia, nome, descricao, pontosDePoder);
    }

    public AtaqueBuilder comAcuracia(int acuracia) {
        this.acuracia = acuracia;
        return this;
    }

    public AtaqueBuilder comPontosDePoder(int pontosDePoder) {
        this.pontosDePoder = pontosDePoder;
        return this;
    }

    public AtaqueBuilder comForca(int forca) {
        this.forca = forca;
        return this;
    }

}
