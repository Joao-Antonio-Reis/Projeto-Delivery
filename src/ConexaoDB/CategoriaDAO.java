package ConexaoDB;

import Models.Categoria;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class CategoriaDAO extends ConexaoGeneric{
    private static final String URL = getURL();
    private static final String  USUARIO = getUSUARIO();
    private static final String SENHA = getSENHA();

    public void inserirCategoria(String categoria_nome, String categoria_descricao) {
        try (

                Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO categoria (categoria_nome, categoria_descricao) VALUES (?, ?)");
        )

        {
            statement.setString(1, categoria_nome);
            statement.setString(2, categoria_descricao);

            statement.executeUpdate();

            statement.close();
            connection.close();

            System.out.println("Categoria inserida com sucesso!");

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir categoria!");
        }
    }

    public ArrayList<Categoria> buscarCategoria() {

        ArrayList<Categoria> listaDeCategoria = new ArrayList<>();

        try (

                Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
                PreparedStatement statement = connection.prepareStatement("SELECT categoria_nome FROM categoria");

                ResultSet resultSet = statement.executeQuery()) {

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

        // SQL para selecionar produtos com base no nome da categoria
        String sql = "SELECT produto_nome, produto_categoria, produto_valor FROM produto WHERE produto_categoria = ?";

        try (
                // Estabelece a conexão com o banco de dados
                Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);

                // Prepara a declaração SQL com um parâmetro
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            // Define o valor do parâmetro na consulta SQL
            statement.setString(1, categoriaNome);

            // Executa a consulta e obtém o resultado
            ResultSet resultSet = statement.executeQuery();

            // Itera sobre os resultados da consulta
            while (resultSet.next()) {
                String nome = resultSet.getString("produto_nome");
                String categoria = resultSet.getString("produto_categoria");
                BigDecimal valor = resultSet.getBigDecimal("produto_valor");

                // Exibe os dados dos produtos
                System.out.println("Nome: " + nome + ", Categoria: " + categoria + " Valor: "+ valor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao consultar produtos por categoria!");
        }
    }

    public void apagarCategoria(String nome){
        try (
                Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
                PreparedStatement statement = connection.prepareStatement("DELETE FROM categoria WHERE categoria_nome = ?");
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
