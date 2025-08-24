<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="java.util.List,com.example.model.Menu" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Menu</title>
    <link rel="stylesheet" href="menu.css">
</head>
<body>
    <header>
        <nav class="navbar">
            <div class="logo">
                <span>🍔</span>
                <span class="brand">FoodExpress</span>
            </div>
            <ul class="nav-links">
                <li><a href="afterLogin">Home</a></li>
                <li><a href="#">Menu</a></li>
                <li><a href="#">Offers</a></li>
                <li><a href="#cart.html">Cart</a></li>
                <li><a href="#">Profile</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <section class="menu-section">
            <h1>Today's Exclusive Dishes</h1>
            <div class="menu-list flex-grid">
            <%
				List<Menu> menus=(List<Menu>)request.getAttribute("allmenu"); 
            
            	for(Menu menu:menus)
            	{
            		%>
            		
                    <div class="menu-card">
                        <img src="https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=400&q=80" alt="Idli [2 Pieces] with 1 Vada">
                        <div class="menu-info">
                            <h2><%=menu.getItemName() %></h2>
                            <span class="price">₹<%=menu.getPrice() %></span>
                            <span class="rating">⭐ <%=menu.getRatings() %></span>
                            <span class="availability available">Available Quantity: <%= menu.getIsAvailable() %></span>
                            <p><%= menu.getDescription() %></p>
                            
                            <form action="cart">
                            <input type="hidden" value="<%=menu.getMenuId()%>" name="menuId">
                            <input type="hidden" value="1" name="quantity">
                            <input type="hidden" value="<%=menu.getRestaurantId()%>" name="resturantId">
                            <input type="hidden" value="add" name="action">
                            <input type="submit" value="Add to Cart">
                            </form>
                        </div>
                    </div>
                    <% 
            	}
            %>
                
            </div>
        </section>
    </main>
    <footer>
        <p>&copy; 2024 FoodExpress. All rights reserved.</p>
    </footer>
</body>
</html> 