package br.com.digix.pokedigixFerias.models;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.digix.pokedigixFerias.Builders.AtaqueBuilder;
import br.com.digix.pokedigixFerias.Builders.TipoBuilder;

public class AtaqueTest {
    @Test
    public void deve_criar_um_ataque()
            throws AcuraciaInvalidaException, PontosDePoderInvalidoException, ForcaInvalidaException, IOException {

        int forca = 40;
        Categoria categoria = Categoria.FISICO;
        int acuracia = 100;
        String nome = "Blizzard";
        String descricao = "O usuário invoca uma grande nevasca ao redor dele. Pode deixar os inimigos congelados.";
        int pontosDePoder = 10;

        Ataque ataque = new AtaqueBuilder().construir();

        Assertions.assertEquals(forca, ataque.getForca());
        Assertions.assertEquals(categoria, ataque.getCategoria());
        Assertions.assertEquals(acuracia, ataque.getAcuracia());
        Assertions.assertEquals(nome, ataque.getNome());
        Assertions.assertEquals(descricao, ataque.getDescricao());
        Assertions.assertEquals(pontosDePoder, ataque.getPontosDePoder());

    }

    @Test
    public void nao_deve_ter_acuracia_menor_que_zero() {

        // Action & Assert
        Assertions.assertThrows(AcuraciaInvalidaException.class, () -> {
            new AtaqueBuilder().comAcuracia(-1).construir();
        });
    }

    @Test
    public void nao_deve_ter_acuracia_maior_que_cem() {

        // Action & Assert
        Assertions.assertThrows(AcuraciaInvalidaException.class, () -> {
            new AtaqueBuilder().comAcuracia(101).construir();
        });
    }

    @Test
    public void nao_deve_ter_pp_maior_que_quarenta() {

        // Action & Assert
        Assertions.assertThrows(PontosDePoderInvalidoException.class, () -> {
            new AtaqueBuilder().comPontosDePoder(41).construir();
        });
    }

    @Test
    public void nao_deve_ter_forca_menor_que_zero() {

        // Action & Assert
        Assertions.assertThrows(ForcaInvalidaException.class, () -> {
            new AtaqueBuilder().comForca(-1).construir();
        });
    }

    @Test
    public void deve_ter_um_tipo()
            throws IOException, AcuraciaInvalidaException, PontosDePoderInvalidoException, ForcaInvalidaException {

        Tipo tipo = new TipoBuilder().construir();

        Ataque ataque = new AtaqueBuilder().comTipo(tipo).construir();

        Assertions.assertEquals(tipo, ataque.getTipo());
    }
}
