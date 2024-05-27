package ud.bases.proyecto.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "espacio")
public class Espacio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "k_idEspacio")
    private long id;

    @Column(name = "n_Estado")
    private String estado;

    @Column(name = "n_TipoEspacio")
    private String tipoEspacio;

    @Column(name = "k_idArea")
    private long idArea;
}
