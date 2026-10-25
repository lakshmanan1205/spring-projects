# Employee Management REST API — V1

A RESTful Employee Management API built with Java and Spring Boot. This project implements CRUD operations using a layered architecture and a manually implemented DAO with JPA's `EntityManager` for database access.

V1 establishes the foundation for understanding how Spring Boot applications interact with relational databases before introducing Spring Data JPA in V2.

## Features

- Create employee records.
- Retrieve all employees.
- Retrieve an employee by ID.
- Update employee details.
- Partially update employee details.
- Delete employee records.
- Handle employee-related exceptions.
- Separate HTTP handling, business logic, and database access into layers.

## Technology Stack

- **Language:** Java 17
- **Framework:** Spring Boot
- **Data Access:** JPA, Hibernate, EntityManager
- **Database:** MySQL
- **Build Tool:** Maven
- **API Style:** REST

## Architecture

This project follows a layered architecture with a manually implemented DAO.

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
EmployeeDAO
  |
  v
EmployeeDAOImpl
  |
  v
EntityManager
  |
  v
MySQL Database
```

### Layer Responsibilities

- **Controller:** Receives HTTP requests and returns responses.
- **Service:** Contains employee-related business logic.
- **DAO:** Defines the database operations required by the application.
- **DAO Implementation:** Implements database operations using `EntityManager`.
- **Entity:** Represents the employee data stored in the database.

## Prerequisites

Install the following before running the application:

- Java Development Kit (JDK) compatible with the project.
- MySQL Server.
- Git.
- An IDE such as IntelliJ IDEA or Eclipse (optional).

## Database Setup

Create a MySQL database:

```sql
CREATE DATABASE employee_management;
```

Configure the database connection in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

Set `DB_USERNAME` and `DB_PASSWORD` to your local MySQL credentials.

Ensure that the database exists and the application has permission to access it. Configure the JPA schema-generation strategy according to your existing project configuration.

## How to Run

Clone the repository:

```bash
git clone https://github.com/lakshmanan1205/spring-projects.git
```

Navigate to the V1 project directory:

```bash
cd spring-projects/employeeManagement_v1
```

Configure the database credentials and ensure MySQL is running.

Start the application on Windows:

```bash
mvnw.cmd spring-boot:run
```

On Linux or macOS:

```bash
./mvnw spring-boot:run
```

Once started, the application is typically available at:

`http://localhost:8080`

## API Endpoints

Base URL: `http://localhost:8080/api/employees`

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/api/employees` | Retrieve all employees |
| GET | `/api/employees/{employeeID}` | Retrieve an employee by ID |
| POST | `/api/employees` | Create a new employee |
| PUT | `/api/employees` | Update an employee |
| PATCH | `/api/employees/{employeeID}` | Partially update an employee |
| DELETE | `/api/employees/{employeeID}` | Delete an employee |

> Confirm the endpoint mappings in the controller before using these examples. Update this table if the implemented paths differ.

## Sample Request

### Create an Employee

**POST** `/api/employees`

Example JSON request body:

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "salary": 50000
}
```

The API should return the created employee if the request succeeds. The exact response body and HTTP status depend on the controller implementation.

### Retrieve All Employees

**GET** `/api/employees`

Returns the employee records available in the database.

### Retrieve an Employee by ID

**GET** `/api/employees/1`

Returns the employee matching the specified ID, or an error if the employee does not exist.

### Update an Employee

**PUT** `/api/employees`

Updates an employee according to the fields and update behavior implemented in the application.

### Partially Update an Employee

**PATCH** `/api/employees/1`

Example request body:

```json
{
  "salary": 60000
}
```

Updates the supplied field according to the application's PATCH implementation.

### Delete an Employee

**DELETE** `/api/employees/1`

Deletes the employee with the specified ID if it exists.

## Key Learning Outcomes

This project helped practise:

- Building REST APIs using Spring Boot.
- Designing a Controller–Service–DAO architecture.
- Understanding the DAO pattern and separation of concerns.
- Performing database operations using JPA's `EntityManager`.
- Working with entity persistence and CRUD operations.
- Handling application exceptions.
- Understanding how service and data-access layers interact.

## Next Iteration

**Employee Management V2** builds on this implementation by replacing the manual DAO implementation with Spring Data JPA and `JpaRepository`, reducing the amount of data-access boilerplate.

[View Employee Management V2](https://github.com/lakshmanan1205/spring-projects/tree/master/employeeManagement_v2)

