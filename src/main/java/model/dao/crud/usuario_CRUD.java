package model.dao.crud;
import database.model.AbstractCRUD;

public class usuario_CRUD extends AbstractCRUD {

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
            = "SELECT id,clave,rol FROM mydb.usuario "
            + "ORDER BY id; ";
    protected static final String ADD_CMD
            = "INSERT INTO mydb.usuario (id,clave,rol) "
            + "VALUES (?, ?, ?); ";
    protected static final String RETRIEVE_CMD
            = "SELECT id,clave,rol FROM mydb.usuario "
            + "WHERE id = ? ; ";
    protected static final String UPDATE_CMD
            = "UPDATE mydb.usuario clave = ? , rol = ? "
            + "WHERE id = ?; ";
    protected static final String DELETE_CMD
            = "DELETE mydb.usuario "
            + "WHERE id = ?; ";
}
