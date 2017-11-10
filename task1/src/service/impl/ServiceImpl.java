package service.impl;

import dao.DAOFactory;
import dao.PersonDAO;
import entity.PersonBean;
import service.Service;

import java.sql.SQLException;

/**
 * Created by DNAPC on 09.11.2017.
 */
public class ServiceImpl implements Service{
    @Override
    public PersonBean findPerson(String ... args) throws SQLException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        PersonDAO personDAO = daoFactory.getPersonDAO();
        return personDAO.findPerson(args);
    }
}
