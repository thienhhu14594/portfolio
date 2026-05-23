# Backend Initial Setup

## Goal

Initialize Spring Boot backend and verify API routing.

## Completed

- Generated Spring Boot project
- Added dependencies
- Fixed datasource startup issue
- Created first API endpoint

## Problems

Spring Boot failed to start because datasource configuration was missing.

## Solution

Temporarily excluded datasource auto-configuration until PostgreSQL setup is ready.

## Lessons Learned

Spring Boot automatically configures datasource when JPA dependencies are included.

# Build Project Entity Flow

## Goal

Build Project Entity flow with structure layers: Entity, Service, Controller, Repository.

## Complete

- create Project entity flow
- fix require a bean of type in ProjectService temporarily
- create projects endpoint
- successfully test on Thunder Client

## Problem

Spring Boot fails to start because ProjectRepository bean cannot be found.

## Solution

Temporary disable components that depend on JPA repository. Temporarily replace database logic with mock data.

## Lessons Learned

With a JpaRepository, Spring needs a DataSource + JPA infrastructure to register the bean.

## Update (2026-05-23)

- Removed the temporary datasource/JPA disabling approach
- Switched `ProjectService` from mock data to `ProjectRepository` (Supabase PostgreSQL)
- Moved datasource credentials to environment variables (no secrets in repo)
