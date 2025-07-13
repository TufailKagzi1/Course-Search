
# Course Search API with Spring Boot & Elasticsearch

This project provides a RESTful API to index and search for educational courses using **Spring Boot** and **Elasticsearch**. It supports rich querying with **filters**, **pagination**, **sorting**, and is designed to easily extend for features like **autocomplete** and **fuzzy suggestions**.

---

## 🚀 Features Implemented

- ✅ Course indexing into Elasticsearch
- ✅ Search courses by title and description (text search)
- ✅ Filtering by:
  - Category
  - Type (e.g. COURSE, CLUB, ONE_TIME)
  - Minimum and maximum age
- ✅ Sorting by fields like `price`, `nextSessionDate`, etc.
- ✅ Pagination support
- ✅ Elasticsearch integration via `spring-data-elasticsearch`
- ✅ Sample dataset indexing at application startup

---

## 📁 Project Structure

```
src/main/java/com/undoschool/course_search/
│
├── controller/
│   └── CourseSearchController.java      # Handles search API endpoint
│
├── model/
│   └── Course.java                      # Course entity
│
├── repository/
│   └── CourseRepository.java            # Elasticsearch repository
│
├── service/
│   ├── CourseIndexService.java          # Indexes courses at startup
│   └── CourseSearchService.java         # Handles filtering & query building
│
└── CourseSearchApplication.java         # Main entrypoint with CommandLineRunner
```

---

## 🔍 Search API

### Endpoint
```
GET /api/courses/search
```

### Query Parameters
| Name             | Type    | Description                              |
|------------------|---------|------------------------------------------|
| `q`              | string  | Text to search in title or description   |
| `category`       | string  | Filter by course category (e.g. Math)    |
| `type`           | string  | Filter by type (COURSE, CLUB, ONE_TIME)  |
| `minAge`         | int     | Minimum age filter                       |
| `maxAge`         | int     | Maximum age filter                       |
| `sortField`      | string  | Field to sort on (`price`, `nextSessionDate`) |
| `sortOrder`      | string  | `asc` or `desc`                          |
| `page`           | int     | Page number (default 0)                  |
| `size`           | int     | Page size (default 10)                   |

### Example
```http
GET /api/courses/search?q=physics&category=Science&type=COURSE&minAge=9&maxAge=13&sortField=price&sortOrder=asc&page=0&size=5
```

---

## 📦 Sample Data

Over 50 preloaded course entries are indexed during application startup (`CourseIndexService#indexCourses()`).

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot 3.x
- Spring Data Elasticsearch (5.5.1)
- Elasticsearch 8.12.2
- Maven

---

## 🧪 Running Locally

### Prerequisites
- Java 21+
- Elasticsearch running locally or remotely (version 8.12.2)
- Maven 3.8+

### Steps
```bash
# Start Elasticsearch (Docker recommended)
docker run -p 9200:9200 -e "discovery.type=single-node" -e "xpack.security.enabled=false" docker.elastic.co/elasticsearch/elasticsearch:8.12.2

# Build and run Spring Boot app
./mvnw spring-boot:run
```

---

## 📬 Contact

For questions or contributions, feel free to connect with the developer.

> Built with ❤️ for UndoSchool Internship Assignment
