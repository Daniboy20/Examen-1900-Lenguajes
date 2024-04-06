package unah.hn.lenguajes.examen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.hn.lenguajes.examen.entities.Cliente;
import unah.hn.lenguajes.examen.services.impl.ClienteServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return this.clienteServiceImpl.crearCliente(cliente);
    }

    @GetMapping("/obtener/{dni}")
    public Cliente obtenerCliente(@PathVariable String dni) {
        return this.clienteServiceImpl.obtenerClienteDni(dni);
    }

    @GetMapping("/todos")
    public List<Cliente> obtenerClienteTodos() {
        return this.clienteServiceImpl.obtenerClienteTodos();
    }

}
