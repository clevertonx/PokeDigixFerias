package br.com.digix.pokedigixFerias.models;

import lombok.Getter;

@Getter

public class Ataque {

    private int forca;
    private Categoria categoria;
    private int acuracia;
    private String nome;
    private String descricao;
    private int pontosDePoder;

    public Ataque(int forca, Categoria categoria, int acuracia, String nome, String descricao, int pontosDePoder)
            throws AcuraciaInvalidaException, PontosDePoderInvalidoException, ForcaInvalidaException {
        verificarAcuraciaEntreZeroeCem(acuracia);
        verificarPontosDePoderEntreZeroeQuarenta(pontosDePoder);
        verificarForcaMenorQueZero(forca);
        this.forca = forca;
        this.categoria = categoria;
        this.acuracia = acuracia;
        this.nome = nome;
        this.descricao = descricao;
        this.pontosDePoder = pontosDePoder;
    }

    private void verificarAcuraciaEntreZeroeCem(int acuracia) throws AcuraciaInvalidaException {
        if (acuracia < 0 || acuracia > 100) {
            throw new AcuraciaInvalidaException();
        }
    }

    private void verificarPontosDePoderEntreZeroeQuarenta(int pontosDePoder) throws PontosDePoderInvalidoException {
        if (pontosDePoder < 0 || pontosDePoder > 40) {
            throw new PontosDePoderInvalidoException();
        }
    }

    private void verificarForcaMenorQueZero(int forca) throws ForcaInvalidaException {
        if (forca < 0) {
            throw new ForcaInvalidaException();
        }
    }
}