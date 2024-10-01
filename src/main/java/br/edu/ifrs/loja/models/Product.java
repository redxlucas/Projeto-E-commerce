package br.edu.ifrs.loja.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Product{
//#region
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
//#endregion
    public void insert(){
        DBConnection c = new DBConnection();
        Connection newConnection = c.getConnection();

        String insertProduct = "INSERT INTO lojateste (name, value) VALUES (?,?)";

        try{
            PreparedStatement ps = newConnection.prepareStatement(insertProduct, Statement.RETURN_GENERATED_KEYS);
            
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

    public void get(){
        DBConnection c = new DBConnection();
        Connection newConnection = c.getConnection();

        String selectProduct = "SELECT * FROM lojateste WHERE id = ?";

        try{
            PreparedStatement ps = newConnection.prepareStatement(selectProduct);
            ps.setInt(1, this.id);

            ResultSet resultSet = ps.executeQuery();

            if(resultSet.next()){
                this.setName(resultSet.getString("name"));
                this.setValue(resultSet.getDouble("value"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Product> getAll(){
        DBConnection c = new DBConnection();
        Connection newConnection = c.getConnection();
        ArrayList<Product> products = new ArrayList<>();

        String selectProduct = "SELECT * FROM lojateste";

        try{
            Statement statement = newConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectProduct);
            while(resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setValue(resultSet.getDouble("value"));
                products.add(product);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    public void update(){
        DBConnection c = new DBConnection();
        Connection newConnection = c.getConnection();

        String updateProduct = "UPDATE lojateste SET name = ?, value = ? WHERE id = ?";

        try{
            PreparedStatement ps = newConnection.prepareStatement(updateProduct);
            ps.setString(1, this.name);
            ps.setDouble(2, this.value);
            ps.setInt(3, this.id);
            ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public boolean delete(){
        DBConnection c = new DBConnection();
        Connection newConnection = c.getConnection();

        String deleteProduct = "DELETE FROM lojateste WHERE id = ?";

        try{
            PreparedStatement ps = newConnection.prepareStatement(deleteProduct);
            ps.setInt(1, this.id);
            ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}