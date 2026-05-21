# AGENTS.md

## Project Overview

This is a small professional portfolio project focused on backend engineering, deployment workflow, and AI-assisted development.

Frontend:

- Vanilla HTML/CSS/JavaScript
- Hosted on Vercel

Backend:

- Java Spring Boot
- Hosted on Render using Docker

Database:

- Supabase PostgreSQL

The goal is to demonstrate:

- clean architecture
- REST API design
- deployment workflow
- documentation discipline
- prompt engineering workflow

---

## Architecture Rules

Backend uses layered architecture:

controller -> service -> repository -> database

Rules:

- Controllers should remain thin
- Business logic belongs in services
- Repositories only handle data access
- Use DTOs for API responses when appropriate

---

## Frontend Rules

Frontend should remain lightweight:

- No frontend frameworks
- No unnecessary animations
- Focus on clean structure and API integration

Preferred stack:

- HTML
- CSS
- Vanilla JavaScript

---

## Backend Rules

Use:

- Constructor injection
- REST conventions
- Clear package structure

Avoid:

- unnecessary dependencies
- overly complex abstractions
- premature optimization

---

## Development Workflow

Before generating large changes:

- explain reasoning
- keep modifications incremental
- prefer small iterative improvements

When debugging:

- explain root cause
- explain why the fix works

---

## Documentation Workflow

Important architectural or debugging decisions should be documented in:

- docs/devlog/
- docs/prompts/

Prompt engineering examples worth documenting:

- debugging prompts
- architecture prompts
- prompt refinements

---

## Constraints

This project intentionally prioritizes:

- simplicity
- maintainability
- learning
- professional workflow

Over:

- excessive features
- advanced frontend effects
- enterprise-scale complexity