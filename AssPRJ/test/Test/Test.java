/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import DAL.AdminDAO;

/**
 *
 * @author nguye
 */
public class Test {
    public static void main(String[] args) throws Exception {
        AdminDAO dao = new AdminDAO();
        dao.addAccount("Tuan", "123456", "Taun@gmail.com", "user");
    }
}
