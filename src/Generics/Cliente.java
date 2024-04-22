package Generics;


import ConexaoDB.ConexaoGeneric;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cliente {

    private static final String URL = ConexaoGeneric.getURL();
    private static final String  USUARIO = ConexaoGeneric.getUSUARIO();
    private static final String SENHA = ConexaoGeneric.getSENHA();

    private String nome;
    private String telefone;
    private Endereco endereço;

    public Cliente(String nome, String telefone, Endereco endereço) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereço = endereço;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Endereco getEndereço() {
        return endereço;
    }
    public void setEndereço(Endereco endereço) {
        this.endereço = endereço;
    }

    public static void inserirCliente(String nome, String telefone, int enderecoID) {
        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            
            String sql = "INSERT INTO clientes (cliente_nome, cliente_telefone, endereco_id) VALUES (?, ?, ?)";
            statement = conexao.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setString(2, telefone);
            statement.setInt(3, enderecoID);

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
}
