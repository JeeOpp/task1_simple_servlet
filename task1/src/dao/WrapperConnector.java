package dao;

import org.apache.log4j.Logger;
import java.sql.*;
import java.util.MissingResourceException;

/**
 * Created by DNAPC on 09.11.2017.
 */
public class WrapperConnector {
    private static final Logger log = Logger.getLogger(WrapperConnector.class.getClass());
    private Connection connection;

    public WrapperConnector() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task1", "root", "root");
        }
        catch (MissingResourceException e) {
            log.error("properties file is missing " + e);
        }catch (SQLException e) {
            log.error("not obtained connection " + e);
        }
    }
    public PreparedStatement getPreparedStatement() throws SQLException{
        if (connection != null) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE name = ? and surname = ?;");
            if (preparedStatement != null) {
                return preparedStatement;
            }
        }
        throw new SQLException("connection or PreparedStatement is null");
    }
    public void closePreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                log.error("Prepared statement is null " + e);
            }
        }
    }
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error(" wrong connection" + e);
            }
        }
    }
}
