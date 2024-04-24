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

    public void inserirCategoria(String categoria_nome, String categoria_descricao) {
        try (
            
            Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO categoria (categoria_nome, categoria_descricao) VALUES (?, ?)");
        )
        
        {
            statement.setString(1, categoria_nome);
            statement.setString(2, categoria_descricao);

            statement.executeUpdate();
            
            statement.close();
            connection.close();

            System.out.println("Categoria inserida com sucesso!");
        
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir categoria!");
        }
    }

    public ArrayList<String> carregarCategoria() {
        
        ArrayList<String> listaDeCategoria = new ArrayList<>();
        
        try (
            
            Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement statement = connection.prepareStatement("SELECT categoria_nome FROM categoria");

            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nomeCategoria = resultSet.getString("categoria_nome");
                listaDeCategoria.add(nomeCategoria);
            }
            
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar categorias!");
        }
        return listaDeCategoria;
    }
}

