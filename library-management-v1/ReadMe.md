# Library Management System

## 1. INTRODUCTION

The **Library Management System** is a Spring Boot-based application designed to manage the day-to-day operations of a library, including book management, borrowing, returning, user management, and wallet transactions.

The library generates income through non-refundable registration fees, wallet deposits, and book rental charges.

The rental fee is calculated based on the book's price and the duration for which it is borrowed.

### Key Features

- User registration and role management.
- Book, physical copy, and author management.
- Book borrowing and returning.
- Automatic rental fee calculation based on borrowing duration.
- Wallet management and deposit history.
- Role-based authentication and authorization.

---

## 2. RENTAL FEE CALCULATION

Each book has an associated price, and the standard borrowing period is **14 days**.

The rental fee is calculated as a percentage of the original book price.

### Rental Fee Structure

| Borrowing Duration | Rental Fee |
|---|---:|
| 1–14 days | 20% |
| 15–21 days | 25% |
| 22–28 days | 30% |
| 29–35 days | 35% |
| 36–42 days | 40% |
| More than 42 days | 40% |

### Business Rules

1. Every borrowed book must be returned within 14 days.
2. A base rental fee of 20% of the book price is charged when returned within the due date.
3. An additional 5% is charged for every subsequent overdue week.
4. The maximum rental fee is capped at 40% of the book price.
5. If a book is not returned within 42 days, the Admin will take the necessary action to recover it.
6. No additional rental fee percentage will be charged beyond 40%.

**Example:**

If a user borrows a book on 1 May:

- Borrowing date: 1 May
- Due date: 14 May

The rental fee is determined by the total elapsed borrowing duration, not by calendar month boundaries.

---

## 3. TYPES OF USERS

The library operates under the supervision of an Admin, who appoints Librarians to manage day-to-day operations.

Users who want to borrow books must register as library members.

There are two types of members:

1. **Member:** Regular library members, including students.
2. **Faculty:** Faculty members whose membership category is verified during registration.

The system supports four roles:

- MEMBER
- FACULTY
- LIBRARIAN
- ADMIN

---

## 4. BOOK BORROWING LIMITS

The maximum number of books a user can borrow at a time depends on their role.

| Role | Maximum Borrowing Limit |
|---|---:|
| Member | 3 |
| Faculty | 10 |
| Librarian | 10 |
| Admin | 10 |

The application validates the borrowing limit before creating a new borrowing record.

---

## 5. WALLET AND CASH FLOW MANAGEMENT

All financial transactions within the library are handled through an internal wallet system.

### Registration Charges

Every new user must pay the following amounts during registration:

| Description | Amount |
|---|---:|
| Non-refundable Registration Fee | ₹200 |
| Minimum Initial Wallet Deposit | ₹300 |
| **Total Initial Payment** | **₹500** |

### Wallet Rules

1. Every new user must pay a non-refundable registration fee of ₹200.
2. Every new user must deposit a minimum of ₹300 into their wallet.
3. Registration fees and initial wallet deposits are maintained as separate transactions in the `DEPOSITS` table.
4. Users can recharge their wallets through a Librarian.
5. The minimum amount for subsequent wallet recharges is ₹100.
6. All amounts credited to the wallet are non-refundable.
7. Rental fees are deducted directly from the user's wallet when a book return is processed.
8. A book return cannot be completed if the user's wallet balance is insufficient to cover the rental fee.

### Deposit Records Example

For a new user registration:

| Transaction Type | Amount |
|---|---:|
| REGISTRATION_FEE | ₹200 |
| WALLET_RECHARGE | ₹300 |

Both transactions are stored as separate records in the `DEPOSITS` table.

### Financial Tracking

- **DEPOSITS:** Maintains the history of registration fees and wallet deposits received from users.
- **BORROWINGS:** Maintains borrowing and return history, including rental fees charged to users.
- **USERS:** Maintains the current wallet balance of each user.

---

## 6. ROLES AND RESPONSIBILITIES

| Role | Responsibilities |
|---|---|
| Admin | Manages users and oversees library operations. |
| Librarian | Manages books, authors, physical book copies, returns, and wallet deposits. |
| Member | Borrows and returns books through the Librarian. |
| Faculty | Borrows and returns books through the Librarian with an increased borrowing limit. |

Members and Faculty users share the same basic library operations but have different borrowing limits.

---

## 7. BUSINESS RULES

### ADMIN

1. An Admin cannot delete a user until all their dependencies are cleared.
2. For example, a user cannot be deleted while they still have unreturned books.
3. At least one active Admin must always exist in the system.
4. The Admin is responsible for recovering books that remain unreturned beyond 42 days.

### LIBRARIAN

1. A Librarian cannot remove a book copy while it is currently borrowed and has not been returned.
2. A Librarian verifies the physical condition of a returned book and completes the return process in the application.
3. A Librarian handles wallet recharge requests and records the corresponding deposit transactions.
4. At least one active Librarian must always exist in the system.

