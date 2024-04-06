package unah.hn.lenguajes.examen.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cuentas")
@Data
public class Cuentas {

    @Id
    @Column(name = "numerocuenta")
    private String numeroCuenta;

    private double saldo;

    private LocalDate date;

    private boolean estado;

    private boolean sobregiro;

    @ManyToOne
    private Cliente cliente;

    @OneToMany
    private List<Movimientos> movimientos;

}
