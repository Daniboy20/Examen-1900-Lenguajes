package unah.hn.lenguajes.examen.services;

import unah.hn.lenguajes.examen.entities.Movimientos;

public interface MovimientoService {

    public Movimientos crearMovimientos(Movimientos movimientos);

    public Movimientos obtenerMovimientosCuenta(String numeroCuenta);

}
