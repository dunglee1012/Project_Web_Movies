/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UsersDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import model.Users;

/**
 *
 * @author leeng
 */
public class ForgetController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UsersDAO dao = new UsersDAO();
        
        Users user = dao.getUserByNameAndPass(username, password);

        if (user != null) {
            pr.println("<script type=\"text/javascript\">");
            pr.println("alert('Change Password Successful');");
            pr.println("location='login.jsp';");
            pr.println("</script>");
        } else {
            req.setAttribute("mess", "Invalid Username");
            req.getRequestDispatcher("forget.jsp").forward(req, resp);
        }
    }

}
