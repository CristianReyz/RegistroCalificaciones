package Grupos;

import Resources.GenericDAO;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class GrupoDAO extends GenericDAO<Grupos> {

    private static final String []  columnas = {"ID","GRADO","GRUPO",
            "TURNO","CICLO"};
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
    public PreparedStatement create(Grupos nuevoGrupos, Connection conexion) throws SQLException {
        String query = "INSERT INTO grupos(idGrupo,grado,grupo,turno,ciclo)VALUES(idGrupo.nextval,?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, nuevoGrupos.getGrado());
        ps.setString(2, nuevoGrupos.getGrupo());
        ps.setString(3, nuevoGrupos.getTurno());
        ps.setString(4, nuevoGrupos.getCiclo());
        return ps;
    }

    @Override
    public PreparedStatement read(String tipo, Connection conexion) throws SQLException {
        String query = "SELECT * from grupos where "+where;
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
    public PreparedStatement update(Grupos gruposOriginal, Grupos gruposActualizado, Connection conexion) throws SQLException {
        String query = "UPDATE grupos SET grado= ?, grupo = ?, turno = ?, ciclo = ? " +
                "WHERE idGrupo = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, gruposActualizado.getGrado());
        ps.setString(2, gruposActualizado.getGrupo());
        ps.setString(3, gruposActualizado.getTurno());
        ps.setString(4, gruposActualizado.getCiclo());
        ps.setInt(5, gruposOriginal.getIdGrupo());
        return ps;
    }

    @Override
    public PreparedStatement delete(Grupos gruposSeleccionado, Connection conexion) throws SQLException {
        String query = "DELETE FROM grupos WHERE idGrupo = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, gruposSeleccionado.getIdGrupo());
        return ps;
    }
}
