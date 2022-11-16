/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Movie;

/**
 *
 * @author leeng
 */
public class MovieDAO extends dbcontext.DBContext {

    public List<Movie> getAllMovies() {
        List<Movie> list = new ArrayList<>();
        String sql = "select * from Movies";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setMovieId(rs.getInt("movieId"));
                movie.setMovieName(rs.getString("movieName"));
                movie.setDescription(rs.getString("description"));
                movie.setDuration(rs.getInt("duration"));
                movie.setRated(rs.getInt("rated"));
                movie.setPublishedYear(rs.getInt("publishedYear"));
                movie.setCountry(rs.getString("country"));
                movie.setImagePath(rs.getString("imagePath"));
                movie.setVideoPath(rs.getString("videoPath"));
                list.add(movie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "Select * from Categories";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt("categoryId"),
                        rs.getString("categoryName")));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public void insertMovie(Movie movie) {
        String sql1 = "INSERT INTO [dbo].[Movies]\n"
                + "           ([movieId]\n"
                + "           ,[movieName]\n"
                + "           ,[description]\n"
                + "           ,[duration]\n"
                + "           ,[rated]\n"
                + "           ,[publishedYear]\n"
                + "           ,[country]\n"
                + "           ,[imagePath]\n"
                + "           ,[videoPath])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setInt(1, movie.getMovieId());
            ps1.setString(2, movie.getMovieName());
            ps1.setString(3, movie.getDescription());
            ps1.setInt(4, movie.getDuration());
            ps1.setInt(5, movie.getRated());
            ps1.setInt(6, movie.getPublishedYear());
            ps1.setString(7, movie.getCountry());
            ps1.setString(8, movie.getImagePath());
            ps1.setString(9, movie.getVideoPath());
            ps1.executeUpdate();

            List<Category> list = movie.getCategories();
            for (Category i : list) {
                String query = "INSERT INTO [dbo].[CategoryMovie]\n"
                        + "           ([categoryId]\n"
                        + "           ,[movieId])\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,?)";
                PreparedStatement ps2 = connection.prepareStatement(query);
                ps2.setInt(1, i.getCategoryId());
                ps2.setInt(2, movie.getMovieId());
                ps2.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void deleteMovie(int movieId) {
        String query = "DELETE FROM [dbo].[CategoryMovie]\n"
                + "      WHERE movieId = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, movieId);
            ps.executeUpdate();
            String query2 = "DELETE FROM [dbo].[Movies]\n"
                    + "      WHERE movieId = ?";
            PreparedStatement ps2 = connection.prepareStatement(query2);
            ps2.setInt(1, movieId);
            ps2.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Movie getMovieByMovieId(int movieId) {
        String query = "select * from Movies\n"
                + "where movieId = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, movieId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                List<Category> category = new ArrayList<>();
                Movie movie = new Movie(rs.getInt("movieId"),
                        rs.getString("movieName"),
                        rs.getString("description"),
                        rs.getInt("duration"),
                        rs.getInt("rated"),
                        rs.getInt("publishedYear"),
                        rs.getString("country"),
                        rs.getString("imagePath"),
                        rs.getString("videoPath"),
                        category);
                return movie;
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public List<Movie> getMovieListByMovieId(int movieId) {
        List<Movie> list = new ArrayList<>();
        String query = "select * from Movies\n"
                + "where movieId = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, movieId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                List<Category> category = new ArrayList<>();
                Movie movie = new Movie(rs.getInt("movieId"),
                        rs.getString("movieName"),
                        rs.getString("description"),
                        rs.getInt("duration"),
                        rs.getInt("rated"),
                        rs.getInt("publishedYear"),
                        rs.getString("country"),
                        rs.getString("imagePath"),
                        rs.getString("videoPath"),
                        category);
                list.add(movie);
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public void updateMovie(
            int movieId, String movieName, String description,
            int duration, int rated, int publishedYear,
            String country, String imagePath, String videoPath) {

        String query = "UPDATE [dbo].[Movies]\n"
                + "   SET \n"
                + "   [movieName] = ?,\n"
                + "   [description] = ?,\n"
                + "   duration = ?,\n"
                + "   rated = ?,\n"
                + "   publishedYear = ?,\n"
                + "   country = ?,\n"
                + "   imagePath = ?,\n"
                + "   videoPath = ?\n"
                + " WHERE movieId = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, movieName);
            ps.setString(2, description);
            ps.setInt(3, duration);
            ps.setInt(4, rated);
            ps.setInt(5, publishedYear);
            ps.setString(6, country);
            ps.setString(7, imagePath);
            ps.setString(8, videoPath);
            ps.setInt(9, movieId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<Movie> getMoviesBySearch(String txtSearch) {
        List<Movie> list = new ArrayList<>();
        String sql = "select * from Movies\n"
                + "where [movieName] like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setMovieId(rs.getInt("movieId"));
                movie.setMovieName(rs.getString("movieName"));
                movie.setDescription(rs.getString("description"));
                movie.setDuration(rs.getInt("duration"));
                movie.setRated(rs.getInt("rated"));
                movie.setPublishedYear(rs.getInt("publishedYear"));
                movie.setCountry(rs.getString("country"));
                movie.setImagePath(rs.getString("imagePath"));
                movie.setVideoPath(rs.getString("videoPath"));
                list.add(movie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getTotalMovie() {
        String sql = "select count(*) from Movies";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
        return 0;
    }

    public List<Movie> pagingMovie(int index) {
        List<Movie> list = new ArrayList<>();
        String sql = "select * from Movies\n"
                + "order by movieId\n"
                + "offset ? row fetch next 12 rows only";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 12);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setMovieId(rs.getInt("movieId"));
                movie.setMovieName(rs.getString("movieName"));
                movie.setDescription(rs.getString("description"));
                movie.setDuration(rs.getInt("duration"));
                movie.setRated(rs.getInt("rated"));
                movie.setPublishedYear(rs.getInt("publishedYear"));
                movie.setCountry(rs.getString("country"));
                movie.setImagePath(rs.getString("imagePath"));
                movie.setVideoPath(rs.getString("videoPath"));
                list.add(movie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Movie> getMovieByCategoryId(int CategoryId) {
        List<Movie> list = new ArrayList<>();
        String sql = "select m.* from Movies m inner join CategoryMovie cm \n"
                + "on m.movieId = cm.movieId\n"
                + "where cm.categoryId = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, CategoryId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setMovieId(rs.getInt("movieId"));
                movie.setMovieName(rs.getString("movieName"));
                movie.setDescription(rs.getString("description"));
                movie.setDuration(rs.getInt("duration"));
                movie.setRated(rs.getInt("rated"));
                movie.setPublishedYear(rs.getInt("publishedYear"));
                movie.setCountry(rs.getString("country"));
                movie.setImagePath(rs.getString("imagePath"));
                movie.setVideoPath(rs.getString("videoPath"));
                list.add(movie);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public int getCategoryById(int categoryId) {
        String sql = "select * from Categories\n"
                + "where categoryId = ? and categoryName";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category category = new Category(rs.getInt("categoryId"),
                        rs.getString("categoryName"));
                return category.getCategoryId();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

//    public static void main(String[] args) {
////        MovieDAO dao = new MovieDAO();
////        Movie movie = dao.getMovieByMovieId(1);
////        System.out.println(movie);
//    }
}
