package dao;

import com.mysql.cj.util.StringUtils;
import models.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    public Connection conectar(){
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
        return conexion;
    }

    public void agregar(Cliente cliente){


        try {
           Connection conexion = conectar();

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

        List<Cliente> listClients = new ArrayList<Cliente>();

        try {
            Connection conexion = conectar();

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

    public void eliminar(String id){


        try {
            Connection conexion = conectar();

            String sql = "DELETE FROM `clientes` WHERE `clientes`.`id` ="+id;

            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void actualizar(Cliente cliente){


        try {
            Connection conexion = conectar();

            String sql = "UPDATE `clientes` SET `nombre` = '" + cliente.getNombre()
                    + "',`apellido` = '" + cliente.getApellido()
                    +"',`telefono` = '" + cliente.getTelefono()
                    + "',`email` ='" + cliente.getEmail()
                    +"' WHERE `clientes`.`id` = " + cliente.getId() +";";

            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public void guardar(Cliente cliente1) {

        if(StringUtils.isEmptyOrWhitespaceOnly(cliente1.getId())){
            agregar(cliente1);
        }else{
            actualizar(cliente1);
        }
    }
}
