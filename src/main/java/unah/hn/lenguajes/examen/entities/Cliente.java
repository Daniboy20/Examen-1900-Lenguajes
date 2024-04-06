package unah.hn.lenguajes.examen.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {

    @Id
    private String dni;

    private String nombre;

    private String apellido;

    private String correo;

    private String telefono;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Cuentas> cuentas;

    @OneToOne
    private Direccion direccion;
}
