package br.com.digix.pokedigixFerias.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigixFerias.Builders.PokemonBuilder;
import br.com.digix.pokedigixFerias.Builders.TipoBuilder;
import br.com.digix.pokedigixFerias.models.Pokemon;
import br.com.digix.pokedigixFerias.models.Tipo;

@DataJpaTest
public class PokemonRepositoryTest {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    public void deve_salvar_um_pokemon() throws Exception {

        Pokemon pokemon = new PokemonBuilder().construir();

        pokemonRepository.save(pokemon);

        Assertions.assertNotNull(pokemon.getId());
    }

    @Test
    public void deve_remover_um_pokemon() throws Exception {
        Pokemon pokemon = new PokemonBuilder().construir();
        pokemonRepository.save(pokemon);

        pokemonRepository.deleteById(pokemon.getId());

        Optional<Pokemon> pokemonBuscado = pokemonRepository.findById(pokemon.getId());
        Assertions.assertFalse(pokemonBuscado.isPresent());
    }

    @Test
    public void deve_buscar_pokemon_pelo_nome() throws Exception {
        String nome = "Pikachu";
        Pokemon pokemon = new PokemonBuilder().comNome(nome).construir();
        pokemonRepository.save(pokemon);

        List<Pokemon> pokemonRetornado = pokemonRepository.findByNomeContainingIgnoreCase(nome);

        Assertions.assertTrue(pokemonRetornado.contains(pokemon));
    }

    @Test
    public void deve_buscar_pokemon_pelo_tipo() throws Exception {
        List<Tipo> tipos = Arrays.asList(new TipoBuilder().construir());
        Pokemon pokemon = new PokemonBuilder().comTipo(tipos).construir();
        pokemonRepository.save(pokemon);

        List<Pokemon> listaDePokemons = pokemonRepository.findByTiposIn(tipos);

        /*
         * boolean pokemonEncontrado = false;
         * for (Pokemon p : listaDePokemons) {
         * if (p.getTipos().containsAll(tipos)) {
         * pokemonEncontrado = true;
         * break;
         * }
         * }
         */

        Assertions.assertTrue(listaDePokemons.contains(pokemon));
    }

}
