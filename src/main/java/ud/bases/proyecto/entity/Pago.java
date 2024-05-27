package ud.bases.proyecto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pago {

    private int id;
    private String formaPago;
    private double valorPagado;
    private Date fechaPago;
    private int idRegistro;
}
