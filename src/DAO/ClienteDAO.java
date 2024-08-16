package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Classe ClienteDAO para manipulação de dados da tabela 'cliente'
public class ClienteDAO extends Conexao {
    // Instância de 'Conexao' para gerenciar conexões com o banco de dados
    private static Conexao dao = new Conexao();

    // Método para inserir um novo cliente no banco de dados
    public static int inserirCliente(String nome, String telefone, String email, int enderecoID) {
        Connection conexao = null;  // Objeto de conexão com o banco de dados
        PreparedStatement statement = null;  // Objeto para execução de comandos SQL

        try {
            // Obtém uma conexão com o banco de dados
            conexao = dao.getConnection();

            // SQL para inserir um novo cliente na tabela 'cliente'
            String sql = "INSERT INTO cliente (cliente_nome, cliente_telefone, cliente_email, endereco_id) VALUES (?, ?, ?, ?)";
            // Prepara a declaração SQL para retornar as chaves geradas
            statement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            // Define os parâmetros para o comando SQL
            statement.setString(1, nome);
            statement.setString(2, telefone);
            statement.setString(3, email);
            statement.setInt(4, enderecoID);

            // Executa a declaração SQL de inserção
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idCliente = generatedKeys.getInt(1);
                    System.out.println("Cliente inserido com sucesso!");
                    return idCliente;
                } else {
                    throw new SQLException("Falha ao inserir cliente, nenhum ID gerado.");
                }
            } else {
                throw new SQLException("Nenhuma linha afetada ao inserir cliente.");
            }
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
        return -1;
    }
}
