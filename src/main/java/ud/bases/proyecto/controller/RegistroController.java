package ud.bases.proyecto.controller;

import org.springframework.web.bind.annotation.*;
import ud.bases.proyecto.entity.Registro;
import ud.bases.proyecto.service.RegistroService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    private final RegistroService registroService;

    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    @GetMapping("/listarTodo")
    public List<Registro> encontrarTodos() throws SQLException {
        return registroService.encontrarTodos();
    }

    @GetMapping("/listar/{id}")
    public Registro encontrarPorId(@PathVariable long id) throws SQLException {
        return registroService.encontrarPorId(id);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody Registro registro) throws SQLException {
        registroService.actualizar(registro);
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody Registro registro) throws SQLException {
        registroService.insertar(registro);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id) throws SQLException {
        Registro registro = new Registro();
        registro.setId(id);
        registroService.eliminar(registro);
    }

    @GetMapping("/filtrar/{campo}/{valor}")
    public List<Registro> filtrarCampoValor(@PathVariable String campo, @PathVariable String valor) throws SQLException {
        return registroService.filtrarCampoValor(campo, valor);
    }

    @GetMapping("/filtrarId/{campo}/{valor}")
    public List<Registro> filtrarId(@PathVariable String campo, @PathVariable int valor) throws SQLException {
        return registroService.filtrarCampoValorId(campo, valor);
    }

    @GetMapping("/espacio/{id}")
    public Registro encontrarPorEspacio(@PathVariable long id) throws SQLException {
        return registroService.registroActual(id);
    }

    @GetMapping("/count")
    public int contarRegistros() throws SQLException {
        return registroService.contarRegistros();
    }

    @PutMapping("/salida/{id}")
    public void actualizarFechaSalida(@PathVariable int id) throws SQLException {
        registroService.actualizarFechaSalida(id);
    }

}
