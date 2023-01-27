package br.com.digix.pokedigixFerias.Builders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.digix.pokedigixFerias.models.AcuraciaInvalidaException;
import br.com.digix.pokedigixFerias.models.AlturaInvalidaException;
import br.com.digix.pokedigixFerias.models.Ataque;
import br.com.digix.pokedigixFerias.models.FelicidadeInvalidaException;
import br.com.digix.pokedigixFerias.models.ForcaInvalidaException;
import br.com.digix.pokedigixFerias.models.QuantidadeInvalidaDeAtaquesException;
import br.com.digix.pokedigixFerias.models.QuantidadeInvalidaDeTiposException;
import br.com.digix.pokedigixFerias.models.Tipo;
import br.com.digix.pokedigixFerias.models.VelocidadeInvalidaException;
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
    private int velocidade = 100;
    private List<Ataque> ataques = new ArrayList<>();
    private List<Tipo> tipos = new ArrayList<>();

    public PokemonBuilder() throws AcuraciaInvalidaException, ForcaInvalidaException, PontosDePoderInvalidoException,
            QuantidadeInvalidaDeAtaquesException, IOException {
        this.ataques.add(new AtaqueBuilder().construir());
        this.tipos.add(new TipoBuilder().construir());
    }

    public Pokemon construir()
            throws FelicidadeInvalidaException, NivelInvalidoException, AlturaInvalidaException, PesoInvalidoException,
            QuantidadeInvalidaDeAtaquesException, QuantidadeInvalidaDeTiposException, VelocidadeInvalidaException {
        return new Pokemon(nome, genero, altura, peso, felicidade, nivel, ataques, tipos, velocidade);
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

    public PokemonBuilder comVelocidade(int velocidade) {
        this.velocidade = velocidade;
        return this;
    }

    public PokemonBuilder comPeso(float peso) {
        this.peso = peso;
        return this;
    }

    public PokemonBuilder semAtaque() {
        this.ataques = new ArrayList<>();
        return this;
    }

    public PokemonBuilder comAtaques(List<Ataque> ataques) {
        this.ataques = ataques;
        return this;
    }

    public PokemonBuilder comTipo(List<Tipo> tipos) {
        this.tipos = tipos;
        return this;
    }

}
