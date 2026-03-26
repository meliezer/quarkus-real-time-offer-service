# Quarkus Real-Time Offer Service

A production-style backend service built with Quarkus (Java 21), focused on real-time offer validation and processing.

## 🚀 Overview

This project demonstrates how to design and implement a high-throughput backend service using modern Java and Quarkus,
applying clean architecture principles and Test-Driven Development (TDD).

It is intentionally designed as a realistic microservice, not a toy example.

## 🧱 Architecture

- Quarkus (Java 21)
- REST APIs
- Constructor-based dependency injection
- Layered architecture (resource → service → domain)
- Centralized validation and error handling
- Isolated cache key strategy

### High-Level Flow

```text
Client
  |
  v
REST Resource
  |
  v
Service Layer
  |
  v
Domain / Business Logic
  |
  +--> Validation
  |
  +--> Cache Key Strategy
  |
  +--> Standardized Error Handling
```

### ASCII Architecture Diagram

```text
+-------------------+
|      Client       |
+-------------------+
          |
          v
+-------------------+
|   REST Resource   |
|  HTTP entrypoint  |
+-------------------+
          |
          v
+-------------------+
|   Service Layer   |
| orchestration/use |
|      cases        |
+-------------------+
          |
          v
+-------------------+
| Domain / Business |
|       Logic       |
+-------------------+
      /    |     \
     v     v      v
+---------+ +-------------+ +----------------------+
|Request  | | Cache Key   | | Standardized Error   |
|Validation| | Strategy    | | Handling / Responses |
+---------+ +-------------+ +----------------------+
```

### Key Design Choices

- **TDD-first approach**: features start from failing tests
- **No field injection**: improved testability and clarity
- **Standardized error responses**: consistent API behavior
- **Separation of concerns** across layers
- **Cache key isolation** to avoid hidden coupling

## ⚙️ Tech Stack

- Java 21
- Quarkus
- JUnit 5
- Mockito
- Maven

## 🧪 Testing

The project follows a strict TDD approach:

- Tests are written before implementation
- Validation scenarios are explicitly tested
- Focus on behavior rather than implementation details

Run tests:

```bash
./mvnw test
```

## ▶️ Running the Application

```bash
./mvnw quarkus:dev
```

## 📌 Example Features

- Request validation with meaningful error responses
- Clean service layer abstraction
- Cache-ready architecture
- Testable and maintainable codebase

## 🤖 AI-Assisted Development

This project was developed using AI-assisted tools, with a strong focus on:

- Code correctness and validation
- Avoiding "AI-generated noise"
- Maintaining clean, production-quality code

All generated code was reviewed, validated, and refined through TDD.

## 🎯 Purpose

This repository is intended to demonstrate:

- Hands-on expertise with Quarkus
- Backend architecture skills
- Testing discipline (TDD)
- Production-oriented coding practices

## 🔗 Author

Menashe Eliezer  
Senior Backend Engineer  
LinkedIn: https://linkedin.com/in/menashe-eliezer-254267
