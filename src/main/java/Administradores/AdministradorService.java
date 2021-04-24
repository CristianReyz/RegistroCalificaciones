package Administradores;

import java.sql.Connection;
import java.sql.SQLException;

public class AdministradorService {

    public static void inicioSesion(Connection conexion, String nombre, String password) throws SQLException {
        Administrador iniciado = new Administrador();
        iniciado.setNombreUsuario(nombre);
        iniciado.setPassword(password);
        AdministradorDAO DAO = new AdministradorDAO();
        DAO.IniciarSesion(conexion,iniciado);
    }
}
