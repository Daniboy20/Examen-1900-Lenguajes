package unah.hn.lenguajes.examen.services;

import unah.hn.lenguajes.examen.entities.Cliente;
import unah.hn.lenguajes.examen.entities.Cuentas;

public interface CuentasService {

    public Cuentas crearCuentas(Cuentas cuentas);

    public Cliente asociarCuentaCliente(Cuentas cuentas);

}
