package DAO;

import Models.Categoria;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

// Classe que realiza operações de banco de dados relacionadas a 'Categoria'
public class CategoriaDAO {
    // Instância da classe 'Conexao' para gerenciar a conexão com o banco de dados
    private static Conexao dao = new Conexao();

    // Método para inserir uma nova categoria no banco de dados
    public void inserirCategoria(String categoria_nome, String categoria_descricao) {
        // Uso do bloco try-with-resources para garantir que os recursos serão fechados automaticamente
        try (
                Connection connection = dao.getConnection(); // Obtém a conexão com o banco de dados
                PreparedStatement stmt = connection.prepareStatement(
                        "INSERT INTO categoria (categoria_nome, categoria_descricao) VALUES (?, ?)"); // Prepara a declaração SQL
        ) {
            // Define os parâmetros da declaração SQL
            stmt.setString(1, categoria_nome);
            stmt.setString(2, categoria_descricao);

            // Executa a declaração SQL
            stmt.executeUpdate();

            // Fecha a declaração e a conexão (opcional aqui, pois try-with-resources fecha automaticamente)
            stmt.close();
            connection.close();

            System.out.println("Categoria inserida com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir categoria!");
        }
    }

    // Método para buscar e retornar uma lista de categorias do banco de dados
    public ArrayList<Categoria> buscarCategoria() {
        // Cria uma lista para armazenar as categorias obtidas
        ArrayList<Categoria> listaDeCategoria = new ArrayList<>();

        try (
                Connection connection = dao.getConnection(); // Obtém a conexão com o banco de dados
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT categoria_nome FROM categoria"); // Prepara a declaração SQL para selecionar categorias
                ResultSet resultSet = statement.executeQuery() // Executa a consulta SQL e obtém os resultados
        ) {
            // Itera sobre os resultados da consulta
            while (resultSet.next()) {
                // Cria uma nova instância de 'Categoria' e define seu nome a partir do resultado
                Categoria categoria = new Categoria();
                categoria.setNome(resultSet.getString("categoria_nome"));
                // Adiciona a categoria à lista
                listaDeCategoria.add(categoria);
            }

            // Fecha a declaração e a conexão (opcional aqui, pois try-with-resources fecha automaticamente)
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar categorias!");
        }
        int quantidadeCategoria = listaDeCategoria.size(); // Obtém a quantidade de categorias
        return listaDeCategoria; // Retorna a lista de categorias
    }

    // Método estático para consultar produtos com base no nome da categoria
    public static void consultarProdutosPorCategoria(String categoriaNome) {

        // SQL para selecionar produtos com base no nome da categoria
        String sql = "SELECT produto_nome, produto_categoria, produto_valor FROM produto WHERE produto_categoria = ?";

        try (
                // Estabelece a conexão com o banco de dados
                Connection connection = dao.getConnection();

                // Prepara a declaração SQL com um parâmetro
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            // Define o valor do parâmetro na consulta SQL
            statement.setString(1, categoriaNome);

            // Executa a consulta e obtém o resultado
            ResultSet resultSet = statement.executeQuery();

            // Itera sobre os resultados da consulta
            while (resultSet.next()) {
                // Extrai dados de cada produto
                String nome = resultSet.getString("produto_nome");
                String categoria = resultSet.getString("produto_categoria");
                BigDecimal valor = resultSet.getBigDecimal("produto_valor");

                // Exibe os dados dos produtos
                System.out.println("Nome: " + nome + ", Categoria: " + categoria + " Valor: " + valor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao consultar produtos por categoria!");
        }
    }

    // Método para apagar uma categoria do banco de dados com base no nome
    public void apagarCategoria(String nome) {
        try (
                Connection connection = dao.getConnection(); // Obtém a conexão com o banco de dados
                PreparedStatement statement = connection.prepareStatement(
                        "DELETE FROM categoria WHERE categoria_nome = ?"); // Prepara a declaração SQL para deletar a categoria
        ) {
            // Define o valor do parâmetro na consulta SQL
            statement.setString(1, nome);

            // Executa a declaração SQL e obtém o número de linhas afetadas
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                // Se pelo menos uma linha foi afetada, a categoria foi apagada
                System.out.println("Categoria apagada com sucesso!");
            } else {
                // Caso contrário, a categoria não foi encontrada
                System.out.println("Categoria não encontrada!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao apagar categoria!");
        }
    }

}
