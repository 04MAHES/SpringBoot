# 🧾 Job Application – Spring Boot Project

A Spring Boot–based backend application for managing job postings, companies, and reviews.  
This module demonstrates practical usage of **Spring Web**, **Spring Data JPA**, and **MySQL**.

---

## 📌 Features

- Create, update, delete job postings  
- CRUD operations for companies  
- REST API structure  
- JPA/Hibernate ORM mapping  
- Auto table creation  
- Clean and modular folder structure  

---

## 🏗️ Project Structure

Job_Application/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com.jobapplication/
│ │ │ ├── controller/
│ │ │ ├── service/
│ │ │ ├── repository/
│ │ │ └── model/
│ │ └── resources/
│ │ ├── application.properties
│ │ └── data.sql / schema.sql (optional)
└── pom.xml

yaml
Copy code

---

## ⚙️ Prerequisites

Install the following:

- Java 17+  
- Maven  
- MySQL  
- IntelliJ IDEA / Eclipse / VS Code  

---

## 🚀 Running the Application

### 1️⃣ Navigate to the project folder:

```bash
cd Job_Application
2️⃣ Configure database in application.properties:
properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/jobdb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
3️⃣ Run using Maven:
bash
Copy code
mvn spring-boot:run
Server starts at:

👉 http://localhost:8080

🛠️ API Endpoints
Job APIs
Method	Endpoint	Description
GET	/jobs	Get all jobs
GET	/jobs/{id}	Get job by ID
POST	/jobs	Create job
PUT	/jobs/{id}	Update job
DELETE	/jobs/{id}	Delete job

Company APIs
Method	Endpoint	Description
GET	/companies	Get all companies
GET	/companies/{id}	Get company by ID
POST	/companies	Create company
PUT	/companies/{id}	Update company
DELETE	/companies/{id}	Delete company

🗄️ Entities Overview
Job Entity
jobId

title

description

salary

location

company (Many-To-One)

Company Entity
companyId

name

location

rating

jobs (One-To-Many)

Review Entity (optional)
reviewId

message

rating

company (Many-To-One)

🧩 Tech Stack
Spring Boot

Spring Web

Spring Data JPA

Hibernate

MySQL

Maven

📝 Future Enhancements
Add JWT Authentication

Add Swagger Documentation

Add search & filter for jobs

Global Exception Handling

Add unit tests
