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
import model.Movie;

/**
 *
 * @author leeng
 */
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String movieId = req.getParameter("movieId");
        int id = Integer.parseInt(movieId);
        MovieDAO dao = new MovieDAO();
        Movie m = dao.getMovieByMovieId(id);
        req.setAttribute("movie", m);
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int movieId = Integer.parseInt(req.getParameter("movieId"));
        String movieName = req.getParameter("movieName");
        String description = req.getParameter("description");
        int duration = Integer.parseInt(req.getParameter("duration"));
        int rated = Integer.parseInt(req.getParameter("rated"));
        int publishedYear = Integer.parseInt(req.getParameter("publishedYear"));
        String country = req.getParameter("country");
        String imagePath = req.getParameter("imagePath");
        String videoPath = req.getParameter("videoPath");
        
        MovieDAO dao = new MovieDAO();
        dao.updateMovie(
                movieId, movieName, description,
                duration, rated, publishedYear,
                country, imagePath, videoPath);
        resp.sendRedirect("list");
    }

}
