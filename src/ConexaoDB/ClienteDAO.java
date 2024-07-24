package ConexaoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ConexaoDB.ConexaoGeneric;
public class ClienteDAO {
    private static final String URL = ConexaoGeneric.getURL();
    private static final String  USUARIO = ConexaoGeneric.getUSUARIO();
    private static final String SENHA = ConexaoGeneric.getSENHA();
    public static void inserirCliente(String nome, String telefone, String email, int enderecoID) {
        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

            String sql = "INSERT INTO cliente (cliente_nome, cliente_telefone, cliente_email, endereco_id) VALUES (?, ?, ?, ?)";
            statement = conexao.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setString(2, telefone);
            statement.setString(3, email);
            statement.setInt(4, enderecoID);

            statement.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir cliente!");
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
    }
    public static void removerCliente(String nome) {
        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

            String sql = "DELETE FROM cliente WHERE nome = ?";
            statement = conexao.prepareStatement(sql);

            statement.setString(1, nome);

            statement.executeUpdate();
            System.out.println("Cliente removido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao remover cliente!");
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
    }
}
