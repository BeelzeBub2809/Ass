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
public class AdminDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void insertProd(String name, String info, double price, String image, int category_id, int quantity) throws Exception {
        String query = 
                 "INSERT INTO [dbo].[Product]\n"
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
}
