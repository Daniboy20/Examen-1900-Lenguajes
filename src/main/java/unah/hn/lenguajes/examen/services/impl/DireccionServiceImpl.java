package unah.hn.lenguajes.examen.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.hn.lenguajes.examen.entities.Cliente;
import unah.hn.lenguajes.examen.entities.Direccion;
import unah.hn.lenguajes.examen.repositories.ClienteRepository;
import unah.hn.lenguajes.examen.repositories.DireccionRepository;
import unah.hn.lenguajes.examen.services.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Direccion crearDireccion(Direccion direccion, String dni) {

        if (this.clienteRepository.existsById(dni)) {
            Cliente cliente = this.clienteRepository.findById(dni).get();

            direccion.setCliente(cliente);
            return this.direccionRepository.save(direccion);
        }
        return null;

    }
}
