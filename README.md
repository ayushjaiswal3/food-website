# Online Food Ordering Website
- An online food ordering system that lets users browse menus, place orders,
-  make secure payments, and track their orders in real-time.
- The application features a robust backend built with Spring Boot, frontend with React.Js, redux for state management, efficient data storage managed using MySQL 
and is deployed using Docker containers to ensure consistency across environments.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Architecture](#architecture)
- [Installation](#installation)
- [Usage](#usage)
- [Database Design](#database-design)
- [Contributing](#contributing)


## Features
- User Management: Users can sign up, log in, and manage their profiles securely using JWT-based authentication.

- Role-Based Access Control: Separate access for Restaurant Owners and Customers to enhance security and personalize user experience.

- Restaurant & Menu Browsing: Customers can explore restaurants, browse dynamic menus, and view food items with details.

- Cart & Order Placement: Add items to cart, update quantities, and place real-time orders with instant feedback.

- Payment Integration: Integrated with Stripe API to handle secure and smooth online payments.

- Order Tracking: Customers can track the status of their orders post-placement.

- Admin/Owner Dashboard: Restaurant owners can manage menu items, view orders, and track customer interactions.

- State Management: Redux used to maintain consistent state across components and ensure smooth UI/UX.

- Responsive UI: Built with React.js and Material UI for a user-friendly experience across devices.

## Tech Stack
- Frontend: React.js, Material UI, Redux, React Router

- Backend: Spring Boot (RESTful APIs)

- Database: MySQL

- Authentication: JWT (Role-based access for Restaurant Owners and Customers)

- Payments: Stripe API (for secure online transactions)

- State Management: Redux

- Build & Deployment: Docker 

## Architecture
The system is designed with a focus on scalability and security, using a layered architecture:
- Frontend: Developed with React.js, using Material UI for UI components and Redux for state management. Handles user interactions, order placement, and real-time updates via API calls.

- Backend: Built with Spring Boot, it manages business logic such as user authentication, role-based access (Customer & Restaurant Owner), order processing, and menu management. Exposes RESTful APIs for frontend communication.

- Authentication: Implemented JWT-based authentication to ensure secure, role-restricted access for different user types.

- Database: Utilizes MySQL to store structured data like users, orders, food items, and transactions with high reliability and consistency.

- Payment Integration: Integrated with Stripe API for secure, real-time payment processing.

## Installation
Follow these steps to set up the project locally:

## Prerequisites
- Java Development Kit (JDK)
- MySQL
  

## Backend Setup
  1. Clone the repository:
   
  `git clone https://github.com/your_username/food-website.git
cd food-website`
  
  2. Navigate to the backend directory and build the Spring Boot application:

  `cd backend
  ./mvnw clean install`
  
  3. Start the backend server:
     
  `./mvnw spring-boot:run`

## Database Configuration

Update the `application.properties` file in the backend:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/food_app
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
```


## Usage
- Use an API testing tool like Postman to interact with the backend services.
- Register a new user account or log in with existing credentials via the API.
- Use API endpoints to manage accounts, perform transactions, and view transaction history.

## Database Design
![DB Image](https://res.cloudinary.com/dxfn9epwh/image/upload/v1725342370/v/cip7wwfsdvati6gvdgrz.png)

The MySQL database consists of the following tables:
- users: Stores customer and restaurant owner details like username, password, contact info, roles, etc.

- address: Contains delivery or billing addresses linked to users.

- cart: Represents a user's cart session, tracking items before order placement.

- cart_item: Line items within the cart, with quantity and linked food IDs.

- category: Defines different categories for food items (e.g., Pizza, Drinks).

- event: Stores promotional or seasonal events (e.g., discounts, offers).

- food: Contains food item details such as name, price, description, and category.

- food_images: Stores image metadata or URLs for food items.

- food_ingredients: Links food items with their ingredients (many-to-many relationship).

- ingredients: List of all ingredients used in recipes.

- ingredients_category: Categorizes ingredients (e.g., Veg, Non-Veg, Dairy).

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch: git checkout -b feature-name.
3. Make your changes and commit them: git commit -m 'Add new feature'.
4. Push to the branch: git push origin feature-name.
5. Submit a pull request.
