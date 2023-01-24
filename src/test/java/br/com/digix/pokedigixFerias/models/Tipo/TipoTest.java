package br.com.digix.pokedigixFerias.models.Tipo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.digix.pokedigixFerias.Tipo;
import br.com.digix.pokedigixFerias.Builders.TipoBuilder;

public class TipoTest {
    @Test
    public void deve_possuir_tipo() {
        String nome = "Psíquico";
        String cor = "Pink";
        String simbolo = "Psi";

        Tipo tipo = new TipoBuilder().construir();

        Assertions.assertEquals(nome, tipo.getNome());
        Assertions.assertEquals(cor, tipo.getCor());
        Assertions.assertEquals(simbolo, tipo.getSimbolo());

    }
}
