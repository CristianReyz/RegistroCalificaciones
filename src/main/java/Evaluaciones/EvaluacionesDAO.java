package Evaluaciones;

import Resources.GenericDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EvaluacionesDAO extends GenericDAO<Evaluacion> {
    @Override
    public PreparedStatement create(Evaluacion dato, Connection conexion) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement read(String dato, Connection conexion) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement update(Evaluacion datoOriginal, Evaluacion datoActualizado, Connection conexion) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement delete(Evaluacion dato, Connection conexion) throws SQLException {
        return null;
    }
}
