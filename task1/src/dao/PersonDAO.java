package dao;

import entity.PersonBean;

import java.sql.SQLException;

/**
 * Created by DNAPC on 09.11.2017.
 */
public interface PersonDAO {
    PersonBean findPerson(String ... args) throws SQLException;
}
