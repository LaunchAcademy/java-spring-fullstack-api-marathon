DROP TABLE IF EXISTS artists;
CREATE TABLE artists (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);