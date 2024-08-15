package ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Classe ClienteDAO para manipulação de dados da tabela 'cliente'
public class ClienteDAO extends Conexao {
    // Instância de 'Conexao' para gerenciar conexões com o banco de dados
    private static Conexao dao = new Conexao();

    // Método para inserir um novo cliente no banco de dados
    public static int inserirCliente(String nome, String telefone, String email, int enderecoID) {
        // Usando try-with-resources para garantir o fechamento automático dos recursos
        String sql = "INSERT INTO cliente (cliente_nome, cliente_telefone, cliente_email, endereco_id) VALUES (?, ?, ?, ?)";
        try (Connection conexao = dao.getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Define os parâmetros para o comando SQL
            statement.setString(1, nome);
            statement.setString(2, telefone);
            statement.setString(3, email);
            statement.setInt(4, enderecoID);

            // Executa a declaração SQL de inserção
            statement.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");

            // Recupera o ID gerado automaticamente
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Retorna o ID do cliente inserido
                } else {
                    throw new SQLException("Falha ao inserir cliente, nenhum ID gerado.");
                }
            }

        } catch (SQLException e) {
            // Captura e exibe erros de SQL
            e.printStackTrace();
            System.out.println("Erro ao inserir cliente!");
        }
        return -1; // Retorna -1 se falhar
    }

    // Método para remover um cliente do banco de dados pelo nome
    public static void removerCliente(String nome) {
        // Usando try-with-resources para garantir o fechamento automático dos recursos
        String sql = "DELETE FROM cliente WHERE cliente_nome = ?";  // Corrigido para 'cliente_nome'
        try (Connection conexao = dao.getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            // Define o parâmetro para o comando SQL
            statement.setString(1, nome);

            // Executa a declaração SQL de remoção
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente removido com sucesso!");
            } else {
                System.out.println("Nenhum cliente encontrado com o nome especificado.");
            }

        } catch (SQLException e) {
            // Captura e exibe erros de SQL
            e.printStackTrace();
            System.out.println("Erro ao remover cliente!");
        }
    }
}
