# Java & Spring Boot Projects

A collection of Java and Spring Boot projects developed to strengthen my backend development skills, practise software engineering fundamentals, and explore different approaches to building backend applications.

This repository includes employee management applications with different data-access approaches, a library management system, and an e-commerce application.

## Projects

### 1. Employee Management — V1

**Focus:** Manual database access using JPA and EntityManager.

An employee management REST API built using a layered architecture, with a custom DAO implementation to handle database operations.

**Key Concepts**
- REST API development with Spring Boot
- Controller–Service–DAO architecture
- Manual database operations using JPA and EntityManager
- CRUD operations
- Exception handling

**Status:** Completed

### 2. Employee Management — V2

**Focus:** Repository-based data access using Spring Data JPA.

An improved version of the employee management application that replaces the manual DAO implementation with Spring Data JPA.

**Key Concepts**
- `JpaRepository`
- Repository-based data access
- CRUD operations
- Partial updates using PATCH
- Service-layer business logic
- Custom exception handling and validation

**Status:** Completed

**Source Code:** [Employee Management V2](https://github.com/lakshmanan1205/spring-projects/tree/master/employeeManagement_v2)

### 3. Employee Management — V3

**Focus:** Exploring Spring Data REST.

An iteration of the employee management application that explores repository-driven REST API generation.

**Key Concepts**
- Spring Data REST
- Repository-based REST endpoints

**Status:** Completed

### 4. Library Management System

**Focus:** Building a real-world backend application using Spring Boot.

A library management application designed around practical library operations, including user management, role-based access control, book inventory, borrowing and returning workflows, and wallet management.

**Key Concepts**
- Layered architecture
- Spring Data JPA and Hibernate
- Spring Security and role-based authorization
- Entity relationships and database design
- Transaction management using `@Transactional`
- Business rule validation
- Centralized exception handling
- Unit and integration testing

**Status:** In Progress

### 5. E-Commerce Application

**Focus:** Backend development for an e-commerce system.

A planned project to explore the design and implementation of common e-commerce functionality.

**Potential Features**
- Product and category management
- Customer management
- Shopping cart
- Order processing
- Database persistence
- REST API development

**Status:** Planned

## Technology Stack

Technologies used across the repository, depending on the individual project:

- **Language:** Java
- **Framework:** Spring Boot
- **Data Access:** JPA, Hibernate, Spring Data JPA, Spring Data REST
- **Database:** MySQL
- **Security:** Spring Security
- **Build Tool:** Maven
- **Testing:** JUnit 5, Spring Boot Test
- **API Documentation:** Swagger / OpenAPI

## Repository Structure

```text
spring-projects/
│
├── employeeManagement_v1/
├── employeeManagement_v2/
├── employeeManagement_v3/
├── libraryManagement/
├── e-commerce/
│
└── README.md
```

Each project has its own directory and README containing its specific implementation details, features, setup instructions, and technical decisions.

## Learning Objectives

This repository reflects my ongoing journey toward becoming a Java backend developer.

My main learning objectives are:

- Strengthen Java and object-oriented programming fundamentals.
- Understand layered application architecture and separation of concerns.
- Build RESTful APIs using Spring Boot.
- Understand different approaches to database access.
- Design relational databases and entity relationships.
- Implement authentication and authorization using Spring Security.
- Apply transaction management and business validations.
- Write unit and integration tests.
- Improve API documentation, code quality, and maintainability.
- Develop practical backend applications using relational databases.

## Getting Started

Each project may have different dependencies and configuration requirements.

To run a project:

1. Clone this repository.
2. Open the required project directory in your IDE.
3. Review the project's README for setup instructions.
4. Configure the required database and application properties.
5. Run the application using the Maven Wrapper or your IDE.

```bash
git clone https://github.com/lakshmanan1205/spring-projects.git
cd spring-projects
```

## Progress

Projects are developed incrementally as I learn and apply new backend development concepts. Features, implementations, and documentation may evolve as the applications improve.