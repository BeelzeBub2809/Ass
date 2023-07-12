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
        dao.insertProd("Tuan", "Tuan", 100, "product/Vet.jsp", 1, 1);
    }
}
