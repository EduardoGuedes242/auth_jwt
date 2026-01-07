# Auth JWT Service — Spring Boot

A stateless authentication service built with **Spring Boot** and  
**Spring Security**, implementing **JWT-based authentication** with  
secure password handling and protected REST endpoints.

This project demonstrates **mid-level backend development skills**,  
focusing on clean architecture, security best practices, and real-world  
authentication flows.

---

## Features

- User registration with encrypted passwords
- User authentication (login) with JWT generation
- Stateless authentication using JSON Web Tokens (JWT)
- Custom JWT authentication filter (`OncePerRequestFilter`)
- Protected endpoints using Spring Security
- Clean separation of concerns (Controller / Service / Repository)
- DTO-based API (no entity leakage)

---

## Tech Stack

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT (jjwt)
- Maven
- PostgreSQL

---

## Authentication Flow

### Register User

**POST** `/api/v1/auth/register`

```json
{
  "name": "Eduardo",
  "email": "eduardoguedes@gmail.com",
  "password": "1234",
  "role": "ADMINISTRATOR"
}
```
**Response — 200 OK**
```json
{
  "id": "7dca5379-431f-4ae3-a890-cbb0e3eeed71",
  "name": "Eduardo",
  "email": "eduardoguedes@gmail.com"
}
```
### Login

**POST** `/api/v1/auth/login`
```json
{
  "email": "eduardoguedes@gmail.com",
  "password": "1234"
}
```
**Response — 200 OK**
```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiJ9...",
  "tokenType": "Bearer"
}
```
------------------------------------------------------------------------

## Security

-   BCrypt password hashing
-   Stateless JWT authentication
-   Custom security filter
-   JWT token expiration handling
-   Public authentication endpoints
-   Protected user and admin endpoints

------------------------------------------------------------------------

## Roles & Authorization

This application implements **role-based access control (RBAC)** using
JWT claims and Spring Security.

### Available Roles

- **ADMINISTRATOR**
    - Full access to administrative endpoints
    - Can access `/api/v1/products/**`
    - Can access `/api/v1/users/**`

- **OPERATOR**
    - Standard authenticated user
    - Can access `/api/v1/users/**`
    - Cannot access administrative endpoints

### How Roles Work

- Each user has a single role stored in the database
- The role is included as a claim inside the JWT token
- On each request, the JWT is validated and the role is converted into a
  Spring Security authority (`ROLE_<ROLE_NAME>`)
- Endpoint access is enforced using `hasRole` and `hasAnyRole`

### Authorization Rules

| Endpoint Path            | Required Role                |
|--------------------------|------------------------------|
| `/api/v1/auth/**`        | Public                       |
| `/api/v1/users/**`       | ADMINISTRATOR, OPERATOR      |
| `/api/v1/products/**`    | ADMINISTRATOR                |

Unauthorized access results in:
- **401 Unauthorized** → missing or invalid token
- **403 Forbidden** → valid token without required role

## Author

Eduardo Guedes\
Backend Developer -- Java / Spring Boot
