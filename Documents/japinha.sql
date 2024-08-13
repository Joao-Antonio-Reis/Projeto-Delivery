-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 06/08/2024 às 12:16
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `japinha`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria`
--

CREATE TABLE `categoria` (
  `categoria_id` int(11) NOT NULL,
  `categoria_nome` varchar(20) DEFAULT NULL,
  `categoria_descricao` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `categoria`
--

INSERT INTO `categoria` (`categoria_id`, `categoria_nome`, `categoria_descricao`) VALUES
(1, 'Temaki', ' '),
(2, 'Combos', ' '),
(3, 'Gunkan', ' '),
(4, 'Hot', ' '),
(6, 'Bebidas', 'Bebidas'),
(7, 'Sobremesas', 'Adoçar a vida né'),
(8, 'Cachacinha', 'Pinguinha nossa de cada dia'),
(9, 'Niguiri', 'Arroz e peixe'),
(10, 'Sushi', 'asdasd');

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `cliente_id` int(11) NOT NULL,
  `cliente_nome` varchar(100) DEFAULT NULL,
  `cliente_telefone` varchar(11) DEFAULT NULL,
  `cliente_email` varchar(120) DEFAULT NULL,
  `endereco_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cliente`
--

INSERT INTO `cliente` (`cliente_id`, `cliente_nome`, `cliente_telefone`, `cliente_email`, `endereco_id`) VALUES
(1, 'João Silva', '11987654321', 'joao.silva@example.com', 1),
(2, 'Maria Oliveira', '21987654321', 'maria.oliveira@example.com', 2),
(3, 'Pedro Santos', '31987654321', 'pedro.santos@example.com', 3),
(4, 'Ana Souza', '41987654321', 'ana.souza@example.com', 4),
(5, 'Carlos Lima', '51987654321', 'carlos.lima@example.com', 5);

-- --------------------------------------------------------

--
-- Estrutura para tabela `endereco`
--

CREATE TABLE `endereco` (
  `endereco_id` int(11) NOT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `rua` varchar(100) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `complemento` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `endereco`
--

INSERT INTO `endereco` (`endereco_id`, `bairro`, `rua`, `numero`, `complemento`) VALUES
(1, 'Jardim Paulista', 'Rua das Flores', '123', 'Apto 101'),
(2, 'Centro', 'Avenida Brasil', '456', 'Sala 202'),
(3, 'Vila Mariana', 'Rua da Esperança', '789', 'Casa 3'),
(4, 'Pinheiros', 'Rua das Palmeiras', '101', 'Casa 4B'),
(5, 'Moema', 'Avenida Moema', '202', 'Condomínio 5');

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto`
--

CREATE TABLE `produto` (
  `produto_id` int(11) NOT NULL,
  `produto_nome` varchar(30) DEFAULT NULL,
  `produto_categoria` varchar(20) DEFAULT NULL,
  `produto_descricao` varchar(100) DEFAULT NULL,
  `produto_valor` decimal(10,2) DEFAULT NULL,
  `produto_imagem` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `produto`
--

INSERT INTO `produto` (`produto_id`, `produto_nome`, `produto_categoria`, `produto_descricao`, `produto_valor`, `produto_imagem`) VALUES
(1, 'Temaki Skin', 'Temaki', '', 22.90, 'Imagens/download.jfif'),
(2, 'Temaki Com Arroz', 'Temaki', '', 20.90, 'Imagens/download.jfif'),
(3, 'Temaki sem Arroz', 'Temaki', '', 25.90, 'Imagens/download.jfif'),
(4, 'Temaki Hot', 'Temaki', '', 25.90, 'Imagens/download.jfif'),
(5, 'Temaki Camarão', 'Temaki', '', 29.90, 'Imagens/download.jfif'),
(6, 'Combo Individual', 'Combos', '', 35.90, 'Imagens/coca.png'),
(7, 'Combo Casal', 'Combos', '', 64.90, 'Imagens/coca.png'),
(8, 'Combo Especial', 'Combos', '', 89.90, 'Imagens/coca.png'),
(9, 'Gunkan Hot Bacon', 'Gunkan', '', 27.90, 'Imagens/gunkan.png'),
(10, 'Gunkan Salmão', 'Gunkan', '', 28.90, 'Imagens/gunkan.png'),
(11, 'Hot Filadélfia', 'Hot', '', 19.90, 'Imagens/hot.png');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`categoria_id`);

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cliente_id`),
  ADD KEY `endereco_id` (`endereco_id`);

--
-- Índices de tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`endereco_id`);

--
-- Índices de tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`produto_id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `categoria_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `cliente_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `endereco`
--
ALTER TABLE `endereco`
  MODIFY `endereco_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `produto_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`endereco_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
