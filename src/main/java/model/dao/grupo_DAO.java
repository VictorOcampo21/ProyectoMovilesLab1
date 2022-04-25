/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import Modelo.entidades.Ent_Grupo;
import database.model.AbstractDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dao.crud.grupo_CRUD;

/**
 *
 * @author jorsu
 */
public class grupo_DAO extends AbstractDAO<String, Modelo.entidades.Ent_Grupo> {

    public grupo_DAO() {
        super(new grupo_CRUD());
    }

    @Override
    public Ent_Grupo getRecord(ResultSet rs) throws SQLException {
        return new Modelo.entidades.Ent_Grupo(
                rs.getString("nrc"),
                rs.getString("nomProfe"),
                rs.getInt("numGrupo"),
                rs.getString("curso"),
                rs.getString("nomCiclo"),
                rs.getString("Curso_id")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, String id, Ent_Grupo value) throws SQLException {
        stm.setString(1, id);
        stm.setString(2, value.getIdProfe());
        stm.setInt(3, value.getNumGrup());
        stm.setString(4, value.getCurso());
        stm.setString(5, value.getNomCiclo());
        stm.setString(6, value.getCurso_id());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, String id, Ent_Grupo value) throws SQLException {
        stm.setString(1, value.getIdProfe());
        stm.setInt(2, value.getNumGrup());
        stm.setString(3, value.getCurso());
        stm.setString(4, value.getNomCiclo());
        stm.setString(5, value.getCurso_id());
        stm.setString(6, id);

    }

}
