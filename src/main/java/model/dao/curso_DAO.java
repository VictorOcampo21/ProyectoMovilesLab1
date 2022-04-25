/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import Modelo.entidades.Ent_Curso;
import database.model.AbstractDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dao.crud.curso_CRUD;

/**
 *
 * @author jorsu
 */
public class curso_DAO extends AbstractDAO<String, Modelo.entidades.Ent_Curso> {

    public curso_DAO() {
        super(new curso_CRUD());
    }

    @Override
    public Ent_Curso getRecord(ResultSet rs) throws SQLException {
        return new Modelo.entidades.Ent_Curso(
                rs.getString("id"),
                rs.getString("nombre"),
                rs.getInt("creditos"),
                rs.getInt("estado"),
                rs.getInt("horas"),
                rs.getString("Ciclo_Id"),
                rs.getString("Carrera_id")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, String id, Ent_Curso value) throws SQLException {
        stm.setString(1, id);
        stm.setString(2, value.getNombre());
        stm.setInt(3, value.getCredito());
        stm.setInt(4, value.getEstado());
        stm.setInt(5, value.getHoras());
        stm.setString(6, value.getNombre());
        stm.setInt(7, value.getCredito());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, String id, Ent_Curso value) throws SQLException {
        stm.setString(1, value.getNombre());
        stm.setInt(2, value.getCredito());
        stm.setInt(3, value.getEstado());
        stm.setInt(4, value.getHoras());
        stm.setString(5, value.getCiclo_id());
        stm.setString(6, value.getCarrera_id());
        stm.setString(6, value.getId());

    }
}
