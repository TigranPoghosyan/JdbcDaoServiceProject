package Buisnesslogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utill {

    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/myjdbcdb?autoReconnect=true&useSSL=false";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "tik93170701";

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            System.out.println("Connection Ok!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Error!");
        }
        return connection;
    }

}
