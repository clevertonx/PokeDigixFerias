package br.com.digix.pokedigixFerias.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.digix.pokedigixFerias.Builders.PokemonBuilder;

public class PokemonTest {
    @Test
    public void deve_criar_um_pokemon()
            throws FelicidadeInvalidaException, NivelInvalidoException, AlturaInvalidaException, PesoInvalidoException {
        // Arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = 0.3f;
        float peso = 2.1f;
        int felicidade = 70;
        int nivel = 5;

        // Action
        Pokemon pokemon = new PokemonBuilder().construir();

        // Assertion
        Assertions.assertEquals(nome, pokemon.getNome());
        Assertions.assertEquals(genero, pokemon.getGenero());
        Assertions.assertEquals(altura, pokemon.getAltura());
        Assertions.assertEquals(peso, pokemon.getPeso());
        Assertions.assertEquals(felicidade, pokemon.getFelicidade());
        Assertions.assertEquals(nivel, pokemon.getNivel());
    }

    @Test
    public void nao_deve_ter_felicidade_menor_que_zero() {

        // Action & Assert
        Assertions.assertThrows(FelicidadeInvalidaException.class, () -> {
            new PokemonBuilder().comFelicidade(-1).construir();
        });
    }

    @Test
    public void nao_deve_ter_felicidade_maior_que_cem() {

        // Action & Assert
        Assertions.assertThrows(FelicidadeInvalidaException.class, () -> {
            new PokemonBuilder().comFelicidade(101).construir();
        });
    }

    @Test
    public void nivel_nao_pode_ser_menor_que_um() {

        // Action & Assert
        Assertions.assertThrows(NivelInvalidoException.class, () -> {
            new PokemonBuilder().comNivel(-1).construir();
        });
    }

    @Test
    public void nivel_nao_pode_ser_maior_que_cem() {

        // Action & Assert
        Assertions.assertThrows(NivelInvalidoException.class, () -> {
            new PokemonBuilder().comNivel(101).construir();
        });
    }

    @Test
    public void altura_nao_pode_ser_menor_que_zero() {

        // Action & Assert
        Assertions.assertThrows(AlturaInvalidaException.class, () -> {
            new PokemonBuilder().comAltura(-1).construir();
        });
    }

    @Test
    public void peso_nao_pode_ser_menor_que_zero() {

        // Action & Assert
        Assertions.assertThrows(PesoInvalidoException.class, () -> {
            new PokemonBuilder().comPeso(-1).construir();
        });
    }
}
