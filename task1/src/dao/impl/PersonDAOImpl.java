package dao.impl;

import dao.PersonDAO;
import dao.WrapperConnector;
import entity.PersonBean;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by DNAPC on 09.11.2017.
 */
public class PersonDAOImpl implements PersonDAO {
    private static final Logger log = Logger.getLogger(PersonDAOImpl.class);
    private WrapperConnector connector;

    public PersonDAOImpl() {
        this.connector = new WrapperConnector();
    }

    public PersonDAOImpl(WrapperConnector connector){
        this.connector = connector;
    }

    public void close() {
        connector.closeConnection();
    }

    @Override
    public PersonBean findPerson(String ... args) throws SQLException {
        PreparedStatement preparedStatement = null;
        PersonBean person = null;
        try {
            preparedStatement = connector.getPreparedStatement();
            preparedStatement.setString(1, args[0]);
            preparedStatement.setString(2, args[1]);
            ResultSet resultSet = preparedStatement.executeQuery();

            person = new PersonBean();

            resultSet.next();
            person.setName(resultSet.getString(1));
            person.setSurname(resultSet.getString(2));
            person.setPhone(resultSet.getString(3));
            person.setEmail(resultSet.getString(4));
        }catch (SQLException ex){
            log.error(ex);
        }finally{
            this.closePreparedStatement(preparedStatement);
        }
        return person;
    }

    private void closePreparedStatement(PreparedStatement preparedStatement) {
        connector.closePreparedStatement(preparedStatement);
    }
}
