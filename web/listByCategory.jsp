<%-- 
    Document   : listbycategory
    Created on : Oct 31, 2022, 9:35:56 PM
    Author     : leeng
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List By Category Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/home.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <script type="text/javascript">
            function doDelete(movieId) {
                if (confirm("Do you want to delete movie with id = " + movieId)) {
                    window.location = "delete?movieId=" + movieId;
                }
            }
        </script>
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

        <div  style="background-color: #06121E; padding-top: 20px; padding-bottom: 20px">
            <center>
                <form action="listcategory" method="post">
                    <p style="font-family:'Courier New'; color: #cc0033">Movie Category</p>
                    <select name="category">
                        <c:forEach var="d" items="${data}">
                            <option ${cid == d.categoryId ?"selected":"" } value="${d.categoryId}">${d.categoryName}</option>
                        </c:forEach>
                    </select>
                    <input class="btn btn-info" type="submit" value="Search Movie">
                </form>
            </center>

            <br>


            <!-- Movie Title-->
            <div class="container" >          
                <div class="row">
                    <c:forEach items="${listmoviebycategory}" var="m">
                        <!-- Movie Name -->
                        <c:set var="movieId" value="${m.movieId}"/>
                        <!--MOVIE CARD-->
                        <div class="card col-3" style="width: 18rem;">
                            <img src="${m.imagePath}" class="card-img-top" alt="...">
                            <div class="card-body">

                                <h5 class="card-title">${m.movieName}</h5>
                                <c:set var = "string1" value = "${m.description}"/>
                                <c:if test = "${fn:length(string1) >30}">
                                    <p class="card-text">${fn:substring(string1, 0, 150)}....</p>
                                </c:if>

                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${m.movieId}">
                                    More Detail
                                </button>

                                <!-- Model -->
                                <div class="modal fade bd-example-modal-lg" id="${m.movieId}" tabindex="-1" role="dialog"
                                     aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                    <div class="modal-dialog modal-lg" role="document">
                                        <div class="modal-content">

                                            <!-- Model Title -->
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLongTitle">${m.movieName}</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <!--Model Body -->
                                            <div class="modal-body">
                                                <div class="container-fluid">
                                                    <div class="row">
                                                        <div class="col"><img src="${m.imagePath}" alt="alt"/></div>
                                                    </div>
                                                    <br>
                                                    <div class="row">
                                                        <div class="col-6">  ${m.description}</div>
                                                        <div class="col-6">  
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    Year: ${m.publishedYear}
                                                                </div>
                                                                <div class="col-6">
                                                                    Rated: ${m.rated}
                                                                </div>
                                                            </div>
                                                            <br>
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    Duration: ${m.duration}
                                                                </div>
                                                                <div class="col-6">
                                                                    Country: ${m.country}
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>

                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-primary">Mua phim</button>
                                                <a href="#" onclick="doDelete('${movieId}')"/> Delete </a>
                                                <a href="update?movieId=${movieId}">Update</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <footer style="background: url(https://xemphim.onl/static/skin/footer-bg.jpg); padding: 60px 0px 80px 60px;">
            <p style="color: white">Phim chất lượng cao online của <a href="list">ABC</a> khác gì so với các trang phim khác?</p>
            <div style="padding: 0px 0px 40px 40px">
                <li style="color: white">Là phim bluray (reencoded), có độ phân giải thấp nhất là Full HD (1080p),
                    trong khi hầu hết các trang phim khác chỉ có tới độ phân giải HD (720p) là cao nhất</li>
                <li style="color: white">Âm thanh 5.1 (6 channel) thay vì stereo (2 channel) như các trang phim khác (kể cả Youtube)</li>
                <li style="color: white">Phù hợp để xem trên màn hình TV, máy tính, laptop có độ phân giải cao</li>
                <li style="color: white">Nếu không hài lòng với phụ đề có sẵn, bạn có thể tự upload phụ đề của riêng mình để xem online</li>
                <li style="color: white">Có lựa chọn hiện phụ đề song ngữ (tức hiện đồng thời cả tiếng Anh & tiếng Việt), phù hợp với những người muốn học tiếng Anh qua phụ đề phim</li>
            </div>

        </footer>
    </body>
</html>
