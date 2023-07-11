/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.ShopDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Cart;
import model.Items;
import model.Product;

/**
 *
 * @author nguye
 */
public class ProcessCartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ShopDAO Sdao = new ShopDAO();
        List<Product> list = Sdao.getAllProduct();
        Cookie[] arr = request.getCookies();
        String txt = "";
        if (arr != null) {
            for (Cookie ck : arr) {
                if (ck.getName().equals("cart")) {
                    txt += ck.getValue();
                    ck.setMaxAge(0);
                    response.addCookie(ck);
                }
            }
        }
        Cart cart = new Cart(txt, list);
        String num_raw = request.getParameter("num");
        String id_raw = request.getParameter("id");
        int id, num = 0;
        try {
            id = Integer.parseInt(id_raw);
            num = Integer.parseInt(num_raw);
            Product p = Sdao.getProdById(id_raw);
            int inStocks = p.getQuantity();
            if (num == -1 && (cart.getQuantityById(id) <= 1)) {
                cart.removeItems(id);
            } else {
                if ((num == 1) && cart.getQuantityById(id) >= inStocks) {
                    num = 0;
                }
                Items t = new Items(p, num, p.getPrice());
                cart.addItem(t);
            }

        } catch (NumberFormatException e) {
        }
        List<Items> items = cart.getItems();
        txt = "";
        if (items.size() > 0) {
            txt = items.get(0).getP().getId() + ":" + items.get(0).getQuantity();
            for (int i = 1; i < items.size(); i++) {
                txt += "." + items.get(0).getP().getId() + ":" + items.get(0).getQuantity();
            }
        }
        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(2 * 60);
        response.addCookie(c);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ShopDAO Sdao = new ShopDAO();
        List<Product> list = Sdao.getAllProduct();
        Cookie[] arr = request.getCookies();
        String txt = "";
        if (arr != null) {
            for (Cookie ck : arr) {
                if (ck.getName().equals("cart")) {
                    txt += ck.getValue();
                    ck.setMaxAge(0);
                    response.addCookie(ck);
                }
            }
        }
        String id = request.getParameter("did");
        String[] ids = txt.split("\\.");
        String out = "";
        for(int i=0; i<ids.length; i++){
            String[] s = ids[i].split(":");
            if(!s[0].equals(id)){
                if(out.isEmpty()){
                    out = ids[i];
                }else{
                    out += "." + ids[i];
                }
            }
        }
        if(!out.isEmpty()){
            Cookie ck = new Cookie("cart", out);
            ck.setMaxAge(2*60);
            response.addCookie(ck);
        }
        Cart cart = new Cart(out, list);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
