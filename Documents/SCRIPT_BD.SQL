CREATE TABLE endereco (
    endereco_id INT AUTO_INCREMENT PRIMARY KEY,
    bairro VARCHAR(100),
    rua VARCHAR(100),
    numero VARCHAR(10),
    complemento VARCHAR(100)
);

CREATE TABLE cliente (
    cliente_id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_nome VARCHAR(100),
    cliente_telefone VARCHAR(11),
    endereco_id INT,
    FOREIGN KEY (endereco_id) REFERENCES endereco(endereco_id)
);

CREATE TABLE categoria (
    categoria_id INT AUTO_INCREMENT PRIMARY KEY,
    categoria_nome VARCHAR(20),
    categoria_descricao VARCHAR(100)
);

CREATE TABLE produto (
    produto_id INT AUTO_INCREMENT PRIMARY KEY,
    produto_nome VARCHAR(30),
    categoria_id INT,
    FOREIGN KEY (categoria_id) REFERENCES categoria(categoria_id),
    produto_descricao VARCHAR(100),
    produto_valor DOUBLE
);
