CREATE TABLE IF NOT EXISTS report (
    id SERIAL,
    request_name VARCHAR(50),
    decision VARCHAR(20),
    result_date TIMESTAMP,
    request_date TIMESTAMP
)