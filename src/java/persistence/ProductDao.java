package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.entities.Product;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustavo
 */
public final class ProductDao {

    private static Connection connection;
    private static PreparedStatement stmt;
    private static ResultSet rs;

    private ProductDao() {
        super();
    }

    public static void save(Product product) {

        connection = MyConnection.getConnection();
        try {
            stmt = connection.prepareStatement("INSERT INTO PRODUCT "
                    + "(NAME,DESCRIPTION,MINIMUMSTOCK,STOCK,UNITYPRICE) "
                    + "VALUES (?,?,?,?,?,?,?)");

            stmt.setString(2, product.getName());
            stmt.setString(3, product.getDescription());
            stmt.setLong(4, product.getMinimunStock());
            stmt.setLong(5, product.getStock());
            stmt.setDouble(6, new Date().getTime());
            stmt.execute();

            connection.close();
            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    private static Product getProduct(ResultSet result) {
        try {
            while (!result.isBeforeFirst() || result.next()) {
                Product product = new Product();
                product.setName(result.getString("name"));
                product.setDescription(result.getString("description"));
                product.setId(result.getInt("id"));
                product.setImage(result.getString("image"));
                product.setMinimunStock(result.getLong("minimunStock"));
                product.setStock(result.getLong("stock"));
                product.setUnityPrice(result.getDouble("unityprice"));
                return product;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    private static List<Product> getProducts(ResultSet result) {

        List<Product> products = new ArrayList<>();

        try {
            while (result.next()) {
                products.add(getProduct(result));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
    }

    public static void deleteAll() {

        connection = MyConnection.getConnection();
        try {
            stmt = connection.prepareStatement("DELETE FROM PRODUCT");
            stmt.execute();
            connection.close();
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }

    public static List<Product> findAll() {

        List<Product> lista = new ArrayList<>();

        connection = MyConnection.getConnection();
        try {
            stmt = connection.prepareStatement("SELECT * FROM PRODUCT");
            rs = stmt.executeQuery();
            lista = getProducts(rs);
            connection.close();
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
