package Evaluaciones;

import Resources.GenericDAO;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EvaluacionesDAO extends GenericDAO<Evaluaciones> {

    private static final String []  columnas = {"ID","Evaluacion","Calificacion",
            "Estado", "Ciclo", "ID Materia", "ID Alumno"};
    public static DefaultTableModel modelo = new DefaultTableModel(null,columnas);

    public String [] filas;

    private String where;

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }


    @Override
    public PreparedStatement create(Evaluaciones evaluacion, Connection conexion) throws SQLException {
        String query = "INSERT INTO evaluaciones(evaluacion,calificacion,estado,ciclo,idMateria,idAlumno) VALUES(?,?,?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1,evaluacion.getEvaluacion());
        ps.setString(2,evaluacion.getCalificacion());
        ps.setString(3,evaluacion.getEstado());
        ps.setString(4,evaluacion.getCiclo());
        ps.setInt(5,evaluacion.getIdMateria());
        ps.setInt(6,evaluacion.getIdAlumno());
        return ps;
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
