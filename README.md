# Java & Spring Boot Projects

A collection of Java and Spring Boot projects developed to strengthen my backend development skills, practise software engineering fundamentals, and explore different approaches to building backend applications.

This repository includes three iterations of an employee management application, each using a different data-access approach, and a library management system built in two versions.

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

**Source Code:** [Employee Management V1](https://github.com/lakshmanan1205/spring-projects/tree/master/employeeManagement_v1)

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

**Source Code:** [Employee Management V3](https://github.com/lakshmanan1205/spring-projects/tree/master/employeeManagement_v3)

### 4. Library Management System — V1

**Focus:** Building a real-world backend application using Spring Boot.

A library management application designed around practical library operations, including user management, role-based access control, book inventory, borrowing and returning workflows, and a prepaid wallet with rental-fee calculation.

**Key Concepts**

- Layered architecture (Controller → Service → Repository → Entity)
- Spring Data JPA and Hibernate with a 9-entity relational design
- Spring Security with role-based authorization (4 roles)
- DTO pattern to keep API contracts separate from persistence entities
- Logging with Spring AOP
- Transaction management using `@Transactional`
- Business rule validation
- Centralized exception handling
- Unit and integration testing
- API documentation with Swagger / OpenAPI

**Status:** In Progress

**Source Code:** [Library Management V1](https://github.com/lakshmanan1205/spring-projects/tree/master/library-management-v1)

### 5. Library Management System — V2

**Focus:** Production-style security on top of V1.

The next iteration of the library management system, replacing basic authentication and hardcoded access rules with token-based security and database-driven permissions.

**Planned Features**

- JWT-based stateless authentication
- Permission-based dynamic authorization managed through the database
- Token lifecycle and session management
- Payment gateway integration for wallet recharges (stretch goal)

**Status:** Planned

## Technology Stack

Technologies used across the repository, depending on the individual project:

- **Language:** Java
- **Framework:** Spring Boot, Spring AOP
- **Data Access:** JPA, Hibernate, Spring Data JPA, Spring Data REST
- **Database:** MySQL
- **Security:** Spring Security (JWT planned for Library Management V2)
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
├── libraryManagement_v1/
├── libraryManagement_v2/
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
- Implement authentication and authorization using Spring Security, and later JWT.
- Apply transaction management and business validations.
- Use DTOs to decouple API contracts from persistence entities.
- Apply AOP for cross-cutting concerns such as logging.
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
