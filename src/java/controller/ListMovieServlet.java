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
public class ListMovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        
        MovieDAO dao = new MovieDAO();
//        List<Movie> list = dao.getAllMovies();
        int count = dao.getTotalMovie();//34
        int endPage = count / 12;
        if (count % 12 != 0) {
            endPage++;
        }

        List<Movie> paging = dao.pagingMovie(index);

        req.setAttribute("list", paging);
        req.setAttribute("endPage", endPage);
//        req.setAttribute("data", list);
        req.getRequestDispatcher("home.jsp").forward(req, resp);

//        MovieDAO dao = new MovieDAO();
//        List<Movie> list = dao.getAllMovies();
//        req.setAttribute("list", list);
//        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

}
