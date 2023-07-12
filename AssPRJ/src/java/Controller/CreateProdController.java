/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.AdminDAO;
import DAL.ShopDAO;
import java.io.IOException;
import java.lang.*;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;

/**
 *
 * @author nguye
 */
@MultipartConfig
public class CreateProdController extends HttpServlet {

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
        ShopDAO dao = new ShopDAO();
        List<Category> listC = dao.getAllCategory();
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("CreateProd.jsp").forward(request, response);
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
        String NameProd = request.getParameter("NameProd");
        String InfoProd = request.getParameter("InfoProd");
        String PriceProd1 = request.getParameter("PriceProd");
        String cate = request.getParameter("cate");
        String Quan = request.getParameter("QuantityProd");
        int category = Integer.parseInt(cate);
        double PriceProd = Double.parseDouble(PriceProd1);
        int quantity = Integer.parseInt(Quan);
        Part file = request.getPart("image");
        String imageName = file.getSubmittedFileName();
        String uploadPath = "C:/Users/nguye/Dropbox/PC/Desktop/ASS_PRJ301/Assignment/Ass/AssPRJ/web/product/" + imageName;
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
        AdminDAO Adao = new AdminDAO();
        try {
            Adao.insertProd(NameProd, InfoProd, PriceProd, archivePath, category, quantity);
        } catch (Exception ex) {
            Logger.getLogger(CreateProdController.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("admin");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
