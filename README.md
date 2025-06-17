# 🧾 NewsFactChecker - Backend

This is the **Spring Boot backend** for the NewsFactChecker application. It handles authentication, user management, and integrates with the Google Fact Check API to verify news credibility.

**🔗 Frontend Live Site:** [https://newsfactchecker.netlify.app](https://newsfactchecker.netlify.app)

---

## ✨ Features

- 🔐 JWT-based Login and Role-based Access
- 👥 Admin/User Registration & Authentication
- 📡 Consume Google Fact Check API (REST)
- 📦 RESTful API endpoints for Angular frontend
- 🛡️ CORS and Spring Security Configured
- 💾 MySQL Database Integration
- 🚉 Deployed on **Railway.app**

---

## 🧰 Tech Stack

- **Spring Boot 3+**
- **Java 17**
- **Spring Security (JWT)**
- **MySQL**
- **Spring Data JPA**
- **Maven**
- **Railway (Deployment)**

---

## 📁 Project Structure
```
newsfactchecker-backend/
│
├── src/
│ ├── main/
│ │ ├── java/com/factchecker/
│ │ │ ├── controller/ # REST controllers
│ │ │ ├── model/ # Entity classes
│ │ │ ├── repository/ # JpaRepository interfaces
│ │ │ ├── security/ # JWT, filter, config
│ │ │ └── service/ # Service classes
│ │ └── resources/
│ │ ├── application.properties
│ │ └── static/
│
├── pom.xml
└── README.md
```

```yaml
---

## 🔧 Setup Instructions

### 1. Clone the repo

```bash
git clone https://github.com/your-username/newsfactchecker-backend.git
cd newsfactchecker-backend
```
2. Configure application.properties
```
properties
spring.datasource.url=jdbc:mysql://localhost:3306/newsdb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=secretkey
jwt.expiration=3600000
```
Create the newsdb schema in MySQL before running the app.

3. Run the application
```
bash
./mvnw spring-boot:run
App will be available at: http://localhost:8080
```
📡 API Endpoints
```
Method	Endpoint	Description	Role Required
POST	/api/auth/register	Register new user	Public
POST	/api/auth/login	Login user	Public
GET	/api/admin/users	Get all users	Admin
DELETE	/api/admin/delete/{username}	Delete user by username	Admin
GET	/api/fact/check?query=	Search fact using Google	User/Admin
```
🧪 Test Users
```
Role	Username Password
Admin	admin	admin123
User	john	john123
```
🧾 Sample Fact Check Query
```
perl
GET /api/fact/check?query=India%20won%20world%20cup
Authorization: Bearer <JWT_TOKEN>
```
🌐 Deployment
🚉 Railway (Backend)
Push code to GitHub.

Connect repo on Railway.app.

Set environment variables:

DB_URL, DB_USERNAME, DB_PASSWORD

JWT_SECRET, etc.

Trigger deployment.


📄 License
This project is licensed under the MIT License.

👨‍💻 Author
Chirag Lokhande
Backend Developer — Java | Spring Boot | REST API
