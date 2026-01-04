# Auth JWT Service -- Spring Boot

A stateless authentication service built with **Spring Boot** and
**Spring Security**, implementing **JWT-based authentication** with
secure password handling and protected REST endpoints.

This project demonstrates **mid-level backend development skills**,
focusing on clean architecture, security best practices, and real-world
authentication flows.

------------------------------------------------------------------------

## Features

-   User registration with encrypted passwords
-   User authentication (login) with JWT generation
-   Stateless authentication using JSON Web Tokens (JWT)
-   Custom JWT authentication filter (`OncePerRequestFilter`)
-   Protected endpoints using Spring Security
-   Clean separation of concerns (Controller / Service / Repository)
-   DTO-based API (no entity leakage)

------------------------------------------------------------------------

## Tech Stack

-   Java 17+
-   Spring Boot
-   Spring Security
-   Spring Data JPA
-   JWT (jjwt)
-   Maven
-   PostgreSQL

------------------------------------------------------------------------

## Authentication Flow

### Register User

POST `/api/v1/auth/register`
```json
{
  "name": "Eduardo",
  "email": "eduardoguedes@gmail.com",
  "password": "1234"
}
```
Response STATUS CODE 200 - OK
```json
{
  "id": "7dca5379-431f-4ae3-a890-cbb0e3eeed71",
  "name": "Eduardo",
  "email": "eduardoguedes@gmail.com"
}
```
### Login

POST `/api/v1/auth/login`
```json
{
  "email": "eduardoguedes@gmail.com",
  "password": "1234"
}
```
Response STATUS CODE 200 - OK
```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiJ9...",
  "tokenType": "Bearer"
}
```
### Access Protected   Endpoint

GET `/api/v1/users/test`\
Header: `Authorization: Bearer <token>`\
Response STATUS CODE 200 - OK 
`User authenticate`

------------------------------------------------------------------------

## Security

-   BCrypt password hashing
-   Stateless JWT authentication
-   Custom security filter
-   Public auth endpoints, protected user endpoints

------------------------------------------------------------------------

## Author

Eduardo Guedes\
Backend Developer -- Java / Spring Boot
