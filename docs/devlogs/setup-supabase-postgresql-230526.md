# Setup Supabase PostgreSQL (Spring Boot)

## Goal

Replace mock `ProjectService` data with real persistence in Supabase PostgreSQL via Spring Data JPA.

## Changes

<!-- - Remove hardcoded DB credentials from `backend/src/main/resources/application.properties`
- Read datasource config from environment variables:
  - `SPRING_DATASOURCE_URL`
  - `SPRING_DATASOURCE_USERNAME`
  - `SPRING_DATASOURCE_PASSWORD` -->
- Enable JPA datasource auto-configuration (no `DataSourceAutoConfiguration` exclusion)
- Use `ProjectRepository` in `ProjectService` (no in-memory list)
- Keep entity/table mapping readable (`githubUrl` -> `github_url`)

## Notes

- Spring Boot standard does not load .env.
- Suggested JDBC URL format for Supabase:
  - `jdbc:postgresql://<host>:5432/<db>?sslmode=require`
- Default `spring.jpa.hibernate.ddl-auto` is set to `validate` so the app fails fast if the schema is missing/mismatched.

