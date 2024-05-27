package ud.bases.proyecto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Area {
    private int id;
    private String nombre;
    private String descripcion;
    private int capacidadTotal;
    private int capacidadDisponible;
    private int idParqueadero;
}
