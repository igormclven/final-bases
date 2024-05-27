package ud.bases.proyecto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Registro {

    private int id;

    private String placa;

    private Timestamp fechaEntrada;

    private Timestamp fechaSalida;

    private String tipoVehiculo;

    private long idEspacio;

}
