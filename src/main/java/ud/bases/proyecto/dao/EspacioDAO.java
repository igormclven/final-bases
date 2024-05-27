package ud.bases.proyecto.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import ud.bases.proyecto.entity.Espacio;

import java.util.List;

@Repository
public class EspacioDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Espacio> encontrarEspaciosDisponibles() {
        String sql = "SELECT * FROM Espacio e WHERE e.estado = 'Disponible'";
        Query query = entityManager.createNativeQuery(sql, Espacio.class);
        return query.getResultList();
    }

}
