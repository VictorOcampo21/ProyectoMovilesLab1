package database.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface DAO<K, V> {

    public List<V> listAll() throws SQLException, IOException;

    // CRUD         (IMEC)
    // C(reate)     I(nsertar)
    // R(etrieve)   C(onsultar)
    // U(pdate)     M(odificar)
    // D(elete)     E(liminar)
    //
    public void add(K id, V value) throws SQLException, IOException;

    public V retrieve(K id) throws SQLException, IOException;

    public void update(K id, V value) throws SQLException, IOException;

    public void delete(K id) throws SQLException, IOException;

}
