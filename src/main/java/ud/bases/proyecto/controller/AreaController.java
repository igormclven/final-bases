package ud.bases.proyecto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ud.bases.proyecto.entity.Area;
import ud.bases.proyecto.service.AreaService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {

    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping("/todas")
    public List<Area> encontrarTodo() throws SQLException {
        return areaService.encontrarTodos();
    }

    @GetMapping("/todas/{id}")
    public List<Area> encontrarPorId(@PathVariable int id) throws SQLException {
        return areaService.filtrarCampoValorId("k_idParqueadero",id);
    }
}
