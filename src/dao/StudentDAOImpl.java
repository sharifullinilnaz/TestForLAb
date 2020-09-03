package dao;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements DAO {

    public List<Student> getTop3() {

        try {
            Connection connection = helpers.Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students ORDER BY score DESC limit 3");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                students.add(new Student(resultSet.getString(1), resultSet.getInt(2), resultSet.getString(3),resultSet.getDouble(4)));
            }
            connection.close();
            return students;
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public int getStudentsWithMin() {

        try {
            Connection connection = helpers.Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM students WHERE score = (SELECT MIN(score) FROM students)");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.isLast()) {
                    return Integer.parseInt(resultSet.getString(1));
                }
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int getStudentsWithMax() {

        try {
            Connection connection = helpers.Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM students WHERE score = (SELECT MAX(score) FROM students)");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.isLast()) {
                    return Integer.parseInt(resultSet.getString(1));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;

    }

    public List<Student> getBestStudentsInGroup() {

        try {
            Connection connection = helpers.Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(fio), MAX(age), group_number, MAX(score) FROPM students GROUP BY group_number");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> students = new ArrayList<>();

            while (resultSet.next()) {
                students.add(new Student(resultSet.getString(1), resultSet.getInt(2), resultSet.getString(3),resultSet.getDouble(4)));
            }
            connection.close();
            return students;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

}