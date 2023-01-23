package br.com.digix.pokedigixFerias.Builders;

import br.com.digix.pokedigixFerias.models.AcuraciaInvalidaException;
import br.com.digix.pokedigixFerias.models.AlturaInvalidaException;
import br.com.digix.pokedigixFerias.models.Ataque;
import br.com.digix.pokedigixFerias.models.FelicidadeInvalidaException;
import br.com.digix.pokedigixFerias.models.ForcaInvalidaException;
import br.com.digix.pokedigixFerias.models.NaoPossuiAtaqueException;
import br.com.digix.pokedigixFerias.models.NivelInvalidoException;
import br.com.digix.pokedigixFerias.models.PesoInvalidoException;
import br.com.digix.pokedigixFerias.models.Pokemon;
import br.com.digix.pokedigixFerias.models.PontosDePoderInvalidoException;

public class PokemonBuilder {

    private String nome = "Pikachu";
    private char genero = 'F';
    private float altura = 0.3f;
    private float peso = 2.1f;
    private int felicidade = 70;
    private int nivel = 5;
    private Ataque ataque;

    public PokemonBuilder() throws AcuraciaInvalidaException, ForcaInvalidaException, PontosDePoderInvalidoException, NaoPossuiAtaqueException {
        this.ataque = new AtaqueBuilder().construir();
    }

    public Pokemon construir()
            throws FelicidadeInvalidaException, NivelInvalidoException, AlturaInvalidaException, PesoInvalidoException, NaoPossuiAtaqueException {
        return new Pokemon(nome, genero, altura, peso, felicidade, nivel, ataque);
    }

    public PokemonBuilder comFelicidade(int felicidade) {
        this.felicidade = felicidade;
        return this;
    }

    public PokemonBuilder comNivel(int nivel) {
        this.nivel = nivel;
        return this;
    }

    public PokemonBuilder comAltura(float altura) {
        this.altura = altura;
        return this;
    }

    public PokemonBuilder comPeso(float peso) {
        this.peso = peso;
        return this;
    }

    public PokemonBuilder semAtaque() {
        this.ataque = null;
        return this;
    }

    
    

}
