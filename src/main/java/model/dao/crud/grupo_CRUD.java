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
public class grupo_CRUD extends AbstractCRUD {
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
            = "SELECT nrc,nomProfe,numGrupo,curso,nomCiclo,Curso_id FROM mydb.grupo "
            + "ORDER BY nrc; ";
    protected static final String ADD_CMD
            = "INSERT INTO mydb.grupo ( nrc,nomProfe,numGrupo,curso,nomCiclo,Curso_id) "
            + "VALUES (?, ?, ?, ?, ?, ?); ";
    protected static final String RETRIEVE_CMD
            = "SELECT  nrc,nomProfe,numGrupo,curso,nomCiclo,Curso_id FROM mydb.grupo "
            + "WHERE nrc = ? ; ";
    protected static final String UPDATE_CMD
            = "UPDATE mydb.grupo nomProfe = ?, numGrupo = ?, curso = ?, nomCiclo = ?, Curso_id "
            + "WHERE nrc = ?; ";
    protected static final String DELETE_CMD
            = "DELETE mydb.grupo "
            + "WHERE nrc = ?; ";
}
