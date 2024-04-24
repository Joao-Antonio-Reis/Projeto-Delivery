package Generics;

import java.math.BigDecimal;
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
    private String categoria;
    private String descricao;
    private BigDecimal valor;
    
    public Produto(int id, String nome, String categoria, String descricao, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Produto(String nome, String categoria, String descricao, BigDecimal valor) {
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
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void inserirProduto(String produto_nome, String produto_categoria, String produto_descricao, BigDecimal produto_valor){
        
        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

            String sql = "INSERT INTO produto (produto_nome, produto_categoria, produto_descricao, produto_valor) VALUES (?, ?, ?, ?)";
            statement = conexao.prepareStatement(sql);
            statement.setString(1, produto_nome);
            statement.setString(2, produto_categoria);
            statement.setString(3, produto_descricao);
            statement.setBigDecimal(4, produto_valor);

            statement.executeUpdate();

            System.out.println("Produto inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir produto!");
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
