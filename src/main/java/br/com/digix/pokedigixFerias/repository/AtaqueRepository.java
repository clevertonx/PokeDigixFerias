package br.com.digix.pokedigixFerias.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.digix.pokedigixFerias.models.Ataque;
import br.com.digix.pokedigixFerias.models.Categoria;

public interface AtaqueRepository extends CrudRepository<Ataque, Long> {
    public List<Ataque> findByCategoria(Categoria categoria);

    public List<Ataque> findByNomeContainingIgnoreCase(String nome);

}
