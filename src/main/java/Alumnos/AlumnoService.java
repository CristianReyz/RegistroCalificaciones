package Alumnos;

import Resources.Usuario;

import java.sql.Connection;
import java.sql.SQLException;

public class AlumnoService {

    private String where;

    public void Create(Connection conexion, String nombre,
                       String primerApellido, String segundoApellido, String CURP,
                       String genero, String tipo, int idGrupo) throws SQLException {
        Usuario alumno = new Usuario();
        alumno.setNombre(nombre);
        alumno.setPrimerApellido(primerApellido);
        alumno.setSegundoApellido(segundoApellido);
        alumno.setCURP(CURP);
        alumno.setGenero(genero);
        alumno.setTipo(tipo);
        alumno.setIdGrupo(idGrupo);
        AlumnoDAO DAO = new AlumnoDAO();
        DAO.crear(alumno,conexion);
    }

    public void Read(Connection conexion,String tipoConsulta,String parametro) throws SQLException {
        AlumnoDAO DAO = new AlumnoDAO();
        switch (tipoConsulta){
            case "ID ALUMNO":
                where = " idAlumno = "+parametro;
                DAO.setWhere(where);
                break;
            case "NOMBRE":
                where = "nombreAlumno = '"+parametro+"'";
                DAO.setWhere(where);
                break;
            case "PRIMER APELLIDO":
                where = "primerApellido = '"+parametro+"'";
                DAO.setWhere(where);
                break;
            case "SEGUNDO APELLIDO":
                where = "segundoApellido = '"+parametro+"'";
                DAO.setWhere(where);
                break;
            case "CURP":
                where = "CURP = '"+parametro+"'";
                DAO.setWhere(where);
                break;
            case "GENERO":
                where = "genero = '"+parametro+"'";
                DAO.setWhere(where);
                break;
            case "ID GRUPO":
                where = "idGrupo = "+parametro;
                DAO.setWhere(where);
                break;
        }
        DAO.leer("read",conexion);
    }

    public Usuario prepararUpdate(Connection conexion, String parametro) throws SQLException {
        AlumnoDAO DAO = new AlumnoDAO();
        where = " idAlumno = "+parametro;
        DAO.setWhere(where);
        DAO.leer("update",conexion);
        Usuario alumnoVirtual = new Usuario();
        alumnoVirtual.setId(Integer.parseInt(DAO.filas[0]));
        alumnoVirtual.setNombre(DAO.filas[1]);
        alumnoVirtual.setPrimerApellido(DAO.filas[2]);
        alumnoVirtual.setSegundoApellido(DAO.filas[3]);
        alumnoVirtual.setCURP(DAO.filas[4]);
        alumnoVirtual.setGenero(DAO.filas[5]);
        //alumnoVirtual.setTipo(DAO.filas[6]);
        alumnoVirtual.setIdGrupo(Integer.parseInt(DAO.filas[6]));
        return alumnoVirtual;
    }

    public void update(Connection conexion,String nombre,
                       String primerApellido, String segundoApellido, String CURP,
                       String genero, int idGrupo, Usuario alumnoActual) throws SQLException {

        Usuario alumnoModificado = new Usuario();
        AlumnoDAO dao = new AlumnoDAO();
        alumnoModificado.setId(alumnoActual.getId());
        alumnoModificado.setNombre(nombre);
        alumnoModificado.setPrimerApellido(primerApellido);
        alumnoModificado.setSegundoApellido(segundoApellido);
        alumnoModificado.setCURP(CURP);
        alumnoModificado.setGenero(genero);
        alumnoModificado.setTipo(alumnoActual.getTipo());
        alumnoModificado.setIdGrupo(idGrupo);
        dao.actualizar(alumnoActual,alumnoModificado,conexion);
    }

    public void delete (Connection conexion, Usuario alumnoSeleccionado) throws SQLException {
        AlumnoDAO dao = new AlumnoDAO();
        dao.eliminar(alumnoSeleccionado,conexion);
    }

}
