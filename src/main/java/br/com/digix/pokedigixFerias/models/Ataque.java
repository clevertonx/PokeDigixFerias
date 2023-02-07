package br.com.digix.pokedigixFerias.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter

public class Ataque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonInclude(Include.NON_NULL)
    private Long id;
    private int forca;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private int acuracia;
    private String nome;
    private String descricao;
    private int pontosDePoder;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Tipo tipo;

    public Ataque(int forca, Categoria categoria, int acuracia, String nome, String descricao, int pontosDePoder,
            Tipo tipo)
            throws AcuraciaInvalidaException, PontosDePoderInvalidoException, ForcaInvalidaException {
        verificarAcuraciaEntreZeroeCem(acuracia);
        verificarPontosDePoderEntreZeroeQuarenta(pontosDePoder);
        verificarForcaMenorQueZero(forca);
        this.tipo = tipo;
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