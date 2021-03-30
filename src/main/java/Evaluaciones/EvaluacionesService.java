package Evaluaciones;

import java.sql.Connection;
import java.sql.SQLException;

public class EvaluacionesService {
    private String where;

    public void Create(Connection conexion,String evaluacion, String calificacion,
                       String estado, String ciclo, int idMateria, int idAlumno) throws SQLException {
        Evaluaciones nuevaEvaluacion = new Evaluaciones();
        nuevaEvaluacion.setEvaluacion(evaluacion);
        nuevaEvaluacion.setCalificacion(calificacion);
        nuevaEvaluacion.setEstado(estado);
        nuevaEvaluacion.setCiclo(ciclo);
        nuevaEvaluacion.setIdMateria(idMateria);
        nuevaEvaluacion.setIdAlumno(idAlumno);
        EvaluacionesDAO dao = new EvaluacionesDAO();
        dao.crear(nuevaEvaluacion,conexion);

    }

    public void Read(Connection conexion,String tipoConsulta,String parametro) throws SQLException {
        EvaluacionesDAO DAO = new EvaluacionesDAO();
        switch (tipoConsulta){
            case "ID EVALUACION":
                where = "e.idEvaluacion = "+parametro;
                DAO.setWhere(where);
                break;
            case "EVALUACION":
                where = "e.evaluacion = '"+parametro+"'";
                DAO.setWhere(where);
                break;
            case "CALIFICACION":
                where = "e.calificacion = '"+parametro+"'";
                DAO.setWhere(where);
                break;
            case "ESTADO":
                where = "e.estado = '"+parametro+"'";
                DAO.setWhere(where);
                break;
            case "CICLO":
                where = "e.ciclo = '"+parametro+"'";
                DAO.setWhere(where);
                break;
            case "ID MATERIA":
                where = "e.idMateria = "+parametro;
                DAO.setWhere(where);
                break;
            case "ID ALUMNO":
                where = "e.idAlumno = "+parametro;
                DAO.setWhere(where);
                break;
        }
        DAO.leer("read",conexion);
    }

    public Evaluaciones prepararUpdate(Connection conexion, String parametro) throws SQLException {
        EvaluacionesDAO dao = new EvaluacionesDAO();
        where = " e.idEvaluacion = "+parametro;
        dao.setWhere(where);
        dao.leer("update",conexion);
        Evaluaciones evaluacionVirtual = new Evaluaciones();
        evaluacionVirtual.setIdEvaluacion(Integer.parseInt(dao.filas[0]));
        evaluacionVirtual.setEvaluacion(dao.filas[5]);
        evaluacionVirtual.setCalificacion(dao.filas[6]);
        evaluacionVirtual.setEstado(dao.filas[7]);
        evaluacionVirtual.setCiclo(dao.filas[8]);
        evaluacionVirtual.setIdMateria(Integer.parseInt(dao.filas[9]));
        evaluacionVirtual.setIdAlumno(Integer.parseInt(dao.filas[1]));
        return evaluacionVirtual;
    }

    public void update(Connection conexion,String evaluacion, String calificacion,
                       String estado, String ciclo, int idMateria, int idAlumno, Evaluaciones evaluacionActual) throws SQLException {

        Evaluaciones evaluacionModificada = new Evaluaciones();
        EvaluacionesDAO dao = new EvaluacionesDAO();
        evaluacionModificada.setIdEvaluacion(evaluacionActual.getIdEvaluacion());
        evaluacionModificada.setEvaluacion(evaluacion);
        evaluacionModificada.setCalificacion(calificacion);
        evaluacionModificada.setEstado(estado);
        evaluacionModificada.setCiclo(ciclo);
        evaluacionModificada.setIdMateria(idMateria);
        evaluacionModificada.setIdAlumno(idAlumno);
        dao.actualizar(evaluacionActual,evaluacionModificada,conexion);
    }

    public void delete (Connection conexion, Evaluaciones evaluacionSeleccionada) throws SQLException {
        EvaluacionesDAO dao = new EvaluacionesDAO();
        dao.eliminar(evaluacionSeleccionada,conexion);
    }

}
