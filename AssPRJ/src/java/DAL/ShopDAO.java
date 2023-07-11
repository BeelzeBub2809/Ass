/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Product;

/**
 *
 * @author nguye
 */
public class ShopDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Category> getAllCategory() {
        List<Category> ls = new ArrayList<>();
        try {

            String query = "SELECT * FROM Product_category";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                ls.add(new Category(rs.getInt(1), rs.getString(2)));
            }

        } catch (Exception ex) {
            Logger.getLogger(ShopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }

    public List<Product> getAllProduct() {
        List<Product> lsP = new ArrayList<>();
        try {

            String query = "SELECT * FROM Product";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                lsP.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
            }

        } catch (Exception ex) {
            Logger.getLogger(ShopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsP;
    }

    public List<Product> getProdByCId(String Id) {
        List<Product> lsP1 = new ArrayList<>();
        try {

            String query = "SELECT * FROM Product WHERE Category_id = ? ";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Id);
            rs = ps.executeQuery();
            while (rs.next()) {
                lsP1.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
            }

        } catch (Exception ex) {
            Logger.getLogger(ShopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsP1;

    }

    public Product getProdById(String id) {
        try {
            String query = "SELECT * FROM Product WHERE Id = ? ";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return null;
    }
}
