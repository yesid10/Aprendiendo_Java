package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClienteDao {

    public void Conectar(){
        String baseDeDatos = "java";
        String user = "root";
        String password = "";
        String hosting = "localhost";
        String puerto = "3306";
        String driver = "com.mysql.cj.jdbc.Driver";
        String conectionURL = "jdbc:mysql://" + hosting + ":" + puerto + "/" + baseDeDatos + "?useSSL=false";
        Connection conexion = null;

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(conectionURL, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}