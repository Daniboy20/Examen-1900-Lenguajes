package unah.hn.lenguajes.examen.repositories;

import org.springframework.data.repository.CrudRepository;

import unah.hn.lenguajes.examen.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {

}
