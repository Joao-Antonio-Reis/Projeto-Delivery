package DAO;

import Models.Categoria;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class CategoriaDAO {
    private static Conexao dao = new Conexao();

    public void inserirCategoria(String categoria_nome, String categoria_descricao) {
        try (
                Connection connection = dao.getConnection();
                PreparedStatement stmt = connection.prepareStatement(
                        "INSERT INTO categoria (categoria_nome, categoria_descricao) VALUES (?, ?)");
        ) {
            stmt.setString(1, categoria_nome);
            stmt.setString(2, categoria_descricao);
            stmt.executeUpdate();
            stmt.close();
            connection.close();

            System.out.println("Categoria inserida com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir categoria!");
        }
    }

    public ArrayList<Categoria> buscarCategoria() {
        ArrayList<Categoria> listaDeCategoria = new ArrayList<>();

        try (
                Connection connection = dao.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT categoria_nome FROM categoria");
                ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setNome(resultSet.getString("categoria_nome"));
                listaDeCategoria.add(categoria);
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar categorias!");
        }
        int quantidadeCategoria = listaDeCategoria.size();
        return listaDeCategoria;
    }

    public static void consultarProdutosPorCategoria(String categoriaNome) {

        String sql = "SELECT produto_nome, produto_categoria, produto_valor FROM produto WHERE produto_categoria = ?";

        try (
                Connection connection = dao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, categoriaNome);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("produto_nome");
                String categoria = resultSet.getString("produto_categoria");
                BigDecimal valor = resultSet.getBigDecimal("produto_valor");
                System.out.println("Nome: " + nome + ", Categoria: " + categoria + " Valor: " + valor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao consultar produtos por categoria!");
        }
    }

    public void apagarCategoria(String nome) {
        try (
                Connection connection = dao.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "DELETE FROM categoria WHERE categoria_nome = ?");
        ) {
            statement.setString(1, nome);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Categoria apagada com sucesso!");
            } else {
                System.out.println("Categoria não encontrada!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao apagar categoria!");
        }
    }

}
