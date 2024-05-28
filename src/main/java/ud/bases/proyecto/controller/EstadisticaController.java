package ud.bases.proyecto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ud.bases.proyecto.entity.Estadistica;
import ud.bases.proyecto.service.EstadisticaService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticaController {

    private final EstadisticaService estadisticaService;

    public EstadisticaController(EstadisticaService estadisticaService) {
        this.estadisticaService = estadisticaService;
    }

    @GetMapping("/dia")
    public List<Estadistica> estadisticaDia() throws SQLException {
        return estadisticaService.estadisticaDia();
    }
}
