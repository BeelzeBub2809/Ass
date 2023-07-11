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
                lsP.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
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
                lsP1.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
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
            while (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void addPayment(String name, String address, String phone, String note, Account a, Cart cart) {
        try {
            String query = "INSERT INTO [dbo].[User_payment]\n"
                    + "           ([Name]\n"
                    + "           ,[Address]\n"
                    + "           ,[Phone_num]\n"
                    + "           ,[Payment_type]\n"
                    + "           ,[User_id])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)\n"
                    + "GO";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, phone);
            ps.setString(4, "COD");
            ps.setInt(5, a.getId());
            ps.executeUpdate();

            //Lay id vua insert 
            String query2 = "SELECT TOP 1 Id \n"
                    + "from User_payment\n"
                    + "order by Id desc";
            Connection conn2 = new DBContext().getConnection();
            PreparedStatement ps1 = conn2.prepareStatement(query2);
            rs = ps1.executeQuery();
            if (rs.next()) {
                int Oid = rs.getInt("Id");
                for (Items i : cart.getItems()) {
                    String query3 = "INSERT INTO [dbo].[order_detail]\n"
                            + "           ([Id]\n"
                            + "           ,[Payment_id]\n"
                            + "           ,[Product_id]\n"
                            + "           ,[Quantity]\n"
                            + "           ,[Total]\n"
                            + "            ,[Note])\n"
                            + "     VALUES\n"
                            + "           ?\n"
                            + "           ,?\n"
                            + "           ,?\n"
                            + "           ,?\n"
                            + "           ,?\n"
                            + "           ,?)\n"
                            + "GO\n"
                            + "\n"
                            + "";
                    Connection conn3 = new DBContext().getConnection();
                    PreparedStatement ps2 = conn3.prepareStatement(query3);
                    ps2.setInt(1, Oid);
                    ps2.setInt(2, Oid);
                    ps2.setInt(3, i.getP().getId());
                    ps2.setInt(4, i.getQuantity());
                    ps2.setDouble(5, i.getPrice());
                    ps2.setString(6, note);
                }
            }
            //Cap nhat so luong sp trong db
            String query4 = "UPDATE Product SET Quantity = Quantity-? WHERE Id=?";
            Connection conn4 = new DBContext().getConnection();
            PreparedStatement ps3 = conn4.prepareStatement(query4);
            for (Items i : cart.getItems()) {
                ps3.setInt(1, i.getQuantity());
                ps3.setInt(2, i.getP().getId());
                ps3.executeUpdate();
            }
        } catch (Exception e) {
        }
    }
}
