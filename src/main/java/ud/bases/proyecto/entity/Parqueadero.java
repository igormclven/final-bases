package ud.bases.proyecto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Parqueadero {
    private int id;
    private String nombre;
    private String direccion;
    private String tipoParqueadero;
    private int localidad;
}
