package service;

import entity.PersonBean;

import java.sql.SQLException;

/**
 * Created by DNAPC on 08.11.2017.
 */
public interface Service {
    PersonBean findPerson(String ... args) throws SQLException;
}
