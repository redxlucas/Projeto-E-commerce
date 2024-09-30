package br.edu.ifrs.loja.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private String url = "jdbc:mysql://localhost/lojateste";
    private String user = "root";
    private String password = "";

    public Connection getConnection(){
        Connection connection = null;

        if(connection == null){
            try{
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Conectado!");
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }
}
