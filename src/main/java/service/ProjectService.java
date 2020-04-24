package service;

import Buisnesslogic.Utill;
import dao.ProjectDao;
import entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectService extends Utill implements ProjectDao {

    Connection connection = getConnection();

    @Override
    public void add(Project project) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO PROJECT(ID,TITLE) VALUES(?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,project.getId());
            preparedStatement.setString(2,project.getTitle());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }if (connection != null){
                connection.close();
            }
        }

    }

    @Override
    public List<Project> getAll() throws SQLException {

        List<Project> projectList = new ArrayList<>();

        String sql = "SELECT ID, TITLE FROM PROJECT";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Project project = new Project();

                project.setId(resultSet.getLong("ID"));
                project.setTitle(resultSet.getString("TITLE"));

                projectList.add(project);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement != null){
                statement.close();
            }if (connection != null){
                connection.close();
            }
        }
        return projectList;
    }

    @Override
    public Project getById(Long id) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, TITLE FROM PROJECT WHERE ID = ?";

        Project project = new Project();

        try {
            preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                project.setId(resultSet.getLong("ID"));
                project.setTitle(resultSet.getString("TITLE"));

                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }if (connection != null){
                connection.close();

            }
        }

        return project;
    }

    @Override
    public void update(Project project) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "UPDATE PROJECT SET TITLE = ? WHERE ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,project.getTitle());
            preparedStatement.setLong(2,project.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement!= null){
                preparedStatement.close();
            }if (connection != null){
                connection.close();
            }
        }

    }

    @Override
    public void remove(Project project) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "DELETE PROJECT WHERE ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,project.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }if (connection != null){
                connection.close();
            }
        }

    }
}
