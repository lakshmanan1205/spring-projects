# Employee Management REST API

A RESTful API for managing employee records, built using Spring Boot and Spring Data JPA. This project demonstrates CRUD operations, layered architecture, request validation, and exception handling with MySQL as the database.

## Features

- Create, retrieve, update, and delete employee records.
- Implement CRUD operations using Spring Data JPA.
- Separate responsibilities across controller, service, and repository layers.
- Handle employee-related exceptions.
- Support partial employee updates using PATCH.
- Persist employee data in MySQL.

## Technology Stack

- **Language:** Java 17
- **Framework:** Spring Boot 4.1.2
- **Data Access:** Spring Data JPA, Hibernate
- **Database:** MySQL
- **Build Tool:** Maven
- **API Style:** REST
- **Testing:** JUnit 5, Spring Boot Test

## Architecture

The application follows a layered architecture:

```text
Client
  |
  v
EmployeeRestController
  |
  v
EmployeeService
  |
  v
EmployeeRepository
  |
  v
MySQL Database
```

- **Controller:** Handles HTTP requests and responses.
- **Service:** Contains employee-related business logic.
- **Repository:** Uses Spring Data JPA to interact with the database.

## Prerequisites

Ensure the following are installed:

- Java 17 or a compatible JDK for the configured project.
- MySQL Server.
- Git.

## Database Setup

1. Create the database in MySQL:

```sql
CREATE DATABASE employee_management;
```

2. Configure the database connection in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
```

3. Configure the `DB_USERNAME` and `DB_PASSWORD` environment variables with your local MySQL credentials.

> Keep database credentials out of version control. The Hibernate schema-generation setting shown above is intended for local development; use managed database migrations for production applications.

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/lakshmanan1205/spring-projects.git
```

2. Navigate to the project directory:

```bash
cd spring-projects/employeeManagement_v2
```

3. Configure your database credentials and ensure MySQL is running.

4. Start the application using the Maven Wrapper on Windows:

```bash
mvnw.cmd spring-boot:run
```

On Linux or macOS:

```bash
./mvnw spring-boot:run
```

The application should start at:

`http://localhost:8080`

## API Endpoints

Base URL: `http://localhost:8080/api/employees`

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/employees` | Retrieve all employees |
| GET | `/api/employees/{employeeID}` | Retrieve an employee by ID |
| POST | `/api/employees` | Create an employee |
| PUT | `/api/employees` | Update an employee |
| PATCH | `/api/employees/{employeeID}` | Partially update an employee |
| DELETE | `/api/employees/{employeeID}` | Delete an employee |

## Sample Request

### Create an employee

**POST** `/api/employees`

```json
{
        "firstName": "sriram",
        "lastName": "moorthy",
        "email": "sriram@yopmail.com",
        "department": "manager",
        "salary":20000
}
```

The response should contain the created employee and its generated ID. The exact HTTP status depends on the controller implementation.

### Retrieve an employee

**GET** `/api/employees/1`

Example response:

```json
{
        "firstName": "sriram",
        "lastName": "moorthy",
        "email": "sriram@yopmail.com",
        "department": "manager",
        "salary":20000
}
```

### Partially update an employee

**PATCH** `/api/employees/1`

```json
{
  "salary": 60000
}
```

Only the supplied field should be updated, while the other employee fields remain unchanged.

### Delete an employee

**DELETE** `/api/employees/1`

The employee record is deleted if the ID exists. Refer to the controller's response handling for the resulting HTTP status.

## Running Tests

Execute the project's tests using:

```bash
mvnw.cmd test
```

## Learning Objectives

This project was developed to practise:

- Building REST APIs with Spring Boot.
- Understanding the Controller–Service–Repository architecture.
- Replacing manual DAO implementations with Spring Data JPA.
- Performing CRUD operations with `JpaRepository`.
- Handling validation failures and application exceptions.
- Working with HTTP methods and REST API conventions.

## Future Improvements

- Add comprehensive unit and integration tests.
- Introduce Bean Validation for request payloads.
- Use request and response DTOs.
- Improve API documentation with OpenAPI.
- Add pagination and sorting.
- Add authentication and authorization.

