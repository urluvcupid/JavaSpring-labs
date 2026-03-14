CREATE TABLE films (
                       id BIGSERIAL PRIMARY KEY,
                       title VARCHAR(150) NOT NULL,
                       genre VARCHAR(80) NOT NULL,
                       director_name VARCHAR(120) NOT NULL,
                       contact_email VARCHAR(120) NOT NULL,
                       duration_minutes INTEGER NOT NULL,
                       age_rating INTEGER NOT NULL,
                       release_date DATE NOT NULL
);