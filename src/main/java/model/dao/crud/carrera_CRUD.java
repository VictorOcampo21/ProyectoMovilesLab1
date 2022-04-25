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
public class carrera_CRUD extends AbstractCRUD {

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
            = "SELECT id,nombre,titulo FROM mydb.carrera "
            + "ORDER BY id; ";
    protected static final String ADD_CMD
            = "INSERT INTO mydb.carrera (id,nombre,titulo) "
            + "VALUES (?, ?, ?); ";
    protected static final String RETRIEVE_CMD
            = "SELECT id,nombre,titulo FROM mydb.carrera "
            + "WHERE id = ? ; ";
    protected static final String UPDATE_CMD
            = "UPDATE mydb.carrera nombre = ? , titutlo = ? "
            + "WHERE id = ?; ";
    protected static final String DELETE_CMD
            = "DELETE mydb.carrera "
            + "WHERE id = ?; ";
}
