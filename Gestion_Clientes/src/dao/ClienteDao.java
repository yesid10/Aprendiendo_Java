package dao;

import models.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {


    public void agregar(Cliente cliente){
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

            String sql = "INSERT INTO `clientes` (`id`, `nombre`, `apellido`, `telefono`, `email`) VALUES (NULL, '"
                    + cliente.getNombre()+ "' , '"
                    + cliente.getApellido() + "', '"
                    + cliente.getTelefono() + "', '"
                    +cliente.getEmail() + "');";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    public List<Cliente> listar(){
        String baseDeDatos = "java";
        String user = "root";
        String password = "";
        String hosting = "localhost";
        String puerto = "3306";
        String driver = "com.mysql.cj.jdbc.Driver";
        String conectionURL = "jdbc:mysql://" + hosting + ":" + puerto + "/" + baseDeDatos + "?useSSL=false";
        Connection conexion = null;

        List<Cliente> listClients = new ArrayList<Cliente>();

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(conectionURL, user, password);

            String sql = "SELECT * FROM `clientes`";
            Statement statement = conexion.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                Cliente cliente = new Cliente();
                cliente.setId(result.getString("id"));
                cliente.setNombre(result.getString("nombre"));
                cliente.setApellido(result.getString("apellido"));
                cliente.setTelefono(result.getString("telefono"));
                cliente.setEmail(result.getString("email"));
                listClients.add(cliente);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return listClients;


    }


}
