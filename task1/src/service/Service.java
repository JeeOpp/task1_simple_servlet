package service;

import entity.Person;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by DNAPC on 08.11.2017.
 */
public interface Service {
    Person findPerson(String ... args) throws SQLException;
}