### MEMBERS / FACULTY

1. Only active and valid members can borrow books.
2. Users cannot exceed their borrowing limits.
3. Users must have sufficient wallet balance to pay the rental fee when returning a book.
4. If the wallet balance is insufficient, users must recharge their wallets before completing the return transaction.

### BOOK BORROWING AND RETURN PROCESS

**Borrowing Process:**

1. The member requests a book.
2. The Librarian verifies the member's eligibility and borrowing limit.
3. The Librarian checks the availability of physical book copies.
4. The Librarian issues an available book copy and creates the borrowing record.

**Return Process:**

1. The member physically hands over the borrowed book to the Librarian.
2. The Librarian verifies the returned book and its physical condition.
3. The Librarian initiates the return process through the application.
4. The application calculates the rental fee based on the borrowing duration.
5. The rental fee is deducted from the user's wallet.
6. The borrowing record is updated.
7. The physical book copy becomes available for borrowing again.

---

## 8. PERMISSIONS AND ACCESS CONTROL

The system supports four roles: MEMBER, FACULTY, LIBRARIAN, and ADMIN.

| Operation | MEMBER | FACULTY | LIBRARIAN | ADMIN |
|---|:---:|:---:|:---:|:---:|
| View Books | ❌ | ❌ | ✅ | ✅ |
| Search Books | ✅ | ✅ | ✅ | ✅ |
| View Book Details | ❌ | ❌ | ✅ | ✅ |
| View Book Copies | ✅ | ✅ | ✅ | ✅ |
| Borrow Books | ❌ | ❌ | ✅ | ✅ |
| Return Books | ❌ | ❌ | ✅ | ✅ |
| Add Books | ❌ | ❌ | ✅ | ✅ |
| Update Books | ❌ | ❌ | ✅ | ✅ |
| Delete Books | ❌ | ❌ | ✅ | ✅ |
| Recharge Wallet | ❌ | ❌ | ✅ | ✅ |
| Manage Users | ❌ | ❌ | ❌ | ✅ |

Additional implementation requirements:

- Implement field-level validations.
- Handle application exceptions appropriately.
- Write unit and integration test cases.
- Integrate Swagger/OpenAPI for API documentation.

---

## 9. APPLICATION ARCHITECTURE

The application follows a layered architecture to separate responsibilities and maintain code organization.

### Technology and Design

1. **Spring Data JPA:** Used for entity management and database operations.
2. **Spring Security:** Used to implement authentication and role-based authorization.
3. **Layered Architecture:** Follows the Controller → Service → DAO/Repository → Entity flow.
4. **Transaction Management:** Uses `@Transactional` for operations involving multiple entities or database tables within a single API request.
5. **Validation:** Implements appropriate field-level and business-level validations.
6. **Exception Handling:** Provides centralized exception handling.
7. **Testing:** Includes unit and integration tests.

---

## 10. DATABASE DESIGN

The database is designed using relational entities and mapping tables to maintain relationships between different entities.

### Main Entities

| Entity | Purpose |
|---|---|
| USERS | Stores all user information. |
| ROLES | Maintains the available roles in the application. |
| USER_ROLES | Maps users to roles and maintains role assignments. |
| BOOKS | Stores book information. |
| AUTHORS | Stores author information. |
| BOOK_AUTHORS | Maintains the many-to-many relationship between books and authors. |
| BOOK_COPIES | Maintains individual physical copies of each book. |
| DEPOSITS | Maintains user registration fee and wallet deposit history. |
| BORROWINGS | Maintains book borrowing and return history. |

### Database Design Decisions

1. **Users and Roles:** `USERS` and `ROLES` are maintained as separate entities. `USER_ROLES` acts as the mapping entity between them.
2. **Books and Authors:** Books and Authors are maintained as separate entities, with `BOOK_AUTHORS` handling their many-to-many relationship.
3. **Book Copies:** `BOOK_COPIES` maintains individual physical copies of each book. Users borrow a physical book copy rather than an entire book title.
4. **Deposits:** The `DEPOSITS` table maintains the history of registration fees and wallet deposits made by users.
5. **User Types:** MEMBER, FACULTY, LIBRARIAN, and ADMIN share the same `USERS` table to avoid unnecessary entity duplication.
6. **Borrowings:** The `BORROWINGS` table maintains borrowing and return history, including rental fee details.

### Financial Tracking

- The `DEPOSITS` table helps track the total amount collected through registration fees and wallet deposits.
- The `BORROWINGS` table helps track rental fees charged to users and their borrowing history.
- The wallet balance maintains the available prepaid credit of each user.

### Entity Relationship Diagram (ERD)

The database structure and relationships are documented in the following ERD:

