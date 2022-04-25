/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import Modelo.entidades.Ent_Carrera;
import database.model.AbstractDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dao.crud.carrera_CRUD;

/**
 *
 * @author jorsu
 */
public class carrera_DAO extends AbstractDAO<String, Modelo.entidades.Ent_Carrera> {

    public carrera_DAO() {
        super(new carrera_CRUD());
    }

    @Override
    public Ent_Carrera getRecord(ResultSet rs) throws SQLException {
        return new Modelo.entidades.Ent_Carrera(
                rs.getString("id"),
                rs.getString("nombre"),
                rs.getString("titulo")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, String id, Ent_Carrera value) throws SQLException {
        stm.setString(1, id);
        stm.setString(2, value.getNombre());
        stm.setString(3, value.getTitulo());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, String id, Ent_Carrera value) throws SQLException {
        stm.setString(1, value.getNombre());
        stm.setString(2, value.getTitulo());
        stm.setString(3, value.getId());
    }
}
