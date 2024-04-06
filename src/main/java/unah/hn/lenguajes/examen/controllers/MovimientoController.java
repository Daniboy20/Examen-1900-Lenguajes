package unah.hn.lenguajes.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.hn.lenguajes.examen.entities.Movimientos;
import unah.hn.lenguajes.examen.services.impl.MovimientoServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/movimiento")
public class MovimientoController {

    @Autowired
    private MovimientoServiceImpl movimientoServiceImpl;

    @PostMapping("/crear")
    public Movimientos crearMovimientos(@RequestBody Movimientos movimientos) {
        return this.movimientoServiceImpl.crearMovimientos(movimientos);
    }

    @GetMapping("/obtener")
    public Movimientos obtenerMovimientosCuenta(@RequestParam String numeroCuenta) {
        return this.obtenerMovimientosCuenta(numeroCuenta);
    }

}
