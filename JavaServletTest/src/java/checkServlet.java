/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mac
 */
@WebServlet(name = "checkServlet", urlPatterns = {"/checkServlet"})
public class checkServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String hostname = "jdbc:mysql://localhost/JavaServletTest";
        String dbUsername = "root";
        String dbPassword = "sly6465";
        try {

            if (username.length() != 0 && password.length() != 0) {

                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(hostname, dbUsername, dbPassword);
                String query = "select * from users where username=? and password=?";
                PreparedStatement prstm = conn.prepareStatement(query);
                prstm.setString(1, username);
                prstm.setString(2, password);
                ResultSet rs = prstm.executeQuery();
                if (rs.next()) {

                    out.println("Kullanici Girisi Basarili");
                    //response.sendRedirect("http://www.turkishcoders.com");


                } else {
                    out.println("Tekrar deneyiniz");
                }
            } else {
                out.println("Lutfen parametreleri kontrol ediniz");
            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(checkServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(checkServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
         String name = request.getParameter("name");
         String country = request.getParameter("country");
        
         if(country !=null && country.length() !=0 && name !=null && name.length()!=0){
            
         request.setAttribute("country1", country);
         request.setAttribute("name1", name);
            
         request.getRequestDispatcher("welcome.jsp").forward(request, response);
            
         }
         else{
         response.sendRedirect("login.jsp");
         }
         */
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(checkServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(checkServlet.class.getName()).log(Level.SEVERE, null, ex);
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
