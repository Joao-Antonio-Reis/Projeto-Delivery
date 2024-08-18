package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Classe EnderecoDAO para manipulação de dados da tabela 'endereco'
public class EnderecoDAO extends Conexao {
    // Instância da classe Conexao para gerenciar conexões com o banco de dados
    private static Conexao dao = new Conexao();

    // Método para inserir um novo endereço no banco de dados
    public static int inserirEndereco(String bairro, String rua, String numero, String complemento) {
        Connection conexao = null; // Objeto de conexão com o banco de dados
        PreparedStatement statement = null; // Objeto para execução de comandos SQL

        try {
            // Obtém uma conexão com o banco de dados
            conexao = dao.getConnection();

            // SQL para inserir um novo endereço na tabela 'endereco'
            String sql = "INSERT INTO endereco (bairro, rua, numero, complemento) VALUES (?, ?, ?, ?)";
            // Prepara a declaração SQL com a opção de retornar chaves geradas
            statement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // Define os parâmetros para o comando SQL
            statement.setString(1, bairro);
            statement.setString(2, rua);
            statement.setString(3, numero);
            statement.setString(4, complemento);

            // Executa a declaração SQL de inserção e obtém o número de linhas afetadas
            int linhasAfetadas = statement.executeUpdate();

            // Verifica se a inserção foi bem-sucedida
            if (linhasAfetadas > 0) {
                // Obtém as chaves geradas (ID do endereço inserido)
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    // Obtém o ID do endereço inserido
                    int enderecoId = rs.getInt(1);
                    System.out.println("Endereço inserido com sucesso! ID: " + enderecoId);
                    return enderecoId; // Retorna o ID do endereço inserido
                }
            }
        } catch (SQLException e) {
            // Captura e exibe erros de SQL
            e.printStackTrace();
            System.out.println("Erro ao inserir endereço!");
        } finally {
            // Bloco finally para garantir o fechamento dos recursos
            try {
                if (statement != null) {
                    statement.close(); // Fecha o PreparedStatement
                }
                if (conexao != null) {
                    conexao.close(); // Fecha a conexão com o banco de dados
                    System.out.println("Conexão encerrada!");
                }
            } catch (SQLException e) {
                // Captura e exibe erros ao fechar os recursos
                System.out.println("Erro ao fechar a conexão com o Banco de dados!");
            }
        }
        return -1; // Retorna -1 se algo der errado
    }
}
