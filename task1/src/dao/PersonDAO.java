package dao;

import entity.Person;

import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 * Created by DNAPC on 09.11.2017.
 */
public interface PersonDAO {
    Person findPerson(String ... args) throws SQLException;
}
