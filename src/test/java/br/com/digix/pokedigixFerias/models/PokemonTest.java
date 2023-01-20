package br.com.digix.pokedigixFerias.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertThrows(FelicidadeInvalidaException.class, () -> {
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

    @Test
    public void nivel_nao_pode_ser_menor_que_um() {

        // Arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = 0.3f;
        float peso = 2.1f;
        int felicidade = 80;
        int nivel = -1;

        // Action & Assert
        Assertions.assertThrows(NivelInvalidoException.class, () -> {
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);
        });
    }

    @Test
    public void nivel_nao_pode_ser_maior_que_cem() {

        // Arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = 0.3f;
        float peso = 2.1f;
        int felicidade = 80;
        int nivel = 101;

        // Action & Assert
        Assertions.assertThrows(NivelInvalidoException.class, () -> {
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);
        });
    }

    @Test
    public void altura_nao_pode_ser_menor_que_zero() {

        // Arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = -1f;
        float peso = 2.1f;
        int felicidade = 80;
        int nivel = 100;

        // Action & Assert
        Assertions.assertThrows(AlturaInvalidaException.class, () -> {
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);
        });
    }

    @Test
    public void peso_nao_pode_ser_menor_que_zero() {

        // Arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = 1.3f;
        float peso = -1f;
        int felicidade = 80;
        int nivel = 100;

        // Action & Assert
        Assertions.assertThrows(PesoInvalidoException.class, () -> {
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);
        });
    }
}
