package service;

import Buisnesslogic.Utill;
import dao.EmplProjDao;
import entity.EmplProj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmplProjService extends Utill implements EmplProjDao {

    Connection connection = getConnection();

    @Override
    public void add(entity.EmplProj emplProj) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO EMPL_PROJ(EMPLOYEE_ID,PROJECT_ID) VALUES(?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,emplProj.getEmployeeId());
            preparedStatement.setLong(2,emplProj.getProjectId());

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
    public List<entity.EmplProj> getAll() throws SQLException {

        List<EmplProj> emplProjList = new ArrayList<>();

        String sql = "SELECT employee_id, project_id FROM EMPL_PROJ";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                EmplProj emplProj = new EmplProj();

                emplProj.setEmployeeId(resultSet.getLong("employee_id"));
                emplProj.setProjectId(resultSet.getLong("project_id"));

                emplProjList.add(emplProj);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection!= null){
                connection.close();
            }if (statement != null){
                statement.close();
            }
        }

        return emplProjList;
    }

    @Override
    public entity.EmplProj getById(Long employeeId, Long projectId) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT employee_id, project_id from EMPL_PROJ WHERE employee_id = ? and project_id = ?";

        EmplProj emplProj = new EmplProj();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,employeeId);
            preparedStatement.setLong(2,projectId);

            ResultSet resultSet = preparedStatement.executeQuery();

                emplProj.setEmployeeId(resultSet.getLong("employee_id"));
                emplProj.setProjectId(resultSet.getLong("project_id"));

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
        return emplProj;
    }

    @Override
    public void update(entity.EmplProj emplProj) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "UPDATE PROJECT SET employee_id = ?, project_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,emplProj.getEmployeeId());
            preparedStatement.setLong(2,emplProj.getProjectId());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
             if (connection != null){
                 connection.close();
              }
            }
        }

    @Override
    public void remove(entity.EmplProj emplProj) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM EMPL_PROJ SET EMPLOYEE_ID = ? AND PROJECT_ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,emplProj.getEmployeeId());
            preparedStatement.setLong(2,emplProj.getProjectId());

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
