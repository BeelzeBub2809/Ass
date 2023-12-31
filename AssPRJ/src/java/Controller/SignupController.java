/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAL.LoginSignupDAO;

/**
 *
 * @author nguye
 */
@WebServlet(name = "SignupController", urlPatterns = {"/signup"})
public class SignupController extends HttpServlet {

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
        request.getRequestDispatcher("signup.jsp").forward(request, response);
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
        String Uname = request.getParameter("username");
        String Email = request.getParameter("email");
        String Pass = request.getParameter("pswd");
        String Re = request.getParameter("re-pswd");
        if (Uname.contains(" ") || Pass.contains(" ") || Re.contains(" ")) {
            request.setAttribute("status", "Invalid");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else if (Pass.equals(Re) != true) {
            request.setAttribute("status", "Unmatch");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else {
            LoginSignupDAO dao = new LoginSignupDAO();
            if (dao.checkAccExist(Uname) != null) {
                request.setAttribute("status", "fail");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            } else {
                dao.signup(Uname, Email, Pass);
                request.setAttribute("status", "success");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        }

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
