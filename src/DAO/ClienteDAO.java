package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO extends Conexao {
    private static Conexao dao = new Conexao();

    public static int inserirCliente(String nome, String telefone, String email, int enderecoID) {
        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = dao.getConnection();

            String sql = "INSERT INTO cliente (cliente_nome, cliente_telefone, cliente_email, endereco_id) VALUES (?, ?, ?, ?)";
            statement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, nome);
            statement.setString(2, telefone);
            statement.setString(3, email);
            statement.setInt(4, enderecoID);

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
            e.printStackTrace();
            System.out.println("Erro ao inserir cliente!");
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
        return -1;
    }
}
