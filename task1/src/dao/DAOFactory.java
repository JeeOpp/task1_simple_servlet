package dao;

import dao.impl.PersonDAOImpl;

/**
 * Created by DNAPC on 09.11.2017.
 */
public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final PersonDAO personDAO = new PersonDAOImpl();

    private DAOFactory() {}

    public static DAOFactory getInstance(){
        return instance;
    }
    public PersonDAO getPersonDAO(){
        return personDAO;
    }
}
