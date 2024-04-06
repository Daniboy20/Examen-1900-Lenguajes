package unah.hn.lenguajes.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unah.hn.lenguajes.examen.entities.Cliente;
import unah.hn.lenguajes.examen.entities.Cuentas;
import unah.hn.lenguajes.examen.services.impl.CuentaServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/cuentas")
public class CuentasController {

    @Autowired
    private CuentaServiceImpl cuentaServiceImpl;

    @PostMapping("/crear")
    public Cuentas crearCuentas(@RequestBody Cuentas cuentas) {
        return this.cuentaServiceImpl.crearCuentas(cuentas);
    }

    @PutMapping("asociar/{id}")
    public Cliente asociarCuentaCliente(@PathVariable String id, @RequestParam String numeroCuenta) {
        return this.asociarCuentaCliente(id, numeroCuenta);
    }

}
