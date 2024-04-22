package Generics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ConexaoDB.ConexaoGeneric;

public class Produto {

    private static final String URL = ConexaoGeneric.getURL();
    private static final String  USUARIO = ConexaoGeneric.getUSUARIO();
    private static final String SENHA = ConexaoGeneric.getSENHA();
    
    private int id;
    private String nome;
    private Categoria categoria;
    private String descricao;
    private Double valor;
    
    public Produto(int id, String nome, Categoria categoria, String descricao, Double valor) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Produto(String nome, Categoria categoria, String descricao, Double valor) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void inserirProduto(String produto_nome, int categoria_id, String produto_descricao, Double produto_valor){
        
        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

            String sql = "INSERT INTO produto (produto_nome, categoria_id, produto_descricao, produto_valor) VALUES (?, ?, ?, ?)";
            statement = conexao.prepareStatement(sql);
            statement.setString(1, produto_nome);
            statement.setInt(2, categoria_id);
            statement.setString(3, produto_descricao);
            statement.setDouble(4, produto_valor);

            statement.executeUpdate();

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
    }
}
