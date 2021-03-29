package Materias;
import java.sql.Connection;
import java.sql.SQLException;

public class MateriasService {

    private String where;

    public void Create(Connection conexion, String nombre, String area) throws SQLException {
        Materias nuevaMateria = new Materias();
        nuevaMateria.setNombre(nombre);
        nuevaMateria.setArea(area);
        MateriasDAO dao = new MateriasDAO();
        dao.crear(nuevaMateria,conexion);
    }

    public void Read(Connection conexion,String tipoConsulta,String parametro) throws SQLException {
        MateriasDAO DAO = new MateriasDAO();
        switch (tipoConsulta){
            case "ID MATERIA":
                where = " idMateria = "+parametro;
                DAO.setWhere(where);
                break;
            case "NOMBRE":
                where = "nombre = '"+parametro+"'";
                DAO.setWhere(where);
                break;
            case "AREA":
                where = "area = '"+parametro+"'";
                DAO.setWhere(where);
                break;
        }
        DAO.leer("read",conexion);
    }

    public Materias prepararUpdate(Connection conexion, String parametro) throws SQLException {
        MateriasDAO DAO = new MateriasDAO();
        where = " idMateria = "+parametro;
        DAO.setWhere(where);
        DAO.leer("update",conexion);
        Materias materiaVirtual = new Materias();
        materiaVirtual.setIdMateria(Integer.parseInt(DAO.filas[0]));
        materiaVirtual.setNombre(DAO.filas[1]);
        materiaVirtual.setArea(DAO.filas[2]);
        return materiaVirtual;
    }

    public void update(Connection conexion,String nombre, String area, Materias materiaActual) throws SQLException {
        Materias materiaModificada = new Materias();
        MateriasDAO dao = new MateriasDAO();
        materiaModificada.setIdMateria(materiaActual.getIdMateria());
        materiaModificada.setNombre(nombre);
        materiaModificada.setArea(area);
        dao.actualizar(materiaActual,materiaModificada,conexion);
    }

    public void delete (Connection conexion, Materias materiaSeleccionada) throws SQLException {
        MateriasDAO dao = new MateriasDAO();
        dao.eliminar(materiaSeleccionada,conexion);
    }

}
