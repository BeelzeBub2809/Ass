/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.*;
import model.Account;

/**
 *
 * @author nguye
 */
public class LoginSignupDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account login(String username, String pass) {
        try {
            String query = "select * from Users\n"
                    + "where Username = ? AND [Password] = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception e) {

        }
        return null;
    }
    
    public Account checkAccExist(String username) {
        try {
            String query = "select * from Users\n"
                    + "where Username = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
               return new Account(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void signup(String username, String email, String pass) {
        try {
            String query = "insert into Users\n"
                    + "values (?, ?, ?, 'user')";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

}
