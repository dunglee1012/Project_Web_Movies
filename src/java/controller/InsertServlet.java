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
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Movie;

/**
 *
 * @author leeng
 */
public class InsertServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("movieId"));
        String name = req.getParameter("movieName");
        String description = req.getParameter("description:");
        int duration = Integer.parseInt(req.getParameter("duration"));
        int rated = Integer.parseInt(req.getParameter("rated"));
        int publishedYear = Integer.parseInt(req.getParameter("publishedYear"));
        String country = req.getParameter("country");
        String imagePath = req.getParameter("imagePath");
        String videoPath = req.getParameter("videoPath");
        String[] category = req.getParameterValues("category");

        List<Category> list = new ArrayList<>();
        if (category != null) {
            for (String i : category) {
                list.add(new Category(Integer.parseInt(i), ""));
            }
        }
        Movie movie = new Movie(id, name, description, duration, rated, publishedYear, country, imagePath, videoPath, list);

        req.setAttribute("errorMessage", "Error Create Movie Try again");
        req.getRequestDispatcher("insert.jsp").forward(req, resp);

        MovieDAO dao = new MovieDAO();
        dao.insertMovie(movie);
        resp.sendRedirect("list");

    }

}
