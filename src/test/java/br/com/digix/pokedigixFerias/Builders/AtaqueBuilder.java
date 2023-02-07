package br.com.digix.pokedigixFerias.Builders;

import java.io.IOException;

import br.com.digix.pokedigixFerias.models.AcuraciaInvalidaException;
import br.com.digix.pokedigixFerias.models.Ataque;
import br.com.digix.pokedigixFerias.models.Categoria;
import br.com.digix.pokedigixFerias.models.ForcaInvalidaException;
import br.com.digix.pokedigixFerias.models.PontosDePoderInvalidoException;
import br.com.digix.pokedigixFerias.models.Tipo;

public class AtaqueBuilder {

    private int forca = 40;
    private Categoria categoria = Categoria.FISICO;
    private int acuracia = 100;
    private String nome = "Blizzard";
    private String descricao = "O usuário invoca uma grande nevasca ao redor dele. Pode deixar os inimigos congelados.";
    private int pontosDePoder = 10;
    private Tipo tipo;

    public AtaqueBuilder() throws IOException {
        this.tipo = new TipoBuilder().construir();
    }

    public Ataque construir()
            throws AcuraciaInvalidaException, PontosDePoderInvalidoException, ForcaInvalidaException {
        return new Ataque(forca, categoria, acuracia, nome, descricao, pontosDePoder, tipo);
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

    public AtaqueBuilder comTipo(Tipo tipo) {
        this.tipo = tipo;
        return this;
    }

    public AtaqueBuilder comCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public AtaqueBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

}
