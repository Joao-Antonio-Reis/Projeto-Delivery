package DAO;

import Models.Produto; // Importa o modelo de dados Produto

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO extends Conexao {
    private static Conexao dao = new Conexao();

    public static void inserirProduto(String produto_nome, String produto_categoria, String produto_descricao, BigDecimal produto_valor, String produto_imagem) {
        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = dao.getConnection();

            String sql = "INSERT INTO produto (produto_nome, produto_categoria, produto_descricao, produto_valor, produto_imagem) VALUES (?, ?, ?, ?, ?)";
            statement = conexao.prepareStatement(sql);  // Prepara a declaração SQL

            statement.setString(1, produto_nome);
            statement.setString(2, produto_categoria);
            statement.setString(3, produto_descricao);
            statement.setBigDecimal(4, produto_valor);
            statement.setString(5, produto_imagem);

            statement.executeUpdate();

            System.out.println("Produto inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir produto!");
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (conexao != null) {
                    conexao.close();
                    System.out.println("Conexão encerrada!");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o Banco de dados!");
            }
        }
    }

    public void removerProduto(String produto_nome) {
        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = dao.getConnection();

            String sql = "DELETE FROM produto WHERE produto_nome = ?";
            statement = conexao.prepareStatement(sql);
            statement.setString(1, produto_nome);

            statement.executeUpdate();
            System.out.println("Produto removido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao remover produto!");
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (conexao != null) {
                    conexao.close();
                    System.out.println("Conexão encerrada!");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o Banco de dados!");
            }
        }
    }

    public List<Produto> obterProdutosOrdenados() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto ORDER BY produto_categoria, produto_nome, produto_imagem";

        try (Connection conn = dao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("produto_id"));
                produto.setNome(rs.getString("produto_nome"));
                produto.setCategoria(rs.getString("produto_categoria"));
                produto.setDescricao(rs.getString("produto_descricao"));
                produto.setValor(rs.getDouble("produto_valor"));
                produto.setImagem(rs.getString("produto_imagem"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }
}
