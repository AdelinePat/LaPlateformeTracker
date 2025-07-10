package DAO;

import exceptions.DataException;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static exceptions.ExceptionMessage.SQL_ERROR;

public class GraphDAO {

    public static int getRangeValue(int valueMin, int valueMax) throws DataException {
        String query = "SELECT COUNT(id_student) FROM student WHERE average > ? AND average < ?";

        try {
            Connection connection = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, valueMin);
            preparedStatement.setInt(2, valueMax);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            return resultSet.getInt(1);

        } catch (SQLException e) {
            throw new DataException(SQL_ERROR.getMessage());
        }
    }
}