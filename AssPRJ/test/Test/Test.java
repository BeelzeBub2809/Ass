/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import DAL.AdminDAO;
import DAL.ShopDAO;
import java.util.List;
import model.Account;
import model.Cart;
import model.Product;

/**
 *
 * @author nguye
 */
public class Test {
    public static void main(String[] args) throws Exception {
        AdminDAO dao = new AdminDAO();
        Account acc = dao.getUserById("1");
        ShopDAO Sdao = new ShopDAO();
        List<Product> list = Sdao.getAllProduct();
        Cart cart = new Cart("1:2.4:1", list);
        Sdao.addPayment("tuan", "SaoDO", "0827014598", "Nothings", acc, cart);
        
    }
}
