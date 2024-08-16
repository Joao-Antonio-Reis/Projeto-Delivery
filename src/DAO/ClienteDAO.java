package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Classe ClienteDAO para manipulação de dados da tabela 'cliente'
public class ClienteDAO extends Conexao {
    // Instância de 'Conexao' para gerenciar conexões com o banco de dados
    private static Conexao dao = new Conexao();

    // Método para inserir um novo cliente no banco de dados
    public static void inserirCliente(String nome, String telefone, String email, int enderecoID) {
        Connection conexao = null;  // Objeto de conexão com o banco de dados
        PreparedStatement statement = null;  // Objeto para execução de comandos SQL

        try {
            // Obtém uma conexão com o banco de dados
            conexao = dao.getConnection();

            // SQL para inserir um novo cliente na tabela 'cliente'
            String sql = "INSERT INTO cliente (cliente_nome, cliente_telefone, cliente_email, endereco_id) VALUES (?, ?, ?, ?)";
            statement = conexao.prepareStatement(sql);  // Prepara a declaração SQL
            // Define os parâmetros para o comando SQL
            statement.setString(1, nome);
            statement.setString(2, telefone);
            statement.setString(3, email);
            statement.setInt(4, enderecoID);

            // Executa a declaração SQL de inserção
            statement.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");
        } catch (SQLException e) {
            // Captura e exibe erros de SQL
            e.printStackTrace();
            System.out.println("Erro ao inserir cliente!");
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

    // Método para remover um cliente do banco de dados pelo nome
    public static void removerCliente(String nome) {
        Connection conexao = null;  // Objeto de conexão com o banco de dados
        PreparedStatement statement = null;  // Objeto para execução de comandos SQL

        try {
            // Obtém uma conexão com o banco de dados
            conexao = dao.getConnection();

            // SQL para deletar um cliente da tabela 'cliente' com base no nome
            String sql = "DELETE FROM cliente WHERE nome = ?";
            statement = conexao.prepareStatement(sql);  // Prepara a declaração SQL

            // Define o parâmetro para o comando SQL
            statement.setString(1, nome);

            // Executa a declaração SQL de remoção
            statement.executeUpdate();
            System.out.println("Cliente removido com sucesso!");
        } catch (SQLException e) {
            // Captura e exibe erros de SQL
            e.printStackTrace();
            System.out.println("Erro ao remover cliente!");
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
}
