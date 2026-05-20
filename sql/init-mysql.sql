CREATE DATABASE IF NOT EXISTS zona_fit_db;
USE zona_fit_db;

CREATE TABLE IF NOT EXISTS cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    membresia INT NOT NULL
);

INSERT INTO cliente (nombre, apellido, membresia) VALUES ('Juan', 'Perez', 101);
INSERT INTO cliente (nombre, apellido, membresia) VALUES ('Maria', 'Garcia', 102);
