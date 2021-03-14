package Administradores;

import Pane.VentanaPrincipal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorDAO{

    public static boolean sesion = false;

    protected void IniciarSesion(Connection conexion, Administrador iniciado) throws SQLException {
        String query = "SELECT * FROM administradores WHERE nombreAdministrador = '"+iniciado.getNombreUsuario()+
                "' AND password = '"+iniciado.getPassword() +"'";
        PreparedStatement ps = conexion.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            sesion = true;
            iniciado.setId(rs.getInt("idAdministrador"));
            iniciado.setGenero(rs.getString("genero"));
            iniciado.setCorreo(rs.getString("correo"));
            VentanaPrincipal inicio = new VentanaPrincipal(conexion);
            inicio.setVisible(true);
        }
    }
}
