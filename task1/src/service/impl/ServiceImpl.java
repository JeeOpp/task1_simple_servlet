package service.impl;

import dao.DAOFactory;
import dao.PersonDAO;
import entity.Person;
import service.Service;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by DNAPC on 09.11.2017.
 */
public class ServiceImpl implements Service{
    @Override
    public Person findPerson(String ... args) throws SQLException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        PersonDAO personDAO = daoFactory.getPersonDAO();
        return personDAO.findPerson(args);
    }
}
