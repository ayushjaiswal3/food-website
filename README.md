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
- Backend: Spring Boot
- Database: MySQL
- Containerization: Docker

## Architecture
The system is designed with a focus on scalability and security, using a layered architecture:
- Backend: Built using Spring Boot, the backend handles all business logic, including user authentication, account management, and transaction processing. It exposes RESTful APIs for communication.
- Database: MySQL is used to securely store user, account, and transaction data, ensuring data integrity and efficient access.
- Docker: The application is containerized using Docker to provide consistent environments across development, testing, and production.

## Installation
Follow these steps to set up the project locally:

## Prerequisites
- Java Development Kit (JDK)
- MySQL
- Docker

## Backend Setup
  1. Clone the repository:
   
  `git clone https://github.com/your-username/online-banking-management-system.git
  cd online-banking-management-system`
  
  2. Navigate to the backend directory and build the Spring Boot application:

  `cd backend
  ./mvnw clean install`
  
  3. Start the backend server:
     
  `./mvnw spring-boot:run`

## Database Setup
1. Create a MySQL database:
`CREATE DATABSE banking;`

2. Update the database configuration in the application.properties:
`spring.datasource.url=jdbc:mysql://localhost:3306/banking_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password`

## Usage
- Use an API testing tool like Postman to interact with the backend services.
- Register a new user account or log in with existing credentials via the API.
- Use API endpoints to manage accounts, perform transactions, and view transaction history.

## Database Design
![DB Image](https://res.cloudinary.com/dxfn9epwh/image/upload/v1725342370/v/cip7wwfsdvati6gvdgrz.png)

The MySQL database consists of the following tables:
- users: Stores user information such as user ID, username, password, and contact details.
- accounts: Stores account details including account ID, user ID, account type, and balance.
- transactions: Stores transaction records with transaction ID, account ID, transaction type, amount, and timestamp.

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch: git checkout -b feature-name.
3. Make your changes and commit them: git commit -m 'Add new feature'.
4. Push to the branch: git push origin feature-name.
5. Submit a pull request.
