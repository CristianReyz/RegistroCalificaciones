package Evaluaciones;

import Resources.GenericDAO;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class EvaluacionesDAO extends GenericDAO<Evaluaciones> {

    private static final String []  columnas = {"IdEvaluacion","ID Alumno","Nombre(s)","Apellido Paterno","Apellido Materno",
            "Evaluacion","Calificacion", "Estado", "Ciclo", "ID Materia"};
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
    public PreparedStatement read(String tipo, Connection conexion) throws SQLException {
        String query = "SELECT e.idEvaluacion, e.idAlumno, a.nombreAlumno, a.primerApellido, a.segundoApellido, " +
                    "e.evaluacion, e.calificacion, e.estado, e.ciclo, e.idMateria " +
                    "FROM alumnos AS a JOIN evaluaciones as e ON a.idAlumno = e.idAlumno" +
                    " where "+where;
        PreparedStatement ps = conexion.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsM = rs.getMetaData();
        int columnas = rsM.getColumnCount();
        while (rs.next()) {
            filas = new String[columnas];
            for(int posicion = 0; posicion<columnas;posicion++){
                filas[posicion] = rs.getString(posicion+1);
            }
            if(tipo.equals("read")){
                modelo.addRow(filas);
            }
        }
        return ps;
    }

    @Override
    public PreparedStatement update(Evaluaciones evaluacionOriginal, Evaluaciones evaluacionActualizada, Connection conexion) throws SQLException {
        String query = "UPDATE evaluaciones SET evaluacion = ?, calificacion = ?, estado = ?, ciclo = ?, " +
                "idMateria = ?, idAlumno = ? WHERE idEvaluacion = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1,evaluacionActualizada.getEvaluacion());
        ps.setString(2,evaluacionActualizada.getCalificacion());
        ps.setString(3,evaluacionActualizada.getEstado());
        ps.setString(4,evaluacionActualizada.getCiclo());
        ps.setInt(5,evaluacionActualizada.getIdMateria());
        ps.setInt(6,evaluacionActualizada.getIdAlumno());
        ps.setInt(7,evaluacionOriginal.getIdEvaluacion());
        return ps;
    }

    @Override
    public PreparedStatement delete(Evaluaciones evaluacionSeleccionada, Connection conexion) throws SQLException {
        String query = "DELETE FROM evaluaciones WHERE idEvaluacion = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1,evaluacionSeleccionada.getIdEvaluacion());
        return ps;
    }
}
