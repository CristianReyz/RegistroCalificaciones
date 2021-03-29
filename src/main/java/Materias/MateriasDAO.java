package Materias;

import Resources.GenericDAO;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class MateriasDAO extends GenericDAO<Materias> {
    private static final String []  columnas = {"ID","Nombre","Area"};
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
    public PreparedStatement create(Materias nuevaMateria, Connection conexion) throws SQLException {
        String query = "INSERT INTO materias(nombre, area) VALUES(?,?);";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1,nuevaMateria.getNombre());
        ps.setString(2,nuevaMateria.getArea());
        return ps;
    }

    @Override
    public PreparedStatement read(String tipo, Connection conexion) throws SQLException {
        String query = "SELECT * from materias where "+where;
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
    public PreparedStatement delete(Materias materiaSeleccionada, Connection conexion) throws SQLException {
        String query = "DELETE FROM materias WHERE idMateria = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1,materiaSeleccionada.getIdMateria());
        return ps;
    }

    @Override
    public PreparedStatement update(Materias materiaOriginal, Materias materiaActualizada, Connection conexion) throws SQLException {
        String query = "UPDATE materias SET nombre= ?, area = ? WHERE idMateria = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1,materiaActualizada.getNombre());
        ps.setString(2,materiaActualizada.getArea());
        ps.setInt(3,materiaOriginal.getIdMateria());
        return ps;
    }
}
