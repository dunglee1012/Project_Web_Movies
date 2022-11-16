/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.MovieDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Category;
import model.Movie;

/**
 *
 * @author leeng
 */
public class ListByCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieDAO dao = new MovieDAO();
        List<Category> list = dao.getAllCategory();
        req.setAttribute("data", list);
        req.getRequestDispatcher("listByCategory.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("category");
        int id = Integer.parseInt(categoryId);
        MovieDAO dao = new MovieDAO();
        List<Movie> movie= dao.getMovieByCategoryId(id);
        List<Category> list = dao.getAllCategory();
        if (id == -1) {
            req.setAttribute("cid", id);
            req.setAttribute("data", list);
            req.getRequestDispatcher("listByCategory.jsp").forward(req, resp);
        } else {
            req.setAttribute("listmoviebycategory", movie);
            req.setAttribute("data", list);
            req.setAttribute("cid", id);
            req.getRequestDispatcher("listByCategory.jsp").forward(req, resp);
        }

    }

}
