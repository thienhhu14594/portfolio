# Database Schema

## projects

```sql
CREATE TABLE IF NOT EXISTS projects (
  id          BIGSERIAL PRIMARY KEY,
  title       VARCHAR(200) NOT NULL,
  description TEXT,
  technologies TEXT,
  github_url   TEXT,
  featured    BOOLEAN NOT NULL DEFAULT FALSE,

  CONSTRAINT projects_title_not_blank
    CHECK (length(btrim(title)) > 0),

  CONSTRAINT projects_github_url_http
    CHECK (github_url IS NULL OR github_url ~* '^https?://')
);

-- Optional, small index for common filtering
CREATE INDEX IF NOT EXISTS idx_projects_featured ON projects (featured);
```

## Notes

- technologies stored as text for simplicity
- featured used for homepage highlighting
- no timestamps yet (keep schema minimal)
