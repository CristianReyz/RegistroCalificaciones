package Evaluaciones;

import Resources.GenericDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EvaluacionesDAO extends GenericDAO<Evaluaciones> {
    @Override
    public PreparedStatement create(Evaluaciones dato, Connection conexion) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement read(String dato, Connection conexion) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement update(Evaluaciones datoOriginal, Evaluaciones datoActualizado, Connection conexion) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement delete(Evaluaciones dato, Connection conexion) throws SQLException {
        return null;
    }
}
