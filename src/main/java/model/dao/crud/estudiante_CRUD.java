/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.crud;

import database.model.AbstractCRUD;

/**
 *
 * @author jorsu
 */
public class estudiante_CRUD extends AbstractCRUD {

 @Override
    public String getListAllCmd() {
        return LIST_CMD;
    }

    @Override
    public String getAddCmd() {
        return ADD_CMD;
    }

    @Override
    public String getRetrieveCmd() {
        return RETRIEVE_CMD;
    }

    @Override
    public String getUpdateCmd() {
        return UPDATE_CMD;
    }

    @Override
    public String getDeleteCmd() {
        return DELETE_CMD;
    }

    protected static final String LIST_CMD
            = "SELECT id,nombre,telefono,email,Usuario_Id,cumple,carrera FROM mydb.estudiante "
            + "ORDER BY id; ";
    protected static final String ADD_CMD
            = "INSERT INTO mydb.estudiante (id,nombre,telefono,email,Usuario_Id,cumple,carrera) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?); ";
    protected static final String RETRIEVE_CMD
            = "SELECT id,nombre,telefono,email,Usuario_Id,cumple,carrera FROM mydb.estudiante "
            + "WHERE id = ? ; ";
    protected static final String UPDATE_CMD
            = "UPDATE mydb.estudiante nombre = ? , telefono = ?, email = ?, Usuario_Id = ?, cumple = ?, carrera = ? "
            + "WHERE id = ?; ";
    protected static final String DELETE_CMD
            = "DELETE mydb.estudiante "
            + "WHERE id = ?; ";
    
}
