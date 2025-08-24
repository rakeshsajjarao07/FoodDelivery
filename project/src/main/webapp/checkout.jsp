<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>

<style>
/* General Page Style */
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: #f8f9fa;
    margin: 0;
    padding: 0;
}

/* Centering Container */
.checkout-container {
    max-width: 500px;
    margin: 60px auto;
    background: #fff;
    padding: 30px;
    border-radius: 12px;
    box-shadow: 0px 6px 15px rgba(0, 0, 0, 0.1);
}

/* Heading */
.checkout-container h1 {
    text-align: center;
    margin-bottom: 25px;
    color: #ff4d4d; /* Food delivery red */
}

/* Form Styling */
.checkout-form label {
    display: block;
    margin: 12px 0 6px;
    font-weight: 600;
    color: #333;
}

.checkout-form textarea,
.checkout-form select {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 8px;
    font-size: 15px;
    transition: border 0.3s;
}

.checkout-form textarea:focus,
.checkout-form select:focus {
    border-color: #ff4d4d;
    outline: none;
}

/* Button Styling */
.place-order-btn {
    width: 100%;
    background: #ff4d4d;
    color: #fff;
    font-size: 16px;
    padding: 14px;
    margin-top: 20px;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    transition: background 0.3s;
}

.place-order-btn:hover {
    background: #e63939;
}
</style>

</head>
<body>

    <div class="checkout-container">
        <h1>Checkout</h1>
        <form action="checkout" method="post" class="checkout-form">
            
            <label for="address">Delivery Address</label>
            <textarea id="address" name="address" rows="5" required></textarea>
            
            <label for="payment">Payment Method</label>
            <select name="paymentMethod" id="payment" required>
                <option value="credit-Card">Credit Card</option>
                <option value="debit-Card">Debit Card</option>
                <option value="cod">Cash on Delivery</option>
            </select>
            <span>Total Amout: <%=session.getAttribute("totalAmount") %></span>
        
            
            <button type="submit" class="place-order-btn">Place Order</button>
        </form>
    </div>
</body>
</html>
