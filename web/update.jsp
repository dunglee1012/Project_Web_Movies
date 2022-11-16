<%-- 
    Document   : update
    Created on : Oct 22, 2022, 11:41:15 PM
    Author     : leeng
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
        
    </head>
    <body>
    <center>
        <h1>Update Movie</h1>
        <form action="update" method="post">
            <table>
                <tr>
                    <td>Enter Movies Id: </td>
                    <td>
                        <input type="text" name="movieId" readonly value="${movie.movieId}"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Name: </td>
                    <td>
                        <input type="text" name="movieName" value="${movie.movieName}"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Description: </td>
                    <td>
                        <input type="text" name="description" value="${movie.description}"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Duration: </td>
                    <td>
                        <input type="text" name="duration" value="${movie.duration}"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Rated: </td>
                    <td>
                        <input type="text" name="rated" value="${movie.rated}"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Published Year: </td>
                    <td>
                        <input type="text" name="publishedYear" value="${movie.publishedYear}"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Country: </td>
                    <td>
                        <input type="text" name="country" value="${movie.country}"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Image Path: </td>
                    <td>
                        <input type="text" name="imagePath" value="${movie.imagePath}"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Video Path: </td>
                    <td>
                        <input type="text" name="videoPath" value="${movie.videoPath}"/>
                    </td>
                </tr>

                <td><input type="submit" value="Update"></td>

            </table>
        </form>
    </center>

</body>
</html>
