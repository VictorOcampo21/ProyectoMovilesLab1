/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import Modelo.entidades.Ent_Estudiante;
import database.model.AbstractDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dao.crud.estudiante_CRUD;

/**
 *
 * @author jorsu
 */
public class estudiante_DAO extends AbstractDAO<String, Modelo.entidades.Ent_Estudiante> {

    public estudiante_DAO() {
        super(new estudiante_CRUD());
    }

    @Override
    public Ent_Estudiante getRecord(ResultSet rs) throws SQLException {
        return new Modelo.entidades.Ent_Estudiante(
                rs.getString("id"),
                rs.getString("nombre"),
                rs.getString("telefono"),
                rs.getString("email"),
                rs.getString("Usuario_Id"),
                rs.getString("cumple"),
                rs.getString("carrera")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, String id, Ent_Estudiante value) throws SQLException {
        stm.setString(1, id);
        stm.setString(2, value.getNombre());
        stm.setString(3, value.getTelefono());
        stm.setString(4, value.getEmail());
        stm.setString(5, value.getUsu());
        stm.setString(6, value.getCumple());
        stm.setString(7, value.getCarrera()
        );

    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, String id, Ent_Estudiante value) throws SQLException {
        stm.setString(1, value.getNombre());
        stm.setString(2, value.getTelefono());
        stm.setString(3, value.getEmail());
        stm.setString(4, value.getUsu());
        stm.setString(5, value.getCumple());
        stm.setString(6, value.getCarrera());
        stm.setString(7, id);
    }

}
