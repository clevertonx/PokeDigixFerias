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
import org.junit.jupiter.api.AfterEach;
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

import br.com.digix.pokedigixFerias.Builders.PokemonBuilder;
import br.com.digix.pokedigixFerias.models.Pokemon;
import br.com.digix.pokedigixFerias.repository.PokemonRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class PokemonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PokemonRepository pokemonRepository;
    @BeforeEach
    @AfterEach
    public void deletaDados() {
        pokemonRepository.deleteAll();
    }

    @Test
    public void deve_buscar_os_pokemons_cadastrados() throws Exception {
        Pokemon charizard = new PokemonBuilder().construir();
        Pokemon pikachu = new PokemonBuilder().comNome("Pikachu").construir();
        pokemonRepository.saveAll(Arrays.asList(charizard, pikachu));

        this.mockMvc
                .perform(get("/pokemon"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Pikachu")));
    }

    @Test
    public void deve_remover_um_pokemon_pelo_id() throws Exception {
        Pokemon rhydon = new PokemonBuilder().construir();
        Pokemon magmar = new PokemonBuilder().comNome("magmar").construir();
        pokemonRepository.saveAll(Arrays.asList(rhydon, magmar));

        this.mockMvc
                .perform(delete("/pokemon/" + rhydon.getId()))
                .andExpect(status().isOk());

        List<Pokemon> pokemonRetornados = pokemonRepository.findByNomeContainingIgnoreCase(rhydon.getNome());

        Assertions.assertThat(pokemonRetornados).isEmpty();
    }

    @Test
    public void deve_incluir_um_pokemon() throws Exception {
        Pokemon pokemon = new PokemonBuilder().construir();
        String json = toJSON(pokemon);
        this.mockMvc
                .perform(post("/pokemon").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());

        List<Pokemon> pokemonRetornados = pokemonRepository.findByNomeContainingIgnoreCase(pokemon.getNome());

        Assertions.assertThat(pokemonRetornados.size()).isEqualTo(1);
        Assertions.assertThat(
                pokemon.getNome()).isIn(pokemonRetornados.stream().map(Pokemon::getNome).toList());

    }

    private String toJSON(Pokemon pokemon) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(pokemon);
        return json;
    }

    @Test
    public void deve_alterar_um_pokemon() throws Exception {
        Pokemon pokemonAlterado = new PokemonBuilder().construir();
        pokemonRepository.save(pokemonAlterado);

        pokemonAlterado.setNome("haunter");

        String json = toJSON(pokemonAlterado);

        this.mockMvc.perform(put("/pokemon").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());

        Pokemon pokemonRetornado = pokemonRepository.findById(pokemonAlterado.getId()).get();
        Assertions.assertThat(pokemonRetornado.getId()).isEqualTo(pokemonAlterado.getId());

    }
}