# Portfolio Project Scope
## Project Overview

This project is a lightweight fullstack developer portfolio designed to demonstrate backend Java development, frontend fundamentals, APIs integration, deployment workflow and AI-assisted development practices.

The project focuses on professional structure and engineering clarify rather than complex UI design.

## Objectives

- Demonstrate backend Java development skills
- Demonstrate frontend fundamentals using vanilla JavaScript
- Practice REST APIs integration
- Learn AI-assisted development and prompt engineering
- Document development decisions and progress
- Build a small but production-style project

## Core features

### Frontend

- Responsive single-page portfolio
- About section
- Skills section
- Projects section
- Contact form

### Backend

- REST APIs for projects
- REST APIs for contact message
- Validation and DTO handling

### Database

- Store projects
- Store contact form submissions

### Documentation

- Development logs
- Architecture notes
- Prompt engineering notes

## Tech Stack

### Frontend

- HTML
- CSS
- JavaScript

### Backend

- Java
- Spring Boot

### Database

- PostgreSQL (Supabase)

### Deployment

- Vercel (Frontend)
- Render with Docker (Backend)

### Tooling

- Git
- Github
- VS Code
- Codex

## Architecture Overview

The frontend communicate with the Spring Boot backend through REST APIs.

The backend handles:
- projects data
- contact form submissions
- database communication

The frontend is deployed separately from the backend to simulate a modern decoupled architecture.

## Non-goal

The project will not include:
- microservices
- authentication systems
- complex animation
- real-time communication
- advanced admin dashboards
- enterprise-scale infrastructure

The goal is simplicity, clarity and professional structure.

## Deployment Plan

Frontend:
- deploy on Vercel

Backend:
- Dockerize Srping Boot application
- deploy on Render

Database:
- use supabase PostgreSQL

## Documentation Plan

The project development process will be documented through:
- architecture notes
- API documentation
- development logs
- deployment notes
- prompt engineering examples

## Success Criteria

The project is considered successful if:
- frontend and backend are deployed publicly
- APIs function correctly
- database integration works
- the portfolio is responsive
- documentation is completed
- the project clearly demonstrate fullstack engineering skills