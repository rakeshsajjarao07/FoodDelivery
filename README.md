# FoodExpress - Food Delivery System

A web-based food delivery application built with Java EE technologies that allows users to browse restaurants, order food, and track deliveries.

## Technologies Used

### Backend
- Java EE (Jakarta EE)
- Servlets
- JDBC
- MySQL Database
- Apache Tomcat 10.1

### Frontend
- JSP (Jakarta Server Pages)
- HTML5
- CSS3
- JavaScript
- Bootstrap

## Features

- **User Authentication**
  - User registration and login
  - Profile management
  - Session handling

- **Restaurant Management**
  - Browse restaurants
  - View restaurant details and ratings
  - Search restaurants by name or cuisine

- **Menu Management**
  - View restaurant menus
  - Item details with prices
  - Availability status

- **Cart System**
  - Add/remove items
  - Update quantities
  - Cart persistence across sessions

- **Order Processing**
  - Multiple payment options
  - Order confirmation
  - Delivery address management
  - Order status tracking

## Project Structure
# Project Structure

📦project
 ┣ 📂src
 ┃ ┗ 📂main
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┗ 📂example
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dao
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserDAO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RestaurantDAO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MenuDAO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜OrderDAO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂daoimplementation
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserDAOImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RestaurantDAOImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MenuDAOImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜OrderDAOImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜User.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Restaurant.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Menu.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Order.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂servlet
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginServlet.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RegisterServlet.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RestaurantServlet.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜OrderServlet.java
 ┃ ┃ ┗ 📂webapp
 ┃ ┃ ┃ ┣ 📂WEB-INF
 ┃ ┃ ┃ ┃ ┣ 📜web.xml
 ┃ ┃ ┃ ┃ ┗ 📂lib
 ┃ ┃ ┃ ┣ 📂css
 ┃ ┃ ┃ ┃ ┣ 📜style.css
 ┃ ┃ ┃ ┃ ┗ 📜bootstrap.min.css
 ┃ ┃ ┃ ┣ 📂js
 ┃ ┃ ┃ ┃ ┗ 📜script.js
 ┃ ┃ ┃ ┣ 📜index.jsp
 ┃ ┃ ┃ ┣ 📜login.jsp
 ┃ ┃ ┃ ┣ 📜register.jsp
 ┃ ┃ ┃ ┣ 📜restaurants.jsp
 ┃ ┃ ┃




## Database Schema

The application uses MySQL with the following main tables:
- User
- Restaurant 
- Menu
- Order
- OrderItem

## Setup Instructions

1. **Prerequisites**
   - JDK 21
   - Apache Tomcat 10.1
   - MySQL Server
   - Eclipse IDE for Java EE

2. **Database Setup**
   - Create a MySQL database named 'project'
   - Update database credentials in DAO implementation files

3. **Project Configuration**
   - Clone the repository
   - Import as Eclipse Dynamic Web Project
   - Add Tomcat server runtime
   - Update build path if needed

4. **Running the Application**
   - Start MySQL server
   - Deploy to Tomcat
   - Access via `http://localhost:8080/project`

## Contributors

- [SAJJARAO RAKESH]


