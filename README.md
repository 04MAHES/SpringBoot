# 🚀 Job Board REST API (Spring Boot)

![Java](https://img.shields.io/badge/Java-17-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen.svg)
![Build](https://img.shields.io/badge/Build-Maven-blue.svg)
![License](https://img.shields.io/badge/license-MIT-green.svg)

## 📖 Project Overview

This is a comprehensive **Backend RESTful API** designed to power a Job Board platform. It follows a "Headless" architecture, allowing any frontend client (React, Angular, Mobile) to consume its services. 

The project demonstrates a production-grade implementation of the **Controller-Service-Repository** pattern, handling complex relationships between Companies, Job Listings, and Reviews.

**Key Technical Highlights for Recruiters:**
* **Layered Architecture:** Strict separation of concerns (Business Logic decoupled from HTTP layer).
* **Relational Data Modeling:** Implementation of One-to-Many relationships using JPA/Hibernate.
* **REST Standards:** Correct use of HTTP verbs, status codes, and resource naming conventions.
* **DTO Pattern:** Separation of Entity models from API responses for cleaner data transfer.

---

## 🛠️ Technology Stack

| Category | Technology |
| :--- | :--- |
| **Core Framework** | Spring Boot 3.x |
| **Language** | Java 17 |
| **Database** | H2 (Dev) / MySQL (Prod) |
| **ORM / Persistence** | Spring Data JPA (Hibernate) |
| **API Testing** | Postman |
| **Build Tool** | Maven |

---

## 🏛️ Architecture & Data Model

The application handles three core domains with the following relationships:

1.  **Company**: The parent entity.
2.  **Job**: Belongs to a specific Company (**Many-to-One**).
3.  **Review**: Belongs to a specific Company (**Many-to-One**).

> **Logic:** If a Company is deleted, all associated Jobs and Reviews are handled via cascading rules to maintain data integrity.

---

## 🔌 API Documentation

Since there is no frontend, the API is the primary interface. Below are the available endpoints.

### 🏢 Company Controller
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/companies` | Fetch all registered companies |
| `GET` | `/companies/{id}` | Fetch a specific company details |
| `POST` | `/companies` | Register a new company |
| `PUT` | `/companies/{id}` | Update company profile |
| `DELETE` | `/companies/{id}` | Delete a company (and its jobs/reviews) |

### 💼 Job Controller
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/jobs` | List all available jobs |
| `GET` | `/jobs/{id}` | Get job description by ID |
| `POST` | `/jobs` | Create a new job listing (linked to Company) |
| `DELETE` | `/jobs/{id}` | Remove a job listing |

### ⭐ Review Controller
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/companies/{companyId}/reviews` | Get all reviews for a specific company |
| `POST` | `/companies/{companyId}/reviews` | Add a review for a company |
| `GET` | `/reviews/{reviewId}` | Get a specific review |


