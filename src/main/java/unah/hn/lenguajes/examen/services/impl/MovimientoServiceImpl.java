package unah.hn.lenguajes.examen.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.hn.lenguajes.examen.entities.Cliente;
import unah.hn.lenguajes.examen.entities.Cuentas;
import unah.hn.lenguajes.examen.entities.Movimientos;
import unah.hn.lenguajes.examen.repositories.ClienteRepository;
import unah.hn.lenguajes.examen.repositories.CuentasRepository;
import unah.hn.lenguajes.examen.repositories.MovimientosRepository;
import unah.hn.lenguajes.examen.services.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientosRepository movimientosRepository;

    @Autowired
    private CuentasRepository cuentasRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Movimientos crearMovimientos(Movimientos movimientos) {
        String numeroCuenta = movimientos.getCuentas().getNumeroCuenta();
        if ((this.cuentasRepository.existsById(numeroCuenta))) {
            Cuentas cuentas = this.cuentasRepository.findById(numeroCuenta).get();
            if (cuentas.isEstado() == true) {
                switch (movimientos.getTipoMovimiento()) {
                    case "c":

                        cuentas.setSaldo(cuentas.getSaldo() + movimientos.getMonto());
                        this.cuentasRepository.save(cuentas);
                        return this.movimientosRepository.save(movimientos);

                    case "d":
                        if (cuentas.getSaldo() < 0) {
                            if (cuentas.isSobregiro() == true) {
                                cuentas.setSaldo(cuentas.getSaldo() - movimientos.getMonto());
                                this.cuentasRepository.save(cuentas);
                                return this.movimientosRepository.save(movimientos);
                            }
                        }
                        break;
                    default:
                        break;
                }
            }

        }
        return null;
    }

    @Override
    public Movimientos obtenerMovimientosCuenta(String numeroCuenta) {
        if (this.clienteRepository.existsById(numeroCuenta)) {
            Optional<Cliente> cliente = this.clienteRepository.findById(numeroCuenta);

            // return this.movimientosRepository.save();
        }

        return null;
    }

}
