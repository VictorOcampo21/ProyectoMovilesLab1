/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import Modelo.entidades.Ent_Horario;
import database.model.AbstractDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dao.crud.horario_CRUD;

/**
 *
 * @author jorsu
 */
public class horario_DAO extends AbstractDAO<String, Modelo.entidades.Ent_Horario> {
        public horario_DAO() {
        super(new horario_CRUD());
    }

    @Override
    public Ent_Horario getRecord(ResultSet rs) throws SQLException {
        return new Modelo.entidades.Ent_Horario(
                rs.getString("idHorario"),
                rs.getString("ini"),
                rs.getString("fin"),
                rs.getString("dia"),
                rs.getString("Grupo_nrc")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, String id, Ent_Horario value) throws SQLException {
        stm.setString(1, id);
        stm.setString(2, value.getIni());
        stm.setString(3, value.getFin());
        stm.setString(4, value.getDia());
        stm.setString(5, value.getGrupo_nrc()
);
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, String id, Ent_Horario value) throws SQLException {
        stm.setString(1,  value.getIni());
        stm.setString(2, value.getFin());
        stm.setString(3, value.getDia());
        stm.setString(4, value.getGrupo_nrc());
        stm.setString(5, id);
        
    }

}
