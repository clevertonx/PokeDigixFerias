package br.com.digix.pokedigixFerias.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import br.com.digix.pokedigixFerias.Builders.AtaqueBuilder;
import br.com.digix.pokedigixFerias.models.Ataque;
import br.com.digix.pokedigixFerias.repository.AtaqueRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class AtaqueControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AtaqueRepository ataqueRepository;

    @BeforeEach
    @AfterEach
    public void deletaDados() {
        ataqueRepository.deleteAll();
    }

    @Test
    public void deve_buscar_os_ataques_cadastrados() throws Exception {
        Ataque gust = new AtaqueBuilder().construir();
        Ataque blizzard = new AtaqueBuilder().comNome("Blizzard").construir();
        ataqueRepository.saveAll(Arrays.asList(blizzard, gust));

        this.mockMvc
                .perform(get("/ataques"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Blizzard")));
    }

    @Test
    public void deve_remover_um_ataque_pelo_id() throws Exception {
        Ataque hyper_beam = new AtaqueBuilder().construir();
        Ataque ice_beam = new AtaqueBuilder().comNome("ice_beam").construir();
        ataqueRepository.saveAll(Arrays.asList(hyper_beam, ice_beam));

        this.mockMvc
                .perform(delete("/ataques/" + hyper_beam.getId()))
                .andExpect(status().isOk());

        List<Ataque> ataquesRetornados = ataqueRepository.findByNomeContainingIgnoreCase(hyper_beam.getNome());

        Assertions.assertThat(ataquesRetornados).isEmpty();
    }
}