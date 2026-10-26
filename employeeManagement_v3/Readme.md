# Employee Management – Spring Data JPA + Spring Data REST

## Overview

This project is an Employee Management REST API built using **Spring Boot**, **Spring Data JPA**, and **Spring Data REST**.

The main purpose of this project is to understand how **Spring Data JPA** and **Spring Data REST** can significantly reduce the amount of boilerplate code required to build a CRUD REST API.

Unlike my previous Employee Management projects, this version does **not use a Service layer or custom Controllers**. Spring Data REST automatically exposes the repository as REST endpoints.

---

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Spring Data REST
- Hibernate
- MySQL
- Maven

---

## Architecture

```text
Client
   |
   v
Spring Data REST
   |
   v
Spring Data JPA Repository
   |
   v
Hibernate / JPA
   |
   v
MySQL Database
```

The repository extends `JpaRepository`, and Spring Data REST automatically exposes CRUD endpoints.

Example:

```java
@RepositoryRestResource(path = "employees")
public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {
}
```

No repository implementation code is required.

---

## REST API

The Spring Data REST base path is configured as:

```properties
spring.data.rest.base-path=/api
```

Example endpoints:

| HTTP Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get employee by ID |
| POST | `/api/employees` | Create employee |
| PUT | `/api/employees/{id}` | Update employee |
| DELETE | `/api/employees/{id}` | Delete employee |

Spring Data REST automatically generates these endpoints from the repository.

---

## Why There Is No Service Layer

This project intentionally does **not** contain a Service layer.

Spring Data REST can directly expose Spring Data repositories as REST APIs. Therefore, for a simple CRUD application, the following can be avoided:

```text
Controller
Service
DAO implementation
```

Spring Data JPA handles the repository implementation, while Spring Data REST handles the REST API exposure.

This makes the project much smaller and demonstrates how much boilerplate Spring can remove.

---

## Limitation of This Approach

Although this approach is convenient for simple CRUD operations, it becomes limited when the application requires significant **business logic**.

For example:

- Checking whether an employee's email already exists
- Applying salary/business rules
- Checking whether an employee can be deleted
- Processing multiple database operations
- Implementing complex workflows
- Performing authorization checks
- Managing transactions across multiple operations

Without a dedicated Service layer, it becomes difficult to organize and maintain complex business logic.

Because of this, this project intentionally does **not include extensive business validations**.

This should **not** be interpreted as saying that validations or business logic are unnecessary in real-world applications.

---

## Real-World Application Architecture

In a real-world Spring Boot application, when business requirements become more complex, a common architecture is:

```text
Client
   |
   v
Controller
   |
   v
Service
   |
   v
Repository
   |
   v
Database
```

### Controller

Responsible for:

- Handling HTTP requests
- Receiving request data
- Returning HTTP responses
- Request-level validation

### Service

Responsible for:

- Business logic
- Business rules
- Coordinating multiple operations
- Transaction management

### Repository

Responsible for:

- Database access
- Querying and persisting data

This separation makes the application easier to maintain, test, and extend.

---

## What I Learned From This Project

- How Spring Data JPA works with `JpaRepository`
- How Spring Data REST automatically exposes repositories
- How CRUD REST endpoints can be generated automatically
- How to configure the Spring Data REST base path
- How `@RepositoryRestResource` customizes repository endpoints
- How Spring Data reduces boilerplate code
- The difference between a simple CRUD application and a business-oriented application
- Why a Service layer becomes important when business logic is introduced

---

## Next Project

In the next version of the Employee Management project, I will move closer to a real-world backend application by adding:

- **Spring Security**
- **Authentication**
- **Authorization**
- **Spring Validation**
- **Test cases**
- Business logic through a **Service layer**

The goal is to progressively move from a simple CRUD application toward a more realistic production-style Spring Boot backend.

---

## Project Progression

```text
Employee Management V1
        |
        | Controller + Service + DAO
        v
Employee Management V2
        |
        | Spring Data JPA
        v
Employee Management V3
        |
        | Spring Data JPA + Spring Data REST
        v
Next Project
        |
        | Service Layer
        | Spring Security
        | Authentication
        | Authorization
        | Validation
        | Test Cases
        v
More Realistic Spring Boot Application
```

## Conclusion

This project is intentionally focused on understanding **Spring Data JPA + Spring Data REST** and how they reduce boilerplate code.

The absence of a Service layer and extensive validation is a deliberate design choice for this learning project. In a real-world application with meaningful business requirements, a **Controller → Service → Repository** architecture is generally more appropriate.