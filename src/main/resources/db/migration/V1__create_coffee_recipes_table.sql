
CREATE TABLE IF NOT EXISTS t_coffee (
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name_type VARCHAR(128) NOT NULL UNIQUE,
    instructions TEXT NOT NULL,
    prep_time timestamp NOT NULL,
    calories INT
)