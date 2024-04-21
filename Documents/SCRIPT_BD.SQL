CREATE TABLE enderecos (
    endereco_id INT AUTO_INCREMENT PRIMARY KEY,
    bairro VARCHAR(100),
    rua VARCHAR(100),
    numero VARCHAR(10),
    complemento VARCHAR(100)
);

CREATE TABLE clientes (
    cliente_id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_nome VARCHAR(100),
    cliente_telefone VARCHAR(10),
    endereco_id INT,
    FOREIGN KEY (endereco_id) REFERENCES enderecos(endereco_id)
);
