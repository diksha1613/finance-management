#  Finance Management System (Spring Boot)

##  Project Description
This is a **Finance Management System** built using **Spring Boot**.  
It allows users to manage financial records such as income and expenses.

The system provides REST APIs to:
- Add financial records
- View all records
- Delete records
- Filter records by type (INCOME / EXPENSE)
- Calculate balance

---

##  Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database (In-Memory)
- Postman (for testing APIs)
- Maven

---

##  Project Structure
src/main/java/com/example/finance
│
├── controller # REST Controllers
├── service # Business Logic
├── repository # JPA Repositories
├── entity # Entity Classes
├── enumtype # Enums (RecordType)
└── FinanceApplication.java

---

## 🗄️ Database
- H2 In-Memory Database is used
- Tables are auto-created at runtime

Tables:
- users
- financial_record

---

##  How to Run the Project

1. Open project in Eclipse
2. open project folder. right click on main file and click on run as spring boot app

 Open browser or Postman:
 
---

## 🔗 API Endpoints

###  Add Financial Record
**POST** `/records`

 Request Body:
```json
{
  "amount": 5000,
  "category": "Salary",
  "description": "Monthly salary",
  "date": "2026-04-06",
  "type": "INCOME"
}
