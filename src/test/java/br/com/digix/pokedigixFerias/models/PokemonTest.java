package br.com.digix.pokedigixFerias.models;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.ThrowsAdvice;

import br.com.digix.pokedigixFerias.Builders.AtaqueBuilder;
import br.com.digix.pokedigixFerias.Builders.PokemonBuilder;

public class PokemonTest {
    @Test
    public void deve_criar_um_pokemon()
            throws FelicidadeInvalidaException, NivelInvalidoException, AlturaInvalidaException, PesoInvalidoException,
            AcuraciaInvalidaException, ForcaInvalidaException, PontosDePoderInvalidoException,
            QuantidadeInvalidaDeAtaquesException {
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

    @Test
    public void deve_ter_pelo_menos_um_ataque() throws AcuraciaInvalidaException, PontosDePoderInvalidoException,
            ForcaInvalidaException, QuantidadeInvalidaDeAtaquesException {

        Assertions.assertThrows(QuantidadeInvalidaDeAtaquesException.class, () -> {
            new PokemonBuilder().semAtaque().construir();
        });
    }

    @Test
    public void deve_poder_ter_quatro_ataques() throws Exception {

        Ataque ataque1 = new AtaqueBuilder().construir();
        Ataque ataque2 = new AtaqueBuilder().construir();
        Ataque ataque3 = new AtaqueBuilder().construir();
        Ataque ataque4 = new AtaqueBuilder().construir();
        List<Ataque> ataques = new ArrayList<>();
        ataques.add(ataque1);
        ataques.add(ataque2);
        ataques.add(ataque3);
        ataques.add(ataque4);

        Pokemon pokemon = new PokemonBuilder().comAtaques(ataques).construir();

        Assertions.assertTrue(ataques.containsAll(pokemon.getAtaques()));

    }

    @Test
    public void nao_deve_possuir_mais_que_quatro_ataques() throws Exception {

        List<Ataque> ataques = new ArrayList<>();
        ataques.add(new AtaqueBuilder().construir());
        ataques.add(new AtaqueBuilder().construir());
        ataques.add(new AtaqueBuilder().construir());
        ataques.add(new AtaqueBuilder().construir());
        ataques.add(new AtaqueBuilder().construir());

        Assertions.assertThrows(QuantidadeInvalidaDeAtaquesException.class, () -> {

            new PokemonBuilder().comAtaques(ataques).construir();
        });
    }
}
