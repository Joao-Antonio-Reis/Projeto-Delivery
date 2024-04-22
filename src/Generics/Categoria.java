package Generics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConexaoDB.ConexaoGeneric;

public class Categoria {

    private static final String URL = ConexaoGeneric.getURL();
    private static final String  USUARIO = ConexaoGeneric.getUSUARIO();
    private static final String SENHA = ConexaoGeneric.getSENHA();
    
    private String nome;
    private String descricao;
    
    ArrayList<String> listaDeCategoria = new ArrayList<>();

    public Categoria(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Categoria(){
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String inserirCategoria(String categoria_nome, String categoria_descricao){
        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

            String sql = "INSERT INTO categoria (categoria_nome, categoria_descricao) VALUES (?, ?)";
            statement = conexao.prepareStatement(sql);
            statement.setString(1, categoria_nome);
            statement.setString(2, categoria_descricao);

            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    String categoriaNome = rs.getString(2);
                    System.out.println("Endereço inserido com sucesso! ID: " + categoriaNome);
                    return categoriaNome;
                }
            }

            System.out.println("Categoria inserida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir categoria!");
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
    return null; // Retorna -1 se algo der errado
    }

    private void carregarCategorias() {
        try {
            Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);

            String sql = "SELECT categoria_nome FROM categoria";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nomeCategoria = resultSet.getString("categoria_nome");
                listaDeCategoria.add(nomeCategoria);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
