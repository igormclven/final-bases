package ud.bases.proyecto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ud.bases.proyecto.entity.Parqueadero;
import ud.bases.proyecto.service.ParqueaderoService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/parqueadero")
public class ParqueaderoController {

    private final ParqueaderoService parqueaderoService;

    public ParqueaderoController(ParqueaderoService parqueaderoService) {
        this.parqueaderoService = parqueaderoService;
    }

    @GetMapping("/todos")
    public List<Parqueadero> encontrarTodo() throws SQLException {
        return parqueaderoService.encontrarTodos();
    }


}
