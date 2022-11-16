<%-- 
    Document   : add
    Created on : Oct 20, 2022, 9:26:51 PM
    Author     : leeng
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movies</title>
<!--        <script>
            function validateForm() {
                var x = document.forms["myForm"]["movieId"]["movieName"].value;
                if (x == "" || x == null) {
                    alert("Name must be filled out");
                    return false;
                }
            }
        </script>-->
    </head>
    <body>

    <center>
        <h3>Enter movie information</h3>
        ${errorMessage}
        <form action="insert" name="myForm" onsubmit="return validateForm()" required>
            <table>
                <tr>
                    <td>Enter Movies Id </td>
                    <td>
                        <input type="text" name="movieId"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Name: </td>
                    <td>
                        <input type="text" name="movieName"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Description: </td>
                    <td>
                        <input type="text" name="description"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Duration: </td>
                    <td>
                        <input type="text" name="duration"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Rated: </td>
                    <td>
                        <input type="text" name="rated"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Published Year: </td>
                    <td>
                        <input type="text" name="publishedYear"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Country: </td>
                    <td>
                        <input type="text" name="country"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Image Path: </td>
                    <td>
                        <input type="text" name="imagePath"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Video Path: </td>
                    <td>
                        <input type="text" name="videoPath"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Movies Category: </td>
                    <td>
                        <c:forEach items="${requestScope.data}" var="c">
                            <input type="checkbox" name="category" value="${c.categoryId}"/>${c.categoryName}<br/>
                        </c:forEach>
                    </td>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create"></td>
                </tr>
            </table>
        </form>

    </center>

</body>
</html>
