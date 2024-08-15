CREATE TABLE IF NOT EXISTS administrador(
    id_adm INT AUTO_INCREMENT PRIMARY KEY ,
    login VARCHAR(50),
    senha VARCHAR(50)
);

INSERT INTO administrador (`id_adm`, `login`, `senha`) VALUES
                                                            (1, 'admin', 'admin'),
                                                            (2, 'jorge', 'jorge'),
                                                            (3,'joao','joao');

CREATE TABLE IF NOT EXISTS endereco (
    endereco_id INT AUTO_INCREMENT PRIMARY KEY,
    bairro VARCHAR(100),
    rua VARCHAR(100),
    numero VARCHAR(10),
    complemento VARCHAR(100)
);

INSERT INTO endereco (bairro, rua, numero, complemento) VALUES
                                                            ('Jardim Paulista', 'Rua das Flores', '123', 'Apto 101'),
                                                            ('Centro', 'Avenida Brasil', '456', 'Sala 202'),
                                                            ('Vila Mariana', 'Rua da Esperança', '789', 'Casa 3'),
                                                            ('Pinheiros', 'Rua das Palmeiras', '101', 'Casa 4B'),
                                                            ('Moema', 'Avenida Moema', '202', 'Condomínio 5');

CREATE TABLE IF NOT EXISTS cliente (
    cliente_id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_nome VARCHAR(100),
    cliente_telefone VARCHAR(11),
    cliente_email VARCHAR(120),
    endereco_id INT,
    FOREIGN KEY (endereco_id) REFERENCES endereco(endereco_id)
);

INSERT INTO cliente (cliente_nome, cliente_telefone, cliente_email, endereco_id) VALUES
                                                            ('João Silva', '11987654321', 'joao.silva@example.com', 1),
                                                            ('Maria Oliveira', '21987654321', 'maria.oliveira@example.com', 2),
                                                            ('Pedro Santos', '31987654321', 'pedro.santos@example.com', 3),
                                                            ('Ana Souza', '41987654321', 'ana.souza@example.com', 4),
                                                            ('Carlos Lima', '51987654321', 'carlos.lima@example.com', 5);

CREATE TABLE Pedidos (
    PedidoID INT PRIMARY KEY AUTO_INCREMENT,
    ClienteID INT NOT NULL,
    DataPedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    ValorTotal DECIMAL(10, 2),
    FormaPagamento VARCHAR(255),
    FOREIGN KEY (ClienteID) REFERENCES cliente(cliente_id)
);


CREATE TABLE IF NOT EXISTS categoria (
    categoria_id INT AUTO_INCREMENT PRIMARY KEY,
    categoria_nome VARCHAR(20),
    categoria_descricao VARCHAR(100)
);

INSERT INTO categoria (categoria_nome, categoria_descricao) VALUES
                                  ('Temaki','Temaki recheados '),
                                  ('Combos','Combos mais baratos'),
                                  ('Gunkan','Salmão e creme cheese'),
                                  ('Hot','Sushi frito '),
                                  ('Bebidas','Bebidas geladas e quentes'),
                                  ('Nigiri','Arroz e salmão'),
                                  ('Uramaki','Arroz alga e salmão'),
                                  ('Sashimi','Peixe cru');

CREATE TABLE IF NOT EXISTS produto (
    produto_id INT AUTO_INCREMENT PRIMARY KEY,
    produto_nome VARCHAR(30),
    produto_categoria VARCHAR(20),
    produto_descricao VARCHAR(100),
    produto_valor DECIMAL(10,2),
    produto_imagem VARCHAR(30)
);

-- Inserindo dados na tabela produto
INSERT INTO produto (produto_nome, produto_categoria, produto_valor, produto_descricao, produto_imagem) VALUES
                                                                                                            ('Temaki Skin', 'Temaki', 22.90, 'Temaki de pele', 'Imagens/temaki.jfif'),
                                                                                                            ('Temaki de salmão com Arroz', 'Temaki', 20.90, 'Imagens/temaki de salmão', 'temaki.jfif'),
                                                                                                            ('Temaki Hot', 'Temaki', 25.90, 'temaki frito', 'Imagens/TemakiHot.jpeg'),
                                                                                                            ('Temaki Camarão', 'Temaki', 29.90, 'temaki camarão', 'Imagens/TemakiSemArroz.jpeg'),
                                                                                                            ('Combo Individual', 'Combos', 35.90, 'combo para uma pessoa', 'Imagens/ComboIndividual.jpeg'),
                                                                                                            ('Combo Casal', 'Combos', 64.90, 'combo para duas pessoas', 'Imagens/ComboCasal.jpeg'),
                                                                                                            ('Combo Especial', 'Combos', 89.90, 'combo especial para mais de duas pessoas', 'Imagens/ComboCasal.jpeg'),
                                                                                                            ('Gunkan Hot Bacon', 'Gunkan', 27.90, 'gunkan com bacon por cima', 'Imagens/gunkan.png'),
                                                                                                            ('Gunkan Salmão', 'Gunkan', 28.90, 'gunkanSalmão', 'Imagens/Gunkan.jpeg'),
                                                                                                            ('Hot Filadélfia', 'Hot', 19.90, 'hot filadelfia', 'Imagens/HotFiladelfia.jpeg');
