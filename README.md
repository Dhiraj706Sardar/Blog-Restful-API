# Blog API

## Overview
The **Blog API** is a Spring Boot application that provides CRUD operations for managing blog posts. It allows users to create, read, update, and delete blogs through a RESTful API.

## Features
- Create a new blog post
- Retrieve all blog posts
- Retrieve a blog post by ID
- Update an existing blog post
- Delete a blog post

## Technologies Used
- **Java 17+**
- **Spring Boot** (Spring Web, Spring Data JPA)
- **Hibernate** (ORM for database interactions)
- **MySQL/PostgreSQL** (or any relational database)
- **Maven** (for dependency management)
- **Postman** (for API testing)

## Setup Instructions
### Prerequisites
Ensure you have the following installed:
- Java Development Kit (JDK 17 or later)
- Maven
- MySQL (or PostgreSQL, or any preferred relational database)

### Steps to Run
1. **Clone the Repository**
   ```sh
   git clone https://github.com/Dhiraj706Sardar/Blog-Restful-API.git
   cd Blog-Restful-API
   ```

2. **Configure the Database**
   Copy the `application.properties.example` file and rename it to `application.properties`. Update it with your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/blogdb
   spring.datasource.username=your_db_username
   spring.datasource.password=your_db_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   ```

3. **Build and Run the Application**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access API Endpoints**
   - **Create a Blog:** `POST /blogs`
   - **Get All Blogs:** `GET /blogs`
   - **Get Blog by ID:** `GET /blogs/{id}`
   - **Update a Blog:** `PUT /blogs/{id}`
   - **Delete a Blog:** `DELETE /blogs/{id}`

## API Documentation
You can use **Postman** to test the endpoints.

## Contributing
1. Fork the repository
2. Create a new feature branch (`git checkout -b feature-name`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature-name`)
5. Create a pull request

## License
This project is licensed under the **MIT License**.

---
Happy Coding! 🚀

