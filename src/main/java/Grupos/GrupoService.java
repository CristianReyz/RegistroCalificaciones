package Grupos;

import java.sql.Connection;
import java.sql.SQLException;

public class GrupoService {

    private String where;

    public void Create(Connection conexion, String grado, String grupo, String turno, String ciclo) throws SQLException {
        Grupos nuevoGrupos = new Grupos();
        nuevoGrupos.setGrado(grado);
        nuevoGrupos.setGrupo(grupo);
        nuevoGrupos.setTurno(turno);
        nuevoGrupos.setCiclo(ciclo);
        GrupoDAO dao = new GrupoDAO();
        dao.crear(nuevoGrupos,conexion);
    }

    public void Read(Connection conexion,String tipoConsulta,String parametro) throws SQLException {
        GrupoDAO dao = new GrupoDAO();
        switch (tipoConsulta){
            case "ID GRUPO":
                where = " idGrupo = "+parametro;
                dao.setWhere(where);
                break;
            case "GRADO":
                where = "grado = '"+parametro+"'";
                dao.setWhere(where);
                break;
            case "GRUPO":
                where = "grupo = '"+parametro+"'";
                dao.setWhere(where);
                break;
            case "TURNO":
                where = "turno = '"+parametro+"'";
                dao.setWhere(where);
                break;
            case "CICLO":
                where = "ciclo = '"+parametro+"'";
                dao.setWhere(where);
                break;
        }
        dao.leer("read",conexion);
    }

    public Grupos prepararUpdate(Connection conexion, String parametro) throws SQLException {
        GrupoDAO DAO = new GrupoDAO();
        where = " idGrupo = "+parametro;
        DAO.setWhere(where);
        DAO.leer("update",conexion);
        Grupos gruposVirtual = new Grupos();
        gruposVirtual.setIdGrupo(Integer.parseInt(DAO.filas[0]));
        gruposVirtual.setGrado(DAO.filas[1]);
        gruposVirtual.setGrupo(DAO.filas[2]);
        gruposVirtual.setTurno(DAO.filas[3]);
        gruposVirtual.setCiclo(DAO.filas[4]);
        return gruposVirtual;
    }

    public void update(Connection conexion,String grado, String grupo, String turno, String ciclo, Grupos gruposActual) throws SQLException {

        Grupos gruposModificado = new Grupos();
        GrupoDAO dao = new GrupoDAO();
        gruposModificado.setIdGrupo(gruposActual.getIdGrupo());
        gruposModificado.setGrado(grado);
        gruposModificado.setGrupo(grupo);
        gruposModificado.setTurno(turno);
        gruposModificado.setCiclo(ciclo);
        dao.actualizar(gruposActual, gruposModificado,conexion);
    }

    public void delete (Connection conexion, Grupos gruposSeleccionado) throws SQLException {
        GrupoDAO dao = new GrupoDAO();
        dao.eliminar(gruposSeleccionado,conexion);
    }
}
