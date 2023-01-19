package br.com.digix.pokedigixFerias.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PokemonTest {
    @Test
    public void deve_criar_um_pokemon() throws FelicidadeInvalidaException {
        // Arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = 0.3f;
        float peso = 2.1f;
        int felicidade = 70;
        int nivel = 5;

        // Action
        Pokemon pokemon = new Pokemon(nome, genero, altura, peso, felicidade, nivel);

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

        // Arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = 0.3f;
        float peso = 2.1f;
        int felicidade = -1;
        int nivel = 5;

        // Action & Assert
        Assertions.assertThrows(FelicidadeInvalidaException.class,() -> {
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);
        });
    }

    @Test
    public void nao_deve_ter_felicidade_maior_que_cem() {

        // Arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = 0.3f;
        float peso = 2.1f;
        int felicidade = 101;
        int nivel = 5;

        // Action & Assert
        Assertions.assertThrows(FelicidadeInvalidaException.class, () -> {
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);
        });

    }

}
