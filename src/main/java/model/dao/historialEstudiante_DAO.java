package model.dao;

import Modelo.entidades.Ent_Historial;
import database.model.AbstractDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dao.crud.historialEstudiante_CRUD;

public class historialEstudiante_DAO extends AbstractDAO<String, Modelo.entidades.Ent_Historial> {

    public historialEstudiante_DAO() {
        super(new historialEstudiante_CRUD());
    }

    @Override
    public Ent_Historial getRecord(ResultSet rs) throws SQLException {
        return new Modelo.entidades.Ent_Historial(
                rs.getString("id"),
                rs.getString("curso"),
                rs.getDouble("nota"),
                rs.getString("grupo"),
                rs.getString("Estudiante_id")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, String id, Ent_Historial value) throws SQLException {
        stm.setString(1, id);
        stm.setString(2, value.getCurso());
        stm.setDouble(3, value.getNota());
        stm.setString(4, value.getGrupo());
        stm.setString(5, value.getEstudiante_id());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, String id, Ent_Historial value) throws SQLException {
        stm.setString(1, value.getCurso());
        stm.setDouble(2, value.getNota());
        stm.setString(3, value.getGrupo());
        stm.setString(4, value.getEstudiante_id());
        stm.setString(5, id);

    }

}
