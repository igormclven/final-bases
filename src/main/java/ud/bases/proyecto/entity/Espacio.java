package ud.bases.proyecto.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Espacio {

    private long id;

    private String estado;

    private String tipoEspacio;

    private long idArea;
}
