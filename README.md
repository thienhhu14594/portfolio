# Portfolio Project

## Overview

A small professional fullstack portfolio project focused on backend engineering, deployment workflow, and AI-assisted development.

## Tech Stack

### Frontend

- HTML
- CSS
- Vanilla JavaScript

### Backend

- Java
- Spring Boot

### Database

- Supabase PostgreSQL

### Deployment

- Vercel
- Render
- Docker

## Project Structure

```text
frontend/   -> frontend application
backend/    -> Spring Boot backend
docs/       -> project documentation and devlogs
```

## Environment Variables

Backend expects these at runtime (local / Render):

- `SPRING_DATASOURCE_URL` (example: `jdbc:postgresql://<host>:5432/<db>?sslmode=require`)
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`
- Optional: `SPRING_JPA_HIBERNATE_DDL_AUTO` (default: `validate`)
- Optional: `SPRING_JPA_SHOW_SQL` (default: `false`)

## Goals

- Demonstrate backend engineering skills
- Practice REST API architecture
- Learn Docker deployment workflow
- Practice prompt engineering workflow
- Document development process

## Status

Project currently in active development.
