package Alumnos;

import Resources.GenericDAO;
import Resources.Usuario;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class AlumnoDAO extends GenericDAO<Usuario> {
    private static final String []  columnas = {"ID","Nombre","Primer Apellido",
            "Segundo Apellido", "CURP", "Genero", "ID Grupo"};
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
    public PreparedStatement create(Usuario alumno, Connection conexion) throws SQLException {
        String query = "INSERT INTO alumnos(nombreAlumno,primerApellido,SegundoApellido,CURP,genero,idGrupo) VALUES(?,?,?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1,alumno.getNombre());
        ps.setString(2,alumno.getPrimerApellido());
        ps.setString(3,alumno.getSegundoApellido());
        ps.setString(4,alumno.getCURP());
        ps.setString(5,alumno.getGenero());
        ps.setInt(6,alumno.getIdGrupo());
        return ps;
    }

    @Override
    public PreparedStatement read(String tipo, Connection conexion) throws SQLException {
        String query = "SELECT * from alumnos where "+where;
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
    public PreparedStatement update(Usuario alumnoOriginal, Usuario alumnoActualizado, Connection conexion) throws SQLException {
        String query = "UPDATE alumnos SET nombreAlumno= ?, primerApellido = ?, segundoApellido = ?, CURP = ?, " +
                "genero = ?, idGrupo = ? WHERE idAlumno = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1,alumnoActualizado.getNombre());
        ps.setString(2,alumnoActualizado.getPrimerApellido());
        ps.setString(3,alumnoActualizado.getSegundoApellido());
        ps.setString(4,alumnoActualizado.getCURP());
        ps.setString(5,alumnoActualizado.getGenero());
        ps.setInt(6,alumnoActualizado.getIdGrupo());
        ps.setInt(7,alumnoOriginal.getId());
        return ps;
    }

    @Override
    public PreparedStatement delete(Usuario alumnoSeleccionado, Connection conexion) throws SQLException {
        String query = "DELETE FROM alumnos WHERE idAlumno = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1,alumnoSeleccionado.getId());
        return ps;
    }
}
