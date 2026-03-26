# Quarkus Real-Time Offer Service

> Real-time offer evaluation service built with Quarkus, showcasing clean architecture, TDD, and scalable backend
> design.

---

## 🚀 Overview

This project is a backend service for evaluating offers in real time, inspired by high-throughput systems commonly found
in fintech, iGaming, and recommendation platforms.

It was designed and built from scratch to demonstrate:

* Architectural ownership
* Clean and maintainable code structure
* Test-Driven Development (TDD)
* Production-oriented backend design

---

## 🧠 Why this project

While I have extensive experience with Quarkus in production, most work was within existing systems.

This project focuses on:

* designing a system end-to-end
* making architectural decisions explicit
* building a clean and understandable codebase
* showing a realistic development workflow through Git history

---

## ✨ Key Features

* Real-time offer evaluation API
* Cache abstraction layer (ready for Redis integration)
* Input validation with consistent error responses
* Clear separation of concerns (API / Application / Infrastructure)
* TDD-driven implementation with meaningful commit history

---

## 🏗️ Architecture

The system follows a layered architecture inspired by Hexagonal Architecture (Ports & Adapters):

```text
API (REST)
  ↓
APPLICATION (services, ports)
  ↓
INFRASTRUCTURE (adapters: cache, persistence)
```

### Main components

* **OfferEvaluationResource** → REST entry point
* **OfferEvaluationService** → application logic
* **DecisionCacheService** → cache abstraction (port)
* **NoOpDecisionCacheService** → default adapter
* **OfferDecisionCacheKeyFactory** → cache key generation
* DTOs & mappers → separation between API and domain

---

## 🔁 TDD Approach

The project was developed using strict TDD principles:

1. Write failing test
2. Implement minimal logic
3. Refactor without changing behavior

The Git history intentionally reflects this flow:

* test commits (red)
* feature commits (green)
* refactor commits (clean-up)

---

## ✅ Validation

Input validation is implemented using Jakarta Bean Validation:

* Required fields enforced via `@NotBlank`
* Centralized error handling via custom exception mapper

### Example error response

```json
{
    "code": "VALIDATION_ERROR",
    "message": "Request validation failed",
    "details": [
        "customerId must not be blank"
    ]
}
```

---

## ▶️ Running locally

Start in dev mode:

```bash
./mvnw quarkus:dev
```

Run tests:

```bash
./mvnw test
```

---

## 🔮 Future Improvements

The current implementation focuses on clean architecture and TDD foundations.
Next steps would evolve the system into a production-grade backend:

* **Redis-backed cache**
  Replace the no-op cache with a distributed cache for low-latency access

* **PostgreSQL-backed rule engine**
  Persist and manage offer rules dynamically

* **Observability (metrics & tracing)**
  Integrate Micrometer and OpenTelemetry for monitoring and diagnostics

* **Performance & concurrency tuning**
  Optimize for high throughput and low latency scenarios

* **Event-driven architecture (Kafka)**
  Support asynchronous processing and real-time data pipelines

---

## 🧰 Tech Stack

* Java 21
* Quarkus
* RESTEasy Reactive
* Jakarta Validation
* Mockito / RestAssured
* Maven Wrapper

---

## 📌 Notes

This project intentionally prioritizes:

* clean architecture
* maintainability
* clarity of intent
* meaningful commit history

over premature optimization or unnecessary complexity.
