package Profesores;

import Resources.GenericDAO;
import Resources.Usuario;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ProfesoresDAO extends GenericDAO<Usuario> {
    private static final String []  columnas = {"ID Profesor","Nombre","Primer Apellido",
            "Segundo Apellido", "CURP", "Genero", "ID Grupo"};
    public static DefaultTableModel modelo = new DefaultTableModel(null,columnas);

    private String where;

    public String [] filas;

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    @Override
    public PreparedStatement create(Usuario profesor, Connection conexion) throws SQLException {
        String query = "INSERT INTO profesores(nombreProfesor,primerApellido,SegundoApellido,CURP,genero,idGrupo) VALUES(?,?,?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1,profesor.getNombre());
        ps.setString(2,profesor.getPrimerApellido());
        ps.setString(3,profesor.getSegundoApellido());
        ps.setString(4,profesor.getCURP());
        ps.setString(5,profesor.getGenero());
        ps.setInt(6,profesor.getIdGrupo());
        return ps;
    }

    @Override
    public PreparedStatement read(String dato, Connection conexion) throws SQLException {
        String query = "SELECT * from profesores where "+where;
        PreparedStatement ps = conexion.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsM = rs.getMetaData();
        int columnas = rsM.getColumnCount();
        while (rs.next()) {
            filas = new String[columnas];
            for(int posicion = 0; posicion<columnas;posicion++){
                filas[posicion] = rs.getString(posicion+1);
            }
            if(dato.equals("read")) {
                modelo.addRow(filas);
            }
        }
        return ps;
    }

    @Override
    public PreparedStatement update(Usuario profesorOriginal, Usuario profesorActualizado, Connection conexion) throws SQLException {
        String query = "UPDATE profesores SET nombreProfesor= ?, primerApellido = ?, segundoApellido = ?, CURP = ?, " +
                "genero = ?, idGrupo = ? WHERE idProfesor = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1,profesorActualizado.getNombre());
        ps.setString(2,profesorActualizado.getPrimerApellido());
        ps.setString(3,profesorActualizado.getSegundoApellido());
        ps.setString(4,profesorActualizado.getCURP());
        ps.setString(5,profesorActualizado.getGenero());
        ps.setInt(6,profesorActualizado.getIdGrupo());
        ps.setInt(7,profesorOriginal.getId());
        return ps;
    }

    @Override
    public PreparedStatement delete(Usuario profesorSeleccionado, Connection conexion) throws SQLException {
        String query = "DELETE FROM profesores WHERE idProfesor = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1,profesorSeleccionado.getId());
        return ps;
    }
}
