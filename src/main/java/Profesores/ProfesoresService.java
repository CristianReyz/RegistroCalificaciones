package Profesores;

import Alumnos.AlumnoDAO;
import Resources.Usuario;

import java.sql.Connection;
import java.sql.SQLException;

public class ProfesoresService {

    private String where;

    public void Create(Connection conexion, String nombre,
                       String primerApellido, String segundoApellido, String CURP,
                       String genero, String tipo, int idGrupo) throws SQLException {
        Usuario profesor = new Usuario();
        profesor.setNombre(nombre);
        profesor.setPrimerApellido(primerApellido);
        profesor.setSegundoApellido(segundoApellido);
        profesor.setCURP(CURP);
        profesor.setGenero(genero);
        profesor.setTipo(tipo);
        profesor.setIdGrupo(idGrupo);
        ProfesoresDAO DAO = new ProfesoresDAO();
        DAO.crear(profesor,conexion);
    }

    public void Read(Connection conexion,String tipoConsulta,String parametro) throws SQLException {
        ProfesoresDAO DAO = new ProfesoresDAO();
        switch (tipoConsulta){
            case "ID PROFESOR":
                where = " idProfesor = "+parametro;
                DAO.setWhere(where);
                break;
            case "NOMBRE":
                where = "nombreProfesor = '"+parametro+"'";
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
        ProfesoresDAO DAO = new ProfesoresDAO();
        where = " idProfesor = "+parametro;
        DAO.setWhere(where);
        DAO.leer("update",conexion);
        Usuario profesorVirtual = new Usuario();
        profesorVirtual.setId(Integer.parseInt(DAO.filas[0]));
        profesorVirtual.setNombre(DAO.filas[1]);
        profesorVirtual.setPrimerApellido(DAO.filas[2]);
        profesorVirtual.setSegundoApellido(DAO.filas[3]);
        profesorVirtual.setCURP(DAO.filas[4]);
        profesorVirtual.setGenero(DAO.filas[5]);
        profesorVirtual.setTipo(DAO.filas[6]);
        profesorVirtual.setIdGrupo(Integer.parseInt(DAO.filas[7]));
        return profesorVirtual;
    }

    public void update(Connection conexion,String nombre,
                       String primerApellido, String segundoApellido, String CURP,
                       String genero, int idGrupo, Usuario profesorActual) throws SQLException {

        Usuario profesorModificado = new Usuario();
        ProfesoresDAO dao = new ProfesoresDAO();
        profesorModificado.setId(profesorActual.getId());
        profesorModificado.setNombre(nombre);
        profesorModificado.setPrimerApellido(primerApellido);
        profesorModificado.setSegundoApellido(segundoApellido);
        profesorModificado.setCURP(CURP);
        profesorModificado.setGenero(genero);
        profesorModificado.setTipo(profesorActual.getTipo());
        profesorModificado.setIdGrupo(idGrupo);
        dao.actualizar(profesorActual,profesorModificado,conexion);
    }

    public void delete (Connection conexion, Usuario profesorSeleccionado) throws SQLException {
        ProfesoresDAO dao =new ProfesoresDAO();
        dao.eliminar(profesorSeleccionado,conexion);
    }
}
