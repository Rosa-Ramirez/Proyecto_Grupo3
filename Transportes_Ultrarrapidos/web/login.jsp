<%-- 
    Document   : login
    Created on : 18/10/2022, 23:42:41
    Author     : ramir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="./styleRegisterPage.css">
        <script src="js/loginScript.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
<!-- partial:index.partial.html -->
<style>
body {
display: flex;
justify-content: center;
align-items: center;
flex-direction: column;
font-family: 'Montserrat', sans-serif;
height: 100vh;
margin: -20px 0 50px;
background:linear-gradient(90deg,#FF7585,#FFBBBA);
}
</style>
<div class="container" id="container">
<div class="form-container sign-up-container">
<form action="#">
<h1>Create Account</h1>
<div class="social-container">
<a href="#" class="social"><i class=""><img src="https://i.ibb.co/5LdP2GW/fb.png" height="30px" width="30px" /></i></a>
<a href="#" class="social"><i class=""><img src="https://i.ibb.co/5Ww6T5p/g.png" height="30px" width="30px" /></i></a>
<a href="#" class="social"><i class=""><img src="https://i.ibb.co/17P4PLV/l.jpg" height="30px" width="30px" /></i></a>
</div>
<span>or use your email for registration</span>
<input type="text" placeholder="Name" />
<input type="email" placeholder="Email" />
<input type="password" placeholder="Password" />
<button><a href="index.html">Sign Up</a></button>
</form>
</div>
<div class="form-container sign-in-container">
<form action="#">
<h1>Sign in</h1>
<div class="social-container">
<a href="#" class="social"><i class=""><img src="https://i.ibb.co/5LdP2GW/fb.png" height="30px" width="30px" /></i></a>
<a href="#" class="social"><i class=""><img src="https://i.ibb.co/5Ww6T5p/g.png" height="30px" width="30px" /></i></a>
<a href="#" class="social"><i class=""><img src="https://i.ibb.co/17P4PLV/l.jpg" height="30px" width="30px" /></i></a>
</div>
<span>or use your account</span>
<input type="email" placeholder="Email" />
<input type="password" placeholder="Password" />
<a href="#">Forgot your password?</a>
<button><a href="index.html">Sign In</a></button>
</form>
</div>
<div class="overlay-container">
<div class="overlay">
<div class="overlay-panel overlay-left">
<br>
<h1> Welcome Back!</h1>
<p>
To keep connected with us please login with your personal info</p>
<button class="ghost" id="signIn" onClick="signin()">Sign In</button>
</div>
<div class="overlay-panel overlay-right"><br>
<h1>Hello, Friend!</h1>
<p>Enter your personal details and start journey with us</p>
<button class="ghost" id="signUp" onClick="signup()">Sign Up</button>
</div>
</div>
</div>
</div>
<!-- partial -->
</body>
</html>
