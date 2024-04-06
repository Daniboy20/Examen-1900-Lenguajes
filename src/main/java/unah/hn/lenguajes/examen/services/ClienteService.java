package unah.hn.lenguajes.examen.services;

import java.util.List;

import unah.hn.lenguajes.examen.entities.Cliente;

public interface ClienteService {

    public Cliente crearCliente(Cliente cliente);

    public Cliente obtenerClienteDni(String dni);

    public List<Cliente> obtenerClienteTodos();

}
