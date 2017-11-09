package dao;

import java.sql.*;
import java.util.MissingResourceException;

/**
 * Created by DNAPC on 09.11.2017.
 */
public class WrapperConnector {

    private Connection connection;

    public WrapperConnector() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task1", "root", "root");
        }
        catch (MissingResourceException e) {
            System.err.println("properties file is missing " + e);
        }catch (SQLException e) {
            System.err.println("not obtained connection " + e);
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
                System.err.println("Prepared statement is null " + e);
            }
        }
    }
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(" wrong connection" + e);
            }
        }
    }
}
