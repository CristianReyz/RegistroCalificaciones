package Joins;

import java.sql.Connection;
import java.sql.SQLException;

public class JoinsService {
    public void reporte1(Connection conexion, String ciclo) throws SQLException {
        JoinsDAO.ciclo = ciclo;
        JoinsDAO dao = new JoinsDAO();
        dao.reporte1(conexion);
    }

    public void reporte6(Connection conexion,String ciclo) throws SQLException {
        JoinsDAO.ciclo = ciclo;
        JoinsDAO dao = new JoinsDAO();
        dao.reporte6(conexion);
    }

    public void reporte11(Connection conexion,String ciclo) throws SQLException {
        JoinsDAO.ciclo = ciclo;
        JoinsDAO dao = new JoinsDAO();
        dao.reporte11(conexion);
    }

    public void reporte15(Connection conexion,String ciclo) throws SQLException {
        JoinsDAO.ciclo = ciclo;
        JoinsDAO dao = new JoinsDAO();
        dao.reporte15(conexion);
    }

}
