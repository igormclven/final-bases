package ud.bases.proyecto.controller;

import org.springframework.web.bind.annotation.*;
import ud.bases.proyecto.entity.Pago;
import ud.bases.proyecto.service.PagoService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/pago")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping("/listarTodo")
    public List<Pago> encontrarTodos() throws SQLException {
        return pagoService.encontrarTodos();
    }

    @GetMapping("/listar/{id}")
    public Pago encontrarPorId(@PathVariable int id) throws SQLException {
        return pagoService.encontrarPorId(id);
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody Pago pago) throws SQLException {
        pagoService.insertar(pago);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id) throws SQLException {
        Pago pago = new Pago();
        pago.setId(id);
        pagoService.eliminar(pago);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody Pago pago) throws SQLException {
        pagoService.actualizar(pago);
    }

    @GetMapping("/filtrar/{campo}/{valor}")
    public List<Pago> filtrarCampoValor(@PathVariable String campo, @PathVariable String valor) throws SQLException {
        return pagoService.filtrarCampoValor(campo, valor);
    }

    @GetMapping("/filtrarId/{campo}/{valor}")
    public List<Pago> filtrarId(@PathVariable String campo, @PathVariable int valor) throws SQLException {
        return pagoService.filtrarCampoValorId(campo, valor);
    }

    @GetMapping("/calcularTarifa/{id}")
    public long calcularTarifa(@PathVariable int id) throws SQLException {
        return pagoService.calcularTarifa(id);
    }

    @GetMapping("/contarPagos")
    public int contarPagos() throws SQLException {
        return pagoService.contarPagos();
    }
}
