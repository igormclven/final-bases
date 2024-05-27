package ud.bases.proyecto.repository;

import java.util.logging.Logger;

public class Connection {

    private static final Logger LOGGER = Logger.getLogger(Connection.class.getName());
    public java.sql.Connection conn;
    private static final String Driver = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://ep-rough-sound-a55wfzoz-pooler.us-east-2.aws.neon.tech/DB_Parqueaderos?sslmode=require";
    private static final String USER = "oati_owner";
    private static final String PASSWORD = "uYWS72gxZpsL";

    public void open() {
        try {
            Class.forName(Driver);
            conn = java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
            LOGGER.info("Conexión establecida");
        } catch (Exception e) {
            LOGGER.severe("Error al establecer la conexión: " + e.getMessage());
        }
    }

    public void close() {
        try {
            conn.close();
            LOGGER.info("Conexión cerrada");
        } catch (Exception e) {
            LOGGER.severe("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