**ER Diagram:** [Add ERD Link Here]

---

## 11. API ENDPOINTS

The following endpoints define the planned API structure and access permissions.

### AUTHENTICATION (PUBLIC)

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register-faculty` | Register as a Faculty user. |
| POST | `/api/auth/register-member` | Register as a Member. |
| POST | `/api/auth/login` | Authenticate a user. |

### USERS (ADMIN)

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/users` | Retrieve all users. |
| GET | `/api/users/{id}` | Retrieve a user by ID. |
| POST | `/api/users` | Create a user. |
| PUT | `/api/users/{id}` | Update user information. |
| DELETE | `/api/users/{id}` | Delete a user. |

### ROLES (ADMIN)

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/roles` | Retrieve all roles. |
| GET | `/api/roles/{id}` | Retrieve a role by ID. |
| POST | `/api/roles` | Create a role. |
| PUT | `/api/roles/{id}` | Update a role. |
| DELETE | `/api/roles/{id}` | Delete a role. |

### USER_ROLES (ADMIN)

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/user_roles` | Retrieve all user-role assignments. |
| GET | `/api/user_roles/{id}` | Retrieve an assignment by ID. |
| POST | `/api/user_roles` | Create a user-role assignment. |
| PUT | `/api/user_roles/{id}` | Update an assignment. |
| DELETE | `/api/user_roles/{id}` | Delete an assignment. |

### BOOKS

| Method | Endpoint | Access | Description |
|---|---|---|---|
| GET | `/api/books` | Librarian | Retrieve all books. |
| GET | `/api/books/{id}` | Librarian | Retrieve a book by ID. |
| POST | `/api/books` | Librarian | Add a new book. |
| PUT | `/api/books/{id}` | Librarian | Update book information. |
| DELETE | `/api/books/{id}` | Librarian | Delete a book. |
| GET | `/api/books/search?title=java` | Users | Search books by title. |

### AUTHORS (LIBRARIAN)

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/authors` | Retrieve all authors. |
| GET | `/api/authors/{id}` | Retrieve an author by ID. |
| POST | `/api/authors` | Create an author. |
| PUT | `/api/authors/{id}` | Update an author. |
| DELETE | `/api/authors/{id}` | Delete an author. |

### BOOK_AUTHORS (LIBRARIAN)

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/book_authors` | Retrieve all book-author mappings. |
| GET | `/api/book_authors/{id}` | Retrieve a mapping by ID. |
| POST | `/api/book_authors` | Create a book-author mapping. |
| PUT | `/api/book_authors/{id}` | Update a mapping. |
| DELETE | `/api/book_authors/{id}` | Delete a mapping. |

### BOOK_COPIES

| Method | Endpoint | Access | Description |
|---|---|---|---|
| GET | `/api/book_copies` | Users | Retrieve book copies. |
| GET | `/api/book_copies/{id}` | Users | Retrieve a book copy by ID. |
| POST | `/api/book_copies` | Librarian | Add a physical book copy. |
| PUT | `/api/book_copies/{id}` | Librarian | Update book copy information. |
| DELETE | `/api/book_copies/{id}` | Librarian | Delete a book copy. |

### BORROWINGS (LIBRARIAN)

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/borrowings` | Create a borrowing record. |
| GET | `/api/borrowings/{id}` | Retrieve a borrowing record. |
| POST | `/api/borrowings/{id}/return` | Process a book return. |
| GET | `/api/borrowings/active` | Retrieve active borrowings. |
| GET | `/api/borrowings/overdue` | Retrieve overdue borrowings. |

### CURRENT USER (AUTHENTICATED USERS)

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/me` | Retrieve the currently authenticated user's information. |
| GET | `/api/me/borrowings` | Retrieve the currently authenticated user's borrowing history. |

---

## 12. FUTURE ENHANCEMENTS – VERSION 2

The following improvements are planned for the next version.

1. **DTO Implementation:** Currently, the APIs expose entity data directly. Introduce Data Transfer Objects (DTOs) to control the data exposed through API requests and responses.
2. **Dynamic Authorization:** Currently, authorization rules are configured using hardcoded Spring Security configuration. Introduce a permission-based database design to manage permissions dynamically without modifying application configuration for every permission change.
3. **JWT Authentication:** Implement JWT-based authentication to support stateless authentication instead of repeatedly sending username and password credentials with every API request.
4. **Session and Token Management:** Introduce appropriate authentication and token lifecycle management.

---

## 13. PROJECT GOALS

This project is intended to demonstrate practical implementation of:

- Java and Spring Boot.
- Spring Data JPA and Hibernate.
- Spring Security and authentication.
- Role-based and permission-based authorization.
- REST API development.
- Relational database design and entity relationships.
- Transaction management.
- Input validation and exception handling.
- Unit and integration testing.
- API documentation using Swagger/OpenAPI.