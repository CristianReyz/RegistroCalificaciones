package Resources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class GenericDAO<Tipo> {

    public abstract PreparedStatement create(Tipo dato, Connection conexion) throws SQLException;

    public abstract PreparedStatement read(String dato, Connection conexion) throws SQLException;

    public abstract PreparedStatement update(Tipo datoOriginal, Tipo datoActualizado, Connection conexion) throws SQLException;

    public abstract PreparedStatement delete(Tipo dato, Connection conexion) throws SQLException;

    public void crear(Tipo dato, Connection conex) throws SQLException {
        PreparedStatement ps;
        ps = create(dato,conex);
        ps.executeUpdate();
    }

    public void eliminar(Tipo dato, Connection conex) throws SQLException{
        PreparedStatement ps;
        ResultSet rs = null;
        ps = delete(dato,conex);
        ps.executeUpdate();
    }

    public void leer(String tipo, Connection conex) throws SQLException{
        PreparedStatement ps;
        ResultSet rs = null;
        ps = read(tipo,conex);
        rs = ps.executeQuery();
    }

    public void actualizar(Tipo datoOriginal, Tipo datoActualizado, Connection conex) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        ps = update(datoOriginal,datoActualizado,conex);
        ps.executeUpdate();
    }
}
