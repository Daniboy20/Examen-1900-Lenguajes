package unah.hn.lenguajes.examen.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.hn.lenguajes.examen.entities.Cliente;
import unah.hn.lenguajes.examen.repositories.ClienteRepository;
import unah.hn.lenguajes.examen.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        String dni = cliente.getDni();
        if (!this.clienteRepository.existsById(dni)) {
            return this.clienteRepository.save(cliente);
        }
        return null;
    }

    @Override
    public Cliente obtenerClienteDni(String dni) {

       
        if (this.clienteRepository.existsById(dni)) {
            System.out.println(this.clienteRepository.findById(dni));
            return this.clienteRepository.findById(dni).get();
        }

        return null;
    }

    @Override
    public List<Cliente> obtenerClienteTodos() {
        return (List<Cliente>) this.clienteRepository.findAll();
    }

}
