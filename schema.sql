CREATE DATABASE IF NOT EXISTS receitas;
USE receitas;

CREATE TABLE IF NOT EXISTS usuario (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(150)
);

CREATE TABLE IF NOT EXISTS categoria (
    idCategoria INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT
);

CREATE TABLE IF NOT EXISTS ingrediente (
    idIngrediente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL
);

CREATE TABLE IF NOT EXISTS receita (
    idReceita INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    descricao TEXT,
    idCategoria INT,
    idUsuario INT,
    FOREIGN KEY (idCategoria) REFERENCES categoria(idCategoria) ON DELETE SET NULL,
    FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS comentario (
    idComentario INT AUTO_INCREMENT PRIMARY KEY,
    idReceita INT,
    idUsuario INT,
    conteudo TEXT,
    FOREIGN KEY (idReceita) REFERENCES receita(idReceita) ON DELETE CASCADE,
    FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario) ON DELETE SET NULL
);
