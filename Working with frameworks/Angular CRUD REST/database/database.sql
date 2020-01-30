CREATE DATABASE ng_almacigo_db;

USE ng_almacigo_db;

CREATE TABLE almacigo(
    id INT(11)  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(180),
    description VARCHAR(255),
    image VARCHAR(200),
    create_at TIMESTAMP DEFAULT  CURRENT_TIMESTAMP
);

DESCRIBE almacigos;