package DAO;

import Models.Produto; // Importa o modelo de dados Produto

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Classe ProdutoDAO para manipulação de dados da tabela 'produto'
public class ProdutoDAO extends Conexao {
    // Instância de Conexao para gerenciar conexões com o banco de dados
    private static Conexao dao = new Conexao();

    // Método estático para inserir um novo produto no banco de dados
    public static void inserirProduto(String produto_nome, String produto_categoria, String produto_descricao, BigDecimal produto_valor, String produto_imagem) {
        Connection conexao = null;  // Objeto de conexão com o banco de dados
        PreparedStatement statement = null;  // Objeto para execução de comandos SQL

        try {
            // Obtém uma conexão com o banco de dados
            conexao = dao.getConnection();

            // SQL para inserir um novo produto na tabela 'produto'
            String sql = "INSERT INTO produto (produto_nome, produto_categoria, produto_descricao, produto_valor, produto_imagem) VALUES (?, ?, ?, ?, ?)";
            statement = conexao.prepareStatement(sql);  // Prepara a declaração SQL

            // Define os parâmetros para o comando SQL
            statement.setString(1, produto_nome);
            statement.setString(2, produto_categoria);
            statement.setString(3, produto_descricao);
            statement.setBigDecimal(4, produto_valor);
            statement.setString(5, produto_imagem);

            // Executa a declaração SQL de inserção
            statement.executeUpdate();

            System.out.println("Produto inserido com sucesso!");
        } catch (SQLException e) {
            // Captura e exibe erros de SQL
            e.printStackTrace();
            System.out.println("Erro ao inserir produto!");
        } finally {
            // Bloco finally para garantir o fechamento dos recursos
            try {
                if (statement != null) {
                    statement.close();  // Fecha o PreparedStatement
                }
                if (conexao != null) {
                    conexao.close();  // Fecha a conexão com o banco de dados
                    System.out.println("Conexão encerrada!");
                }
            } catch (SQLException e) {
                // Captura e exibe erros ao fechar os recursos
                System.out.println("Erro ao fechar a conexão com o Banco de dados!");
            }
        }
    }

    // Método para remover um produto do banco de dados pelo nome
    public void removerProduto(String produto_nome) {
        Connection conexao = null;  // Objeto de conexão com o banco de dados
        PreparedStatement statement = null;  // Objeto para execução de comandos SQL

        try {
            // Obtém uma conexão com o banco de dados
            conexao = dao.getConnection();

            // SQL para deletar um produto da tabela 'produto' com base no nome
            String sql = "DELETE FROM produto WHERE produto_nome = ?";
            statement = conexao.prepareStatement(sql);  // Prepara a declaração SQL

            // Define o parâmetro para o comando SQL
            statement.setString(1, produto_nome);

            // Executa a declaração SQL de remoção
            statement.executeUpdate();
            System.out.println("Produto removido com sucesso!");
        } catch (SQLException e) {
            // Captura e exibe erros de SQL
            e.printStackTrace();
            System.out.println("Erro ao remover produto!");
        } finally {
            // Bloco finally para garantir o fechamento dos recursos
            try {
                if (statement != null) {
                    statement.close();  // Fecha o PreparedStatement
                }
                if (conexao != null) {
                    conexao.close();  // Fecha a conexão com o banco de dados
                    System.out.println("Conexão encerrada!");
                }
            } catch (SQLException e) {
                // Captura e exibe erros ao fechar os recursos
                System.out.println("Erro ao fechar a conexão com o Banco de dados!");
            }
        }
    }

    // Método para obter a lista de produtos ordenados por categoria, nome e imagem
    public List<Produto> obterProdutosOrdenados() {
        List<Produto> produtos = new ArrayList<>();  // Lista para armazenar produtos recuperados
        // SQL para selecionar todos os produtos, ordenados por categoria, nome e imagem
        String sql = "SELECT * FROM produto ORDER BY produto_categoria, produto_nome, produto_imagem";

        try (Connection conn = dao.getConnection(); // Abre uma nova conexão
             PreparedStatement stmt = conn.prepareStatement(sql)) {  // Prepara a declaração SQL

            ResultSet rs = stmt.executeQuery();  // Executa a consulta SQL

            // Itera sobre os resultados da consulta
            while (rs.next()) {
                // Cria uma nova instância de Produto e preenche os dados
                Produto produto = new Produto();
                produto.setId(rs.getInt("produto_id"));
                produto.setNome(rs.getString("produto_nome"));
                produto.setCategoria(rs.getString("produto_categoria"));
                produto.setDescricao(rs.getString("produto_descricao"));
                produto.setValor(rs.getDouble("produto_valor"));
                produto.setImagem(rs.getString("produto_imagem"));
                // Adiciona o produto à lista
                produtos.add(produto);
            }
        } catch (SQLException e) {
            // Captura e exibe erros de SQL
            e.printStackTrace();
        }

        return produtos;  // Retorna a lista de produtos
    }
}
