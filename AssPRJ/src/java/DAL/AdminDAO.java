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
import model.Account;
import model.Cart;
import model.Category;
import model.Items;
import model.Orders;
import model.Product;

public class AdminDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void insertProd(String name, String info, double price, String image, int category_id, int quantity) throws Exception {
        String query
                = "INSERT INTO [dbo].[Product]\n"
                + "           ([Name]\n"
                + "           ,[Info]\n"
                + "           ,[Price]\n"
                + "           ,[Images]\n"
                + "           ,[Category_id]\n"
                + "           ,[Quantity])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)\n";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, info);
            ps.setDouble(3, price);
            ps.setString(4, image);
            ps.setInt(5, category_id);
            ps.setInt(6, quantity);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProd(String id) throws Exception {
        String query = "DELETE FROM Product\n"
                + "WHERE Id = ?;";
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(query);
        ps.setString(1, id);
        ps.executeUpdate();

    }

    public void updateProd(String name, String info, double price, String image, int category_id, int quantity, int id) {
        String query = "UPDATE [dbo].[Product]\n"
                + "   SET [Name] = ?\n"
                + "      ,[Info] = ?\n"
                + "      ,[Price] =?\n"
                + "      ,[Images] =?\n"
                + "      ,[Category_id] =?\n"
                + "      ,[Quantity] =?\n"
                + " WHERE [Id] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, info);
            ps.setDouble(3, price);
            ps.setString(4, image);
            ps.setInt(5, category_id);
            ps.setInt(6, quantity);
            ps.setInt(7, id);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public Category getCategoryOfProd(String id) {
        String query = "SELECT Product_category.*\n"
                + "FROM Product INNER JOIN Product_category\n"
                + "ON Product.Category_id = Product_category.Id\n"
                + "WHERE Product.Id = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account getUserById(String id) {
        String query = "SELECT * FROM Users\n"
                + "WHERE Id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM Users";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void addAccount(String username, String password, String email, String permission) {
        String query = "INSERT INTO Users\n"
                + "VALUES(?, ?, ?, ?) ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, permission);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateAccount(String username, String password, String email, String permission, String id) {
        String query = "UPDATE [dbo].[Users]\n"
                + "   SET [Username] = ?\n"
                + "      ,[Password] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[Permission] = ?\n"
                + " WHERE [Id] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, permission);
            ps.setString(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteAccount(String id) {
        String query = "DELETE FROM Users\n"
                + "WHERE Id = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public List<Orders> getAllOrders() {
        List<Orders> listO = new ArrayList<>();
        String query = "SELECT * FROM User_payment \n"
                + "INNER JOIN order_detail \n"
                + "ON User_payment.Id = order_detail.Payment_id";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                listO.add(new Orders(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(8), rs.getInt(9), rs.getDouble(10), rs.getString(11)));
            }
        } catch (Exception e) {
        }
        return listO;
    }
}
