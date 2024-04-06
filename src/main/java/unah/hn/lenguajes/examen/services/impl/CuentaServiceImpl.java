package unah.hn.lenguajes.examen.services.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.hn.lenguajes.examen.entities.Cliente;
import unah.hn.lenguajes.examen.entities.Cuentas;
import unah.hn.lenguajes.examen.repositories.ClienteRepository;
import unah.hn.lenguajes.examen.repositories.CuentasRepository;
import unah.hn.lenguajes.examen.services.CuentasService;

@Service
public class CuentaServiceImpl implements CuentasService {

    @Autowired
    private CuentasRepository cuentasRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cuentas crearCuentas(Cuentas cuentas) {

        String numeroCuenta = cuentas.getNumeroCuenta();

        if (!this.cuentasRepository.existsById(numeroCuenta)) {
            LocalDate fechaApertura = LocalDate.now();
            cuentas.setDate(fechaApertura);
            cuentas.setEstado(true);
            if (cuentas.getSaldo() > 500) {
                return this.cuentasRepository.save(cuentas);
            }

        }
        return null;
    }

    @Override
    public Cliente asociarCuentaCliente(Cuentas cuentas) {

        String dni = cuentas.getCliente().getDni();
        String numeroCuenta = cuentas.getNumeroCuenta();

        if ((this.clienteRepository.existsById(dni)) && (this.cuentasRepository.existsById(numeroCuenta))) {
            cuentas.setCliente(this.clienteRepository.findById(dni).get());
            this.cuentasRepository.save(cuentas);
            this.clienteRepository.findById(dni).get();
            return this.clienteRepository.findById(dni).get();

        }
        return null;

    }

}
