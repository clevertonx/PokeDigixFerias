package br.com.digix.pokedigixFerias.repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigixFerias.Builders.AtaqueBuilder;
import br.com.digix.pokedigixFerias.models.AcuraciaInvalidaException;
import br.com.digix.pokedigixFerias.models.Ataque;
import br.com.digix.pokedigixFerias.models.Categoria;
import br.com.digix.pokedigixFerias.models.ForcaInvalidaException;
import br.com.digix.pokedigixFerias.models.PontosDePoderInvalidoException;

@DataJpaTest
public class AtaqueRepositoryTest {

    @Autowired
    private AtaqueRepository ataqueRepository;

    @Test
    public void deve_salvar_um_ataque()
            throws IOException, AcuraciaInvalidaException, PontosDePoderInvalidoException, ForcaInvalidaException {
        Ataque ataque = new AtaqueBuilder().construir();

        ataqueRepository.save(ataque);

        Assertions.assertNotNull(ataque.getId());

    }

    @Test
    public void deve_remover_um_ataque() throws Exception {
        Ataque ataque = new AtaqueBuilder().construir();
        ataqueRepository.save(ataque);

        ataqueRepository.deleteById(ataque.getId());

        Optional<Ataque> tipoBuscado = ataqueRepository.findById(ataque.getId());
        Assertions.assertFalse(tipoBuscado.isPresent());
    }

    @Test
    public void deve_buscar_por_categoria() throws Exception {
        Categoria categoria = Categoria.ESPECIAL;
        Ataque ataque = new AtaqueBuilder().comCategoria(categoria).construir();
        ataqueRepository.save(ataque);

        List<Ataque> ataqueRetornado = ataqueRepository.findByCategoria(categoria);

        Assertions.assertTrue(ataqueRetornado.contains(ataque));
    }
}
