package br.com.digix.pokedigixFerias.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import br.com.digix.pokedigixFerias.Builders.TipoBuilder;
import br.com.digix.pokedigixFerias.models.Tipo;
import br.com.digix.pokedigixFerias.repository.TipoRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class TipoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TipoRepository tipoRepository;

    @BeforeEach
    public void deletaDados() {
        tipoRepository.deleteAll();
    }

    @Test
    public void deve_buscar_os_tipos_cadastrados() throws Exception {
        Tipo poison = new TipoBuilder().construir();
        Tipo psiquico = new TipoBuilder().comNome("Psiquico").construir();
        tipoRepository.saveAll(Arrays.asList(psiquico, poison));

        this.mockMvc
                .perform(get("/tipos"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Psiquico")));
    }

    @Test
    public void deve_remover_um_tipo_pelo_id() throws Exception {
        Tipo water = new TipoBuilder().construir();
        Tipo fire = new TipoBuilder().comNome("Fire").construir();
        tipoRepository.saveAll(Arrays.asList(fire, water));

        this.mockMvc
                .perform(delete("/tipos/" + water.getId()))
                .andExpect(status().isOk());

        List<Tipo> tiposRetornados = tipoRepository.findByNomeContainingIgnoreCase(water.getNome());

        Assertions.assertThat(tiposRetornados).isEmpty();
    }

    @Test
    public void deve_incluir_um_tipo() throws Exception {
        Tipo tipo = new TipoBuilder().construir();
        String json = toJSON(tipo);
        this.mockMvc
                .perform(post("/tipos").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());

        List<Tipo> tiposRetornados = tipoRepository.findByNomeContainingIgnoreCase(tipo.getNome());

        Assertions.assertThat(tiposRetornados.size()).isEqualTo(1);
        Assertions.assertThat(
                tipo.getNome()).isIn(tiposRetornados.stream().map(Tipo::getNome).toList());

    }

    private String toJSON(Tipo tipo) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(tipo);
        return json;
    }

    @Test
    public void deve_alterar_um_tipo() throws Exception {
        Tipo tipoAlterado = new TipoBuilder().construir();
        tipoRepository.save(tipoAlterado);

        tipoAlterado.setNome("Ghost");

        String json = toJSON(tipoAlterado);

        this.mockMvc.perform(put("/tipos").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());

        Tipo tipoRetornado = tipoRepository.findById(tipoAlterado.getId()).get();
        Assertions.assertThat(tipoRetornado.getId()).isEqualTo(tipoAlterado.getId());

    }
}