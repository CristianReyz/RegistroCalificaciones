package Joins;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class JoinsDAO {
    private static final String [] columnas1 = {"Alumno","Grado","Grupo",
            "Turno", "Calificacion", "Estado", "Evaluacion","Ciclo"};

    private static final String [] columnas6 = {"Profesor","Grado","Grupo",
            "Turno", "Ciclo", "Cantidad"};

    private static final String [] columnas11 = {"Grado","Grupo","Hombres",
            "Mujeres"};

    private static final String [] columnas15 = {"Profesor","Grado","Grupo",
            "Turno", "Calificacion", "Estado","Evaluacion","Ciclo"};

    public static DefaultTableModel modelo;

    public static String [] ciclos;

    public static String ciclo;


    public void reporte1(Connection conexion) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT DISTINCT a.nombreAlumno, g.grado, g.grupo, g.turno, e.calificacion,e.estado, e.evaluacion, e.ciclo\n" +
                "FROM alumnos a\n" +
                "JOIN evaluaciones e\n" +
                "\tUSING(idAlumno)\n" +
                "JOIN grupos g\n" +
                "\tUSING (idGrupo)\t\n" +
                "WHERE e.ciclo = '"+ciclo+"' AND e.evaluacion = 'FINAL'\n" +
                "ORDER BY e.calificacion DESC";
        ps = conexion.prepareStatement(query);
        rs = ps.executeQuery();
        ResultSetMetaData rsM = rs.getMetaData();
        int cantidad = rsM.getColumnCount();
        while (rs.next()) {
            ciclos = new String[cantidad];
            for(int posicion = 0; posicion<cantidad;posicion++){
                ciclos[posicion] = rs.getString(posicion+1);
            }
            modelo = new DefaultTableModel(null, columnas1);
            modelo.addRow(ciclos);
        }
    }


    public void reporte6(Connection conexion) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT DISTINCT p.nombreProfesor, g.grado, g.grupo, g.turno, g.ciclo,(SELECT count(*) from alumnos where idGrupo = ?) as alumnos\n" +
                "FROM profesores p\n" +
                "INNER JOIN grupos g\n" +
                "\tUSING(idGrupo)\n" +
                "WHERE g.ciclo = '"+ciclo+"'";
        ps = conexion.prepareStatement(query);
        rs = ps.executeQuery();
        ResultSetMetaData rsM = rs.getMetaData();
        int cantidad = rsM.getColumnCount();
        while (rs.next()) {
            ciclos = new String[cantidad];
            for(int posicion = 0; posicion<cantidad;posicion++){
                ciclos[posicion] = rs.getString(posicion+1);
            }
            modelo = new DefaultTableModel(null, columnas6);
            modelo.addRow(ciclos);
        }
    }

    public void reporte11(Connection conexion) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT DISTINCT g.grado, g.grupo, (SELECT COUNT(*) from alumnos where genero = 'MASCULINO' AND idGrupo = ?) as Hombres, (SELECT COUNT(*) from alumnos where genero = 'FEMENINO' AND idGrupo = ?) as Mujeres\n" +
                "FROM grupos g\n" +
                "WHERE g.ciclo = '"+ciclo+"'";
        ps = conexion.prepareStatement(query);
        rs = ps.executeQuery();
        ResultSetMetaData rsM = rs.getMetaData();
        int cantidad = rsM.getColumnCount();
        while (rs.next()) {
            ciclos = new String[cantidad];
            for(int posicion = 0; posicion<cantidad;posicion++){
                ciclos[posicion] = rs.getString(posicion+1);
            }
            modelo = new DefaultTableModel(null, columnas11);
            modelo.addRow(ciclos);
        }
    }

    public void reporte15(Connection conexion) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT DISTINCT (SELECT nombreProfesor FROM profesores where idGrupo = ?), g.grado, g.grupo, g.turno, e.calificacion,e.estado, e.evaluacion, e.ciclo\n" +
                "FROM alumnos a\n" +
                "JOIN evaluaciones e\n" +
                "\tUSING(idAlumno)\n" +
                "JOIN grupos g\n" +
                "\tUSING(idGrupo)\t\n" +
                "WHERE e.ciclo = '"+ciclo+"' AND e.evaluacion = 'FINAL'\n" +
                "ORDER BY e.calificacion ASC";
        ps = conexion.prepareStatement(query);
        rs = ps.executeQuery();
        ResultSetMetaData rsM = rs.getMetaData();
        int cantidad = rsM.getColumnCount();
        while (rs.next()) {
            ciclos = new String[cantidad];
            for(int posicion = 0; posicion<cantidad;posicion++){
                ciclos[posicion] = rs.getString(posicion+1);
            }
            modelo = new DefaultTableModel(null, columnas15);
            modelo.addRow(ciclos);
        }
    }
}
