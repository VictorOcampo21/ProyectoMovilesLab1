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
public class horario_CRUD extends AbstractCRUD {
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
            = "SELECT id,ini,fin,dia,Grupo_nrc FROM mydb.horario "
            + "ORDER BY idHorario; ";
    protected static final String ADD_CMD
            = "INSERT INTO mydb.horario (idHorario,ini,fin,dia,Grupo_nrc) "
            + "VALUES (?, ?, ?, ?, ?); ";
    protected static final String RETRIEVE_CMD
            = "SELECT idHorario,ini,fin,dia,Grupo_nrc FROM mydb.horario "
            + "WHERE idHorario = ? ; ";
    protected static final String UPDATE_CMD
            = "UPDATE mydb.horario ini = ? , fin = ?, dia = ? "
            + "WHERE idHorario = ?; ";
    protected static final String DELETE_CMD
            = "DELETE mydb.horario "
            + "WHERE idHorario = ?; ";
}
