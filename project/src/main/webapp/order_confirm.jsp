<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.example.model.Order" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>

<style>
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: #f8f9fa;
    margin: 0;
    padding: 0;
    text-align: center;
}

/* Container */
.confirmation-container {
    margin-top: 80px;
}

/* Success Circle Animation */
.success-checkmark {
    width: 80px;
    height: 80px;
    border-radius: 50%;
    display: inline-block;
    border: 4px solid #28a745;
    position: relative;
    animation: scaleUp 0.5s ease forwards;
}

.success-checkmark::after {
    content: "";
    position: absolute;
    left: 22px;
    top: 40px;
    width: 20px;
    height: 40px;
    border-right: 4px solid #28a745;
    border-bottom: 4px solid #28a745;
    transform: rotate(45deg);
    opacity: 0;
    animation: drawCheck 0.8s ease 0.4s forwards;
}

@keyframes scaleUp {
    from { transform: scale(0); opacity: 0; }
    to { transform: scale(1); opacity: 1; }
}

@keyframes drawCheck {
    from { opacity: 0; height: 0; }
    to { opacity: 1; height: 40px; }
}

/* Heading */
h1 {
    margin-top: 25px;
    color: #28a745;
    font-size: 28px;
    animation: fadeIn 1s ease;
}

/* Pending Status */
h2 {
    margin-top: 15px;
    color: #ff9800;
    font-size: 22px;
    animation: blink 1.5s infinite;
}

@keyframes blink {
    0% { opacity: 1; }
    50% { opacity: 0.3; }
    100% { opacity: 1; }
}

/* Food image */
.food-img {
    margin-top: 30px;
    width: 120px;
    animation: bounce 2s infinite;
}

@keyframes bounce {
    0%, 100% { transform: translateY(0); }
    50% { transform: translateY(-10px); }
}
</style>

</head>
<body>

<%
	Order order=(Order)session.getAttribute("order");
%>
    <div class="confirmation-container">
        <div class="success-checkmark"></div>
        <h1>Order Placed Successfully 🎉</h1>
        <h2>Status: <%=order.getStatus() %></h2>
        <img src="https://cdn-icons-png.flaticon.com/512/1046/1046784.png" 
             alt="Food Delivery" class="food-img">
    </div>
</body>
</html>
