package br.edu.ifrs.loja.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Product{
    private int id;
    private String name;
    private double value;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public void insert(){
        DBConnection c = new DBConnection();
        Connection newConnection = c.getConnection();

        String insertIntoProduct = "INSERT INTO lojateste (name, value) VALUES (?,?)";

        try{
            PreparedStatement ps = newConnection.prepareStatement(insertIntoProduct, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, this.name);
            ps.setDouble(2, this.value);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                this.id = rs.getInt(1);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}