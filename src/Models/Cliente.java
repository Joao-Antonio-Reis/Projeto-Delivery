package Models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ConexaoDB.ConexaoGeneric;

public class Cliente  extends Pessoa{
    private String telefone;
    private String email;
    private Endereco endereço;

    public Cliente(String nome, String telefone, String email, Endereco endereço) {
        super(nome);
        this.telefone = telefone;
        this.email = email;
        this.endereço = endereço;
    }

    public String getNome() {
        return super.getNome();
    }
    public void setNome(String nome) {
        this.setNome(nome);
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Endereco getEndereço() {
        return endereço;
    }
    public void setEndereço(Endereco endereço) {
        this.endereço = endereço;
    }

}
