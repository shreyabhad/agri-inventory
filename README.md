# Agricultural Inventory & Crop Management System

A backend application built with Java and Spring Boot to manage agricultural crop inventory through REST APIs.

## Problem Statement

Agricultural businesses need a reliable way to maintain crop inventory, track quantities, and perform updates efficiently.

This project provides a REST-based backend for creating, retrieving, updating, and deleting crop inventory records.

## Key Features

- Create crop inventory records
- Retrieve all crops
- Retrieve a crop by ID
- Update crop information
- Delete crop records
- Input validation
- Centralized exception handling
- Meaningful HTTP status codes
- Unit testing using JUnit and Mockito
- MySQL database persistence
- Layered backend architecture

## Tech Stack

- Java 17
- Spring Boot 4.0.8
- Spring Data JPA
- REST APIs
- MySQL 8
- Maven
- JUnit
- Mockito
- Git/GitHub

## Architecture

```text
Client / Postman
       |
       v
REST Controller
       |
       v
Service Layer
       |
       v
Repository Layer
       |
       v
MySQL Database