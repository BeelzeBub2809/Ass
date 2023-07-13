/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.AdminDAO;
import DAL.ShopDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author nguye
 */
@MultipartConfig
public class EditProdServlet extends HttpServlet {

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
        String id = request.getParameter("ID");
        AdminDAO dao = new AdminDAO();
        ShopDAO sdao = new ShopDAO();
        Product p = sdao.getProdById(id);
        request.setAttribute("Prod", p);
        Category cate = dao.getCategoryOfProd(id);
        request.setAttribute("category", cate);
        request.getRequestDispatcher("editprod.jsp").forward(request, response);
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
        String NameProd = request.getParameter("Name");
        String InfoProd = request.getParameter("InfoProd");
        double PriceProd = Double.parseDouble(request.getParameter("PriceProd"));
        int category = Integer.parseInt(request.getParameter("cate"));
        int quantity = Integer.parseInt(request.getParameter("QuantityProd"));
        String id = request.getParameter("ID");
        int id_int = Integer.parseInt(id);
        ShopDAO sdao = new ShopDAO();
        Product p = sdao.getProdById(id);
        String oldPath = p.getImage();
        Part file = request.getPart("image");
        String imageName = file.getSubmittedFileName();
        String uploadPath = request.getServletContext().getRealPath("/product") +"/"+imageName;
        String archivePath = "product/" + imageName;

        try {
            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = file.getInputStream();
            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
        } catch (FileNotFoundException e) {

        }
        if (imageName != null) {
            AdminDAO dao = new AdminDAO();
            dao.updateProd(NameProd, InfoProd, PriceProd, archivePath, category, quantity, id_int);
        } else {
            AdminDAO dao = new AdminDAO();
            dao.updateProd(NameProd, InfoProd, PriceProd, oldPath, category, quantity, id_int);
        }
        response.sendRedirect(request.getContextPath() + "/admin");
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
