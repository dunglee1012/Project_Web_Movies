<%-- 
    Document   : forget
    Created on : Nov 2, 2022, 11:24:07 PM
    Author     : leeng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forget Password</title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/home.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </head>
    <body>
    <center>
        <div class="card text-center" style="margin-top: 100px;background: #ffffff; width: 300px;">
            <div class="card-header h5 text-white bg-primary">Password Reset</div>
            <div class="card-body px-5">
                <p class="card-text py-2">
                    Enter your username to reset your password.
                </p>
                <form action="forget" method="post">
                    <div class="form-outline" >
                        <label class="form-label" for="typeEmail" >Username</label>
                        <input type="text" class="form-control my-3" name="username" />
                        <label class="form-label" for="typeEmail">New Password</label>
                        <input type="password" class="form-control my-3" name="password" />
                        <p class="text-danger">${mess}</p>
                    </div>
                    <br>
                    <input class="btn btn-primary w-100" type="submit" value="Reset Password">
                </form>

                <div class="d-flex justify-content-between mt-4">
                    <a class="" href="login.jsp">Back to Login</a>
                    <a class="" href="register">Register Account</a>
                </div>
            </div>
        </div>
    </center>

</body>
</html>
