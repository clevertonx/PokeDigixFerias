package br.com.digix.pokedigixFerias.models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.digix.pokedigixFerias.Builders.TipoBuilder;
import br.com.digix.pokedigixFerias.utils.ArquivoUtils;

public class TipoTest {
    private byte[] icone;

    @BeforeEach
    public void carregarIcone() throws IOException {
        this.icone = ArquivoUtils
                .abrirArquivo("src//test//java//br//com//digix//pokedigixFerias//icons//Pokemon_Type_Icon_Psychic.svg");
    }

    @Test
    public void deve_possuir_tipo() throws FileNotFoundException, IOException {
        String nome = "Psiquico";
        String cor = "#f366b9";
        byte[] simbolo = this.icone;

        Tipo tipo = new TipoBuilder().construir();

        Assertions.assertEquals(nome, tipo.getNome());
        Assertions.assertEquals(cor, tipo.getCor());
        Assertions.assertEquals(Arrays.toString(simbolo), Arrays.toString(tipo.getSimbolo()));

    }
    
}
