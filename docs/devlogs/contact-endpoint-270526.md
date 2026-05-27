# Contact messages endpoint

## Goal

Accept contact form submissions and persist them to Supabase PostgreSQL.

## Backend

- Endpoint: `POST /api/contact`
- Request body (JSON): `{ "name": "...", "email": "...", "message": "..." }`
- Validation: `@NotBlank` + `@Email`
- Response: success message only (no entity returned)

## Database (Supabase)

- Create table `contact_messages` (see `docs/devlogs/database-schema-230526.md`)
- Keep schema minimal: no auth, no relationships, no custom queries

## Frontend

- Collect form values and `fetch('/api/contact')`
- Display success/error message in `#contact-feedback`

