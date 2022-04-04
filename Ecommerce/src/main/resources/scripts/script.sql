CREATE DATABASE ecommerce;
USE ecommerce;
CREATE TABLE produto (codigo int NOT NULL AUTO_INCREMENT, nome VARCHAR(120) NOT NULL, preco DECIMAL(7,2) NOT NULL, quantidade_estoque int NOT NULL, PRIMARY KEY(codigo));
INSERT INTO produto (nome, preco, quantidade_estoque) VALUES ("Computador Notebook Dell", 5000.00, 100); 
INSERT INTO produto (nome, preco, quantidade_estoque) VALUES ("Monitor 23' Dell", 1999.00, 100);
INSERT INTO produto (nome, preco, quantidade_estoque) VALUES ("Impressora HP", 1300.00, 20);
