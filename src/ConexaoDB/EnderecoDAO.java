package ConexaoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConexaoDB.ConexaoGeneric;
public class EnderecoDAO extends ConexaoGeneric {
    private static final String URL = getURL();
    private static final String  USUARIO = getUSUARIO();
    private static final String SENHA = getSENHA();

    public static int inserirEndereco(String bairro, String rua, String numero, String complemento) {
        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

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
                if(statement != null){
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
        return -1; // Retorna -1 se algo der errado
    }
}
