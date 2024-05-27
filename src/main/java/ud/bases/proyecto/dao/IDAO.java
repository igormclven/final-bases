package ud.bases.proyecto.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {

    void insertar(T t) throws SQLException;

    public void actualizar(T t) throws SQLException;

    public void eliminar(T t) throws SQLException;

    public T encontrarPorId(long id) throws SQLException;

    public List<T> encontrarTodos() throws SQLException;

    public List<T> filtrarCampoValor(String campo, String valor) throws SQLException;

    public List<T> filtrarCampoValorId(String campo, long valor) throws SQLException;

}
