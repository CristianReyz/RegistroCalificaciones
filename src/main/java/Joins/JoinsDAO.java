package Joins;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class JoinsDAO {
    private static final String []  columnas = {"ID","Nombre","Primer Apellido",
            "Segundo Apellido", "CURP", "Genero", "ID Grupo"};
    public static DefaultTableModel modelo = new DefaultTableModel(null,columnas);

    public String [] filas;
    public static String [] ciclos;

    private String where;


    public void ciclos(Connection conexion) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT distinct ciclo from mensajes";
        ps = conexion.prepareStatement(query);
        rs = ps.executeQuery();
        ResultSetMetaData rsM = rs.getMetaData();
        int cantidad = rsM.getColumnCount();
        while (rs.next()) {
            ciclos = new String[cantidad];
            for(int posicion = 0; posicion<cantidad;posicion++){
                ciclos[posicion] = rs.getString(posicion+1);
            }
        }
    }

    public void reporte1(String ciclo, Connection conexion) throws SQLException {
       /* PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM mensajes";
        ps = conexion.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()){
            filas = new String[columnas];
            for(int posicion = 0; posicion<columnas;posicion++){
                filas[posicion] = rs.getString(posicion+1);
            }
            modelo.addRow(filas);
        }*/
    }

    public void reporte6(String ciclo){

    }

    public void reporte10(){

    }

    public void reporte14(){

    }
}
