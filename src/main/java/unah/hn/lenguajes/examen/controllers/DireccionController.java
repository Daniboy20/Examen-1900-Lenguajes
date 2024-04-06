package unah.hn.lenguajes.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.hn.lenguajes.examen.entities.Direccion;
import unah.hn.lenguajes.examen.services.impl.DireccionServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/direccion")
public class DireccionController {

    @Autowired
    private DireccionServiceImpl direccionServiceImpl;

    @PostMapping("/crear/{dni}")
    public Direccion crearDireccion(@PathVariable String dni, @RequestBody Direccion direccion) {
        return this.direccionServiceImpl.crearDireccion(direccion, dni);
    }

}
