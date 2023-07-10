/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.LoginSignupDAO;
import com.oracle.wls.shaded.org.apache.bcel.classfile.Code;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;
import jakarta.servlet.http.*;

/**
 *
 * @author nguye
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

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
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie ck : cookie) {
                if (ck.getName().equals("unameCK")) {
                    request.setAttribute("uname", ck.getValue());
                }
                else if (ck.getName().equals("passCK")) {
                    request.setAttribute("pass", ck.getValue());
                }
                else if (ck.getName().equals("remCK")) {
                    request.setAttribute("rem", ck.getValue());
                }
            }
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
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
        String username = request.getParameter("username_in").trim();
        String password = request.getParameter("pswd_in").trim();
        String Rem = request.getParameter("remember");
        LoginSignupDAO dao = new LoginSignupDAO();
        Account acc = dao.login(username, password);
        if (acc == null) {
            request.setAttribute("mess", "Wrong username or password");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("AccSes", acc);
            if (Rem != null) {
                Cookie Uname_CK = new Cookie("unameCK", username);
                Cookie Pass_CK = new Cookie("passCK", password);
                Cookie Rem_CK = new Cookie("remCK", Rem);
                Uname_CK.setMaxAge(3600 * 24 * 30);
                Pass_CK.setMaxAge(3600 * 24 * 30);
                Rem_CK.setMaxAge(3600 * 24 * 30);
                response.addCookie(Uname_CK);
                response.addCookie(Pass_CK);
                response.addCookie(Rem_CK);

            }
            response.sendRedirect("login");
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
