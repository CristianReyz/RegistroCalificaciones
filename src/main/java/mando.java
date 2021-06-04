import Pane.VentanaInicio;
import Pane.VentanaPrincipal;
import Resources.Conexion;

import java.sql.Connection;
import java.sql.SQLException;

public class mando {

    //public final static Connection conexion = Conexion.conecToDB();
    public static void main(String[] args) throws SQLException {
        //InicioSesion inicio = new InicioSesion();
        //inicio.setVisible(true);

        VentanaInicio inicio = new VentanaInicio();
        inicio.setVisible(true);
        //VentanaPrincipal ventana = new VentanaPrincipal(conexion);
        //ventana.setVisible(true);
    }
}
