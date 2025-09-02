-- Creates the 'appointments' table
CREATE TABLE appointments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    appointment_date DATE,
    appointment_time TIME,
    description VARCHAR(255)
);

-- Creates the 'users' table
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    img_url VARCHAR(255),
    rank VARCHAR(255),
    age INT,
    appointment_id BIGINT,
    FOREIGN KEY (appointment_id) REFERENCES appointments(id)
);