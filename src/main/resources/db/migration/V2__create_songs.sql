DROP TABLE IF EXISTS songs;

CREATE TABLE songs (
  id BIGSERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  genre VARCHAR(255),
  release_year INTEGER NOT NULL,
  explicit_content BOOLEAN NOT NULL,
  artist_id bigint NOT NULL REFERENCES artists(id)
);