CREATE TABLE events (
                        id BIGSERIAL PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        organizer_email VARCHAR(255) NOT NULL,
                        ticket_price INTEGER NOT NULL,
                        age_limit INTEGER NOT NULL,
                        event_date TIMESTAMP NOT NULL
);