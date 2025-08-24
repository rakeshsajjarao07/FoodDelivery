<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In - FoodExpress</title>
    <link rel="stylesheet" href="signin.css">
</head>
<body>
    <video src="./assests/mixkit-abstract-smoke-on-a-black-background-1969-full-hd.mp4" autoplay muted loop class="background-video" alt="background image is not available"></video>
    <div class="background-overlay"></div>
    <div class="signin-container">
        <h2 style="color:#cb202d; text-align:center;">SignIn Here</h2>
        <p> <% String message=(String)session.getAttribute("message"); %>
        <%= message %>
        </p>
        <form class="signin-form" action="login">
        
            <label>UserName:
                <input type="text" name="username" placeholder="UserName" required>
            </label>
            <label>Email:
                <input type="email" name="email" placeholder="Email" required>
            </label>
            <label>Password:
                <input type="password" name="password" placeholder="Password" required>
            </label>
            <button type="button" class="forgot-btn" onclick="alert('Forgot password functionality coming soon!')">Forgot password?</button>
            <div class="form-actions">
                <button type="submit" class="submit-btn">Sign In</button>
                <button type="button" class="signup-btn" onclick="window.location.href='signup.html'">Sign Up</button>
            </div>
        </form>
    </div>
</body>
</html> 