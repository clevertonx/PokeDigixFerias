package br.com.digix.pokedigixFerias.repository;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigixFerias.Builders.TipoBuilder;
import br.com.digix.pokedigixFerias.models.Tipo;

@DataJpaTest
public class TipoRepositoryTest {

    @Autowired
    private TipoRepository tipoRepository;

    @Test
    public void deve_salvar_um_tipo() throws IOException {
        Tipo tipo = new TipoBuilder().construir();

        tipoRepository.save(tipo);

        Assertions.assertNotNull(tipo.getId());
    }
}
