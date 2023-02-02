package br.com.digix.pokedigixFerias.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.digix.pokedigixFerias.models.Pokemon;
import br.com.digix.pokedigixFerias.models.Tipo;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
    public List<Pokemon> findByNomeContainingIgnoreCase(String nome);
    public List<Pokemon> findByTiposIn(List<Tipo> tipos);
    
}
