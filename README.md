# Java & Spring Boot Projects

A collection of Java and Spring Boot projects developed to strengthen my backend development skills, practise software engineering fundamentals, and explore different approaches to building applications.

The repository includes employee management projects with different data-access approaches, a library management application, and an e-commerce project.

## Projects

### 1. Employee Management — V1

**Focus:** Manual data access using JPA and EntityManager.

An employee management REST API built using a layered architecture, with a custom DAO implementation to handle database operations.

**Key concepts**
- REST API development with Spring Boot
- Controller–Service–DAO architecture
- Manual database operations using JPA and EntityManager
- CRUD operations
- Exception handling

**Status:** Completed

### 2. Employee Management — V2

**Focus:** Simplifying data access with Spring Data JPA.

An improved version of the employee management application that replaces the manual DAO implementation with a Spring Data JPA repository.

**Key concepts**
- `JpaRepository`
- Repository-based data access
- CRUD operations using Spring Data JPA
- Partial updates using PATCH
- Service-layer business logic
- Custom exception handling and validation

**Status:** Completed

**Source code:** [Employee Management V2](https://github.com/lakshmanan1205/spring-projects/tree/master/employeeManagement_v2)

### 3. Employee Management — V3

**Focus:** Spring Data REST, validation, and automated testing.

The next iteration of the employee management application, exploring repository-driven REST APIs and improving application reliability.

**Planned features**
- Spring Data REST

**Status:** Completed

### 4. Library Management

**Focus:** Java fundamentals and application development.

A library management application for practising core programming concepts and implementing common library operations.

**Key concepts**
- Object-oriented programming
- Classes, objects, and encapsulation
- Collections and data handling
- Application logic and CRUD-style operations
- spring security
- validations
- test cases

**Status:** Planned / In Progress

### 5. E-Commerce Application

**Focus:** Backend development for an e-commerce system.

A project intended to explore the design and implementation of common e-commerce functionality.

**Potential features**
- Product management
- Category management
- Customer management
- Shopping cart
- Order processing
- Database persistence
- REST API development

**Status:** Planned / In Progress

## Technology Stack

Technologies used across the repository, depending on the individual project:

- **Language:** Java
- **Framework:** Spring Boot
- **Data access:** JPA, Hibernate, Spring Data JPA
- **Database:** MySQL
- **Build tool:** Maven
- **Testing:** JUnit 5, Spring Boot Test
- **API documentation:** Swagger / OpenAPI (planned for V3)

## Repository Structure

```text
spring-projects/
│
├── employeeManagement_v1/
│   └── Employee management with manual DAO
│
├── employeeManagement_v2/
│   └── Employee management with Spring Data JPA
│
├── employeeManagement_v3/
│   └── Employee management with Spring Data REST
│
├── libraryManagement/
│   └── Library management application
│
├── e-commerce/
│   └── E-commerce application
│
└── README.md
```

> Directory names above are illustrative. Update them to match the actual folder names in the repository.

## Learning Objectives

This repository reflects my ongoing journey toward becoming a Java backend developer.

My main learning objectives are:

- Strengthen Java and object-oriented programming fundamentals.
- Understand layered application architecture.
- Build RESTful APIs using Spring Boot.
- Compare manual DAO implementations with Spring Data JPA.
- Explore automatic REST endpoint generation with Spring Data REST.
- Implement validation and consistent exception handling.
- Write unit and integration tests.
- Improve API documentation and code quality.
- Develop practical backend applications using relational databases.

## Getting Started

Each project may have different dependencies and configuration requirements.

To run a project:

1. Clone this repository.
2. Open the required project directory in your IDE.
3. Review the project's README, if available.
4. Configure the required database and application properties.
5. Run the application using the Maven Wrapper or your IDE.

```bash
git clone https://github.com/lakshmanan1205/spring-projects.git
cd spring-projects
```

## Progress

Projects are developed incrementally as I learn and apply new backend development concepts. Features and documentation may evolve as the applications improve.

