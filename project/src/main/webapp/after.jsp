<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.example.model.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodExpress - Order Food Online from Restaurants</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <!-- Header Section -->
    <header class="main-header">
        <div class="header-left">
            <span class="app-icon" aria-label="Food App">🍽️</span>
            <span class="app-title" style="color: black;">FoodExpress</span>
        </div>
        <div class="header-right">
            <div class="profile-dropdown-container" tabindex="0">
              <p  style="color: rgb(0,0,0);">profile </p><img src="images/dpimage.jpeg" alt="Profile" class="profile-icon">
                <div class="profile-dropdown">
                    <div class="profile-modal-content">
                    <!--  user details should be add here  -->
                    
                        <h2>User Profile</h2>
                        <div class="profile-info">
                            <div><strong style="color: black">Name:</strong> <%=session.getAttribute("name") %></div>
                            <div><strong style="color: black">Username:</strong> <%=session.getAttribute("username") %></div>
                            <div><strong style="color: black">Email:</strong> <%=session.getAttribute("email") %></div>
                            <div><strong style="color: black">Mobile:</strong> +91 <%=session.getAttribute("phoneNumber") %></div>
                            <div><strong style="color: black">Address:</strong><%= session.getAttribute("address") %></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Hero Section -->
    <section class="hero">
        <div class="hero-overlay"></div>
        <div class="hero-content">
            <div class="brand-logo">FoodExpress</div>
            <div class="brand-tagline">Discover the best food & drinks in your city</div>
            <form class="search-bar-container">
                <input type="text" class="search-bar" id="search-bar" placeholder="Search for restaurant, cuisine or a dish">
                <button class="search-btn" id="search-go" type="button">Search</button>
            </form>
            <div class="search-note">(Search your favourite restaurant Here)</div>
        </div>
    </section>

    <!-- Popular Areas -->
    <div class="popular-areas">
        <h3>Popular areas in your city</h3>
        <div class="area-list">
            <div class="area-item">Connaught Place</div>
            <div class="area-item">Koramangala</div>
            <div class="area-item">Bandra</div>
            <div class="area-item">Indiranagar</div>
            <div class="area-item">Powai</div>
            <div class="area-item">MG Road</div>
            <div class="area-item">Sector 29</div>
            <div class="area-item">Jubilee Hills</div>
        </div>
    </div>

    <!-- Restaurant Cards Section -->
    <section class="restaurant-section">
        <h2 style="font-weight:600; margin-bottom:1.5rem; text-align:center;">Order food from top restaurants</h2>
            	<div class="restaurant-list" id="restaurant-list">
        <%  List<Restaurant> resturantDetails=(List<Restaurant>)request.getAttribute("allRestaurants");
            for(Restaurant resturant:resturantDetails)
            {
            	%>
            	
                <a href="menu?resturantId=<%= resturant.getRestaurantId() %>" class="restaurant-card">
                    <img src="<%= resturant.getImagePath() %>" alt="The Spice Route" class="restaurant-img">
                    <div class="restaurant-info">
                        <div class="restaurant-title"><%= resturant.getName() %></div>
                        <div class="restaurant-cuisine"><%= resturant.getCuisineType() %></div>
                        <div class="restaurant-address"><%= resturant.getAddress() %></div>
                        <div class="restaurant-meta">
                            <span class="rating"><%= resturant.getRating() %> ★</span>
                            <span><%=resturant.getDeliveryTime() %> mins</span>
                        </div>
                    </div>
                </a>
            	
        <%  
        }
        %>
            </div>
        
        
    </section>

    <!-- Footer -->
    <footer class="footer">
        <div>© 2025 FoodExpress. All rights reserved.</div>
        <div style="margin-top:0.5rem;">
            <a href="#" style="color: black; text-decoration:none; margin:0 0.5rem;">About</a>|
            <a href="#" style="color: black; text-decoration:none; margin:0 0.5rem;">Contact</a>|
            <a href="#" style="color: black; text-decoration:none; margin:0 0.5rem;">Privacy Policy</a>
        </div>
    </footer>
    
    <script>
document.getElementById('search-go').onclick = function() {
    var searchValue = document.getElementById('search-bar').value.toLowerCase().trim();
    var cards = document.querySelectorAll('.restaurant-card');
    var anyVisible = false;
    cards.forEach(function(card) {
        var name = card.querySelector('.restaurant-title').textContent.toLowerCase();
        var cuisine = card.querySelector('.restaurant-cuisine').textContent.toLowerCase();
        if (name.includes(searchValue) || cuisine.includes(searchValue) || searchValue === "") {
            card.style.display = '';
            anyVisible = true;
        } else {
            card.style.display = 'none';
        }
    });
    // Optionally, show a message if no results found
    let noResult = document.getElementById('no-result');
    if (!anyVisible) {
        if (!noResult) {
            noResult = document.createElement('div');
            noResult.id = 'no-result';
            noResult.textContent = 'No restaurants found.';
            noResult.style.textAlign = 'center';
            noResult.style.margin = '2rem';
            document.getElementById('restaurant-list').appendChild(noResult);
        }
    } else if (noResult) {
        noResult.remove();
    }
};

// ✅ Add alert ONLY when pressing Enter with empty input
document.querySelector('.search-bar-container').addEventListener('submit', function(e) {
    var searchValue = document.getElementById('search-bar').value.trim();
    if (searchValue === "") {
        e.preventDefault(); // Stop form submission
        alert("Please enter a valid search term.");
    }
});
</script>


</body>
</html>