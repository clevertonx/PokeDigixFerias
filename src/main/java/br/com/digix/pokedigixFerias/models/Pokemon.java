package br.com.digix.pokedigixFerias.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter

public class Pokemon {

    private String nome;
    private char genero;
    private float altura;
    private float peso;
    private int felicidade;
    private int nivel;
    private int velocidade;
    private List<Ataque> ataques = new ArrayList<>();
    private List<Tipo> tipos = new ArrayList<>();

    public Pokemon(String nome, char genero, float altura, float peso, int felicidade, int nivel, List<Ataque> ataques,
            List<Tipo> tipos, int velocidade)
            throws FelicidadeInvalidaException, NivelInvalidoException, AlturaInvalidaException, PesoInvalidoException,
            QuantidadeInvalidaDeAtaquesException, QuantidadeInvalidaDeTiposException, VelocidadeInvalidaException {
        verificarFelicidadeEntreZeroeCem(felicidade);
        verificarNivelEntreUmeCem(nivel);
        verificarAltura(altura);
        verificarPeso(peso);
        verificarVelocidadeEntreUmeCem(velocidade);
        verificarQuantidadeDeAtaque(ataques);
        verificarQuantidadeDeTipo(tipos);
        this.ataques = ataques;
        this.nome = nome;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.velocidade = velocidade;
        this.felicidade = felicidade;
        this.nivel = nivel;
        this.tipos = tipos;

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

    private void verificarVelocidadeEntreUmeCem(int velocidade) throws VelocidadeInvalidaException {
        if (velocidade < 1 || velocidade > 100) {
            throw new VelocidadeInvalidaException();
        }
    }

    private void verificarQuantidadeDeAtaque(List<Ataque> ataques) throws QuantidadeInvalidaDeAtaquesException {
        if (ataques.size() == 0 || ataques.size() > 4) {
            throw new QuantidadeInvalidaDeAtaquesException();
        }
    }

    private void verificarQuantidadeDeTipo(List<Tipo> tipos) throws QuantidadeInvalidaDeTiposException {
        if (tipos.size() < 1 || tipos.size() > 2) {
            throw new QuantidadeInvalidaDeTiposException();
        }
    }
}
