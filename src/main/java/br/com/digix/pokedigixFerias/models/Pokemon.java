package br.com.digix.pokedigixFerias.models;

import lombok.Getter;

@Getter

public class Pokemon {

    private String nome;
    private char genero;
    private float altura;
    private float peso;
    private int felicidade;
    private int nivel;
    private Ataque ataque;

    public Pokemon(String nome, char genero, float altura, float peso, int felicidade, int nivel, Ataque ataque)
            throws FelicidadeInvalidaException, NivelInvalidoException, AlturaInvalidaException, PesoInvalidoException, NaoPossuiAtaqueException {
        verificarFelicidadeEntreZeroeCem(felicidade);
        verificarNivelEntreUmeCem(nivel);
        verificarAltura(altura);
        verificarPeso(peso);
        verificarSePossuiAoMenosUmAtaque(ataque);
        this.ataque = ataque;
        this.nome = nome;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.felicidade = felicidade;
        this.nivel = nivel;
    }

    private void verificarFelicidadeEntreZeroeCem(int felicidade) throws FelicidadeInvalidaException {
        if (felicidade < 0 || felicidade > 100) {
            throw new FelicidadeInvalidaException();
        }
    }

    private void verificarNivelEntreUmeCem(int nivel) throws NivelInvalidoException {
        if (nivel < 0 || nivel > 100) {
            throw new NivelInvalidoException();
        }
    }

    private void verificarAltura(float altura) throws AlturaInvalidaException {
        if (altura < 0) {
            throw new AlturaInvalidaException();
        }
    }

    private void verificarPeso(float peso) throws PesoInvalidoException {
        if (peso < 0) {
            throw new PesoInvalidoException();
        }
    }

    private void verificarSePossuiAoMenosUmAtaque(Ataque ataque) throws NaoPossuiAtaqueException {
        if (ataque == null) {
            throw new NaoPossuiAtaqueException();
        }
    }
}
