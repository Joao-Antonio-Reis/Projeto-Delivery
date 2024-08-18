package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoDAO extends Conexao {
    private static Conexao dao = new Conexao();

    public static int inserirEndereco(String bairro, String rua, String numero, String complemento) {
        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = dao.getConnection();

            String sql = "INSERT INTO endereco (bairro, rua, numero, complemento) VALUES (?, ?, ?, ?)";
            statement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, bairro);
            statement.setString(2, rua);
            statement.setString(3, numero);
            statement.setString(4, complemento);

            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    int enderecoId = rs.getInt(1);
                    System.out.println("Endereço inserido com sucesso! ID: " + enderecoId);
                    return enderecoId;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir endereço!");
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
