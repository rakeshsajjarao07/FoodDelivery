<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Cart - FoodExpress</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
            flex: 1;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        .cart-header {
            text-align: center;
            margin-bottom: 40px;
        }

        .cart-title {
            font-size: 2.5rem;
            font-weight: bold;
            color: #333;
            margin-bottom: 20px;
            letter-spacing: 2px;
        }

        .empty-message {
            font-size: 1.5rem;
            color: #666;
            margin-bottom: 30px;
        }

        .home-button {
            background-color: #d64545;
            color: white;
            padding: 15px 30px;
            border: none;
            border-radius: 8px;
            font-size: 1.1rem;
            font-weight: bold;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        .home-button:hover {
            background-color: #c23939;
            transform: translateY(-2px);
        }

        .home-button:active {
            transform: translateY(0);
        }

        .footer {
            text-align: center;
            padding: 20px;
            color: #666;
            font-size: 0.9rem;
            margin-top: auto;
        }

        .footer a {
            color: #d64545;
            text-decoration: none;
            margin: 0 10px;
        }

        .footer a:hover {
            text-decoration: underline;
        }

        /* Optional: Add a cart icon for visual appeal */
        .cart-icon {
            font-size: 4rem;
            color: #ccc;
            margin-bottom: 20px;
        }

        @media (max-width: 768px) {
            .cart-title {
                font-size: 2rem;
            }
            
            .empty-message {
                font-size: 1.2rem;
            }
            
            .container {
                padding: 15px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="cart-header">
            <div class="cart-icon">🛒</div>
            <h1 class="cart-title">YOUR CART</h1>
            <p class="empty-message">YOUR CART IS EMPTY</p>
        </div>
        
        <a href="afterLogin" class="home-button" onclick="goToHomePage()">
            Go to Home Page
        </a>
    </div>

    <footer class="footer">
        © 2024 FoodExpress. All rights reserved.<br>
        <a href="#about">About</a> |
        <a href="#contact">Contact</a> |
        <a href="#privacy">Privacy Policy</a>
    </footer>

    <script>
        function goToHomePage() {
            // You can customize this function to redirect to your actual home page
            // For now, it will try to go to index.html
            // You can change this to your actual home page URL
            window.location.href = 'index.html';
        }

        // Optional: Add some interactive feedback
        document.querySelector('.home-button').addEventListener('click', function(e) {
            // Add a small animation effect
            this.style.transform = 'scale(0.95)';
            setTimeout(() => {
                this.style.transform = 'scale(1)';
            }, 150);
        });
    </script>
</body>
</html>