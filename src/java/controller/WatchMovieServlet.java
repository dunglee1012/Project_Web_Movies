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
import model.Movie;

/**
 *
 * @author leeng
 */
public class WatchMovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String movieId = req.getParameter("movieId");
        int id = Integer.parseInt(movieId);
        MovieDAO dao = new MovieDAO();
        List<Movie> movie = dao.getMovieListByMovieId(id);
        req.setAttribute("watch", movie);
        req.getRequestDispatcher("watchMovie.jsp").forward(req, resp);
    }

}
