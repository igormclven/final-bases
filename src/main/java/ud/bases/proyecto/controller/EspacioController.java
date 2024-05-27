package ud.bases.proyecto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ud.bases.proyecto.entity.Espacio;
import ud.bases.proyecto.service.EspacioServico;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/espacio")
public class EspacioController {

    private final Logger LOGGER = Logger.getLogger(EspacioController.class.getName());

    private final EspacioServico espacioServico;

    public EspacioController(EspacioServico espacioServico) {
        this.espacioServico = espacioServico;
    }

    @GetMapping("/listarTodo")
    public List<Espacio> encontrarTodos() throws SQLException {
        return espacioServico.encontrarTodos();
    }

    @GetMapping("/listar/{id}")
    public Espacio encontrarPorId(@PathVariable long id) throws SQLException {
        return espacioServico.encontrarPorId(id);
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody Espacio espacio) throws SQLException {
        espacioServico.insertar(espacio);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody Espacio espacio) throws SQLException {
        espacioServico.actualizar(espacio);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable long id) throws SQLException {
        Espacio espacio = new Espacio();
        espacio.setId(id);
        espacioServico.eliminar(espacio);
    }

    @PutMapping("/actualizarEstado/{id}/{estado}")
    public void actualizarEstado(@PathVariable long id, @PathVariable String estado) throws SQLException {
        espacioServico.actualizarEstado(id, estado);
    }

    @GetMapping("/filtrar/{campo}/{valor}")
    public List<Espacio> filtrarCampoValor(@PathVariable String campo, @PathVariable String valor) throws SQLException {
        return espacioServico.filtrarCampoValor(campo, valor);
    }

    @GetMapping("/filtrarId/{campo}/{valor}")
    public List<Espacio> filtrarCampoValorId(@PathVariable String campo, @PathVariable long valor) throws SQLException {
        return espacioServico.filtrarCampoValorId(campo, valor);
    }

    /**
     * Método para manejar excepciones de tipo SQLException
     * @param ex Excepción de tipo SQLException
     * @return ResponseEntity con el mensaje de error y el código de estado HTTP
     */

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<String> handleSQLException(SQLException ex) {
        return new ResponseEntity<>("Error en la base de datos: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
