package model.dao;

import Modelo.entidades.Ent_Usuario;
import database.model.AbstractDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dao.crud.usuario_CRUD;

/**
 *
 * @author jorsu
 */
public class usuario_DAO extends AbstractDAO<String, Modelo.entidades.Ent_Usuario> {

    public usuario_DAO() {
        super(new usuario_CRUD());
    }

    @Override
    public Ent_Usuario getRecord(ResultSet rs) throws SQLException {
        return new Modelo.entidades.Ent_Usuario(
                rs.getString("id"),
                rs.getString("clave"),
                rs.getString("rol")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, String id, Ent_Usuario value) throws SQLException {
        stm.setString(1, id);
        stm.setString(2, value.getClave());
        stm.setString(3, value.getRol());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, String id, Ent_Usuario value) throws SQLException {
        stm.setString(1, value.getClave());
        stm.setString(2, value.getRol());
        stm.setString(3, id);
    }
}
