package Generics;
import ConexaoDB.ConexaoGeneric;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Endereco {

    private static final String URL = ConexaoGeneric.getURL();
    private static final String  USUARIO = ConexaoGeneric.getUSUARIO();
    private static final String SENHA = ConexaoGeneric.getSENHA();
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    
    public Endereco(String bairro, String rua, String numero, String complemento) {
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }
    
    public Endereco() {
    }

    // Getters e setters

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
