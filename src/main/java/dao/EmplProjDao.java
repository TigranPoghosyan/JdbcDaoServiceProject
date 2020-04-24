package dao;

import entity.Address;
import entity.EmplProj;

import java.sql.SQLException;
import java.util.List;

public interface EmplProjDao {

    //create
    void add(EmplProj emplProj) throws SQLException;

    //read
    List<EmplProj> getAll() throws SQLException;

    EmplProj getById(Long employeeId,Long projectId) throws SQLException;

    //update
    void update(EmplProj emplProj) throws SQLException;

    //delete
    void remove(EmplProj emplProj) throws SQLException;

}
