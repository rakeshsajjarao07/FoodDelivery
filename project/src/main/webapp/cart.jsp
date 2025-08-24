<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.example.model.Cart,com.example.model.CartItem"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FoodExpress - Your Cart</title>
<link rel="stylesheet" href="cart.css">
</head>
<body>
	<h1 style="text-align: center; margin: 2rem 0 1rem 0;">YOUR CART</h1>
	<div class="page-wrapper">
		<!-- Cart Section -->
		<%
					int restid=(int)session.getAttribute("resturantID");
					String resturantId=Integer.toString(restid);
					
					
					%>
		<section class="cart-section" style="width: 50%;">
			<div class="cart-header">
				<form action="cart" method="post" style="margin: 0;">
					<input type="hidden" name="action" value="clear">
					<input type="hidden" name="resturantId" value="<%=resturantId%>">
					<button class="clear-cart-btn" type="submit">Clear Cart</button>
				</form>
				
				

			</div>
			<div class="cart-list">
				<!-- Example Cart Item -->

				<%
				Cart cart = (Cart) session.getAttribute("cart");
				

				if (cart != null && !cart.getItems().isEmpty()) {
					for (CartItem item : cart.getItems().values()) {
						
						
						%>
			<div class="cart-item-card" style="width: 600px;">
					<img
						src="https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=100&q=80"
						alt="Biryani" class="cart-item-img">
					<div class="cart-item-info">
						<div class="cart-item-title"><%=item.getName()%></div>
						<div class="cart-item-meta">
							<span>₹ <%=item.getPrice()%></span> <span>Qty: <span
								class="quantity-controls" style="display: flex;">
									<form action="cart" method="post">
										<input type="hidden" name="itemId" value="<%=item.getId()%>">
										<input type="hidden" name="action" value="update"> 
										<input type="hidden" name="quantity" value="<%=item.getQuantity() - 1%>">
										<button class="qty-btn minus-btn" type="button">&#8722;</button>
									</form> 
									
									<input type="text" value="<%=item.getQuantity() %>" min="1" class="cart-qty-input"
									readonly>


									<form action="cart" method="post">
										<input type="hidden" name="itemId" value="<%=item.getId()%>">
										<input type="hidden" name="action" value="update">
										 <input type="hidden" name="quantity" value="<%=item.getQuantity() + 1%>">
										<button class="qty-btn plus-btn" type="button">&#43;</button>
									</form>
							</span>
							</span>
						</div>
					</div>
							
					<form action="cart">
						<input type="hidden" name="itemId" value="<%=item.getId()%>">
						<input type="hidden" name="resturantId" value="<%=item.getRestuarantId()%>">
						 <input type="hidden" name="action" value="remove">
						<button class="remove-btn">Remove</button>

					</form>


				</div>

				<%
				}
				}
				%>

				<!-- Add more cart items as needed -->
			</div>
			<div class="cart-summary">
				<div class="cart-total">
				
				<% Double Amount=(Double)session.getAttribute("totalAmount"); %>
					<span>Total:</span> <span>₹ <%= Amount %></span> <br>
					
					<a href="menu?resturantId=<%=resturantId%>"><button type="submit" class="add-more-btn">Add More Items</button></a>
					
				</div>
				<form action="checkout.jsp" method="post">
				
				<input type="hidden" value="fromCart" name="fromCart">
				  <input type="submit" value="Proceed to Checkout" class="checkout-btn">
				
				</form>
				
			</div>
		</section>
	</div>
	<!-- Footer -->
	<footer class="footer">
		<div style="color: black; text-decoration: none; margin: 0 0.5rem;">©
			2024 FoodExpress. All rights reserved.</div>
		<div style="margin-top: 0.5rem;">
			<a href="#"
				style="color: black; text-decoration: none; margin: 0 0.5rem;">About</a>|
			<a href="#"
				style="color: black; text-decoration: none; margin: 0 0.5rem;">Contact</a>|
			<a href="#"
				style="color: black; text-decoration: none; margin: 0 0.5rem;">Privacy
				Policy</a>
		</div>
	</footer>
	<script>
		document.addEventListener('DOMContentLoaded', function() {
			const minusBtn = document.querySelector('.minus-btn');
			const plusBtn = document.querySelector('.plus-btn');
			const qtyInput = document.querySelector('.cart-qty-input');

			minusBtn.addEventListener('click', function() {
				let current = parseInt(qtyInput.value, 10);
				if (current > 1) {
					qtyInput.value = current - 1;
				}
			});
			plusBtn.addEventListener('click', function() {
				let current = parseInt(qtyInput.value, 10);
				qtyInput.value = current + 1;
			});
		});
	</script>
</body>
</html>
