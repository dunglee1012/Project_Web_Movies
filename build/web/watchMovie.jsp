<%-- 
    Document   : watchMovie
    Created on : Nov 8, 2022, 1:07:43 AM
    Author     : leeng
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/home.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </head>
    <body>
        <div class="container headername header" style="background-color: #091C2D">
            <div class="row ">
                <a href="list" class=" col-3" style="color: white">HOME</a>
                <a href="listcategory" class=" col-3" style="color: white">MOVIES</a>
                <a href="" class=" col-2" style="color: white">ABOUT</a>
                <a href="search.jsp" class=" col-3" style="color: white">SEARCH</a>
                <c:if test="${sessionScope.user != null}">
                    <a href="logout" class=" col-1" style="color: white">Log Out</a>
                </c:if>

            </div>
        </div>
        <div>


            <c:forEach items="${watch}" var="item">
                <iframe style="position: fixed;
                        padding-top:  0;
                        min-width: 100%;
                        min-height: 80%;"
                        scrolling="no" 
                        src="${item.videoPath}"
                        title="YouTube video player"
                        frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write;
                        encrypted-media; gyroscope; picture-in-picture"
                        allowfullscreen>
                </iframe>

                <video src="${item.videoPath}"></video>
                </c:forEach>
        </div>
        <footer style="background: url(https://xemphim.onl/static/skin/footer-bg.jpg); padding: 60px 0px 80px 60px;">
            <p style="color: white">Phim ch???t l?????ng cao online c???a <a href="list">ABC</a> kh??c g?? so v???i c??c trang phim kh??c?</p>
            <div style="padding: 0px 0px 40px 40px">
                <li style="color: white">L?? phim bluray (reencoded), c?? ????? ph??n gi???i th???p nh???t l?? Full HD (1080p),
                    trong khi h???u h???t c??c trang phim kh??c ch??? c?? t???i ????? ph??n gi???i HD (720p) l?? cao nh???t</li>
                <li style="color: white">??m thanh 5.1 (6 channel) thay v?? stereo (2 channel) nh?? c??c trang phim kh??c (k??? c??? Youtube)</li>
                <li style="color: white">Ph?? h???p ????? xem tr??n m??n h??nh TV, m??y t??nh, laptop c?? ????? ph??n gi???i cao</li>
                <li style="color: white">N???u kh??ng h??i l??ng v???i ph??? ????? c?? s???n, b???n c?? th??? t??? upload ph??? ????? c???a ri??ng m??nh ????? xem online</li>
                <li style="color: white">C?? l???a ch???n hi???n ph??? ????? song ng??? (t???c hi???n ?????ng th???i c??? ti???ng Anh & ti???ng Vi???t), ph?? h???p v???i nh???ng ng?????i mu???n h???c ti???ng Anh qua ph??? ????? phim</li>
            </div>

        </footer>
    </body>
    
</html>
