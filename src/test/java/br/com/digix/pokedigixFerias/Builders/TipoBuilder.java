package br.com.digix.pokedigixFerias.Builders;

import java.io.IOException;

import br.com.digix.pokedigixFerias.models.Tipo;
import br.com.digix.pokedigixFerias.utils.ArquivoUtils;

public class TipoBuilder {

    private String nome = "Psíquico";
    private String cor = "#f366b9";
    private byte[] simbolo;

    public TipoBuilder() throws IOException {
        this.simbolo = ArquivoUtils
                .abrirArquivo("src//test//java//br//com//digix//pokedigixFerias//icons//Pokemon_Type_Icon_Psychic.svg");
    }

    public Tipo construir() {
        return new Tipo(nome, cor, simbolo);
    }

    public TipoBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public TipoBuilder comCor(String cor) {
        this.cor = cor;
        return this;
    }

    public TipoBuilder comSimbolo(byte[] simbolo) {
        this.simbolo = simbolo;
        return this;
    }

}
